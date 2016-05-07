package ru.kpfu.itis.Mironov.SE.forms;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * Created by Юра on 07.05.2016.
 */
public class AdviceAddForm {
    @NotEmpty(message = "Поле обязательно для заполнения!")
    private String title;
    @NotEmpty(message = "Поле обязательно для заполнения!")
    private String body;
    @Pattern(regexp = "((^(https?://)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([/\\w \\.-]*)*/?$)|)", message = "Введите ссылку на картинку!")
    private String filesrc;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFilesrc() {
        return filesrc;
    }

    public void setFilesrc(String filesrc) {
        this.filesrc = filesrc;
    }
}
