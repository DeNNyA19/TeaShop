package com.deniskorbovsky.dao.implementations;

import com.deniskorbovsky.dao.AbstractDao;
import com.deniskorbovsky.dao.interfaces.TypeDao;
import com.deniskorbovsky.model.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("typeDao")
public class TypeDaoImpl extends AbstractDao<Integer, Type> implements TypeDao {

    public Type getById(int id) {
        return getByKey(id);
    }

    public List<Type> getAll() {
        return (List<Type>) createEntityCriteria().list();
    }
}
