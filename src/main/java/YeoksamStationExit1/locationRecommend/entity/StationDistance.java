package YeoksamStationExit1.locationRecommend.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "station_distance") // 테이블과 클래스명이 같을 경우 생략 가능
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@SuperBuilder
public class StationDistance {

    @Id
    @Column(name = "station_Distance_id") // station_id를 id로 사용
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stationDistanceId;

    @OneToOne
    @JoinColumn(name = "station_id", referencedColumnName = "station_id")
    private Station station;

    @Column(nullable = true)
    private double min5distance;

    @Column(nullable = true)
    private double min10distance;

    @Column(nullable = true)
    private double min15distance;

    @Column(nullable = true)
    private double min20distance;

    @Column(nullable = true)
    private double min25distance;

    @Column(nullable = true)
    private double min30distance;

    @Column(nullable = true)
    private double min35distance;

    @Column(nullable = true)
    private double min40distance;

    @Column(nullable = true)
    private double min45distance;

    @Column(nullable = true)
    private double min50distance;

    @Column(nullable = true)
    private double min55distance;

    @Column(nullable = true)
    private double min60distance;
}
