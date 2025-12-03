package com.anuragbansall.learnSpring.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = {EmployeeNameValidator.class})
public @interface EmployeeNameValidation {
    String message() default "Employee name must starts with 'emp.'"; // Default error message

    Class <?>[] groups() default {}; // For grouping constraints

    Class <? extends Payload[]>[] payload() default {}; // For carrying metadata information
}
