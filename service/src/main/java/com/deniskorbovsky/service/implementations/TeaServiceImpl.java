package com.deniskorbovsky.service.implementations;

import com.deniskorbovsky.dao.interfaces.TeaDao;
import com.deniskorbovsky.model.Tea;
import com.deniskorbovsky.service.interfaces.TeaService;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("teaService")
@Transactional
public class TeaServiceImpl implements TeaService {

    @Autowired
    private TeaDao dao;

    public Tea getTeaById(int id) {
        return dao.getById(id);
    }

    public List<Tea> getAllTea(int numberOfPage, int amountOnPage) {
        return dao.getAll(numberOfPage, amountOnPage);
    }

    public List<Tea> getAllTea() {
        return dao.getAll();
    }

    public List<Tea> getTeasByType(int idOfType) {
        Criterion criterion = Restrictions.eq("type.idOfType", idOfType);
        return dao.getByCriterion(criterion);
    }

    public List<Tea> getTeasByType(int idOfType, int numberOfPage, int amountOnPage) {
        Criterion criterion = Restrictions.eq("type.idOfType", idOfType);
        return dao.getByCriterion(criterion, numberOfPage, amountOnPage);
    }

    public List<Tea> getTeasByCountry(int idOfCountry) {
        Criterion criterion = Restrictions.eq("country.idOfCountry", idOfCountry);
        return dao.getByCriterion(criterion);
    }

    public List<Tea> getTeasByCountry(int idOfCountry, int numberOfPage, int amountOnPage) {
        Criterion criterion = Restrictions.eq("country.idOfCountry", idOfCountry);
        return dao.getByCriterion(criterion, numberOfPage, amountOnPage);
    }

    public List<Tea> getTeasBySearch(String searchString) {
        Criterion criterion = Restrictions.ilike("nameOfTea", searchString, MatchMode.ANYWHERE);
        return dao.getByCriterion(criterion);
    }

    public List<Tea> getTeasBySearch(String searchString, int numberOfPage, int amountOnPage) {
        Criterion criterion = Restrictions.ilike("nameOfTea", searchString, MatchMode.ANYWHERE);
        return dao.getByCriterion(criterion, numberOfPage, amountOnPage);
    }
}
