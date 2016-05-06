package ru.kpfu.itis.Mironov.SE.entities;

import javax.persistence.*;

/**
 * Created by Юра on 21.04.2016.
 */
@Entity
@Table(name = "newses")
public class News {
    private Long idNews;
    private String title;
    private String body;
    @Id
    @Column(name = "id_news")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getIdNews() {
        return idNews;
    }

    public void setIdNews(Long idNews) {
        this.idNews = idNews;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "body")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News that = (News) o;

        if (idNews != null ? !idNews.equals(that.idNews) : that.idNews != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (body != null ? !body.equals(that.body) : that.body != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idNews != null ? idNews.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "News{" +
                "idNews=" + idNews +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
