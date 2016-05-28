package sem02.components;


/**
 * Created by Юра on 21.04.2016.
 */
public class Firm {
    private Long idFirm;
    private String nameF;
    private String director;
    private String addres;
    private Integer raiting;
    private Phone phone;

    public Long getIdFirm() {
        return idFirm;
    }

    public void setIdFirm(Long idFirm) {
        this.idFirm = idFirm;
    }

    public String getNameF() {
        return nameF;
    }

    public void setNameF(String nameF) {
        this.nameF = nameF;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public Integer getRaiting() {
        return raiting;
    }

    public void setRaiting(Integer raiting) {
        this.raiting = raiting;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Firm that = (Firm) o;

        if (idFirm != null ? !idFirm.equals(that.idFirm) : that.idFirm != null) return false;
        if (nameF != null ? !nameF.equals(that.nameF) : that.nameF != null) return false;
        if (director != null ? !director.equals(that.director) : that.director != null) return false;
        if (addres != null ? !addres.equals(that.addres) : that.addres != null) return false;
        if (raiting != null ? !raiting.equals(that.raiting) : that.raiting != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFirm != null ? idFirm.hashCode() : 0;
        result = 31 * result + (nameF != null ? nameF.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (addres != null ? addres.hashCode() : 0);
        result = 31 * result + (raiting != null ? raiting.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Firm{" +
                "idFirm=" + idFirm +
                ", nameF='" + nameF + '\'' +
                ", director='" + director + '\'' +
                ", addres='" + addres + '\'' +
                ", raiting=" + raiting +
                ", phone=" + phone +
                '}';
    }
}
