package com.deniskorbovsky.dao.interfaces;


import com.deniskorbovsky.model.User;

public interface UserDao {

    User findById(int id);
    User findByUsername(String username);
    int saveUser(User user);
}
