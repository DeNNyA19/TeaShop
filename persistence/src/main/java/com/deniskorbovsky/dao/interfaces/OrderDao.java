package com.deniskorbovsky.dao.interfaces;

import com.deniskorbovsky.model.Order;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by denis on 13.04.2017.
 */
public interface OrderDao {

    int saveOrder(Order order);
    Order getById(int id);
    List<Order> getAllOrders();
    void updateStatus(int id, String status) throws UnsupportedEncodingException;

}
