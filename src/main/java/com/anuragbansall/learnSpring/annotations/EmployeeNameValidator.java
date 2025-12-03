package com.anuragbansall.learnSpring.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeeNameValidator implements ConstraintValidator<EmployeeNameValidation, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Consider null as valid. Use @NotNull for null checks.
        }

        return value.startsWith("emp.");
    }
}
