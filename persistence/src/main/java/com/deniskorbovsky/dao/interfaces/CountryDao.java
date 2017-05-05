package com.deniskorbovsky.dao.interfaces;

import com.deniskorbovsky.model.Country;

import java.util.List;

/**
 * Created by denis on 13.04.2017.
 */
public interface CountryDao {

    Country getById(int id);
    List<Country> getAll();

}
