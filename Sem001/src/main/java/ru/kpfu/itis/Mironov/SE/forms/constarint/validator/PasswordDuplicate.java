package ru.kpfu.itis.Mironov.SE.forms.constarint.validator;

import ru.kpfu.itis.Mironov.SE.forms.constarint.validator.impl.PasswordConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Юра on 06.05.2016.
 */
@Documented
@Constraint(validatedBy = PasswordConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordDuplicate {
    public static final String MESSAGE = "PasswordNotDuplicated";
    String passwordField();
    String passwordField2();
    String message() default MESSAGE;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
