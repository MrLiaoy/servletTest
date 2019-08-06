package com.lyl.edusys.service;

import com.lyl.edusys.model.User;

public interface UserService {
    /*
    * 添加用户
    * */
    User queryByUserIDAndPassword(User user);

}
