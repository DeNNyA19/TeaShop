package com.deniskorbovsky.dao.interfaces;


import com.deniskorbovsky.model.Type;

import java.util.List;


public interface TypeDao {

    Type getById(int id);
    List<Type> getAll();

}
