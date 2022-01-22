package com.avoidance.avoidance.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Seeker {
    private double latitude;
    private double longitude;
}
