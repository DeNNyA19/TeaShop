package com.deniskorbovsky.dao.implementations;


import com.deniskorbovsky.dao.interfaces.CartDao;
import com.deniskorbovsky.model.Cart;
import com.deniskorbovsky.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("cartDao")
public class CartDaoImpl implements CartDao {

    private Cart cart;

    @Autowired
    public CartDaoImpl(Cart cart) {
        this.cart = cart;
    }

    public void addSale(Sale sale) {
        cart.addSale(sale);
    }

    public void removeSale(Sale sale) {
        cart.removeSale(sale);
    }

    public int getFinalPrice() {
        return cart.getFinalPrice();
    }

    public int getAmountOfSales() {
        return cart.getAmountOfSales();
    }

    public List<Sale> getSales() {
        return cart.getSales();
    }

    public void removeAllSales() {
        cart.setSales(new ArrayList<Sale>());
    }
}
