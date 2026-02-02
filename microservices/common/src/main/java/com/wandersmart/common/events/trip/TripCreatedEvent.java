package com.wandersmart.common.events.trip;

import java.time.LocalDateTime;
import java.util.UUID;

public record TripCreatedEvent(UUID tripId, UUID travellerId, String tripName, LocalDateTime createdAt)  {}


