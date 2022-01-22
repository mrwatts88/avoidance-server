package com.avoidance.avoidance.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class State {
    private String id;
    private final List<Seeker> seekers;
}
