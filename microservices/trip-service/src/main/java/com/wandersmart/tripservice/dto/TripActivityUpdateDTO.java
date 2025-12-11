package com.wandersmart.tripservice.dto;

import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDateTime;

public record TripActivityUpdateDTO(String placeId, @FutureOrPresent(message = "Visit time cannot be in the past") LocalDateTime visitTime) {
}
