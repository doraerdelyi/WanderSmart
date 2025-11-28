package com.wandersmart.common.events.trip;

import java.time.LocalDateTime;
import java.util.UUID;

public class TripActivityUpdatedEvent {
    private UUID activityId;
    private UUID tripId;
    private String description;
    private LocalDateTime updatedAt;


    public TripActivityUpdatedEvent() {}


    public TripActivityUpdatedEvent(UUID activityId, UUID tripId, String description, LocalDateTime updatedAt) {
        this.activityId = activityId;
        this.tripId = tripId;
        this.description = description;
        this.updatedAt = updatedAt;
    }


    public UUID getActivityId() { return activityId; }
    public void setActivityId(UUID activityId) { this.activityId = activityId; }


    public UUID getTripId() { return tripId; }
    public void setTripId(UUID tripId) { this.tripId = tripId; }


    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }


    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
