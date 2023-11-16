package YeoksamStationExit1.locationRecommend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MeetingPlaceReqDto {
    private List<FindCenterCoordinatesReqDto> locations;
    private int stationNumber;
}
