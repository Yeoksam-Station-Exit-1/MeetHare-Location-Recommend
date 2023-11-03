package YeoksamStationExit1.locationRecommend.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@ToString
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@Table(name = "station_time") // 테이블과 클래스명이 같을 경우 생략 가능
@Entity
public class StationTime {

    @Id
    @Column(name = "station_time_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stationTimeId;

    @Column(name = "start_station")
    private String startStation;

    @Column(name = "end_station")
    private String endStation;

    @Column(name = "travel_time")
    private int travelTime;

    @Column(name = "status")
    private String status;

    private StationTime(String startStation, String endStation, int travelTime){
        this.startStation = startStation;
        this.endStation = endStation;
        this.travelTime = travelTime;
    }

    private StationTime(String startStation, String endStation){
        this.startStation = startStation;
        this.endStation = endStation;
    }

    public static StationTime createStationTime(String startStation, String endStation, int travelTime){
        return new StationTime(startStation, endStation, travelTime);
    }

    public static StationTime createStationTime(String startStation, String endStation){
        return new StationTime(startStation, endStation);
    }


}
