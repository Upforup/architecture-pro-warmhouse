package com.warmhouse.monitoring.model.dto;

public record MetricsDTO(
        String deviceId,
        Double average,
        Double min,
        Double max,
        Long count
) {
}
