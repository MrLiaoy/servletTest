package com.lyl.edusys.dao;

import com.lyl.edusys.model.User;

import java.util.List;

public interface UserDao {
    User queryByUserIDAndPassword(User user);

    int addUser(User user);

    List<User> queryAll();
}
