package com.example.todobackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_notification_preferences")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserNotificationPreferences {
    
    @Id
    @Column(name = "user_id")
    private String userId;
    
    @Column(name = "notifications_enabled", nullable = false)
    private boolean notificationsEnabled = true;
    
    @Column(name = "default_timing_minutes", nullable = false)
    private long defaultTimingMinutes = 60; // Default to 1 hour before deadline
    
    @Column(name = "sound_enabled", nullable = false)
    private boolean soundEnabled = true;
    
    @Column(name = "vibration_enabled", nullable = false)
    private boolean vibrationEnabled = true;
    
    @ElementCollection
    @CollectionTable(
        name = "user_notification_custom_intervals",
        joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "interval_minutes")
    private List<Long> customIntervals = new ArrayList<>();
    
    // Custom constructor for business logic
    public UserNotificationPreferences(String userId) {
        this.userId = userId;
        this.notificationsEnabled = true;
        this.defaultTimingMinutes = 60;
        this.soundEnabled = true;
        this.vibrationEnabled = true;
        this.customIntervals = new ArrayList<>();
    }
}