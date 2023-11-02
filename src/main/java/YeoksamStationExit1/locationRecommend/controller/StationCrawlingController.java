package YeoksamStationExit1.locationRecommend.controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Controller;

@Controller
public class StationCrawlingController {

    public static void main(String[] args) {

        stationCrawling();

    }

    public static void stationCrawling() {

        System.out.println(1212312334);

        System.setProperty("webdriver.chrome.driver",
                "/home/ubuntu/BEapi/MeetHare-Location-Recommend/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // 지도 서비스 페이지 열기
        driver.get("https://map.naver.com/p?c=15.00,0,0,0,dh"); // 실제 사용하는 지도 서비스 주소로 바꿔주세요.

    }

}
