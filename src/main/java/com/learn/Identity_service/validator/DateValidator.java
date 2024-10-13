package com.learn.Identity_service.validator;

import com.learn.Identity_service.validator.Constraint.DateConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.Getter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Getter
public class DateValidator implements ConstraintValidator<DateConstraint, LocalDate> {

    private int min;
    private String[] attributeName;

    @Override
    public void initialize(DateConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        min = constraintAnnotation.min();
        attributeName = constraintAnnotation.paramMessageNames();
    }

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext constraintValidatorContext) {

        if (Objects.isNull(date)) return true;

        long years = ChronoUnit.YEARS.between(date, LocalDate.now());

        return years > min;
    }
}
