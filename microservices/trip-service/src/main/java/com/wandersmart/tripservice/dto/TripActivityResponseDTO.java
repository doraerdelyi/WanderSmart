package com.wandersmart.tripservice.dto;

import java.time.LocalDateTime;

public record TripActivityResponseDTO(String placeId, LocalDateTime visitTime) {
}
