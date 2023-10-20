package YeoksamStationExit1.locationRecommend.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class LocationService {

    @Value("${kakao.key}")
    private String key;
    private String url = "https://dapi.kakao.com/v2/local/search/category";
    public void findNearbyAreas(){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "KakaoAK " + key); //Authorization 설정
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
        URI targetUrl = UriComponentsBuilder
                .fromUriString(url) //기본 url
                .queryParam("category_group_code", "SW8") //카테고리설정(지하철)
                .queryParam("x","126.9579114" ) //경도
                .queryParam("y","37.57446808") //위도
                .queryParam("radius", 1500) //거리 m단위
                .build()
                .encode(StandardCharsets.UTF_8) //인코딩
                .toUri();

        //GetForObject는 헤더를 정의할 수 없음
        ResponseEntity<Map> result = restTemplate.exchange(targetUrl, HttpMethod.GET, httpEntity, Map.class);
        getStationNames(result);
    }

    /**
     * ResponseEntity 중 역이름만 꺼내서 List에 담기
     * */
    public void getStationNames(ResponseEntity<Map> responseEntity){
        Map<String, Object> responseBody = responseEntity.getBody();

        // "documents" 키의 값을 가져와 List<Map> 형태로 캐스팅
        List<Map<String, Object>> documents = (List<Map<String, Object>>) responseBody.get("documents");

        // "place_name" 값을 추출하여 List<String>에 담기
        List<String> placeNames = new ArrayList<>();
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

    }

}
