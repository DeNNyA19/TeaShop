package com.deniskorbovsky.dao.implementations;

import com.deniskorbovsky.dao.AbstractDao;
import com.deniskorbovsky.dao.interfaces.UserDao;
import com.deniskorbovsky.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    public User findById(int id) {
        return getByKey(id);
    }

    public User findByUsername(String username) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("username", username));
        return (User) crit.uniqueResult();
    }

    public int saveUser(User user) {
        return (Integer) save(user);
    }
}
