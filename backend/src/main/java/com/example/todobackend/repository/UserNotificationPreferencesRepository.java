package com.example.todobackend.repository;

import com.example.todobackend.model.UserNotificationPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserNotificationPreferencesRepository extends JpaRepository<UserNotificationPreferences, String> {
    
    /**
     * Find notification preferences by user ID
     */
    Optional<UserNotificationPreferences> findByUserId(String userId);
    
    /**
     * Check if user has notifications enabled
     */
    default boolean areNotificationsEnabledForUser(String userId) {
        return findByUserId(userId)
                .map(UserNotificationPreferences::isNotificationsEnabled)
                .orElse(true); // Default to enabled if no preferences found
    }
}