package com.mcubes.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by A.A.MAMUN on 9/2/2020.
 */
public class GenderValidator implements ConstraintValidator<Gender, String>{

    private List<String> types;

    @Override
    public void initialize(Gender constraintAnnotation) {
        types = Arrays.asList(constraintAnnotation.types());
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return types.stream().anyMatch(type -> type.equals(s));
    }
}
