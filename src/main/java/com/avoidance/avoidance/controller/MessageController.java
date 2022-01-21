package com.avoidance.avoidance.controller;

import com.avoidance.avoidance.model.Message;
import com.avoidance.avoidance.model.OutgoingMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageController {

    @MessageMapping("/start")
    @SendTo("/topic/updates")
    public OutgoingMessage start(Message message) throws Exception {
        System.out.println("start");
        Thread.sleep(1000);
        return new OutgoingMessage("Hello, " + message.getName());
    }

    @SendTo("/topic/updates")
    public OutgoingMessage update(Message message) throws Exception {
        System.out.println("update");
        Thread.sleep(1000);
        return new OutgoingMessage("Updating, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
