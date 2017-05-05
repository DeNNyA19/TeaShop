package com.deniskorbovsky.service.implementations;

import com.deniskorbovsky.dao.interfaces.CountryDao;
import com.deniskorbovsky.model.Country;
import com.deniskorbovsky.service.interfaces.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("countryService")
@Transactional
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao dao;

    public Country getCountryById(int id) {
        return dao.getById(id);
    }

    public List<Country> getAllCountries() {
        return dao.getAll();
    }
}
