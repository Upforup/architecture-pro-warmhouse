package com.warmhouse.monitoring.model;

public record MetricsDTO(
        String deviceId,
        Double average,
        Double min,
        Double max,
        Long count
) {
}
