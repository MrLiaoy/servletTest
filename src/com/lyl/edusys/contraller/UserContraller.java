package com.lyl.edusys.contraller;

import com.lyl.edusys.frame.contraller.BaseContraller;
import com.lyl.edusys.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserContraller extends BaseContraller {

    private static final long serialVersionUID = -8750121791535145193L;


    @Override
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = new User();

        String login_name = req.getParameter("login_name");

        String password = req.getParameter("password");
        user.setLogin_name(login_name);
        user.setPassword(password);

        user = userService.queryByUserIDAndPassword(user);
        req.getSession().setAttribute("user", user);
        if (user != null)
            resp.sendRedirect("view/success.jsp");
        else {
            req.getSession().setAttribute("message", "帐号或者密码错误");
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    public void delet(HttpServletRequest req, HttpServletResponse resp) {
        int user_id;
        String user_idstr = req.getParameter("user_id");
        user_id = Integer.parseInt(user_idstr);
        int n = userService.deleteUserByUser_id(user_id);
        req.setAttribute("userlist", userService.queryAll());
        try {
            req.getRequestDispatcher("view/user/userList.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(HttpServletRequest req, HttpServletResponse resp) {
        User user1 = new User();
        String user_idstr = req.getParameter("user_id");
        System.out.println(user_idstr);
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String sex = req.getParameter("sex");
        String hobby = req.getParameter("hobby");
        String login_name = req.getParameter("login_name");
        String password = req.getParameter("password");
        int user_id=0;
        try {
          user_id  = Integer.parseInt(user_idstr);
        }catch (RuntimeException e){
            return;
        }

        user1.setUser_id(user_id);
        user1.setName(name);
        user1.setAge(age);
        user1.setSex(sex);
        user1.setHobby(hobby);
        user1.setLogin_name(login_name);
        user1.setPassword(password);
        System.out.println(user1);

        int n = userService.updateById(user1);
        req.setAttribute("userlist", userService.queryAll());
        try {
            req.getRequestDispatcher("view/user/userList.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<User> userList = userService.queryAll();
        req.getSession().setAttribute("userlist", userList);
        resp.sendRedirect("view/user/userList.jsp");
    }

    @Override
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user1 = new User();
        user1.setName(req.getParameter("name"));
        user1.setAge(req.getParameter("age"));
        user1.setSex(req.getParameter("sex"));
        user1.setHobby(req.getParameter("hobby"));
        user1.setLogin_name(req.getParameter("login_name"));
        user1.setPassword(req.getParameter("password"));
        System.out.println(user1);
        int i = userService.addUser(user1);
        if (i == 0) {
            resp.sendRedirect("view/user/adduser.jsp");
        }
        if (i == 1) {
            req.getSession().setAttribute("addSuccessMsg", "添加用户名为" + user1.getName() + "的用户成功");
            resp.sendRedirect("view/user/userList.jsp");
        }
    }

    @Override
    public void toUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("user_id"));
        User user = userService.queryById(id);
        req.setAttribute("user1", user);
        try {
            req.getRequestDispatcher("view/user/updateUser.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
