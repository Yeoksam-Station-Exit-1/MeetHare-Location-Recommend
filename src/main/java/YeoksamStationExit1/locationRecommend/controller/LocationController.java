package YeoksamStationExit1.locationRecommend.controller;

import YeoksamStationExit1.locationRecommend.dto.request.FindCenterCoordinatesReqDto;
import YeoksamStationExit1.locationRecommend.dto.response.TransPathPerUserDto;
import YeoksamStationExit1.locationRecommend.entity.StationInfra;
// import YeoksamStationExit1.locationRecommend.repository.LocationRepository;
import YeoksamStationExit1.locationRecommend.service.LocationService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/map")
@Slf4j
@RequiredArgsConstructor
public class LocationController {

    // private final LocationRepository locationRepository;

    private final LocationService locationService;

    @PostMapping("/middlespot")
    public ResponseEntity<?> findCenterCoordinates(@RequestBody List<FindCenterCoordinatesReqDto> req)
            throws Exception {
        Set<String> placeNames = locationService.findCenterCoordinates(req);

        StationInfra recommendPlace = locationService.findPlaceByInfracount(placeNames);

        List<TransPathPerUserDto> list = locationService.searchPubTransPath(req, recommendPlace);

        System.out.println(recommendPlace.getStationName());

        // TODO : 우선순위 구하기
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/test")
    public void testmoe() {
        System.out.println("test!!!!");
    }

}
