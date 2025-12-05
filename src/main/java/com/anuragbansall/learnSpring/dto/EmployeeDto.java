package com.anuragbansall.learnSpring.dto;

import com.anuragbansall.learnSpring.annotations.EmployeeNameValidation;
import com.anuragbansall.learnSpring.annotations.ValidPassword;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
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
    @NotBlank(message = "Name cannot be null")
    @EmployeeNameValidation
    String name;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be null")
    String email;

    @ValidPassword
    @NotBlank(message = "Password cannot be null")
    String password;

    @NotNull(message = "Age cannot be null")
    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 65, message = "Age should not be greater than 65")
    Integer age;

    @PastOrPresent(message = "Date of joining cannot be in the future")
    LocalDate dateOfJoining;

    @JsonProperty("isActive") // To ensure proper serialization/deserialization
    Boolean isActive;
}
