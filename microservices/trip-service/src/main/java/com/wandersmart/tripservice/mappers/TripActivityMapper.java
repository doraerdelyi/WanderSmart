package com.wandersmart.tripservice.mappers;


import com.wandersmart.tripservice.dto.TripActivityRequestDTO;
import com.wandersmart.tripservice.dto.TripActivityResponseDTO;
import com.wandersmart.tripservice.model.Trip;
import com.wandersmart.tripservice.model.TripActivity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TripActivityMapper {

    TripActivityResponseDTO toDTO(TripActivity tripActivity);
    TripActivity toTripActivity(TripActivityRequestDTO tripActivityRequestDTO, Trip trip);
}
