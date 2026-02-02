package com.wandersmart.common.events.trip;

import java.time.LocalDateTime;
import java.util.UUID;

public record TripUpdatedEvent(
        UUID tripId,
        UUID travellerId,
        String tripName,
        LocalDateTime updatedAt
) {}
