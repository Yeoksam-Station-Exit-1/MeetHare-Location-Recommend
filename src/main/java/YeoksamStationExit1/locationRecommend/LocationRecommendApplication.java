package YeoksamStationExit1.locationRecommend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import YeoksamStationExit1.locationRecommend.controller.StationCrawlingController;

@SpringBootApplication
public class LocationRecommendApplication {

	private static StationCrawlingController sc = new StationCrawlingController();

	public static void main(String[] args) {
		SpringApplication.run(LocationRecommendApplication.class, args);

		sc.stationCrawling();
	}

}
