package YeoksamStationExit1.locationRecommend.repository;

import YeoksamStationExit1.locationRecommend.entity.StationInfra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface LocationRepository extends JpaRepository<StationInfra, Integer> {

    List<StationInfra> findAll();

    @Query("SELECT s FROM StationInfra s " +
            "WHERE s.stationName IN :stationNames " +
            "ORDER BY s.infraCount DESC")
    ArrayList<StationInfra> findByInfraCount(@Param("stationNames") Set<String> placeNames);


}
