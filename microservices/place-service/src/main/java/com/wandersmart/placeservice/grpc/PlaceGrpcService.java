package com.wandersmart.placeservice.grpc;

import com.wandersmart.grpc.place.Place;
import com.wandersmart.grpc.place.PlaceRequest;
import com.wandersmart.grpc.place.PlaceResponse;
import com.wandersmart.grpc.place.PlaceServiceGrpc;
import com.wandersmart.placeservice.service.PlaceService;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;
import java.util.UUID;

@GrpcService
public class PlaceGrpcService extends PlaceServiceGrpc.PlaceServiceImplBase {
    private final PlaceService placeService;


    public PlaceGrpcService(PlaceService placeService) {
        this.placeService = placeService;
    }

    @Override
    public void getPlaceById(PlaceRequest request, io.grpc.stub.StreamObserver<PlaceResponse> responseObserver) {

        List<PlaceDTO> places = placeService.getPlacesByIds(request.getPlaceIdList());

        List<Place> grpcPlaces =
                places.stream()
                        .map(this::toGrpcPlace)
                        .toList();

        PlaceResponse response =
                PlaceResponse.newBuilder()
                        .addAllPlaces(grpcPlaces)
                        .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private com.wandersmart.grpc.place.Place toGrpcPlace(PlaceDTO dto) {
        return com.wandersmart.grpc.place.Place.newBuilder()
                .setPlaceId(dto.placeId())
                .setName(dto.name())
                .setRating(dto.rating())
                .setPriceLevel(dto.priceLevel())
                .addAllOpeningHours(dto.openingHours())
                .addAllPhotoIds(
                        dto.photos().stream()
                                .map(UUID::toString)
                                .toList()
                )
                .setLatitude(dto.latitude())
                .setLongitude(dto.longitude())
                .build();
    }

}
