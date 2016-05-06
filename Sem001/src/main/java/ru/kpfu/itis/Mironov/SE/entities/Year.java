package ru.kpfu.itis.Mironov.SE.entities;

import javax.persistence.*;

/**
 * Created by Rus on 17.04.2016.
 */
@Entity
@Table(name = "years")
public class Year {
    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "years_id_seq")
    @SequenceGenerator(name="years_id_seq", sequenceName="years_id_seq", allocationSize = 1)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Year that = (Year) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
