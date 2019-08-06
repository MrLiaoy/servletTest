package com.lyl.edusys.dao.impl;

import com.lyl.edusys.dao.UserDao;
import com.lyl.edusys.model.User;

import java.util.Date;

public class UserDaoImpl implements UserDao {

    @Override
    public User queryByUserIDAndPassword(User user) {
        //将user传入查询返回一个新的user；
        User user1=new User();
        user1.setUser_id(12345);
        user1.setPassword("abcd");
        user1.setAge("20");
        user1.setCreate_time(new Date());
        user1.setSex("男");
        user1.setName("张三");
        if (user.getUser_id()==user1.getUser_id()&&user.getPassword().equals(user1.getPassword()))
            return user1;
        else
            return null;
    }
}
