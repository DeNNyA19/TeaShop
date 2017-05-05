package com.deniskorbovsky.service.implementations;

import com.deniskorbovsky.dao.interfaces.UserDao;
import com.deniskorbovsky.model.User;
import com.deniskorbovsky.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by denis on 18.04.2017.
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao dao;

    public User findById(int id) {
        return dao.findById(id);
    }

    public User findByUsername(String username) {
        return dao.findByUsername(username);
    }

    @Override
    public int saveUser(User user) {
        return dao.saveUser(user);
    }
}
