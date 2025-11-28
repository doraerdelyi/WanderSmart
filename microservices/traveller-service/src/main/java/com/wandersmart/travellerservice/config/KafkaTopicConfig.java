package com.wandersmart.travellerservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    public static final String TRAVELLER_CREATED = "traveller.created";
    public static final String TRAVELLER_UPDATED = "traveller.updated";
    public static final String TRAVELLER_DELETED = "traveller.deleted";


    @Bean
    public NewTopic travellerCreatedTopic() {
        return TopicBuilder.name(TRAVELLER_CREATED)
                .partitions(1)
                .replicas(1)
                .build();
    }


    @Bean
    public NewTopic travellerUpdatedTopic() {
        return TopicBuilder.name(TRAVELLER_UPDATED)
                .partitions(1)
                .replicas(1)
                .build();
    }


    @Bean
    public NewTopic travellerDeletedTopic() {
        return TopicBuilder.name(TRAVELLER_DELETED)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
