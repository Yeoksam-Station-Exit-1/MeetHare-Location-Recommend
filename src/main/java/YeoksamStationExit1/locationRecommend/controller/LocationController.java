package YeoksamStationExit1.locationRecommend.controller;

import YeoksamStationExit1.locationRecommend.dto.request.FindCenterCoordinatesReqDto;
import YeoksamStationExit1.locationRecommend.dto.response.FindMyStationRespDto;
import YeoksamStationExit1.locationRecommend.service.LocationService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/map")
@Slf4j
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    /**
     * 사용자 위치 기반 중심장소를 찾아주는 메서드
     * */
    @PostMapping("/middlespot")
    public ResponseEntity<?> findCenterCoordinates(@RequestBody List<FindCenterCoordinatesReqDto> req) throws Exception {
        Set<String> placeNames = locationService.findCenterCoordinates(req);
        //TODO : 우선순위 구하기
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 검색어 기반 검색어가 포함된 역 이름을 찾아 좌표값을 반환하는 메서드
     * */
    @GetMapping("/myStation")
    public ResponseEntity<?> findMyStation(@RequestParam("stationName") String stationName ) throws Exception {
        List<FindMyStationRespDto> stationList = locationService.findMyStation(stationName);
        return new ResponseEntity<>(stationList, HttpStatus.OK);
    }
}
