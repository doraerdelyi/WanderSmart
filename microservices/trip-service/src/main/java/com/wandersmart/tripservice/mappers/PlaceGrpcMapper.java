package com.wandersmart.tripservice.mappers;

import com.wandersmart.grpc.place.Place;
import com.wandersmart.tripservice.dto.PlaceDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlaceGrpcMapper {

    PlaceDTO toDTO(Place place);

    List<PlaceDTO> toDTOList(List<Place> places);
}
