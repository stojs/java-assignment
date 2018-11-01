package io.falcon.assignment.websockets;

import io.falcon.assignment.model.TestModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class WebSocketController {

    @MessageMapping("/add")
    @SendTo("/topic/messages")
    public TestModel sendMessage(TestModel test) throws Exception {
        log.info("Received: {}", test.getContent());
        return test;
    }
}
