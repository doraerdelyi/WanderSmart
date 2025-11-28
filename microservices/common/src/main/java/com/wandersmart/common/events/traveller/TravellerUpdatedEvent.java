package com.wandersmart.common.events.traveller;

import java.time.LocalDateTime;
import java.util.UUID;

public class TravellerUpdatedEvent {
    private UUID travellerId;
    private String nickname;
    private LocalDateTime updatedAt;


    public TravellerUpdatedEvent() {}


    public TravellerUpdatedEvent(UUID travellerId, String nickname, LocalDateTime updatedAt) {
        this.travellerId = travellerId;
        this.nickname = nickname;
        this.updatedAt = updatedAt;
    }


    public UUID getTravellerId() { return travellerId; }
    public void setTravellerId(UUID travellerId) { this.travellerId = travellerId; }


    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }


    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}

