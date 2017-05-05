package com.deniskorbovsky.service.interfaces;


import com.deniskorbovsky.model.Type;

import java.util.List;


public interface TypeService {

    Type getTypeById(int id);
    List<Type> getAllTypes();

}
