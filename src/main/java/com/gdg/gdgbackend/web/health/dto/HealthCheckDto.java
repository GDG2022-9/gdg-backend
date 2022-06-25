package com.gdg.gdgbackend.web.health.dto;

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
