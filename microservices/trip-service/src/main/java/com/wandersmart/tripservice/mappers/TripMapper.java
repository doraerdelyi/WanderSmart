package com.wandersmart.tripservice.mappers;

import com.wandersmart.tripservice.dto.TripActivityResponseDTO;
import com.wandersmart.tripservice.dto.TripDetailsResponseDTO;
import com.wandersmart.tripservice.dto.TripResponseDTO;
import com.wandersmart.tripservice.model.Trip;


import java.util.List;
import java.util.stream.Collectors;

public class TripMapper {

    public static TripResponseDTO tripToTripResponseDTO(Trip trip) {
        return new TripResponseDTO(trip.getTripId(), trip.getName(), trip.getStartDate(), trip.getEndDate());
    }
    public static TripDetailsResponseDTO tripToTripDetailsResponseDTO(Trip trip) {
        //List<TripActivity> tripActivities = trip.getTripActivities();
        List<TripActivityResponseDTO> tripActivityDTOS = tripActivities.stream().map(this::convertTripActivityToTripActivityDTO).collect(Collectors.toList());
        return new TripDetailsResponseDTO(trip.getTripId(), trip.getName(), trip.getStartDate(), trip.getEndDate(), tripActivityDTOS);
    }

}
