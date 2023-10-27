package YeoksamStationExit1.locationRecommend.repository;

import YeoksamStationExit1.locationRecommend.dto.response.FindMyStationRespDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import static YeoksamStationExit1.locationRecommend.entity.QStation.station;

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
}
