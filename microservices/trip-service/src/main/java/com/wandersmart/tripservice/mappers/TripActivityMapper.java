package com.wandersmart.tripservice.mappers;


import com.wandersmart.tripservice.dto.PlaceDTO;
import com.wandersmart.tripservice.dto.TripActivityRequestDTO;
import com.wandersmart.tripservice.dto.TripActivityResponseDTO;
import com.wandersmart.tripservice.model.Trip;
import com.wandersmart.tripservice.model.TripActivity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TripActivityMapper {


    @Mapping(target = "placeId", source = "place.placeId")
    @Mapping(target = "name", source = "place.name")
    @Mapping(target = "rating", source = "place.rating")
    @Mapping(target = "priceLevel", source = "place.priceLevel")
    @Mapping(target = "openingHours", source = "place.openingHours")
    @Mapping(target = "photos", source = "place.photos")
    @Mapping(target = "latitude", source = "place.latitude")
    @Mapping(target = "longitude", source = "place.longitude")
    @Mapping(target = "visitTime", source = "tripActivity.visitTime")
    TripActivityResponseDTO toDTO(TripActivity tripActivity, PlaceDTO place);
    TripActivity toTripActivity(TripActivityRequestDTO tripActivityRequestDTO, Trip trip);
}
