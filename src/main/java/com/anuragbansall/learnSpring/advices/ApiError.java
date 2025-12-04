package com.anuragbansall.learnSpring.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data // Lombok annotation to generate getters, setters, toString, etc.
@Builder // Lombok annotation to implement the builder pattern
public class ApiError {
    private HttpStatus status;
    private String message;
    private List<String> subErrors;
}
