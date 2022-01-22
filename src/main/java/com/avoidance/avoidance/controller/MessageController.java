package com.avoidance.avoidance.controller;

import com.avoidance.avoidance.model.IncomingMessage;
import com.avoidance.avoidance.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class MessageController {

    @Autowired
    private StateService stateService;

    @MessageMapping("/start/{id}")
    public void start( @Payload IncomingMessage incomingMessage, @DestinationVariable String id) {
        stateService.start(id, incomingMessage.getSeekers());
    }

    @MessageMapping("/stop/{id}")
    public void stop(@DestinationVariable String id) {
        stateService.stop(id);
    }
}
