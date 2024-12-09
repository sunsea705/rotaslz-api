package com.rotaslzapi.config.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class EnumValidatorImpl implements ConstraintValidator<EnumValidator, Enum<?>> {

    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(EnumValidator annotation) {
        this.enumClass = annotation.enumClass();
    }

    @Override
    public boolean isValid(Enum<?> value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true; // Permitir nulo caso seja validado separadamente com @NotNull
        }
        return Arrays.asList(enumClass.getEnumConstants()).contains(value);
    }
}
