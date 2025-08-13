package com.example.todobackend.repository;

import com.example.todobackend.model.NotificationAction;
import com.example.todobackend.model.NotificationHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NotificationHistoryRepository extends JpaRepository<NotificationHistory, Long> {
    
    /**
     * Find notification history for a specific user with pagination
     */
    Page<NotificationHistory> findByUserIdOrderBySentAtDesc(String userId, Pageable pageable);
    
    /**
     * Find notification history for a specific task
     */
    List<NotificationHistory> findByTaskIdOrderBySentAtDesc(Long taskId);
    
    /**
     * Find notification history for a specific user and task
     */
    List<NotificationHistory> findByUserIdAndTaskIdOrderBySentAtDesc(String userId, Long taskId);
    
    /**
     * Find notifications by action type for a user
     */
    List<NotificationHistory> findByUserIdAndAction(String userId, NotificationAction action);
    
    /**
     * Find recent notification history within a time range
     */
    @Query("SELECT n FROM NotificationHistory n WHERE n.userId = :userId AND n.sentAt >= :fromTime ORDER BY n.sentAt DESC")
    List<NotificationHistory> findRecentNotifications(@Param("userId") String userId, 
                                                     @Param("fromTime") LocalDateTime fromTime);
    
    /**
     * Count notifications by action for a user
     */
    long countByUserIdAndAction(String userId, NotificationAction action);
    
    /**
     * Delete old notification history records
     */
    void deleteBySentAtBefore(LocalDateTime cutoffTime);
}