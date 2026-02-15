package com.warmhouse.monitoring.service;

import com.warmhouse.monitoring.model.dto.DeviceStatusDTO;
import com.warmhouse.monitoring.model.entity.Device;
import com.warmhouse.monitoring.model.enums.DeviceStatus;
import com.warmhouse.monitoring.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public Optional<DeviceStatusDTO> getDeviceStatus(String deviceId) {
        return deviceRepository.findById(deviceId)
                .map(this::toDTO);
    }

    public void updateDeviceState(String deviceId, DeviceStatus status) {
        deviceRepository.findById(deviceId).ifPresent(device -> {
            device.setStatus(status);
            device.setLastSeen(java.time.Instant.now());
            deviceRepository.save(device);
        });
    }

    private DeviceStatusDTO toDTO(Device device) {
        return new DeviceStatusDTO(
                device.getDeviceId(),
                device.getStatus().name(),
                device.getLastSeen()
        );
    }
}
