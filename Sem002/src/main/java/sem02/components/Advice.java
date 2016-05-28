package sem02.components;

import org.apache.commons.lang3.StringEscapeUtils;


/**
 * Created by Юра on 22.04.2016.
 */
public class Advice {
    private Long id;
    private String advname;
    private String advbody;
    private String filesrc;
    private SafetyUser author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdvname() {
        return advname;
    }


    public String getAdvbody() {
        return advbody;
    }

    public void setAdvbody(String advbody) {
        this.advbody = StringEscapeUtils.escapeHtml4(advbody);
    }

    public String getFilesrc() {
        return filesrc;
    }

    public void setFilesrc(String filesrc) {
        this.filesrc = filesrc.indexOf("http") == 0 ? filesrc : "";
    }

    public SafetyUser getAuthor() {
        return author;
    }

    public void setAuthor(SafetyUser author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Advice that = (Advice) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (advname != null ? !advname.equals(that.advname) : that.advname != null) return false;
        if (advbody != null ? !advbody.equals(that.advbody) : that.advbody != null) return false;
        if (filesrc != null ? !filesrc.equals(that.filesrc) : that.filesrc != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (advname != null ? advname.hashCode() : 0);
        result = 31 * result + (advbody != null ? advbody.hashCode() : 0);
        result = 31 * result + (filesrc != null ? filesrc.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Advice{" +
                "id=" + id +
                ", advname='" + advname + '\'' +
                ", advbody='" + advbody + '\'' +
                ", filesrc='" + filesrc + '\'' +
                ", author=" + author +
                '}';
    }

    public void setAdvname(String advname) {
        this.advname = advname;
    }
}