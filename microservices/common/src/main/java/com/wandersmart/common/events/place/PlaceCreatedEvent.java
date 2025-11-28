package com.wandersmart.common.events.place;

import java.time.LocalDateTime;
import java.util.UUID;

public class PlaceCreatedEvent {

    private UUID placeId;
    private String name;
    private LocalDateTime createdAt;


    public PlaceCreatedEvent() {}


    public PlaceCreatedEvent(UUID placeId, String name, LocalDateTime createdAt) {
        this.placeId = placeId;
        this.name = name;
        this.createdAt = createdAt;
    }


    public UUID getPlaceId() { return placeId; }
    public void setPlaceId(UUID placeId) { this.placeId = placeId; }


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }


    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}

