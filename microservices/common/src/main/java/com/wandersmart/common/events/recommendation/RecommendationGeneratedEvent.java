package com.wandersmart.common.events.recommendation;

import java.time.LocalDateTime;
import java.util.UUID;

public class RecommendationGeneratedEvent {
    private UUID recommendationId;
    private UUID travellerId;
    private String content;
    private LocalDateTime generatedAt;


    public RecommendationGeneratedEvent() {}


    public RecommendationGeneratedEvent(UUID recommendationId, UUID travellerId, String content, LocalDateTime generatedAt) {
        this.recommendationId = recommendationId;
        this.travellerId = travellerId;
        this.content = content;
        this.generatedAt = generatedAt;
    }


    public UUID getRecommendationId() { return recommendationId; }
    public void setRecommendationId(UUID recommendationId) { this.recommendationId = recommendationId; }


    public UUID getTravellerId() { return travellerId; }
    public void setTravellerId(UUID travellerId) { this.travellerId = travellerId; }


    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }


    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(LocalDateTime generatedAt) { this.generatedAt = generatedAt; }
}

