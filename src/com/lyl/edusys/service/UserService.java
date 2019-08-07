package com.lyl.edusys.service;

import com.lyl.edusys.model.User;

import java.util.List;

public interface UserService {
    /*
    * 添加用户
    * */
    User queryByUserIDAndPassword(User user);

    int addUser(User user);

    List<User> queryAll();
}
