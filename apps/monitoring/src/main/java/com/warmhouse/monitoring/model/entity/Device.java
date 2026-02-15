package com.warmhouse.monitoring.model.entity;

import com.warmhouse.monitoring.model.enums.DeviceStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
@Entity
@Table(name = "device_registry")
public class Device {

    @Id
    @Column(length = 36)
    private String deviceId;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeviceStatus status;

    @Column
    private String location;

    @Column
    private Instant lastSeen;

    @Column
    private String properties;

    @Column(nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    @Column
    private Instant updatedAt;

    public Device() {
    }

    public Device(String deviceId, String name, DeviceStatus status) {
        this.deviceId = deviceId;
        this.name = name;
        this.status = status;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Instant.now();
    }
}
