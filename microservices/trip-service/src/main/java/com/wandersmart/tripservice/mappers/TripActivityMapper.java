package com.wandersmart.tripservice.mappers;

import com.wandersmart.tripservice.dto.TripActivityCreateDTO;
import com.wandersmart.tripservice.dto.TripActivityResponseDTO;
import com.wandersmart.tripservice.dto.TripResponseDTO;
import com.wandersmart.tripservice.model.Trip;
import com.wandersmart.tripservice.model.TripActivity;

public class TripActivityMapper {

    public static TripActivityResponseDTO toTripActivityResponseDTO(TripActivity tripActivity) {
        PlaceDTO placeDto = PlaceMapper.placeToPlaceDTO(tripActivity.getPlace());
        return new TripActivityResponseDTO(placeDto, tripActivity.getVisitTime());
    }


    public static TripActivity tripActivityCreateDTOToTripActivity (TripActivityCreateDTO dto, Trip trip, Place place) {
        TripActivity activity = new TripActivity(
                place,
                dto.visitTime(),
                trip
        );
        return activity;
    }
}
