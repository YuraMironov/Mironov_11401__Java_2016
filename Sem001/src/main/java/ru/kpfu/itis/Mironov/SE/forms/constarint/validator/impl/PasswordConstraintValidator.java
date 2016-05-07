package ru.kpfu.itis.Mironov.SE.forms.constarint.validator.impl;

import ru.kpfu.itis.Mironov.SE.forms.RegistrationForm;
import ru.kpfu.itis.Mironov.SE.forms.constarint.validator.PasswordDuplicate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;

/**
 * Created by Юра on 06.05.2016.
 */
public class PasswordConstraintValidator implements ConstraintValidator<PasswordDuplicate, Object>{
    private String passwordField;
    private String passwordField2;
    private String message;


    public void initialize(PasswordDuplicate passwordDuplicate) {
        setPasswordField(passwordDuplicate.passwordField());
        setPasswordField2(passwordDuplicate.passwordField2());
        setMessage(passwordDuplicate.message());
    }

    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        try {

            final Object fieldObject = getProperty(o, passwordField);
            final Object equalsToObject = getProperty(o, passwordField2);

            if (fieldObject == null && equalsToObject == null) {
                return false;
            }

            boolean matches = (fieldObject != null)
                    && fieldObject.equals(equalsToObject);

            if (!matches) {
                String msg = getMessage();
                if( this.message == null
                        || "".equals( getMessage())
                        || PasswordDuplicate.MESSAGE.equals( getMessage() ) ){
                    msg = "Не правильно подтвержден пароль";
                }
                constraintValidatorContext.disableDefaultConstraintViolation();
                constraintValidatorContext.buildConstraintViolationWithTemplate(msg)
                        .addPropertyNode(passwordField2).addConstraintViolation();
            }

            return matches;
        } catch (final Exception ignored) {
        }
        return false;
    }
    private Object getProperty(Object value, String fieldName) {
        Class<?> clazz = value.getClass();
        String methodName = "get" + Character.toUpperCase(fieldName.charAt(0))
                + fieldName.substring(1);
        try {
            Method method = clazz.getDeclaredMethod(methodName);
            return method.invoke(value);
        } catch (Exception ignored) {
        }
        return null;
    }

    public String getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(String passwordField) {
        this.passwordField = passwordField;
    }

    public String getPasswordField2() {
        return passwordField2;
    }

    public void setPasswordField2(String passwordField2) {
        this.passwordField2 = passwordField2;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
