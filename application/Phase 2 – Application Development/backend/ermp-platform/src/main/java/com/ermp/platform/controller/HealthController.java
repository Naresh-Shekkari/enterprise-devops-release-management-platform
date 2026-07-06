package com.ermp.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ermp.platform.dto.HealthResponse;
import com.ermp.platform.service.HealthService;

@RestController
public class HealthController {

    @Autowired
    private HealthService healthService;

    @GetMapping("/api/v1/health")
    public HealthResponse getApplicationHealth() {

        return healthService.getApplicationHealth();

    }

}