package com.avoidance.avoidance.service;

import com.avoidance.avoidance.model.Seeker;
import com.avoidance.avoidance.model.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

@Service
public class StateService {
    private List<State> states = new ArrayList<>();

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    public void init() {
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                emit();
            }
        }, 0, 1000);
    }

    public void emit() {
        for (State state : states) {
            this.simpMessagingTemplate.convertAndSend("/topic/updates/" + state.getId(), state);
        }
    }

    public void start(final String id, final List<Seeker> seekers) {
        this.states.add(State.builder().id(id).seekers(seekers).build());
        this.init();
    }

    public void stop(final String id) {
        this.states = this.states.stream().filter(s -> !s.getId().equals(id)).collect(Collectors.toList());
    }
}
