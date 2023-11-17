package YeoksamStationExit1.locationRecommend.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@RequiredArgsConstructor
@EnableWebSocketMessageBroker
@CrossOrigin("*")
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){

        registry.enableSimpleBroker("/sub");
        //메세지 가공이 필요한 경우 핸들러를 통해 가도록 하기 위함 prefix
        registry.setApplicationDestinationPrefixes("/pub");
    }

    /**
     * Endpoint : /ws
     * */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry
                .addEndpoint("/ws")
                .setAllowedOrigins("wss://meethare.site","ws://meethare.site","https://meethare.site","http://meethare.site","wss://localhost:3000","ws://localhost:3000","https://localhost:3000","http://localhost:3000");
    }



}