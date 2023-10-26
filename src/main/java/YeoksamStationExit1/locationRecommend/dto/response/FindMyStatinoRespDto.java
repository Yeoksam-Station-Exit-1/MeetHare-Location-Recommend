package YeoksamStationExit1.locationRecommend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FindMyStatinoRespDto {
    double longitude; //경도
    double latitude; //위도
    String stationName; //역이름
}
