package com.wandersmart.tripservice.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TripCreateDTO(String name, @NotNull(message = "Trip cannot be created without start date") @FutureOrPresent(message = "Start date cannot be in the past") LocalDate startDate, @NotNull(message = "Trip cannot be created without end date") @FutureOrPresent(message = "End date cannot be in the past") LocalDate endDate) {
}
