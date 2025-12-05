package com.anuragbansall.learnSpring.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentDto {
    Long id;

    @NotBlank(message = "Title cannot be blank")
    @Size(min = 3, max = 50)
    String title;

    @AssertTrue(message = "Department must be active")
    boolean isActive;

    @Null(message = "createdAt must be null when creating department")
    @CreationTimestamp // Automatically set the creation timestamp
    LocalDateTime createdAt;
}
