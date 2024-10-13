package com.learn.Identity_service.validator.Constraint;

import com.learn.Identity_service.validator.DateValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {DateValidator.class})
public @interface DateConstraint {
    String message() default "Invalid date";

    int min();

    String [] paramMessageNames() default {};

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
