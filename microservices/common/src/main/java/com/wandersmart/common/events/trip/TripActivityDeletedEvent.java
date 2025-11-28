package com.wandersmart.common.events.trip;

import java.time.LocalDateTime;
import java.util.UUID;

public class TripActivityDeletedEvent {
    private UUID activityId;
    private UUID tripId;
    private LocalDateTime deletedAt;


    public TripActivityDeletedEvent() {}


    public TripActivityDeletedEvent(UUID activityId, UUID tripId, LocalDateTime deletedAt) {
        this.activityId = activityId;
        this.tripId = tripId;
        this.deletedAt = deletedAt;
    }


    public UUID getActivityId() { return activityId; }
    public void setActivityId(UUID activityId) { this.activityId = activityId; }


    public UUID getTripId() { return tripId; }
    public void setTripId(UUID tripId) { this.tripId = tripId; }


    public LocalDateTime getDeletedAt() { return deletedAt; }
    public void setDeletedAt(LocalDateTime deletedAt) { this.deletedAt = deletedAt; }
}
