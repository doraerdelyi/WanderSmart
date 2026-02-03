package com.wandersmart.tripservice.kafka;

import com.wandersmart.common.events.trip.TripCreatedEvent;
import com.wandersmart.common.events.trip.TripDeletedEvent;
import com.wandersmart.common.events.trip.TripUpdatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TripEventsProducer {

    private static final Logger log = LoggerFactory.getLogger(TripEventsProducer.class);

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public TripEventsProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishTripCreated(TripCreatedEvent tripCreatedEvent) {
        String tripId = tripCreatedEvent.tripId().toString();
        log.info("Publishing trip created event for trip id: {}", tripId);
        kafkaTemplate.send("trip-created", tripId, tripCreatedEvent);
    }

    public void publishTripDeleted(TripDeletedEvent tripDeletedEvent) {
        String tripId = tripDeletedEvent.tripId().toString();
        log.info("Publishing trip deleted event for trip id: {}", tripId);
        kafkaTemplate.send("trip-deleted", tripId, tripDeletedEvent);
    }
}
