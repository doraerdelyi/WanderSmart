package com.wandersmart.tripservice.config;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    public static final String TRIP_CREATED = "trip.created";
    public static final String TRIP_UPDATED = "trip.updated";
    public static final String TRIP_DELETED = "trip.deleted";
    public static final String TRIPACTIVITY_ADDED = "tripactivity.created";
    public static final String TRIPACTIVITY_UPDATED = "tripactivity.updated";
    public static final String TRIPACTIVITY_DELETED = "tripactivity.deleted";


    @Bean
    public NewTopic tripCreatedTopic() {
        return TopicBuilder.name(TRIP_CREATED)
                .partitions(1)
                .replicas(1)
                .build();
    }


    @Bean
    public NewTopic tripUpdatedTopic() {
        return TopicBuilder.name(TRIP_UPDATED)
                .partitions(1)
                .replicas(1)
                .build();
    }


    @Bean
    public NewTopic tripDeletedTopic() {
        return TopicBuilder.name(TRIP_DELETED)
                .partitions(1)
                .replicas(1)
                .build();
    }


    @Bean
    public NewTopic tripActivityAddedTopic() {
        return TopicBuilder.name(TRIPACTIVITY_ADDED)
                .partitions(1)
                .replicas(1)
                .build();
    }


    @Bean
    public NewTopic tripActivityUpdatedTopic() {
        return TopicBuilder.name(TRIPACTIVITY_UPDATED)
                .partitions(1)
                .replicas(1)
                .build();
    }


    @Bean
    public NewTopic tripActivityDeletedTopic() {
        return TopicBuilder.name(TRIPACTIVITY_DELETED)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
