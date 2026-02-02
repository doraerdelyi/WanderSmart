package com.wandersmart.common.events.trip;

import java.time.LocalDateTime;
import java.util.UUID;

public record TripActivityAddedEvent(UUID activityId, UUID tripId, LocalDateTime addedAt) {}

