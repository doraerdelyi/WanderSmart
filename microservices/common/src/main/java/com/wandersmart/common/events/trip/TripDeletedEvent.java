package com.wandersmart.common.events.trip;

import java.time.LocalDateTime;
import java.util.UUID;

public class TripDeletedEvent {
    private UUID tripId;
    private UUID travellerId;
    private LocalDateTime deletedAt;


    public TripDeletedEvent() {}


    public TripDeletedEvent(UUID tripId, UUID travellerId, LocalDateTime deletedAt) {
        this.tripId = tripId;
        this.travellerId = travellerId;
        this.deletedAt = deletedAt;
    }


    public UUID getTripId() { return tripId; }
    public void setTripId(UUID tripId) { this.tripId = tripId; }


    public UUID getTravellerId() { return travellerId; }
    public void setTravellerId(UUID travellerId) { this.travellerId = travellerId; }


    public LocalDateTime getDeletedAt() { return deletedAt; }
    public void setDeletedAt(LocalDateTime deletedAt) { this.deletedAt = deletedAt; }
}

