package com.wandersmart.common.events.traveller;

import java.time.LocalDateTime;
import java.util.UUID;

public class TravellerDeletedEvent {
    private UUID travellerId;
    private LocalDateTime deletedAt;


    public TravellerDeletedEvent() {}


    public TravellerDeletedEvent(UUID travellerId, LocalDateTime deletedAt) {
        this.travellerId = travellerId;
        this.deletedAt = deletedAt;
    }


    public UUID getTravellerId() { return travellerId; }
    public void setTravellerId(UUID travellerId) { this.travellerId = travellerId; }


    public LocalDateTime getDeletedAt() { return deletedAt; }
    public void setDeletedAt(LocalDateTime deletedAt) { this.deletedAt = deletedAt; }
}

