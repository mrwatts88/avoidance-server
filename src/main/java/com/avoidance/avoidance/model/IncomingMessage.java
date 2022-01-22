package com.avoidance.avoidance.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class IncomingMessage {
    private List<Seeker> seekers;
}
