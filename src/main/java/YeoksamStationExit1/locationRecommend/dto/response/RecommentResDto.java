package YeoksamStationExit1.locationRecommend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
import YeoksamStationExit1.locationRecommend.entity.Station;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecommentResDto {

    Station station;
    List<TransPathPerUserDto> list;

}
