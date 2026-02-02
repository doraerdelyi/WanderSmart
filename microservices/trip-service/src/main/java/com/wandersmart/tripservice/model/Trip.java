package com.wandersmart.tripservice.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private UUID tripId;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TripActivity> tripActivities = new ArrayList<>();

    @Column(nullable = false)
    private UUID travellerId;

    @PrePersist
    private void onCreate() {
        this.tripId = UUID.randomUUID();
    }

    public Trip() {
    }

    public Trip(String name, LocalDate startDate, LocalDate endDate, UUID travellerId) {
        this.tripId = UUID.randomUUID();
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.travellerId = travellerId;
    }

    public String getName() {
        return name;
    }

    public UUID getTripId() {
        return tripId;
    }

    public UUID getTravellerId() {
        return travellerId;
    }

    public List<TripActivity> getTripActivities() {
        return List.copyOf(tripActivities);
    }

    public List<String> getPlaceIds() {
        return tripActivities.stream().map(TripActivity::getPlaceId).toList();
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setTripId(UUID tripId) {
        this.tripId = tripId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trip)) return false;
        Trip trip = (Trip) o;
        return tripId != null && tripId.equals(trip.tripId);
    }

    @Override
    public int hashCode() {
        return this.tripId.hashCode();
    }

}
