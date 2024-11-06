package com.example.lab1.dto.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CosmicTitleValidator implements ConstraintValidator<ValidSpaceTitle, String> {

    private static final Pattern pattern = Pattern.compile("(?i)\\b(star|galaxy|comet)\\b");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }
}
