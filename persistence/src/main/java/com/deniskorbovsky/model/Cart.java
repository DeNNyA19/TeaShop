package com.deniskorbovsky.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope(
        value= WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.TARGET_CLASS
)
public class Cart implements Serializable {

    private final static long serialVersionUID = 1L;

    private List<Sale> sales = new ArrayList<Sale>();

    public void addSale(Sale sale) {
        if (!sales.contains(sale))
            sales.add(sale);
        else if (sale.getAmount() == -1)
            sales.get(sales.indexOf(sale)).amountDecrement();
        else
            sales.get(sales.indexOf(sale)).addAmount(sale.getAmount());
    }

    public void removeSale(Sale sale) {
        sales.remove(sale);
    }

    public int getFinalPrice() {
        int finalPrice = 0;
        for (Sale sale : sales) {
            finalPrice += (sale.getTea().getPrice() * sale.getAmount());
        }
        return finalPrice;
    }

    public int getAmountOfSales() {
        int amount = 0;
        for (Sale sale : sales)
            amount += sale.getAmount();
        return amount;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
}
