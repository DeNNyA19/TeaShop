package com.deniskorbovsky.service.implementations;

import com.deniskorbovsky.dao.interfaces.OrderDao;
import com.deniskorbovsky.model.Order;
import com.deniskorbovsky.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.util.List;


@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao dao;

    public int saveOrder(Order order) {
        return dao.saveOrder(order);
    }

    public Order getOrderById(int id) {
        return dao.getById(id);
    }

    public List<Order> getAllOrders() {
        return dao.getAllOrders();
    }

    @Override
    public void updateStatus(int id, String status) throws UnsupportedEncodingException {
        dao.updateStatus(id, status);
    }
}
