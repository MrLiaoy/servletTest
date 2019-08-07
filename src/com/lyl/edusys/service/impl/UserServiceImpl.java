package com.lyl.edusys.service.impl;

import com.lyl.edusys.dao.UserDao;
import com.lyl.edusys.dao.impl.UserDaoImpl;
import com.lyl.edusys.model.User;
import com.lyl.edusys.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public User queryByUserIDAndPassword(User user) {

        return userDao.queryByUserIDAndPassword(user);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }

    @Override
    public int deleteUserByUser_id(int user_id) {
        return userDao.deleteUserByUser_id(user_id);
    }

    @Override
    public int updateById(User user) {
        return userDao.updateById(user);
    }

    @Override
    public User queryById(int id) {
        return userDao.queryById( id);
    }
}
