package YeoksamStationExit1.locationRecommend.controller;

import YeoksamStationExit1.locationRecommend.dto.request.FindAvgDistanceReqDto;
import YeoksamStationExit1.locationRecommend.dto.request.FindCenterCoordinatesReqDto;

import YeoksamStationExit1.locationRecommend.dto.response.RecommentResDto;
import YeoksamStationExit1.locationRecommend.dto.response.TransPathPerUserDto;
import YeoksamStationExit1.locationRecommend.entity.Station;
import YeoksamStationExit1.locationRecommend.dto.response.FindMyStationRespDto;

import YeoksamStationExit1.locationRecommend.service.LocationService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/map")
@Slf4j
@RequiredArgsConstructor
public class LocationController {

    @Autowired
    private final LocationService locationService;

    @PostMapping("/middlespot")
    public ResponseEntity<?> findCenterCoordinates(@RequestBody List<FindCenterCoordinatesReqDto> req)
            throws Exception {
        Set<String> placeNames = locationService.findCenterCoordinates(req);

        Station recommendPlace = locationService.findPlaceByInfracount(placeNames);
        List<TransPathPerUserDto> list = locationService.searchPubTransPath(req, recommendPlace);

        System.out.println(recommendPlace.getStationName());
        RecommentResDto res = new RecommentResDto(recommendPlace, list);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<?> testmoe() {
        System.out.println("test!!!!");
        String str = "meethare";

        return new ResponseEntity<>(str, HttpStatus.OK);
    }

    /**
     * 검색어 기반 검색어가 포함된 역 이름을 찾아 좌표값을 반환하는 메서드
     */
    @GetMapping("/myStation")
    public ResponseEntity<?> findMyStation(@RequestParam("stationName") String stationName) throws Exception {
        System.out.println(stationName);
        List<FindMyStationRespDto> stationList = locationService.findMyStation(stationName);
        return new ResponseEntity<>(stationList, HttpStatus.OK);
    }

    /**
     * 특정 좌표 기준 시간별 이동가능한 평균거리 구하는 메서드 -> db저장용
     * */
    public ResponseEntity<?> findAvgDistanceByTime() {
        double avgDistance = locationService.findAvgDistanceByTime();
        System.out.println("avgDistance " + avgDistance);
        locationService.selectAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 특정 좌표 별 이동가능한 등시선도 확인 + 교차되는 좌표를 구하는 메서드
     * */
    @PostMapping("/moveableArea")
    public ResponseEntity<?> getMoveableArea(@RequestBody List<FindAvgDistanceReqDto> req) {
        Set<String> stationList = locationService.checkMovableArea(req);
        for ( String station: stationList
        ) {
            System.out.println(station);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
