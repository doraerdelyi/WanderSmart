package com.wandersmart.tripservice.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record TripDetailsResponseDTO(UUID tripId, String name, LocalDate startDate, LocalDate endDate, List<TripActivityResponseDTO> tripActivities) {
}