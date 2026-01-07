package com.wandersmart.tripservice.exceptions;

public class TripActivityNotFoundException extends RuntimeException {
    public TripActivityNotFoundException(String message) {
        super(message);
    }
}
