package com.spring_boot.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomValidator implements
        ConstraintValidator<CustomValidation,String> {

    @Override
    public boolean isValid(String value,
                           ConstraintValidatorContext constraintValidatorContext) {
        return value != null && !value.isEmpty();
    }
}
