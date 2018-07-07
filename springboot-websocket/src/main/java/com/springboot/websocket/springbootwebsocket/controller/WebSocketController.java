package com.springboot.websocket.springbootwebsocket.controller;

import com.springboot.websocket.springbootwebsocket.message.WebSocketMessage;
import com.springboot.websocket.springbootwebsocket.response.WebSocketResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/7/7 22:32
 */
@RestController
public class WebSocketController {

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WebSocketResponse say(WebSocketMessage message) throws Exception{
        Thread.sleep(3000);
        return new WebSocketResponse("Welcome,"+message.getName()+"!");
    }
}
