package com.meli.socialmeli.utilities;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class CustomLocalDateValidator implements ConstraintValidator<CustomLocalDateValidation, LocalDate> {
    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        return !localDate.equals(LocalDate.MIN);
    }

    @Override
    public void initialize(CustomLocalDateValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
