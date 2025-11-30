package com.anuragbansall.learnSpring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDto {
    Long id;
    String name;
    String email;
    Integer age;
    LocalDate dateOfJoining;
    @JsonProperty("isActive") // To ensure proper serialization/deserialization
    Boolean isActive;
}
