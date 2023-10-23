package YeoksamStationExit1.locationRecommend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "station_infra")
public class StationInfra{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "station_id")
    private Integer stationId;

    @Column(name = "station_name")
    private String stationName;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "infra_count")
    private Integer infraCount;

}
