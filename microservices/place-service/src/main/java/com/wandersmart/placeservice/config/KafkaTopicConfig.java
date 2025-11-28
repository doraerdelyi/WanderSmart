package com.wandersmart.placeservice.config;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    public static final String PLACE_REVIEWED = "place.reviewed";
    public static final String PLACE_CREATED = "place.created";

    @Bean
    public NewTopic placeReviewedTopic() {
        return TopicBuilder.name(PLACE_REVIEWED)
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic placeCreatedTopic() {
        return TopicBuilder.name(PLACE_CREATED)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
