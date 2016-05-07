package ru.kpfu.itis.Mironov.SE.forms.constarint.validator;

import ru.kpfu.itis.Mironov.SE.forms.constarint.validator.impl.EmailConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Юра on 06.05.2016.
 */
@Documented
@Constraint(validatedBy = EmailConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {
        public static final String MESSAGE = "Пользователь с таким электронным адресом уже существует!";
        String message() default MESSAGE;
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
}
