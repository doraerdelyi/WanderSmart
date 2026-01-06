package com.wandersmart.tripservice.mappers;

import com.wandersmart.tripservice.dto.TripDetailsResponseDTO;
import com.wandersmart.tripservice.dto.TripRequestDTO;
import com.wandersmart.tripservice.dto.TripResponseDTO;
import com.wandersmart.tripservice.model.Trip;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = TripActivityMapper.class)
public interface TripMapper {

    TripResponseDTO toResponseDTO(Trip trip);

    TripDetailsResponseDTO toDetailsResponseDTO(Trip trip, PlaceResponseDTO placeResponseDTO);

    Trip toTrip(TripRequestDTO tripRequestDTO, UUID travellerId);
}
