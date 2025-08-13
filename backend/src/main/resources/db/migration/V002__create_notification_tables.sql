-- Create notification_schedule table
CREATE TABLE notification_schedule (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    task_id BIGINT NOT NULL,
    user_id VARCHAR(255) NOT NULL,
    scheduled_time TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL CHECK (status IN ('SCHEDULED', 'SENT', 'CANCELLED', 'FAILED')),
    priority VARCHAR(20) NOT NULL CHECK (priority IN ('LOW', 'MEDIUM', 'HIGH', 'CRITICAL')),
    notification_content TEXT,
    INDEX idx_task_id (task_id),
    INDEX idx_user_id (user_id),
    INDEX idx_scheduled_time (scheduled_time),
    INDEX idx_status (status)
);

-- Create notification_history table
CREATE TABLE notification_history (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    task_id BIGINT NOT NULL,
    user_id VARCHAR(255) NOT NULL,
    sent_at TIMESTAMP NOT NULL,
    dismissed_at TIMESTAMP,
    action VARCHAR(20) NOT NULL CHECK (action IN ('SENT', 'DISMISSED', 'SNOOZED', 'CLICKED')),
    device_info VARCHAR(500),
    INDEX idx_task_id (task_id),
    INDEX idx_user_id (user_id),
    INDEX idx_sent_at (sent_at),
    INDEX idx_action (action)
);

-- Create user_notification_preferences table
CREATE TABLE user_notification_preferences (
    user_id VARCHAR(255) PRIMARY KEY,
    notifications_enabled BOOLEAN NOT NULL DEFAULT TRUE,
    default_timing_minutes BIGINT NOT NULL DEFAULT 60,
    sound_enabled BOOLEAN NOT NULL DEFAULT TRUE,
    vibration_enabled BOOLEAN NOT NULL DEFAULT TRUE
);

-- Create user_notification_custom_intervals table for @ElementCollection
CREATE TABLE user_notification_custom_intervals (
    user_id VARCHAR(255) NOT NULL,
    interval_minutes BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user_notification_preferences(user_id) ON DELETE CASCADE,
    INDEX idx_user_id (user_id)
);