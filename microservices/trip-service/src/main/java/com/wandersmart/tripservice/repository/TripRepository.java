package com.wandersmart.tripservice.repository;

import com.wandersmart.tripservice.model.Trip;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    @EntityGraph(attributePaths = {"tripActivities"})
    Optional<Trip> findByTripId(UUID tripId);
    long deleteByTripId(UUID tripId);
    List<Trip> findAllByTravellerId(UUID travellerId);
}
