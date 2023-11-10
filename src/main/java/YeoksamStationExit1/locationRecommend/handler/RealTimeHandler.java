//package YeoksamStationExit1.locationRecommend.handler;
//
//import YeoksamStationExit1.locationRecommend.vo.Message;
//import lombok.extern.log4j.Log4j2;
//import org.apache.tomcat.websocket.Util;
//import org.aspectj.weaver.Utils;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Component
//@Log4j2
//public class RealTimeHandler extends TextWebSocketHandler {
//
//    //    private static List<WebSocketSession> list = new ArrayList<>();
//    private final Map<String, WebSocketSession> sessions = new HashMap<>(); //key: 세션Id, value: 세션
//
//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
////        String payload = message.getPayload();
////        log.info("payload : " + payload);
////
////        for (WebSocketSession sess : list) {
////            sess.sendMessage(message);
////        }
//        Message message = Utils.getObject(massage.getPayload());
//    }
//
//    /**
//     * Client 접속 시 호출되는 메서드
//     */
//    @Override
//    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//
//        var sessionId = session.getId();
//        sessions.put(sessionId, session);
//        log.info(session + " 클라이언트 접속");
//
//        Message message = Message.builder().sender(sessionId).receiver("all").build();
//        message.newConnect();
//
//        sessions.values().forEach(s -> {
//            try {
//                if (!s.getId().equals(sessionId)) {
//                    s.sendMessage(new TextMessage(Utils.getString(message)));
//                }
//            } catch (Exception e) {
//                //TODO: 예외처리
//            }
//        });
//
//
//    }
//
//    /**
//     * Client 접속 해제 시 호출되는 메서드
//     */
//    @Override
//    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//
//        log.info(session + " 클라이언트 접속 해제");
////        list.remove(session);
//    }
//
//    @Override
//    public void handleTransportError(WebSocketSession session, CloseStatus status) throws Exception {
//
//    }
//
//}
