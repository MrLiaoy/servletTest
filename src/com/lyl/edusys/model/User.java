package com.lyl.edusys.model;

import java.util.Date;

public class User {
    /*
     * user_id用户id唯一
     * name 用户姓名
     * age 用户年龄
     * sex 用户性别
     * hobby 用户爱好
     * password 用户密码
     * create_time 用户创建的时间
     *
     *
     * */
    private int user_id;
    private String name;
    private String age;
    private String sex;
    private String hobby;
    private String password;
    private String login_name;
    private Date create_time;

    public User() {
    }

    public User(int user_id, String name, String age, String sex, String hobby, String password, String login_name, Date create_time) {
        this.user_id = user_id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.hobby = hobby;
        this.password = password;
        this.login_name = login_name;
        this.create_time = create_time;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", hobby='" + hobby + '\'' +
                ", password='" + password + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}
