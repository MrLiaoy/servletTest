package com.lyl.edusys.dao;

import com.lyl.edusys.model.User;

public interface UserDao {
    User queryByUserIDAndPassword(User user);

    int addUser(User user);
}
