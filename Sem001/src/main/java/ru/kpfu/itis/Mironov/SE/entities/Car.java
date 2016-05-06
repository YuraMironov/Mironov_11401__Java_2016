package ru.kpfu.itis.Mironov.SE.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Rus on 17.04.2016.
 */
@Entity
@Table(name = "cars")
public class Car {
    private Long id;
    private Double kof;
    private CarManufacture manufacture;
    private Model model;
    private Color color;
    private Year year;
    private List<Attribute> attributes;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cars_id_seq")
    @SequenceGenerator(name = "cars_id_seq", sequenceName = "cars_id_seq", allocationSize = 1)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "manufacture", referencedColumnName = "id")
    public CarManufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(CarManufacture manufacture) {
        this.manufacture = manufacture;
    }
    @ManyToOne
    @JoinColumn(name = "model", referencedColumnName = "id")
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @ManyToOne
    @JoinColumn(name = "color", referencedColumnName = "id")
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @ManyToOne
    @JoinColumn(name = "year", referencedColumnName = "id")
    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "car_atributes", joinColumns = @JoinColumn(name = "cars_id"),
            inverseJoinColumns = @JoinColumn(name = "attributes_id"))
    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    @Basic
    @Column(name = "kof")
    public Double getKof() {
        return kof;
    }

    public void setKof(Double kof) {
        this.kof = kof;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (year != car.year) return false;
        if (id != null ? !id.equals(car.id) : car.id != null) return false;
        if (kof != null ? !kof.equals(car.kof) : car.kof != null) return false;
        if (manufacture != null ? !manufacture.equals(car.manufacture) : car.manufacture != null) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        return color != null ? color.equals(car.color) : car.color == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (kof != null ? kof.hashCode() : 0);
        result = 31 * result + (manufacture != null ? manufacture.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
