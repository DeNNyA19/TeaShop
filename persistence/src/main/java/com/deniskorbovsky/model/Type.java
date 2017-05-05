package com.deniskorbovsky.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "types")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOfType;

    @NotNull
    private String nameOfType;

    @OneToMany(mappedBy = "type")
    private List<Tea> teas;

    public int getIdOfType() {
        return idOfType;
    }

    public void setIdOfType(int idOfType) {
        this.idOfType = idOfType;
    }

    public String getNameOfType() {
        return nameOfType;
    }

    public void setNameOfType(String nameOfType) {
        this.nameOfType = nameOfType;
    }

    public List<Tea> getTeas() {
        return teas;
    }

    public void setTeas(List<Tea> teas) {
        this.teas = teas;
    }
}
