package com.ermp.platform.dto;

import java.time.LocalDateTime;

public class HealthResponse {

    private String application;
    private String version;
    private String status;
    private String environment;
    private LocalDateTime timestamp;

    public HealthResponse() {
    }

    public HealthResponse(String application,
                          String version,
                          String status,
                          String environment,
                          LocalDateTime timestamp) {

        this.application = application;
        this.version = version;
        this.status = status;
        this.environment = environment;
        this.timestamp = timestamp;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "HealthResponse{" +
                "application='" + application + '\'' +
                ", version='" + version + '\'' +
                ", status='" + status + '\'' +
                ", environment='" + environment + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}