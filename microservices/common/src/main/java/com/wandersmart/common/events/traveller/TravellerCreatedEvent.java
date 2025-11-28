package com.wandersmart.common.events.traveller;

import java.time.LocalDateTime;
import java.util.UUID;

public class TravellerCreatedEvent {
    private UUID travellerId;
    private String nickname;
    private LocalDateTime createdAt;


    public TravellerCreatedEvent() {}


    public TravellerCreatedEvent(UUID travellerId, String nickname, LocalDateTime createdAt) {
        this.travellerId = travellerId;
        this.nickname = nickname;
        this.createdAt = createdAt;
    }


    public UUID getTravellerId() { return travellerId; }
    public void setTravellerId(UUID travellerId) { this.travellerId = travellerId; }


    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }


    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}

