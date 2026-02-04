package com.wandersmart.apigateway.controller;

@RestController
public class FallBackController {

    @GetMapping("/fallback/trips")
    public ResponseEntity<String> fallbackTrips() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Trip service is currently unavailable. Please try again later.");
    }
}
