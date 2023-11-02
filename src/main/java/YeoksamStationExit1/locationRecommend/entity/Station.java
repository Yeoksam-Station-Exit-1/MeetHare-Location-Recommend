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


}
