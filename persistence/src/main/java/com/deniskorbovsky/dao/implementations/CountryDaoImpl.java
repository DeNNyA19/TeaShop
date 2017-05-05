package com.deniskorbovsky.dao.implementations;

import com.deniskorbovsky.dao.AbstractDao;
import com.deniskorbovsky.dao.interfaces.CountryDao;
import com.deniskorbovsky.model.Country;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("countryDao")
public class CountryDaoImpl extends AbstractDao<Integer, Country> implements CountryDao {

    public Country getById(int id) {
        return getByKey(id);
    }

    public List<Country> getAll() {
        return (List<Country>) createEntityCriteria().list();
    }
}
