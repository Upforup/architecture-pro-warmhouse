package com.warmhouse.monitoring.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Setter
@Getter
@Entity
@Table(name = "telemetry_data")
public class TelemetryData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String deviceId;

    @Column(nullable = false)
    private BigDecimal value;

    @Column(nullable = false)
    private String unit;

    @Column(nullable = false)
    private Instant timestamp;

    @Column
    private String metadata;

    public TelemetryData() {
    }

    public TelemetryData(String deviceId, BigDecimal value, String unit, Instant timestamp, String metadata) {
        this.deviceId = deviceId;
        this.value = value;
        this.unit = unit;
        this.timestamp = timestamp;
        this.metadata = metadata;
    }

}
