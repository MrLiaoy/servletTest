package com.lyl.edusys.contraller;

import com.lyl.edusys.frame.contraller.BaseContraller;
import com.lyl.edusys.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserContraller extends BaseContraller {

    private static final long serialVersionUID = -8750121791535145193L;
    User user = new User();

    @Override
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int user_id = 0;
        try {
            user_id = Integer.parseInt(req.getParameter("user_id"));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        System.out.println(user_id);
        String password = req.getParameter("password");
        System.out.println(password);
        user.setUser_id(user_id);
        user.setPassword(password);

        user = userService.queryByUserIDAndPassword(user);
        if (user != null)
            resp.sendRedirect("view/success.jsp");
        else
            resp.sendRedirect("index.jsp");
    }

    @Override
    public void delet(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    public void update(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("view/user/userList.jsp");
    }

    @Override
    public void add(HttpServletRequest req, HttpServletResponse resp) {

    }
}
