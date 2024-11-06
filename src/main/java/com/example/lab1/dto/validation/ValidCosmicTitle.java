package com.example.lab1.dto.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SpaceTitleValidator.class)
@Documented
public @interface ValidCosmicTitle {

    String message() default ValidationMessages.INVALID_COSMIC_TITLE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
