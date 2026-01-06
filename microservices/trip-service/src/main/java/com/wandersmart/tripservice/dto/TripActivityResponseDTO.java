package com.wandersmart.tripservice.dto;

import java.time.LocalDateTime;

public record TripActivityResponseDTO(PlaceResponseDTO placeResponseDTO, LocalDateTime visitTime) {
}
