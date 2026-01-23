package com.wandersmart.placeservice.model;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.Set;

    @Entity
    public class Place {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;


        @Column(nullable = false, unique = true)
        private String placeId;


        @Column(nullable = false)
        private String name;


        @ManyToMany(cascade = CascadeType.PERSIST)
        @JoinTable(name = "place_place_type", joinColumns = @JoinColumn(name = "place_id"), inverseJoinColumns = @JoinColumn(name = "place_type_id"))
        private Set<PlaceType> placeTypes;

        private double rating;

        private int priceLevel;

        @Type(JsonType.class)
        @Column(columnDefinition = "jsonb")
        private List<String> openingHours;

        @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
        private List<Photo> photos;

        private double latitude;

        private double longitude;

    }
}
