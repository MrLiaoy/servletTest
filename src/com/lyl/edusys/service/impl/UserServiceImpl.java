package com.lyl.edusys.service.impl;

import com.lyl.edusys.dao.UserDao;
import com.lyl.edusys.dao.impl.UserDaoImpl;
import com.lyl.edusys.model.User;
import com.lyl.edusys.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao =new UserDaoImpl();
    @Override
    public User queryByUserIDAndPassword(User user) {

        return userDao.queryByUserIDAndPassword(user);
    }
}
