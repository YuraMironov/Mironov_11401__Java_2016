package ru.kpfu.itis.Mironov.SE.forms.constarint.validator.impl;

import ru.kpfu.itis.Mironov.SE.forms.constarint.validator.LastLength;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Pattern;

/**
 * Created by Юра on 06.05.2016.
 */
public class LastLengthConstraintValidator implements ConstraintValidator<LastLength, Integer> {
    public void initialize(LastLength lastLength) {

    }

    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return (integer + "").length() == 5;
    }
}
