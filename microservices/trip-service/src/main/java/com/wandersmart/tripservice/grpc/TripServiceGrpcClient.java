package com.wandersmart.tripservice.grpc;

import com.wandersmart.grpc.place.PlaceRequest;
import com.wandersmart.grpc.place.PlaceResponse;
import com.wandersmart.grpc.place.PlaceServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TripServiceGrpcClient {

    private final PlaceGrpcMapper mapper;
    private final PlaceServiceGrpc.PlaceServiceBlockingStub blockingStub;

    public TripServiceGrpcClient(@GrpcClient("place-service") PlaceServiceGrpc.PlaceServiceBlockingStub blockingStub, PlaceGrpcMapper mapper) {
        this.mapper = mapper;
        this.blockingStub = blockingStub;
    }

  public Map<String, PlaceDTO> getPlaceById(List<String> placeIds) {
      if (placeIds == null || placeIds.isEmpty()) {
          return Collections.emptyMap();
      }

      PlaceRequest request = PlaceRequest.newBuilder().addAllPlaceId(placeIds).build();

      PlaceResponse response = blockingStub.getPlaceById(request);

      return mapper.toDTOList(response.getPlacesList())
              .stream()
              .collect(Collectors.toMap(
                      com.wandersmart.grpc.place.Place::getPlaceId,
                      Function.identity()
              ));

    }
}
