package YeoksamStationExit1.locationRecommend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import YeoksamStationExit1.locationRecommend.entity.Station;

import java.util.List;
import java.util.Set;

public interface LocationRepository extends JpaRepository<Station, Integer> {

    List<Station> findAll();

    @Query("SELECT s.stationName FROM Station s")
    List<String> findAllStationName();

    @Query("SELECT s FROM Station s WHERE s.stationName IN :stationNames ORDER BY s.infraCount DESC")
    List<Station> findByInfraCount(@Param("stationNames") Set<String> placeNames);

    @Query("SELECT s FROM Station s WHERE s.stationId = :stationNumber")
    Station findStationByStationId(@Param("stationNumber") int stationNumber);

}
