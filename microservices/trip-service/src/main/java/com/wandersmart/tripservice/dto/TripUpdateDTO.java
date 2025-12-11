package com.wandersmart.tripservice.dto;

import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDate;
import java.util.UUID;

public record TripUpdateDTO(UUID tripId, String name, @FutureOrPresent(message = "Start date cannot be in the past") LocalDate startDate, @FutureOrPresent(message = "End date cannot be in the past") LocalDate endDate) {
}
