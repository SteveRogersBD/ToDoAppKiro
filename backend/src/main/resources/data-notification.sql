-- Sample notification preferences for development/testing
-- This file can be used to populate initial notification preferences

-- Default notification preferences for a test user
INSERT INTO user_notification_preferences (user_id, notifications_enabled, default_timing_minutes, sound_enabled, vibration_enabled) 
VALUES ('test-user-1', true, 60, true, true);

-- Custom intervals for the test user (15 minutes, 1 hour, 1 day)
INSERT INTO user_notification_custom_intervals (user_id, interval_minutes) 
VALUES 
    ('test-user-1', 15),
    ('test-user-1', 60),
    ('test-user-1', 1440);

-- Another test user with different preferences
INSERT INTO user_notification_preferences (user_id, notifications_enabled, default_timing_minutes, sound_enabled, vibration_enabled) 
VALUES ('test-user-2', true, 1440, false, true);

-- Custom intervals for the second test user (1 day, 1 week)
INSERT INTO user_notification_custom_intervals (user_id, interval_minutes) 
VALUES 
    ('test-user-2', 1440),
    ('test-user-2', 10080);