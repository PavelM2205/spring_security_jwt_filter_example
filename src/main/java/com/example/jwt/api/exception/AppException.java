package com.example.jwt.api.exception;

import lombok.Data;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Data
public class AppException {
    private int status;
    private String message;
    private Instant timestamp;

    public AppException(int status, String message) {
        this.status = status;
        this.message = message;
        timestamp = Instant.now().truncatedTo(ChronoUnit.SECONDS);
    }
}
