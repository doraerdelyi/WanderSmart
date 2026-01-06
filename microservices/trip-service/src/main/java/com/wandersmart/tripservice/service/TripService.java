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
import java.util.NoSuchElementException;
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


    @Transactional
    public UUID addTripActivity(UUID tripId, TripActivityRequestDTO tripActivityCreateDTO) {
        Trip trip = this.tripRepository.findByTripId(tripId).orElseThrow(() -> new NoSuchElementException("Trip not found"));
        //Place place = this.placeRepository.findByPlaceId(tripActivityCreateDTO.placeId()).orElseThrow(() -> new NoSuchElementException("Place not found"));
        TripActivity newTripActivity = new TripActivity(place,
                                                        tripActivityCreateDTO.visitTime(),
                                                        trip);
        return this.tripActivityRepository.save(newTripActivity).getTripActivityId();
    }


    public long deleteTripActivityById(UUID tripActivityId) {
        return this.tripActivityRepository.deleteByTripActivityId(tripActivityId);
    }

    public List<TripResponseDTO> getTrips() {
        List<Trip> trips = this.tripRepository.findAll();
        return trips.stream().map(TripMapper::tripToTripResponseDTO).collect(Collectors.toList());
    }

    public TripDetailsResponseDTO getTripById(UUID tripId) {
        Trip trip = this.tripRepository.findByTripId(tripId).orElseThrow(NoSuchElementException::new);
        return TripMapper.tripToTripDetailsResponseDTO(trip);

    }

    public long deleteTripById(UUID tripId) {
        return this.tripRepository.deleteByTripId(tripId);
    }

    @Transactional
    public void updateTripById(UUID tripId, TripUpdateDTO tripUpdateDTO) {
        Trip trip = this.tripRepository.findByTripId(tripId).orElseThrow(() -> new NoSuchElementException("Trip not found"));
        trip.setName(tripUpdateDTO.name());
        trip.setStartDate(tripUpdateDTO.startDate());
        trip.setEndDate(tripUpdateDTO.endDate());
    }

    public List<TripResponseDTO> getTripsByTraveller() {
        //Traveller traveller = new Traveller();
        List<Trip> trips = this.tripRepository.findByTraveller(traveller);
        return trips.stream().map(TripMapper::tripToTripResponseDTO).collect(Collectors.toList());
    }
}