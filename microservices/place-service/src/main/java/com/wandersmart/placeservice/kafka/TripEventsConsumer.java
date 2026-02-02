package com.wandersmart.placeservice.kafka;

import com.wandersmart.common.events.trip.TripCreatedEvent;
import com.wandersmart.common.events.trip.TripDeletedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TripEventsConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TripEventsConsumer.class);

    @KafkaListener(topics="trip-created")
    public void consumeTripCreatedEvent(TripCreatedEvent createdTrip) {
        LOGGER.info("Trip created event received: {}", createdTrip);
    }


    @KafkaListener(topics="trip-deleted")
    public void consumeTripDeletedEvent(TripDeletedEvent deletedTrip) {
        LOGGER.info("Trip deleted event received: {}", deletedTrip);
    }
}
