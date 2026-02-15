-- Warmhouse Monitoring App - Database Schema Initialization

CREATE DATABASE monitoring;

-- Connect to the database
\c monitoring;


-- Device Registry Table
CREATE TABLE IF NOT EXISTS device_registry (
    device_id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    status VARCHAR(20) NOT NULL CHECK (status IN ('ONLINE', 'OFFLINE', 'MAINTENANCE', 'ERROR')),
    location VARCHAR(100),
    last_seen TIMESTAMP WITH TIME ZONE,
    properties JSON,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE
);

-- Indexes for device_registry
CREATE INDEX IF NOT EXISTS idx_device_status ON device_registry(status);
CREATE INDEX IF NOT EXISTS idx_device_location ON device_registry(location);

-- Telemetry Data Table (time-series optimized)
CREATE TABLE IF NOT EXISTS telemetry_data (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    device_id VARCHAR(36) NOT NULL,
    value DOUBLE PRECISION NOT NULL,
    unit VARCHAR(20) NOT NULL,
    timestamp TIMESTAMP WITH TIME ZONE NOT NULL,
    metadata JSON,
    CONSTRAINT fk_telemetry_device FOREIGN KEY (device_id) REFERENCES device_registry(device_id) ON DELETE CASCADE
);

-- Indexes for telemetry_data
CREATE INDEX IF NOT EXISTS idx_telemetry_device_timestamp ON telemetry_data(device_id, timestamp DESC);
CREATE INDEX IF NOT EXISTS idx_telemetry_timestamp ON telemetry_data(timestamp DESC);

-- Comment for table documentation
COMMENT ON TABLE device_registry IS 'Registry of all IoT devices in the system';
COMMENT ON TABLE telemetry_data IS 'Time-series telemetry data from IoT devices';
