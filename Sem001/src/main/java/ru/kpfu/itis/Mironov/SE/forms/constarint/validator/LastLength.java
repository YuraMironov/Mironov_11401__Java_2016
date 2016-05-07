package ru.kpfu.itis.Mironov.SE.forms.constarint.validator;

import ru.kpfu.itis.Mironov.SE.forms.constarint.validator.impl.LastLengthConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Юра on 06.05.2016.
 */
@Documented
@Constraint(validatedBy = LastLengthConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LastLength {
    public static final String MESSAGE = "Введите строку из 5 цифр";
    String message() default MESSAGE;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
