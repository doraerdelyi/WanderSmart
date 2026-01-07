package com.wandersmart.tripservice.service;

import com.wandersmart.tripservice.dto.*;
import com.wandersmart.tripservice.mappers.TripActivityMapper;
import com.wandersmart.tripservice.mappers.TripMapper;
import com.wandersmart.tripservice.model.Trip;
import com.wandersmart.tripservice.model.TripActivity;
import com.wandersmart.tripservice.repository.TripActivityRepository;
import com.wandersmart.tripservice.repository.TripRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TripService {

    private final TripRepository tripRepository;
    private final TripActivityRepository tripActivityRepository;
    private final TripMapper tripMapper;
    private final TripActivityMapper tripActivityMapper;



    public TripService(TripRepository tripRepository, TripActivityRepository tripActivityRepository, TripMapper tripMapper, TripActivityMapper tripActivityMapper) {
        this.tripRepository = tripRepository;
        this.tripActivityRepository = tripActivityRepository;
        this.tripMapper = tripMapper;
        this.tripActivityMapper = tripActivityMapper;
    }

    public UUID createTrip(TripRequestDTO tripCreateDTO, UUID travellerId) {
        Trip newTrip = new Trip(tripCreateDTO.name(),
                                tripCreateDTO.startDate(),
                                tripCreateDTO.endDate(),
                                travellerId);
        return this.tripRepository.save(newTrip).getTripId();
    }

    public TripDetailsResponseDTO getTripById(UUID tripId) {
        Trip trip = this.tripRepository.findByTripId(tripId).orElseThrow(() -> new TripNotFoundException("Trip not found"));
        return tripMapper.toDetailsResponseDTO(trip);
    }

    public long deleteTripById(UUID tripId) {
        return this.tripRepository.deleteByTripId(tripId);
    }

    @Transactional
    public void updateTripById(UUID tripId, TripRequestDTO tripRequestDTO) {
        Trip trip = this.tripRepository.findByTripId(tripId).orElseThrow(() -> new TripNotFoundException("Trip not found"));
        trip.setName(tripRequestDTO.name());
        trip.setStartDate(tripRequestDTO.startDate());
        trip.setEndDate(tripRequestDTO.endDate());
    }

    public List<TripResponseDTO> getTripsByTraveller(UUID travellerId) {
        List<Trip> trips = this.tripRepository.findAllByTravellerId(travellerId);
        return trips.stream().map(tripMapper::toResponseDTO).collect(Collectors.toList());
    }


    @Transactional
    public UUID addTripActivity(UUID tripId, TripActivityRequestDTO tripActivityRequestDTO) {
        Trip trip = this.tripRepository.findByTripId(tripId).orElseThrow(() -> new TripNotFoundException("Trip not found"));
        TripActivity activity = new TripActivity(tripActivityRequestDTO.placeId(),
                                                tripActivityRequestDTO.visitTime(),
                                                    trip);
        return this.tripActivityRepository.save(activity).getTripActivityId();
    }


    public long deleteTripActivityById(UUID tripActivityId) {
        return this.tripActivityRepository.deleteByTripActivityId(tripActivityId);
    }
}