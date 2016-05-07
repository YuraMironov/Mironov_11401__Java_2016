package ru.kpfu.itis.Mironov.SE.forms;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by Юра on 06.05.2016.
 */
public class UserSchetForm {
    @NotNull(message = "Поле, обязательное для заполнения!!!")
    @Min(10000000)
    @Max(99999999)
    private Integer schetNumber;
    @NotNull(message = "Поле, обязательное для заполнения!!!")
    private String date;
    @NotEmpty(message = "Поле, обязательное для заполнения!")
    @Pattern(regexp = "[0-9]{5}", message = "Введите 5 главных цифр!")
    private String schetchik;

    public Integer getSchetNumber() {
        return schetNumber;
    }

    public void setSchetNumber(Integer schetNumber) {
        this.schetNumber = schetNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSchetchik() {
        return schetchik;
    }

    public void setSchetchik(String schetchik) {
        this.schetchik = schetchik;
    }

    public Integer getLastNow() {
        return Integer.parseInt(getSchetchik());
    }

    public void setLastNow(String last) {
        setSchetchik(last + "");
    }
}
