package YeoksamStationExit1.locationRecommend.repository;

import YeoksamStationExit1.locationRecommend.dto.response.FindMyStationRespDto;

import java.util.List;

public interface QLocationRepository {

    List<FindMyStationRespDto> findByStationName(String stationName);
}
