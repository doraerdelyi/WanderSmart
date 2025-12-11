package com.wandersmart.tripservice.dto;

import java.time.LocalDate;
import java.util.UUID;

public record TripResponseDTO(UUID tripId, String name, LocalDate startDate, LocalDate endDate) {
}
