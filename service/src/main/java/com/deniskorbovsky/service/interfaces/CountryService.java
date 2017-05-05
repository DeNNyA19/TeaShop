package com.deniskorbovsky.service.interfaces;


import com.deniskorbovsky.model.Country;

import java.util.List;

public interface CountryService {

    Country getCountryById(int id);
    List<Country> getAllCountries();

}
