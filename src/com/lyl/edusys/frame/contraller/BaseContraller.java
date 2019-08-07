package com.lyl.edusys.frame.contraller;

import com.lyl.edusys.service.UserService;
import com.lyl.edusys.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract  class BaseContraller extends HttpServlet {

    private static final long serialVersionUID = -7824894020784619563L;
    public UserService userService=new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("login".equals(method)){
            this.login(req,resp);
        }
        if ("add".equals(method)){
            this.add(req,resp);
        }
        if ("delet".equals(method)){
            this.delet(req,resp);
        }
        if ("update".equals(method)){
            this.update(req,resp);
        }
        if ("query".equals(method)){
            this.query(req,resp);
        }
    }

    public  abstract void login(HttpServletRequest req, HttpServletResponse resp) throws IOException;
    public abstract void delet(HttpServletRequest req, HttpServletResponse resp);
    public abstract void update(HttpServletRequest req, HttpServletResponse resp);

    public abstract void query(HttpServletRequest req, HttpServletResponse resp) throws IOException;
    public abstract void add(HttpServletRequest req, HttpServletResponse resp);
}
