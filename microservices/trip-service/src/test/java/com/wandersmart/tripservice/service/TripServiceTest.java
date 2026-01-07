package com.wandersmart.tripservice.service;

import com.wandersmart.tripservice.dto.*;
import com.wandersmart.tripservice.exceptions.TripActivityNotFoundException;
import com.wandersmart.tripservice.exceptions.TripNotFoundException;
import com.wandersmart.tripservice.mappers.TripActivityMapper;
import com.wandersmart.tripservice.mappers.TripMapper;
import com.wandersmart.tripservice.model.Trip;
import com.wandersmart.tripservice.model.TripActivity;
import com.wandersmart.tripservice.repository.TripActivityRepository;
import com.wandersmart.tripservice.repository.TripRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TripServiceTest {

    @Mock
    private TripRepository tripRepository;

    @Mock
    private TripActivityRepository tripActivityRepository;

    @Mock
    private TripMapper tripMapper;

    @Mock
    private TripActivityMapper tripActivityMapper;

    @InjectMocks
    private TripService tripService;

    private UUID travellerId;
    private TripRequestDTO tripRequestDTO;

    @BeforeEach
    void setUp() {
        travellerId = UUID.randomUUID();
        tripRequestDTO = new TripRequestDTO("Trip1", LocalDate.now(), LocalDate.now().plusDays(1));
    }

    @Test
    void createTrip_shouldReturnTripId() {
        Trip savedTrip = new Trip(tripRequestDTO.name(), tripRequestDTO.startDate(), tripRequestDTO.endDate(), travellerId);
        UUID expectedTripId = UUID.randomUUID();
        savedTrip.setTripId(expectedTripId);
        when(tripRepository.save(any())).thenReturn(savedTrip);
        UUID tripId = tripService.createTrip(tripRequestDTO, travellerId);

        assertEquals(expectedTripId, tripId);
        verify(tripRepository).save(any(Trip.class));
    }

    @Test
    void getTripById_shouldReturnDetails() {
        UUID tripId = UUID.randomUUID();
        Trip trip = new Trip("Trip1", LocalDate.now(), LocalDate.now().plusDays(1), travellerId);
        TripDetailsResponseDTO dto = mock(TripDetailsResponseDTO.class);

        when(tripRepository.findByTripId(tripId)).thenReturn(Optional.of(trip));
        when(tripMapper.toDetailsResponseDTO(trip)).thenReturn(dto);

        TripDetailsResponseDTO result = tripService.getTripById(tripId);

        assertEquals(dto, result);
        verify(tripRepository).findByTripId(tripId);
        verify(tripMapper).toDetailsResponseDTO(trip);
    }

    @Test
    void getTripById_notFound_shouldThrow() {
        UUID tripId = UUID.randomUUID();
        when(tripRepository.findByTripId(tripId)).thenReturn(Optional.empty());

        assertThrows(TripNotFoundException.class, () -> tripService.getTripById(tripId));
    }

    @Test
    void deleteTripById_shouldCallRepositories() {
        UUID tripId = UUID.randomUUID();

        tripService.deleteTripById(tripId);

        verify(tripActivityRepository).deleteAllByTripId(tripId);
        verify(tripRepository).deleteByTripId(tripId);
    }

    @Test
    void updateTripById_shouldUpdateFields() {
        UUID tripId = UUID.randomUUID();
        Trip trip = new Trip("Old", LocalDate.now(), LocalDate.now().plusDays(1), travellerId);
        when(tripRepository.findByTripId(tripId)).thenReturn(Optional.of(trip));

        tripService.updateTripById(tripId, tripRequestDTO);

        verify(tripRepository).findByTripId(tripId);
        assertEquals(tripRequestDTO.name(), trip.getName());
        assertEquals(tripRequestDTO.startDate(), trip.getStartDate());
        assertEquals(tripRequestDTO.endDate(), trip.getEndDate());
    }

    @Test
    void updateTripById_notFound_shouldThrow() {
        UUID tripId = UUID.randomUUID();
        when(tripRepository.findByTripId(tripId)).thenReturn(Optional.empty());

        assertThrows(TripNotFoundException.class, () -> tripService.updateTripById(tripId, tripRequestDTO));
    }

    @Test
    void getTripsByTraveller_shouldReturnList() {
        Trip trip = new Trip("Trip1", LocalDate.now(), LocalDate.now().plusDays(1), travellerId);
        List<Trip> trips = List.of(trip);
        TripResponseDTO dto = mock(TripResponseDTO.class);

        when(tripRepository.findAllByTravellerId(travellerId)).thenReturn(trips);
        when(tripMapper.toResponseDTO(trip)).thenReturn(dto);

        List<TripResponseDTO> result = tripService.getTripsByTraveller(travellerId);

        assertEquals(1, result.size());
        assertEquals(dto, result.get(0));
        verify(tripRepository).findAllByTravellerId(travellerId);
        verify(tripMapper).toResponseDTO(trip);
    }

    @Test
    void addTripActivity_shouldReturnId() {
        UUID tripId = UUID.randomUUID();
        String activityId = UUID.randomUUID().toString();
        Trip trip = new Trip("Trip", LocalDate.now(), LocalDate.now().plusDays(1), travellerId);
        TripActivityRequestDTO dto = new TripActivityRequestDTO(activityId, LocalDateTime.now());
        TripActivity savedActivity = new TripActivity(dto.placeId(), dto.visitTime(), trip);

        when(tripRepository.findByTripId(tripId)).thenReturn(Optional.of(trip));
        when(tripActivityRepository.save(any(TripActivity.class))).thenReturn(savedActivity);

        UUID resultId = tripService.addTripActivity(tripId, dto);

        assertEquals(savedActivity.getTripActivityId(), resultId);
        verify(tripActivityRepository).save(any(TripActivity.class));
    }

    @Test
    void addTripActivity_tripNotFound_shouldThrow() {
        UUID tripId = UUID.randomUUID();
        String activityId = UUID.randomUUID().toString();
        TripActivityRequestDTO dto = new TripActivityRequestDTO(activityId, LocalDateTime.now());
        when(tripRepository.findByTripId(tripId)).thenReturn(Optional.empty());

        assertThrows(TripNotFoundException.class, () -> tripService.addTripActivity(tripId, dto));
    }

    @Test
    void deleteTripActivityById_shouldSucceed() {
        UUID id = UUID.randomUUID();
        when(tripActivityRepository.deleteByTripActivityId(id)).thenReturn(1L);

        assertDoesNotThrow(() -> tripService.deleteTripActivityById(id));
        verify(tripActivityRepository).deleteByTripActivityId(id);
    }

    @Test
    void deleteTripActivityById_notFound_shouldThrow() {
        UUID id = UUID.randomUUID();
        when(tripActivityRepository.deleteByTripActivityId(id)).thenReturn(0L);

        assertThrows(TripActivityNotFoundException.class, () -> tripService.deleteTripActivityById(id));
    }
}