package com.wandersmart.tripservice.mappers;

import com.wandersmart.tripservice.dto.TripActivityRequestDTO;
import com.wandersmart.tripservice.dto.TripActivityResponseDTO;
import com.wandersmart.tripservice.model.Trip;
import com.wandersmart.tripservice.model.TripActivity;

public class TripActivityMapper {

    public static TripActivityResponseDTO toDTO(TripActivity tripActivity) {
        PlaceResponseDTO placeResponseDTO = PlaceMapper.toDTO(tripActivity.getPlace());
        return new TripActivityResponseDTO(placeResponseDTO, tripActivity.getVisitTime());
    }


    public static TripActivity toTripActivity (TripActivityRequestDTO tripActivityRequestDTO, Trip trip, Place place) {
        return new TripActivity(
                place,
                tripActivityRequestDTO.visitTime(),
                trip
        );
    }
}
