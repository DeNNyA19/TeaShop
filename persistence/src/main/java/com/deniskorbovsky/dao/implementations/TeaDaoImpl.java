package com.deniskorbovsky.dao.implementations;

import com.deniskorbovsky.dao.AbstractDao;
import com.deniskorbovsky.dao.interfaces.TeaDao;
import com.deniskorbovsky.model.Tea;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("teaDao")
public class TeaDaoImpl extends AbstractDao<Integer, Tea> implements TeaDao {

    public Tea getById(int id) {
        return getByKey(id);
    }

    public List<Tea> getAll(int numberOfPage, int amountOnPage) {
        Criteria criteria = createEntityCriteria();
        criteria.setFirstResult(numberOfPage * amountOnPage - amountOnPage);
        criteria.setMaxResults(amountOnPage);
        return (List<Tea>) criteria.list();
    }

    public List<Tea> getAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Tea>) criteria.list();
    }

    public List<Tea> getByCriterion(Criterion criterion, int numberOfPage, int amountOnPage) {
        Criteria criteria = createEntityCriteria();
        criteria.setFirstResult(numberOfPage * amountOnPage - amountOnPage);
        criteria.setMaxResults(amountOnPage);
        return (List<Tea>) criteria.add(criterion).list();
    }

    public List<Tea> getByCriterion(Criterion criterion) {
        Criteria criteria = createEntityCriteria();
        return (List<Tea>) criteria.add(criterion).list();
    }
}
