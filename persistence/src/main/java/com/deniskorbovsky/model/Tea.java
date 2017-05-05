package com.deniskorbovsky.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="teas")
public class Tea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOfTea;

    @NotNull
    private String nameOfTea;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idOfType")
    private Type type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idOfCountry")
    private Country country;

    private byte[] image;

    private String description;

    private int price;

    @OneToMany(mappedBy = "tea")
    private List<Sale> sales;

    public int getIdOfTea() {
        return idOfTea;
    }

    public void setIdOfTea(int idOfTea) {
        this.idOfTea = idOfTea;
    }

    public String getNameOfTea() {
        return nameOfTea;
    }

    public void setNameOfTea(String nameOfTea) {
        this.nameOfTea = nameOfTea;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Sale)) {
            return false;
        }
        Tea tea = (Tea)obj;
        return Objects.equals(nameOfTea, tea.nameOfTea) && price == tea.price;
    }

    public int hashCode() {
        return Objects.hash(nameOfTea, price);
    }
}
