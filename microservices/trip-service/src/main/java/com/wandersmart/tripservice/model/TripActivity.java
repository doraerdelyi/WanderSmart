package com.wandersmart.tripservice.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class TripActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private UUID tripActivityId;

    @Column(nullable = false)
    private String placeId;

    private LocalDateTime visitTime;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    public TripActivity() {}

    public TripActivity(String placeId, LocalDateTime visitTime, Trip trip) {
        this.tripActivityId = UUID.randomUUID();
        this.placeId = placeId;
        this.visitTime = visitTime;
        this.trip = trip;
    }

    public UUID getTripActivityId() {
        return tripActivityId;
    }

    public String getPlaceId() {
        return placeId;
    }
    public LocalDateTime getVisitTime() {
        return visitTime;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTripActivityId(UUID tripActivityId) {
        this.tripActivityId = tripActivityId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public void setVisitTime(LocalDateTime visitTime) {
        this.visitTime = visitTime;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TripActivity)) return false;
        TripActivity that = (TripActivity) o;
        return tripActivityId != null && tripActivityId.equals(that.tripActivityId);
    }

    @Override
    public int hashCode() {
        return this.tripActivityId.hashCode();
    }

}
