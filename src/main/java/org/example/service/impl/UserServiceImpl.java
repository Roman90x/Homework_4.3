package org.example.service.impl;

import org.example.dao.UserDao;
import org.example.dao.impl.UserDaoImpl;
import org.example.entity.User;
import org.example.service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public boolean checkUserExist(User user) {
        return userDao.getUserByName(user.getName()) != null;
    }
}
