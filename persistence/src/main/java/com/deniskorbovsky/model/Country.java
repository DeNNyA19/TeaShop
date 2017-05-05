package com.deniskorbovsky.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOfCountry;

    @NotNull
    @Column(unique = true)
    private String nameOfCountry;

    @OneToMany(mappedBy = "country")
    private List<Tea> teas;

    public int getIdOfCountry() {
        return idOfCountry;
    }

    public void setIdOfCountry(int idOfCountry) {
        this.idOfCountry = idOfCountry;
    }

    public String getNameOfCountry() {
        return nameOfCountry;
    }

    public void setNameOfCountry(String nameOfCountry) {
        this.nameOfCountry = nameOfCountry;
    }

    public List<Tea> getTeas() {
        return teas;
    }

    public void setTeas(List<Tea> teas) {
        this.teas = teas;
    }
}
