package ru.kpfu.itis.Mironov.SE.forms;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import ru.kpfu.itis.Mironov.SE.forms.constarint.validator.PasswordDuplicate;
import ru.kpfu.itis.Mironov.SE.forms.constarint.validator.UniqueEmail;

import javax.validation.constraints.Pattern;

/**
 * Created by Rus on 25.04.2016.
 */
@PasswordDuplicate(passwordField = "password", passwordField2 = "password2")
public class RegistrationForm {
    @NotEmpty(message = "Поле обязательно для заполнения!")
    @Pattern(regexp = "[a-zA-Z0-9_]+", message = "Только латинские буквы и цифры!")
    private String login;
    @NotEmpty(message = "Поле обязательно для заполнения!")
    @Length(min = 6, max = 30)
    @Pattern(regexp = "[a-zA-Z0-9_]+", message = "Только латинские буквы и цифры!")
    private String password;

    @NotEmpty(message = "Поле обязательно для заполнения!")
    @Length(min = 6, max = 30)
    @Pattern(regexp = "[a-zA-Z0-9_]+", message = "Только латинские буквы и цифры!")
    private String password2;


    @NotEmpty(message = "Поле обязательно для заполнения!")
    @Pattern(regexp = "[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+", message = "Введите правильный адресс!")
    @UniqueEmail
    private String email;


    @NotEmpty(message = "Поле обязательно для заполнения!")
    @Pattern(regexp = "[0-9]{5}", message = "Введите 5 главных цифр!")
    private String schetchik;

    public RegistrationForm(String login, String password, String password2, String email, Integer last){
        setLogin(login);
        setPassword(password);
        setPassword2(password2);
        setEmail(email);
        setSchetchik(last + "");
    }

    public RegistrationForm() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchetchik() {
        return schetchik;
    }

    public void setSchetchik(String schetchik) {
        this.schetchik = schetchik;
    }
    public Integer getLast() {
        return Integer.parseInt(getSchetchik());
    }

    public void setLast(String last) {
        setSchetchik(last + "");
    }


}