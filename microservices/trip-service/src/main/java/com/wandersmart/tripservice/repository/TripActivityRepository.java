package com.wandersmart.tripservice.repository;

import com.wandersmart.tripservice.model.TripActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TripActivityRepository extends JpaRepository<TripActivity,Long> {
    long deleteByTripActivityId(UUID tripActivityId);
    void deleteAllByTrip_TripId(UUID tripId);
}
