package com.wandersmart.common.events.trip;

import java.time.LocalDateTime;
import java.util.UUID;

public record TripDeletedEvent(
        UUID tripId,
        LocalDateTime deletedAt
) {}