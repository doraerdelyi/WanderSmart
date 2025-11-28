package com.wandersmart.recommendationservice.config;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    public static final String RECOMMENDATION_GENERATED = "recommendation.generated";


    @Bean
    public NewTopic recommendationGeneratedTopic() {
        return TopicBuilder.name(RECOMMENDATION_GENERATED)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
