package com.wandersmart.tripservice.dto;

import java.time.LocalDateTime;

public record TripActivityResponseDTO(PlaceResponseDTO placResponseDTO, LocalDateTime visitTime) {
}
