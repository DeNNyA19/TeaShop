package com.deniskorbovsky.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name="sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOfSale;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="idOfOrder")
    private Order order;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="idOfTea")
    private Tea tea;

    @NotNull
    private int amount;

    public Sale() {
        this(null, 0);
    }

    public Sale(Tea tea) {
        super();
        this.tea = tea;
        this.amount = 0;
    }

    public Sale(Tea tea, int amount) {
        super();
        this.tea = tea;
        this.amount = amount;
    }

    public void amountIncrement() {
        this.amount++;
    }

    public void amountDecrement() {
        this.amount--;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }

    public int getIdOfSale() {
        return idOfSale;
    }

    public void setIdOfSale(int idOfSale) {
        this.idOfSale = idOfSale;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Tea getTea() {
        return tea;
    }

    public void setTea(Tea tea) {
        this.tea = tea;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
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
        Sale sale = (Sale)obj;
        return tea.getNameOfTea().equals(sale.tea.getNameOfTea());
    }

    public int hashCode() {
        return Objects.hash(tea);
    }
}
