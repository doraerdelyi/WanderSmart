package com.wandersmart.common.events.trip;

import java.time.LocalDateTime;
import java.util.UUID;

public class TripUpdatedEvent {
    private UUID tripId;
    private UUID travellerId;
    private String title;
    private LocalDateTime updatedAt;


    public TripUpdatedEvent() {}


    public TripUpdatedEvent(UUID tripId, UUID travellerId, String title, LocalDateTime updatedAt) {
        this.tripId = tripId;
        this.travellerId = travellerId;
        this.title = title;
        this.updatedAt = updatedAt;
    }


    public UUID getTripId() { return tripId; }
    public void setTripId(UUID tripId) { this.tripId = tripId; }


    public UUID getTravellerId() { return travellerId; }
    public void setTravellerId(UUID travellerId) { this.travellerId = travellerId; }


    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }


    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
