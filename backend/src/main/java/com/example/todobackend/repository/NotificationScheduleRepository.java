package com.example.todobackend.repository;

import com.example.todobackend.model.NotificationSchedule;
import com.example.todobackend.model.NotificationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NotificationScheduleRepository extends JpaRepository<NotificationSchedule, Long> {
    
    /**
     * Find all scheduled notifications for a specific task
     */
    List<NotificationSchedule> findByTaskIdAndStatus(Long taskId, NotificationStatus status);
    
    /**
     * Find all notifications for a specific user
     */
    List<NotificationSchedule> findByUserId(String userId);
    
    /**
     * Find all notifications scheduled before a specific time with given status
     */
    List<NotificationSchedule> findByScheduledTimeBeforeAndStatus(LocalDateTime time, NotificationStatus status);
    
    /**
     * Find all scheduled notifications for a specific task (any status)
     */
    List<NotificationSchedule> findByTaskId(Long taskId);
    
    /**
     * Delete all notifications for a specific task
     */
    void deleteByTaskId(Long taskId);
    
    /**
     * Find notifications that are due for processing
     */
    @Query("SELECT n FROM NotificationSchedule n WHERE n.scheduledTime <= :currentTime AND n.status = :status")
    List<NotificationSchedule> findDueNotifications(@Param("currentTime") LocalDateTime currentTime, 
                                                   @Param("status") NotificationStatus status);
    
    /**
     * Count scheduled notifications for a user
     */
    long countByUserIdAndStatus(String userId, NotificationStatus status);
}