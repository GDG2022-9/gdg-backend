package com.gdg.gdgbackend.api.health.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class HealthCheckDto {

    private boolean status;

    private String health;
}
