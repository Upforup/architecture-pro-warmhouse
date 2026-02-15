package com.warmhouse.monitoring.model;

import java.time.Instant;

public record ErrorResponse(
        String error,
        String code,
        Instant timestamp
) {
    public ErrorResponse(String error, String code) {
        this(error, code, Instant.now());
    }
}
