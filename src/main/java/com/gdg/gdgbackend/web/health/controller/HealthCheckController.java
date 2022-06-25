package com.gdg.gdgbackend.web.health.controller;

import com.gdg.gdgbackend.web.health.dto.HealthCheckDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HealthCheckController {

    @GetMapping("/health")
    public ResponseEntity<HealthCheckDto> healthCheck() {
        HealthCheckDto healthCheckDto = HealthCheckDto.builder()
                .status(true)
                .health("ok")
                .build();

        return ResponseEntity.ok(healthCheckDto);
    }
}
