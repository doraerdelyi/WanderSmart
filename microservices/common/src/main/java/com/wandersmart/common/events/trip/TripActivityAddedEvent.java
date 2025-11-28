package com.wandersmart.common.events.trip;

import java.time.LocalDateTime;
import java.util.UUID;

public class TripActivityAddedEvent {
    private UUID activityId;
    private UUID tripId;
    private String description;
    private LocalDateTime addedAt;


    public TripActivityAddedEvent() {}


    public TripActivityAddedEvent(UUID activityId, UUID tripId, String description, LocalDateTime addedAt) {
        this.activityId = activityId;
        this.tripId = tripId;
        this.description = description;
        this.addedAt = addedAt;
    }


    public UUID getActivityId() { return activityId; }
    public void setActivityId(UUID activityId) { this.activityId = activityId; }


    public UUID getTripId() { return tripId; }
    public void setTripId(UUID tripId) { this.tripId = tripId; }


    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }


    public LocalDateTime getAddedAt() { return addedAt; }
    public void setAddedAt(LocalDateTime addedAt) { this.addedAt = addedAt; }
}

