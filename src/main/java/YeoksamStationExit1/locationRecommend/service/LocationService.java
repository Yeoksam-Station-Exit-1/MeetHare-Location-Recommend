package YeoksamStationExit1.locationRecommend.service;

import YeoksamStationExit1.locationRecommend.dto.request.FindCenterCoordinatesReqDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class LocationService {

    @Value("${kakao.key}")
    private String key;
    private String url = "https://dapi.kakao.com/v2/local/search/category";

    /**
     * 중심좌표 기준 가까운 지하철 역을 구하는 메서드
     * 외부 api (kakao api) 를 사용하여 목록을 받아옴.
     * */
    public void findNearbyAreas(double[] centerCoordinates){
        //중심좌표
        double longitude = centerCoordinates[0];//경도
        double latitude = centerCoordinates[1];//위도

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "KakaoAK " + key); //Authorization 설정
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
        URI targetUrl = UriComponentsBuilder
                .fromUriString(url) //기본 url
                .queryParam("category_group_code", "SW8") //카테고리설정(지하철)
                .queryParam("x",longitude ) //경도
                .queryParam("y",latitude) //위도
                .queryParam("radius", 1500) //거리 m단위
                .build()
                .encode(StandardCharsets.UTF_8) //인코딩
                .toUri();

        //GetForObject는 헤더를 정의할 수 없음
        ResponseEntity<Map> result = restTemplate.exchange(targetUrl, HttpMethod.GET, httpEntity, Map.class);
        getStationNames(result);
    }

    /**
     * api 를 사용하여 받아온 data 중 필요한 데이터만을 가져옴
     * ResponseEntity 중 역이름만 꺼내서 List에 담기
     * */
    public Set<String> getStationNames(ResponseEntity<Map> responseEntity){
        Map<String, Object> responseBody = responseEntity.getBody();

        // "documents" 키의 값을 가져와 List<Map> 형태로 캐스팅
        List<Map<String, Object>> documents = (List<Map<String, Object>>) responseBody.get("documents");

        // "place_name" 값을 추출하여 List<String>에 담기
        Set<String> placeNames = new HashSet<>(); //역이름만 담은 리스트
        for (Map<String, Object> document : documents) {
            String placeName = (String) document.get("place_name");
            String[] words = placeName.split(" "); //호선은 제외한 역이름만 사용
            if (words.length > 0) {
                placeNames.add(words[0]);
            }
        }

        // 결과 출력
        for (String placeName : placeNames) {
            System.out.println(placeName);
        }
        return placeNames;
    }

    /**
     * 사용자의 위치에 따른 무게중심 좌표를 구하는 메서드
     * 경도, 위도 순으로 double형식의 배열에 담아 return 함
     * */
    public double[] findCenterCoordinates(List<FindCenterCoordinatesReqDto> req){
        List<FindCenterCoordinatesReqDto> positions = req;
        double cnt = req.size(); //사용자 수
        double sumOfLong = 0; //경도
        double sumOfLat = 0; //위도
        for (FindCenterCoordinatesReqDto fcc : positions) {
            sumOfLong += fcc.getLongitude();
            sumOfLat += fcc.getLatitude();
        }
        double[] centerCoordinates = new double[2];
        centerCoordinates[0] = Math.round((sumOfLong/cnt)*100000000.0)/100000000.0; //경도
        centerCoordinates[1] = Math.round((sumOfLat/cnt)*100000000.0)/100000000.0; //위도
        System.out.println("중심경도 : " +centerCoordinates[0] );
        System.out.println("중심위도 : " +centerCoordinates[1] );

        findNearbyAreas(centerCoordinates);

        return centerCoordinates; 
    }


}
