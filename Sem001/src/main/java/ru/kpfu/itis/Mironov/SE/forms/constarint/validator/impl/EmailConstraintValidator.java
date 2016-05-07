package ru.kpfu.itis.Mironov.SE.forms.constarint.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.Mironov.SE.forms.constarint.validator.UniqueEmail;
import ru.kpfu.itis.Mironov.SE.services.MyUserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Юра on 06.05.2016.
 */
@Component
public class EmailConstraintValidator implements ConstraintValidator<UniqueEmail, String> {
    @Autowired
    MyUserService userService;
    public void initialize(UniqueEmail uniqueEmail) {

    }

    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return userService.getByEmail(s) == null;
    }
}
