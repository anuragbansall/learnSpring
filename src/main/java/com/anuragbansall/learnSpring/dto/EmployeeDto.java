package com.anuragbansall.learnSpring.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDto {
    Long id;
    String name;
    String email;
    Integer age;
    LocalDate dateOfJoining;
    Boolean isActive;
}
