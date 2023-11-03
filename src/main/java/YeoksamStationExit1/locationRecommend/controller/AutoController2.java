//package YeoksamStationExit1.locationRecommend.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//
//@EnableScheduling
//@Configuration
//public class AutoController2 {
//
//    @Autowired
//    private StationCrawlingController stationCrawlingController;

//
//    @Scheduled(fixedRate = 2000) // 5분마다 실행 (밀리초 단위)
//    public void performCrawling1() {
//
//        stationCrawlingController.stationCrawling(100);

//        try {
//            Thread.sleep(1000); // 1000 밀리초 = 1초
//        } catch (InterruptedException e) {
//            e.printStackTrace(); // 예외 처리
//        }
//
//        stationCrawlingController.stationCrawling(100);
//
//        try {
//            Thread.sleep(1000); // 1000 밀리초 = 1초
//        } catch (InterruptedException e) {
//            e.printStackTrace(); // 예외 처리
//        }
//
//        stationCrawlingController.stationCrawling(150);
//
//        try {
//            Thread.sleep(1000); // 1000 밀리초 = 1초
//        } catch (InterruptedException e) {
//            e.printStackTrace(); // 예외 처리
//        }
//
//        stationCrawlingController.stationCrawling(200);
//
//        try {
//            Thread.sleep(1000); // 1000 밀리초 = 1초
//        } catch (InterruptedException e) {
//            e.printStackTrace(); // 예외 처리
//        }
//
//        stationCrawlingController.stationCrawling(250);
//    }

//    @Scheduled(fixedRate = 2000) // 5분마다 실행 (밀리초 단위)
//    public void performCrawling2() {
//        stationCrawlingController.stationCrawling(100);
//    }
//
//    @Scheduled(fixedDelay = 300000) // 5분마다 실행 (밀리초 단위)
//    public void performCrawling3() {
//        stationCrawlingController.stationCrawling(150);
//    }
//
//    @Scheduled(fixedDelay = 300000) // 5분마다 실행 (밀리초 단위)
//    public void performCrawling4() {
//        stationCrawlingController.stationCrawling(200);
//    }
//
//    @Scheduled(fixedDelay = 300000) // 5분마다 실행 (밀리초 단위)
//    public void performCrawling5() {
//        stationCrawlingController.stationCrawling(250);
//    }

//}
