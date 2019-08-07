package com.lyl.edusys.frame.contraller;

import com.lyl.edusys.service.UserService;
import com.lyl.edusys.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class BaseContraller extends HttpServlet {

    private static final long serialVersionUID = -7824894020784619563L;
    public UserService userService = new UserServiceImpl();

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置servlet编码，防止前端传到后台中文乱码
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        if (method==null&&method.trim().isEmpty()){
            return;
        }
        Class clas = this.getClass();
        try {
          Method method1 = clas.getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
          method1.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public abstract void login(HttpServletRequest req, HttpServletResponse resp) throws IOException;

    public abstract void delet(HttpServletRequest req, HttpServletResponse resp);

    public abstract void update(HttpServletRequest req, HttpServletResponse resp);

    public abstract void query(HttpServletRequest req, HttpServletResponse resp) throws IOException;

    public abstract void add(HttpServletRequest req, HttpServletResponse resp) throws IOException;
}
