package com.service.impl;

import com.bean.User;
import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void RegisterUser(User user) {
        userDao.RegisterUser(user);
    }

    @Override
    public Integer getUserIdByName(String username) {
        return userDao.getUserIdByName(username);
    }

    @Override
    public User loginUser(String username, String password) {
        return userDao.loginUser(username,password);
    }
}
