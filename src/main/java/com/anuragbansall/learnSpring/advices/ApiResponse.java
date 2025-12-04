package com.anuragbansall.learnSpring.advices;

import lombok.Data;

import java.time.LocalDateTime;

@Data // Lombok annotation to generate getters, setters, toString, etc.
public class ApiResponse<T> {
    private LocalDateTime timestamp;
    private T data;
    private ApiError error;

    // Default constructor to set timestamp
    public ApiResponse() {
        this.timestamp = LocalDateTime.now();
    }

    // Constructor for successful response
    public ApiResponse(T data) {
        this(); // Call default constructor to set timestamp
        this.data = data;
        this.error = null;
    }

    // Constructor for error response
    public ApiResponse(ApiError error) {
        this(); // Call default constructor to set timestamp
        this.data = null;
        this.error = error;
    }
}
