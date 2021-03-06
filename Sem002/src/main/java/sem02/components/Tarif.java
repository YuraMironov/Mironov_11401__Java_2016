package sem02.components;


/**
 * Created by Юра on 21.04.2016.
 */
public class Tarif {
    private Long idTarif;
    private String nameT;
    private String specialty;
    private Double cost;
    private Firm produce;

    public Long getIdTarif() {
        return idTarif;
    }

    public void setIdTarif(Long idTarif) {
        this.idTarif = idTarif;
    }

    public Firm getProduce() {
        return produce;
    }

    public void setProduce(Firm produce) {
        this.produce = produce;
    }

    @Override
    public String toString() {
        return "Tarif{" +
                "idTarif=" + idTarif +
                ", nameT='" + nameT + '\'' +
                ", specialty='" + specialty + '\'' +
                ", cost=" + cost +
                ", produce=" + produce +
                '}';
    }

    public String getNameT() {
        return nameT;
    }

    public void setNameT(String nameT) {
        this.nameT = nameT;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tarif that = (Tarif) o;

        if (idTarif != null ? !idTarif.equals(that.idTarif) : that.idTarif != null) return false;
        if (nameT != null ? !nameT.equals(that.nameT) : that.nameT != null) return false;
        if (specialty != null ? !specialty.equals(that.specialty) : that.specialty != null) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTarif != null ? idTarif.hashCode() : 0;
        result = 31 * result + (nameT != null ? nameT.hashCode() : 0);
        result = 31 * result + (specialty != null ? specialty.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }
}
