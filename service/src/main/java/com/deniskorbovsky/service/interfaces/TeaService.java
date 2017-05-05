package com.deniskorbovsky.service.interfaces;


import com.deniskorbovsky.model.Tea;

import java.util.List;

public interface TeaService {

    Tea getTeaById(int id);
    List<Tea> getAllTea(int numberOfPage, int amountOnPage);
    List<Tea> getAllTea();
    List<Tea> getTeasByType(int idOfType);
    List<Tea> getTeasByType(int idOfType, int numberOfPage, int amountOnPage);
    List<Tea> getTeasByCountry(int idOfCountry);
    List<Tea> getTeasByCountry(int idOfCountry, int numberOfPage, int amountOnPage);
    List<Tea> getTeasBySearch(String searchString);
    List<Tea> getTeasBySearch(String searchString, int numberOfPage, int amountOnPage);

}
