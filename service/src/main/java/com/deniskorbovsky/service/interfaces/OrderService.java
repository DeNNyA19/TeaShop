package com.deniskorbovsky.service.interfaces;

import com.deniskorbovsky.model.Order;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by denis on 20.04.2017.
 */
public interface OrderService {

    int saveOrder(Order order);
    Order getOrderById(int id);
    List<Order> getAllOrders();
    void updateStatus(int id, String status) throws UnsupportedEncodingException;
}
