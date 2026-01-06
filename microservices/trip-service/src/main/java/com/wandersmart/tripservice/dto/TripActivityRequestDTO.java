package com.wandersmart.tripservice.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TripActivityRequestDTO(@NotNull(message = "A place must be chosen for a trip activity") String placeId, @NotNull(message = "A date and time must be chosen for a trip activity") @FutureOrPresent(message = "Visit time cannot be in the past") LocalDateTime visitTime) {
}
