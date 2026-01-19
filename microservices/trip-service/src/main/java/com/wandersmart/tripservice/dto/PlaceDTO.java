package com.wandersmart.tripservice.dto;

import java.util.List;

public record PlaceDTO(String placeId,
                       String name,
                       double rating,
                       int priceLevel,
                       List<String> openingHours,
                       double latitude,
                       double longitude) {
}
