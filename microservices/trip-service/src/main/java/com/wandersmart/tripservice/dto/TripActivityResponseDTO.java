package com.wandersmart.tripservice.dto;

import java.time.LocalDateTime;

public record TripActivityResponseDTO(PlaceDTO placeDTO, LocalDateTime visitTime) {
}
