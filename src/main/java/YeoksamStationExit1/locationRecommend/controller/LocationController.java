package YeoksamStationExit1.locationRecommend.controller;

import YeoksamStationExit1.locationRecommend.dto.request.FindCenterCoordinatesReqDto;
import YeoksamStationExit1.locationRecommend.service.LocationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/map")
@Slf4j
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;
//    @GetMapping("/middlespot")
    public ResponseEntity<?> findMiddleSpot() throws Exception {
//        locationService.findNearbyAreas();
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("/findCenterCoordinates")
    @GetMapping("/middlespot")
    public ResponseEntity<?> findCenterCoordinates(@RequestBody List<FindCenterCoordinatesReqDto> req) throws Exception {
        locationService.findCenterCoordinates(req);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
