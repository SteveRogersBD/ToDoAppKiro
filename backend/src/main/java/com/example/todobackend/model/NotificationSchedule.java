package com.example.todobackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "notification_schedule")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationSchedule {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "task_id", nullable = false)
    private Long taskId;
    
    @Column(name = "user_id", nullable = false)
    private String userId;
    
    @Column(name = "scheduled_time", nullable = false)
    private LocalDateTime scheduledTime;
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private NotificationStatus status;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "priority", nullable = false)
    private NotificationPriority priority;
    
    @Column(name = "notification_content", columnDefinition = "TEXT")
    private String notificationContent;
    
    // Custom constructor for business logic
    public NotificationSchedule(Long taskId, String userId, LocalDateTime scheduledTime, 
                               NotificationPriority priority, String notificationContent) {
        this.taskId = taskId;
        this.userId = userId;
        this.scheduledTime = scheduledTime;
        this.priority = priority;
        this.notificationContent = notificationContent;
        this.createdAt = LocalDateTime.now();
        this.status = NotificationStatus.SCHEDULED;
    }
}