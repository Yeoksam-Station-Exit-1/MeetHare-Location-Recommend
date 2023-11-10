package YeoksamStationExit1.locationRecommend.controller;

import YeoksamStationExit1.locationRecommend.vo.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
public class RealTimeController {

    //    @GetMapping("/realtime")
//    public String chatGET(){
//
//        log.info("@RealTimeController, realtime GET()");
//
//        return "realtime";
//    }
    private final SimpMessageSendingOperations simpMessageSendingOperations;

    /*
        /sub/channel/12345      - 구독(channelId:12345)
        /pub/hello              - 메시지 발행
    */

    @MessageMapping("/hello")
    public void message(Message message) {
        log.info("message.getChannelId : "+ message.getChannelId());
        log.info("message : "+ message.getData() );
        simpMessageSendingOperations.convertAndSend("/sub/channel/" + message.getChannelId(), message);
    }
}