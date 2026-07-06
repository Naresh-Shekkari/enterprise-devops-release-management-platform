package com.ermp.platform.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.ermp.platform.dto.HealthResponse;
import com.ermp.platform.service.HealthService;

@Service
public class HealthServiceImpl implements HealthService {

    @Override
    public HealthResponse getApplicationHealth() {

        HealthResponse response = new HealthResponse();

        response.setApplication("Enterprise DevOps Release Management Platform");
        response.setVersion("1.0.0");
        response.setStatus("UP");
        response.setEnvironment("Development");
        response.setTimestamp(LocalDateTime.now());

        return response;
    }

}