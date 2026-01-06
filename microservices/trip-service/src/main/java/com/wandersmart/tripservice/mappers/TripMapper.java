package com.wandersmart.tripservice.mappers;

import com.wandersmart.tripservice.dto.TripDetailsResponseDTO;
import com.wandersmart.tripservice.dto.TripResponseDTO;
import com.wandersmart.tripservice.model.Trip;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = TripActivityMapper.class)
public interface TripMapper {

    TripResponseDTO toResponseDTO(Trip trip);

    TripDetailsResponseDTO toDetailsResponseDTO(Trip trip, PlaceResponseDTO placeResponseDTO);
}
