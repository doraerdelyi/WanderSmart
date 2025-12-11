package com.wandersmart.tripservice.dto;

import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDate;
import java.util.UUID;

public record TripUpdateDTO(UUID tripId, String name, @FutureOrPresent LocalDate startDate, @FutureOrPresent LocalDate endDate) {
}
