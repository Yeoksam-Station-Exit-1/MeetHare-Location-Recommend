package YeoksamStationExit1.locationRecommend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransPathPerUserDto {
    String userId;
    String transPath;
}
