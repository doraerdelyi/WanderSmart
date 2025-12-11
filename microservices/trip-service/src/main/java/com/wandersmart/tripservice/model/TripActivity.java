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

    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;

    private LocalDateTime visitTime;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    public TripActivity() {}

    public TripActivity(Place place, LocalDateTime visitTime, Trip trip) {
        this.tripActivityId = UUID.randomUUID();
        this.place = place;
        this.visitTime = visitTime;
        this.trip = trip;
    }

    public UUID getTripActivityId() {
        return tripActivityId;
    }

    public Place getPlace() {
        return place;
    }

    public LocalDateTime getVisitTime() {
        return visitTime;
    }

    public Trip getTrip() {
        return trip;
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
