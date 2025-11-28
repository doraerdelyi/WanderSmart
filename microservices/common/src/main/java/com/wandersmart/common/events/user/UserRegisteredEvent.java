package com.wandersmart.common.events.user;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserRegisteredEvent {
    private UUID userId;
    private String email;
    private String fullName;
    private LocalDateTime registeredAt;


    public UserRegisteredEvent() {}


    public UserRegisteredEvent(UUID userId, String email, String fullName, LocalDateTime registeredAt) {
        this.userId = userId;
        this.email = email;
        this.fullName = fullName;
        this.registeredAt = registeredAt;
    }


    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }


    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }


    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }


    public LocalDateTime getRegisteredAt() { return registeredAt; }
    public void setRegisteredAt(LocalDateTime registeredAt) { this.registeredAt = registeredAt; }
}
