package com.anuragbansall.learnSpring.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "employees") // Default table name will be 'employee_entity' based on class name
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto-generate the primary key value
    Long id;
    String name;
    String email;
    Integer age;
    LocalDate dateOfJoining;
    @JsonProperty("isActive") // To ensure proper serialization/deserialization
    Boolean isActive;
}