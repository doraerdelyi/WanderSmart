package com.wandersmart.tripservice.service;

import com.wandersmart.common.events.trip.TripCreatedEvent;
import com.wandersmart.common.events.trip.TripDeletedEvent;
import com.wandersmart.tripservice.dto.*;
import com.wandersmart.tripservice.exceptions.TripActivityNotFoundException;
import com.wandersmart.tripservice.exceptions.TripNotFoundException;
import com.wandersmart.tripservice.grpc.TripServiceGrpcClient;
import com.wandersmart.tripservice.kafka.TripEventsProducer;
import com.wandersmart.tripservice.mappers.TripActivityMapper;
import com.wandersmart.tripservice.mappers.TripMapper;
import com.wandersmart.tripservice.model.Trip;
import com.wandersmart.tripservice.model.TripActivity;
import com.wandersmart.tripservice.repository.TripActivityRepository;
import com.wandersmart.tripservice.repository.TripRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TripService {

    private final TripRepository tripRepository;
    private final TripActivityRepository tripActivityRepository;
    private final TripMapper tripMapper;
    private final TripActivityMapper tripActivityMapper;
    private final TripServiceGrpcClient tripServiceGrpcClient;
    private final TripEventsProducer tripEventsProducer;



    public TripService(TripRepository tripRepository, TripActivityRepository tripActivityRepository, TripMapper tripMapper, TripActivityMapper tripActivityMapper, TripServiceGrpcClient tripServiceGrpcClient, TripEventsProducer tripEventsProducer) {
        this.tripRepository = tripRepository;
        this.tripActivityRepository = tripActivityRepository;
        this.tripMapper = tripMapper;
        this.tripActivityMapper = tripActivityMapper;
        this.tripServiceGrpcClient = tripServiceGrpcClient;
        this.tripEventsProducer = tripEventsProducer;
    }

    public UUID createTrip(TripRequestDTO tripCreateDTO, UUID travellerId) {
        Trip newTrip = new Trip(tripCreateDTO.name(),
                                tripCreateDTO.startDate(),
                                tripCreateDTO.endDate(),
                                travellerId);
        Trip savedTrip = tripRepository.save(newTrip);
        UUID savedTripId = savedTrip.getTripId();
        TripCreatedEvent tripCreated = new TripCreatedEvent(savedTripId, travellerId, savedTrip.getName(), LocalDateTime.now());
        tripEventsProducer.publishTripCreated(tripCreated);
        return savedTrip.getTripId();
    }

    @Transactional(readOnly=true)
    public TripDetailsResponseDTO getTripById(UUID tripId) {
        Trip trip = this.tripRepository.findByTripId(tripId).orElseThrow(() -> new TripNotFoundException("Trip not found"));
        List<String> placeIds = trip.getPlaceIds();
        Map<String, PlaceDTO> placesById = tripServiceGrpcClient.getPlaceById(placeIds);
        List<TripActivityResponseDTO> tripActivityResponse = trip.getTripActivities().stream().map(activity -> tripActivityMapper.toDTO(activity, placesById.get(activity.getPlaceId()))).toList();
        return new TripDetailsResponseDTO(trip.getTripId(), trip.getName(), trip.getStartDate(), trip.getEndDate(), tripActivityResponse);
    }

    @Transactional
    public void deleteTripById(UUID tripId) {
        Trip trip = tripRepository.findByTripId(tripId).orElseThrow(() -> new TripNotFoundException("Trip not found"));
        this.tripActivityRepository.deleteAllByTrip_TripId(tripId);
        this.tripRepository.deleteByTripId(tripId);
        TripDeletedEvent deletedTrip = new TripDeletedEvent(tripId, LocalDateTime.now());
        tripEventsProducer.publishTripDeleted(deletedTrip);
    }

    @Transactional
    public void updateTripById(UUID tripId, TripRequestDTO tripRequestDTO) {
        Trip trip = this.tripRepository.findByTripId(tripId).orElseThrow(() -> new TripNotFoundException("Trip not found"));
        trip.setName(tripRequestDTO.name());
        trip.setStartDate(tripRequestDTO.startDate());
        trip.setEndDate(tripRequestDTO.endDate());
    }

    @Transactional(readOnly=true)
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


    public void deleteTripActivityById(UUID tripActivityId) {
        boolean deleted = this.tripActivityRepository.deleteByTripActivityId(tripActivityId) > 0;
        if (!deleted) {
            throw new TripActivityNotFoundException("Trip Activity Not Found");
        }
    }
}