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

    int  deleteUserByUser_id(int user_id);

    int updateById(User user);

    User queryById(int id);
}
