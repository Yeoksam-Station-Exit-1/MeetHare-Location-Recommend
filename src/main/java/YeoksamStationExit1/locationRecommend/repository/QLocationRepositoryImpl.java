package YeoksamStationExit1.locationRecommend.repository;

import YeoksamStationExit1.locationRecommend.dto.response.FindMyStationRespDto;
import YeoksamStationExit1.locationRecommend.dto.response.GetAvgDistanceRespDto;
import YeoksamStationExit1.locationRecommend.dto.response.GetStationCoordinateResDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import static YeoksamStationExit1.locationRecommend.entity.QStation.station;
import static YeoksamStationExit1.locationRecommend.entity.QStationDistance.stationDistance;



@Slf4j
@Repository
public class QLocationRepositoryImpl implements QLocationRepository {

    private final JPAQueryFactory queryFactory;

    public QLocationRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<FindMyStationRespDto> findByStationName(String stationName) {
        log.info("stationName: " + stationName);
        return queryFactory
                .select(Projections.constructor(FindMyStationRespDto.class,
                        station.stationId.as("stationId"),
                        station.stationName.as("stationName"),
                        station.longitude.as("longitude"),
                        station.latitude.as("latitude"),
                        station.infraCount.as("infraCount")))
                .from(station)
                .where(keywordSearch(stationName))
                .fetch();
    }

    private BooleanExpression keywordSearch(String keyword) {
        return keyword == null ? null : station.stationName.contains(keyword);
    }

    @Override
    public List<GetStationCoordinateResDto> findAll() {

        return queryFactory
                .select(Projections.constructor(GetStationCoordinateResDto.class,
                        station.stationId.as("stationId"),
                        station.longitude.as("longitude"),
                        station.latitude.as("latitude")))
                .from(station)
                .fetch();
    }

    @Override
    public void updateDistanceColumn(int stationId, double distance) {
        queryFactory
                .update(stationDistance)
                .set(stationDistance.min55distance, distance)
                .where(stationDistance.station.stationId.eq(stationId))
                .execute();
    }


    @Override
    public GetAvgDistanceRespDto findByStationId(int stationId) {
        log.info("stationId: " + stationId);
        return queryFactory
                .select(Projections.constructor(GetAvgDistanceRespDto.class,
                        stationDistance.stationDistanceId.as("stationDistanceId"),
                        stationDistance.station.stationId.as("stationId"),
                        stationDistance.min5distance.as("min5distance"),
                        stationDistance.min10distance.as("min10distance"),
                        stationDistance.min15distance.as("min15distance"),
                        stationDistance.min20distance.as("min20distance"),
                        stationDistance.min25distance.as("min25distance"),
                        stationDistance.min30distance.as("min30distance"),
                        stationDistance.min35distance.as("min35distance"),
                        stationDistance.min40distance.as("min40distance"),
                        stationDistance.min45distance.as("min45distance"),
                        stationDistance.min50distance.as("min50distance"),
                        stationDistance.min55distance.as("min55distance"),
                        stationDistance.min60distance.as("min60distance")))
                .from(stationDistance)
                .where(stationDistance.station.stationId.eq(stationId))
                .fetchOne();
    }

    @Override
    public List<GetStationCoordinateResDto> getStationPosition(int stationId) {
        return queryFactory
                .select(Projections.constructor(GetStationCoordinateResDto.class,
                        station.stationId.as("stationId"),
                        station.longitude.as("longitude"),
                        station.latitude.as("latitude")))
                .from(station)
                .where(station.stationId.eq(stationId))
                .fetch();
    }


}
