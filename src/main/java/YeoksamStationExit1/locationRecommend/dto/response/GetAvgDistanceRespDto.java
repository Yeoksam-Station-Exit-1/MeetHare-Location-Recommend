package YeoksamStationExit1.locationRecommend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAvgDistanceRespDto {
    Long stationDistanceId;
    int stationId;
    double min5distance;
    double min10distance;
    double min15distance;
    double min20distance;
    double min25distance;
    double min30distance;
    double min35distance;
    double min40distance;
    double min45distance;
    double min50distance;
    double min55distance;
    double min60distance;
}
