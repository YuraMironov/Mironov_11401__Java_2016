package ru.kpfu.itis.Mironov.SE.forms;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import ru.kpfu.itis.Mironov.SE.forms.constarint.validator.PasswordDuplicate;

import javax.validation.constraints.Pattern;

/**
 * Created by Юра on 07.05.2016.
 */
@PasswordDuplicate(passwordField = "password", passwordField2 = "password2")
public class ChangePassForm {
    @NotEmpty(message = "Поле обязательно для заполнения!")
    @Length(min = 6, max = 30)
    @Pattern(regexp = "[a-zA-Z0-9_]+", message = "Только латинские буквы и цифры!")
    private String oldPass;
    @NotEmpty(message = "Поле обязательно для заполнения!")
    @Length(min = 6, max = 30)
    @Pattern(regexp = "[a-zA-Z0-9_]+", message = "Только латинские буквы и цифры!")
    private String password;

    @NotEmpty(message = "Поле обязательно для заполнения!")
    @Length(min = 6, max = 30)
    @Pattern(regexp = "[a-zA-Z0-9_]+", message = "Только латинские буквы и цифры!")
    private String password2;

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
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

}


