package com.wandersmart.tripservice.controller;

import com.wandersmart.tripservice.dto.TripActivityRequestDTO;
import com.wandersmart.tripservice.dto.TripDetailsResponseDTO;
import com.wandersmart.tripservice.dto.TripRequestDTO;
import com.wandersmart.tripservice.dto.TripResponseDTO;
import com.wandersmart.tripservice.service.TripService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/trips")
public class TripController {

    private TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }
    @GetMapping("/{tripId}")
    public TripDetailsResponseDTO getTripById(@PathVariable UUID tripId) {
        return tripService.getTripById(tripId);
    }

    @GetMapping("/traveller/{travellerId}")
    public List<TripResponseDTO> getTripsByTraveller(@PathVariable UUID travellerId) {
        return tripService.getTripsByTraveller(travellerId);
    }

    @PostMapping
    public UUID createTrip(
            @RequestBody @Valid TripRequestDTO tripRequestDTO,
            @RequestHeader("X-Traveller-Id") UUID travellerId) {

        UUID tripId = tripService.createTrip(tripRequestDTO, travellerId);
        return tripId;
    }

    @DeleteMapping("/{tripId}")
    public void deleteTrip(@PathVariable UUID tripId) {
        tripService.deleteTripById(tripId);
    }

    @PostMapping("/{tripId}/activities")
    public UUID addTripActivity(
            @PathVariable UUID tripId,
            @RequestBody @Valid TripActivityRequestDTO tripActivityRequestDTO) {

        UUID activityId = tripService.addTripActivity(tripId, tripActivityRequestDTO);
        return activityId;
    }

    @DeleteMapping("/activities/{activityId}")
    public void deleteTripActivity(@PathVariable UUID activityId) {
        tripService.deleteTripActivityById(activityId);
    }
}


}
