package com.deniskorbovsky.dao.implementations;

import com.deniskorbovsky.dao.AbstractDao;
import com.deniskorbovsky.dao.interfaces.UserTypeDao;
import com.deniskorbovsky.model.UserType;
import org.springframework.stereotype.Repository;

@Repository("userTypeDao")
public class UserTypeDaoImpl extends AbstractDao<Integer, UserType> implements UserTypeDao {


    public void saveUserType(UserType userType) {
        save(userType);
    }
}
