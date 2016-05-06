package ru.kpfu.itis.Mironov.SE.entities;

import javax.persistence.*;

/**
 * Created by Юра on 21.04.2016.
 */
@Entity
@Table(name = "cssnames")
public class CssNames {
    private Integer idCss;
    private String namecss;
    private Integer sizeh;
    private Integer filesize;

    @Id
    @Column(name = "id_css")
    public Integer getIdCss() {
        return idCss;
    }

    public void setIdCss(Integer idCss) {
        this.idCss = idCss;
    }

    @Basic
    @Column(name = "namecss")
    public String getNamecss() {
        return namecss;
    }

    public void setNamecss(String namecss) {
        this.namecss = namecss;
    }

    @Basic
    @Column(name = "sizeh")
    public Integer getSizeh() {
        return sizeh;
    }

    public void setSizeh(Integer sizeh) {
        this.sizeh = sizeh;
    }

    @Basic
    @Column(name = "filesize")
    public Integer getFilesize() {
        return filesize;
    }

    public void setFilesize(Integer filesize) {
        this.filesize = filesize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CssNames that = (CssNames) o;

        if (idCss != null ? !idCss.equals(that.idCss) : that.idCss != null) return false;
        if (namecss != null ? !namecss.equals(that.namecss) : that.namecss != null) return false;
        if (sizeh != null ? !sizeh.equals(that.sizeh) : that.sizeh != null) return false;
        if (filesize != null ? !filesize.equals(that.filesize) : that.filesize != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCss != null ? idCss.hashCode() : 0;
        result = 31 * result + (namecss != null ? namecss.hashCode() : 0);
        result = 31 * result + (sizeh != null ? sizeh.hashCode() : 0);
        result = 31 * result + (filesize != null ? filesize.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CssNames{" +
                "idCss=" + idCss +
                ", namecss='" + namecss + '\'' +
                ", sizeh=" + sizeh +
                ", filesize=" + filesize +
                '}';
    }
}
