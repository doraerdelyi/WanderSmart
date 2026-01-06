package com.wandersmart.tripservice.mappers;


import com.wandersmart.tripservice.dto.TripActivityResponseDTO;
import com.wandersmart.tripservice.model.TripActivity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TripActivityMapper {

    TripActivityResponseDTO toDTO(TripActivity tripActivity);

}
