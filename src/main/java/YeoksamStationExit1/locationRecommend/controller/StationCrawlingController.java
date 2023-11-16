
//package YeoksamStationExit1.locationRecommend.controller;
//
//import YeoksamStationExit1.locationRecommend.entity.StationTime;
//import YeoksamStationExit1.locationRecommend.repository.StationTimeRepository;
////import YeoksamStationExit1.locationRecommend.service.LocationService;
//import lombok.RequiredArgsConstructor;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.springframework.http.HttpRequest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.client.support.HttpRequestWrapper;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpSession;
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@CrossOrigin("*")
//@RequestMapping("/craw")
//@RequiredArgsConstructor
//public class StationCrawlingController {
//
////    private final LocationService locationService;
//    private final StationTimeRepository stationTimeRepository;
//
////    @GetMapping("/time")
//    public ResponseEntity<?> stationCrawling( int offset) {
//
//        System.setProperty("webdriver.chrome.driver",
//                "./chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver = new ChromeDriver(options);
//
//        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//        // 지도 서비스 페이지 열기
//        driver.get("https://map.naver.com/p/directions/-/-/-/transit");
//
//        try {
//            Thread.sleep(5000); // 1000 밀리초 = 1초
//        } catch (InterruptedException e) {
//            e.printStackTrace(); // 예외 처리
//        }
//
////        WebElement navbar = driver.findElement(By.className("iLeNBU"));
////        System.out.println(navbar);
////        navbar.click();
//
//        try {
//            Thread.sleep(300); // 1000 밀리초 = 1초
//        } catch (InterruptedException e) {
//            e.printStackTrace(); // 예외 처리
//        }
//
//        List<StationTime> testList = stationTimeRepository.findStationTimeByIntGreaterThanEqual(offset);
//
//        WebElement inputStart = driver.findElement(By.cssSelector(".start>div>input"));
//        WebElement inputEnd = driver.findElement(By.cssSelector(".goal>div>input"));
//
//        try{
//
//        for(StationTime testSt : testList){
//
//            while(!inputStart.getAttribute("value").isEmpty()){
//                inputStart.sendKeys(Keys.BACK_SPACE);
//            }
//
//            try {
//                Thread.sleep(1500); // 1000 밀리초 = 1초
//            } catch (InterruptedException e) {
//                e.printStackTrace(); // 예외 처리
//            }
//
//            inputStart.sendKeys(testSt.getStartStation());
//
//            try {
//                Thread.sleep(1000); // 1000 밀리초 = 1초
//            } catch (InterruptedException e) {
//                e.printStackTrace(); // 예외 처리
//            }
//            inputStart.sendKeys(Keys.ENTER);
//            try {
//                Thread.sleep(200); // 1000 밀리초 = 1초
//            } catch (InterruptedException e) {
//                e.printStackTrace(); // 예외 처리
//            }
//            inputStart.sendKeys(Keys.ENTER);
//            try {
//                Thread.sleep(200); // 1000 밀리초 = 1초
//            } catch (InterruptedException e) {
//                e.printStackTrace(); // 예외 처리
//            }
//            inputStart.sendKeys(Keys.ENTER);
//
//            try {
//                Thread.sleep(500); // 1000 밀리초 = 1초
//            } catch (InterruptedException e) {
//                e.printStackTrace(); // 예외 처리
//            }
//
//            while(!inputEnd.getAttribute("value").isEmpty()){
//                inputEnd.sendKeys(Keys.BACK_SPACE);
//            }
//
//            try {
//                Thread.sleep(1000); // 1000 밀리초 = 1초
//            } catch (InterruptedException e) {
//                e.printStackTrace(); // 예외 처리
//            }
//
//            inputEnd.sendKeys(testSt.getEndStation());
//            try {
//                Thread.sleep(1000); // 1000 밀리초 = 1초
//            } catch (InterruptedException e) {
//                e.printStackTrace(); // 예외 처리
//            }
//            inputEnd.sendKeys(Keys.ENTER);
//            try {
//                Thread.sleep(200); // 1000 밀리초 = 1초
//            } catch (InterruptedException e) {
//                e.printStackTrace(); // 예외 처리
//            }
//            inputEnd.sendKeys(Keys.ENTER);
//            try {
//                Thread.sleep(200); // 1000 밀리초 = 1초
//            } catch (InterruptedException e) {
//                e.printStackTrace(); // 예외 처리
//            }
//            inputEnd.sendKeys(Keys.ENTER);
//
//            try {
//                Thread.sleep(1000); // 1000 밀리초 = 1초
//            } catch (InterruptedException e) {
//                e.printStackTrace(); // 예외 처리
//            }
//
//            WebElement searchTime = driver.findElement(By.className("search"));
//            searchTime.click();
//            searchTime.click();
//
//            try {
//                Thread.sleep(3000);
//            } catch (Exception e) {
//                e.printStackTrace(); // 예외 처리
//            }
//
//
//            try {
//                WebElement switchoff = driver.findElement(By.className("on"));
//                switchoff.click();
//            } catch (Exception ignored) {
//            }
//
//
//            try {
//                Thread.sleep(5000);
//            } catch (Exception e) {
//                e.printStackTrace(); // 예외 처리
//            }
//
//            WebElement takenTime = driver.findElement(By.className("wrap_time_taken"));
//
//            String timeString = takenTime.getText();
//
//            if(timeString.contains("시간") && timeString.contains("분")){
//
//                String[] parts = timeString.split("시간|분");
//                int hours = Integer.parseInt(parts[0]);
//                int minutes = Integer.parseInt(parts[1]);
//                int totalMinutes = hours * 60 + minutes;
//
//                stationTimeRepository.updateStatusStation(testSt.getStationTimeId(), totalMinutes);
//
//            }else if(timeString.contains("시간")){
//
//                String[] parts = timeString.split("시간");
//                int hours = Integer.parseInt(parts[0]);
//                int totalMinutes = hours * 60;
//
//                stationTimeRepository.updateStatusStation(testSt.getStationTimeId(), totalMinutes);
//
//            }else{
//
//                String[] parts = timeString.split("분");
//                int totalMinutes = Integer.parseInt(parts[0]);
//                stationTimeRepository.updateStatusStation(testSt.getStationTimeId(), totalMinutes);
//
//            }
//
//        }
//
//        }catch(Exception e){
//            driver.quit();
//        }
//
//        try {
//            Thread.sleep(500); // 1000 밀리초 = 1초
//        } catch (InterruptedException ignored) {
//        }
//
//        driver.quit();
//
//        return new ResponseEntity<>(HttpStatus.OK);
//
//    }
//
//}

