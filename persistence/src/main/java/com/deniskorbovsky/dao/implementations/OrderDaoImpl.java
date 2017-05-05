package com.deniskorbovsky.dao.implementations;

import com.deniskorbovsky.dao.AbstractDao;
import com.deniskorbovsky.dao.interfaces.OrderDao;
import com.deniskorbovsky.model.Order;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Repository("orderDao")
public class OrderDaoImpl extends AbstractDao<Integer, Order> implements OrderDao {

    public int saveOrder(Order order) {
        return save(order);
    }

    public Order getById(int id) {
        return getByKey(id);
    }

    public List<Order> getAllOrders() {
        return createEntityCriteria().list();
    }

    public void updateStatus(int id, String status) throws UnsupportedEncodingException {
        //Transaction tx = getSession().beginTransaction();
        String hqlUpdate = "update orders c set c.status = '" + new String (status.getBytes("iso-8859-1"), "UTF-8") + "' where c.idOfOrder = " + id;
        getSession().createSQLQuery(hqlUpdate).executeUpdate();
        //getSession().createQuery(hqlUpdate).setString("newStatus", status).setInteger("id", id).executeUpdate();
        //tx.commit();
    }
}
