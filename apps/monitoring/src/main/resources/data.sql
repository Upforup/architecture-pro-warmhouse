-- Insert sample devices
INSERT INTO device_registry (device_id, name, status, location, last_seen, created_at, updated_at)
VALUES
    ('device-001', 'Living Room Temperature', 'ONLINE', 'Living Room', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('device-002', 'Bedroom Humidity', 'OFFLINE', 'Bedroom', CURRENT_TIMESTAMP - INTERVAL '5 minute', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('device-003', 'Kitchen Motion Sensor', 'ONLINE', 'Kitchen', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
