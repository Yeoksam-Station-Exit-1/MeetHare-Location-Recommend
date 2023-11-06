package YeoksamStationExit1.locationRecommend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@EnableAsync
@EnableScheduling
@Configuration
public class AutoController {

    @Autowired
    private StationCrawlingController stationCrawlingController;

    @Async
//    @Scheduled(cron = "* */5 7-22 * * *")
    @Scheduled(fixedRate = 300000)
    public void performCrawling1() {

        stationCrawlingController.stationCrawling(50);

    }

    @Async
//    @Scheduled(cron = "* */5 7-22 * * *")
    @Scheduled(fixedRate = 300000)
    public void performCrawling2() {

        stationCrawlingController.stationCrawling(100);

    }

    @Async
//    @Scheduled(cron = "* */5 7-22 * * *")
    @Scheduled(fixedRate = 300000)
    public void performCrawling3() {
        stationCrawlingController.stationCrawling(150);
    }

    @Async
//    @Scheduled(cron = "* */5 7-22 * * *")
    @Scheduled(fixedRate = 300000)
    public void performCrawling4() {
        stationCrawlingController.stationCrawling(200);
    }

    @Async
//    @Scheduled(cron = "* */5 7-22 * * *")
    @Scheduled(fixedRate = 300000)
    public void performCrawling5() {
        stationCrawlingController.stationCrawling(250);
    }

    @Async
//    @Scheduled(cron = "* */5 7-22 * * *")
    @Scheduled(fixedRate = 300000)
    public void performCrawling6() {
        stationCrawlingController.stationCrawling(300);
    }

    @Async
//    @Scheduled(cron = "* */5 7-22 * * *")
    @Scheduled(fixedRate = 300000)
    public void performCrawling7() {
        stationCrawlingController.stationCrawling(350);
    }

    @Async
//    @Scheduled(cron = "* */5 7-22 * * *")
    @Scheduled(fixedRate = 300000)
    public void performCrawling8() {
        stationCrawlingController.stationCrawling(400);
    }

//    @Async
//    @Scheduled(fixedDelay = 300000) // 5분마다 실행 (밀리초 단위)
//    public void performCrawling9() {
//        stationCrawlingController.stationCrawling(450);
//    }
//
//    @Async
//    @Scheduled(fixedDelay = 300000) // 5분마다 실행 (밀리초 단위)
//    public void performCrawling10() {
//        stationCrawlingController.stationCrawling(500);
//    }

}
