package com.example.todobackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "notification_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationHistory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "task_id", nullable = false)
    private Long taskId;
    
    @Column(name = "user_id", nullable = false)
    private String userId;
    
    @Column(name = "sent_at", nullable = false)
    private LocalDateTime sentAt;
    
    @Column(name = "dismissed_at")
    private LocalDateTime dismissedAt;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "action", nullable = false)
    private NotificationAction action;
    
    @Column(name = "device_info")
    private String deviceInfo;
    
    // Custom constructor for business logic
    public NotificationHistory(Long taskId, String userId, NotificationAction action, String deviceInfo) {
        this.taskId = taskId;
        this.userId = userId;
        this.sentAt = LocalDateTime.now();
        this.action = action;
        this.deviceInfo = deviceInfo;
    }
}