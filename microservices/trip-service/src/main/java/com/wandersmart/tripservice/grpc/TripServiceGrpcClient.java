package com.wandersmart.tripservice.grpc;

import com.wandersmart.grpc.place.PlaceServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class TripServiceGrpcClient {

    @GrpcClient("place-service")
    private final PlaceServiceGrpc.PlaceServiceBlockingStub blockingStub;


    public TripServiceGrpcClient(PlaceServiceGrpc.PlaceServiceBlockingStub blockingStub) {
        this.blockingStub = blockingStub;
    }
}
