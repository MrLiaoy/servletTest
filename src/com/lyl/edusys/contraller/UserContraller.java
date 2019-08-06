package com.lyl.edusys.contraller;

import com.lyl.edusys.model.User;
import com.lyl.edusys.service.UserService;
import com.lyl.edusys.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserContraller extends HttpServlet {

    private static final long serialVersionUID = -8750121791535145193L;
    UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int user_id = 0;
        try {
            Integer.parseInt(req.getParameter("user_id"));
        } catch (RuntimeException e) {

        }

        String password = req.getParameter("password");
        User user = service.queryByUserIDAndPassword(new User());
        if (user_id == user.getUser_id() && password.equals(user.getPassword())) {
            resp.sendRedirect("view/success.jsp");
        } else {
            resp.sendRedirect("index.jsp");
        }
    }
}
