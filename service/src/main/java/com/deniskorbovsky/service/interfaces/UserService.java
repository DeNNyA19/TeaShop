package com.deniskorbovsky.service.interfaces;

import com.deniskorbovsky.model.User;

/**
 * Created by denis on 18.04.2017.
 */
public interface UserService {

    User findById(int id);

    User findByUsername(String username);

    int saveUser(User user);

}
