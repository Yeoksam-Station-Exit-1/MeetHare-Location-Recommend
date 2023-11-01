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
@Table(name = "station") // 테이블과 클래스명이 같을 경우 생략 가능
@Entity
public class Station {

    @Id
    @Column(name = "station_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stationId;

    @Column(name = "station_name")
    private String stationName;
    private double longitude;
    private double latitude;

    @Column(name = "infra_count")
    private int infraCount;

    private double min5distance;
    private double min10distance;
    private double min15distance;
    private double min20distance;
    private double min25distance;
    private double min30distance;
    private double min35distance;
    private double min40distance;
    private double min45distance;
    private double min50distance;
    private double min55distance;
    private double min60distance;
}
