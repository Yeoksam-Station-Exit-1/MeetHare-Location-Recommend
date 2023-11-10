package YeoksamStationExit1.locationRecommend.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FindCenterCoordinatesReqDto {
     double longitude;
     double latitude;
     String userId;
}

