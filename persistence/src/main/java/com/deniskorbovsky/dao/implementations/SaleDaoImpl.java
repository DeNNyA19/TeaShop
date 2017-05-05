package com.deniskorbovsky.dao.implementations;

import com.deniskorbovsky.dao.AbstractDao;
import com.deniskorbovsky.dao.interfaces.SaleDao;
import com.deniskorbovsky.model.Sale;
import org.springframework.stereotype.Repository;

@Repository("saleDao")
public class SaleDaoImpl extends AbstractDao<Integer, Sale> implements SaleDao {

    public void saveSale(Sale sale) {
        save(sale);
    }
}
