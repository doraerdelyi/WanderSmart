package com.wandersmart.tripservice.dto;

import java.time.LocalDateTime;
import java.util.List;

public record TripActivityResponseDTO(String placeId, String name, double rating, int priceLevel, List<String> openingHours, List<String> photos, double latitude, double longitude, LocalDateTime visitTime) {
}
