<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/8/7
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<center>
    <h1>修改用户</h1>
</center>
<center>
    <hr>
    <form action="<%=basePath%>userContraller?method=update" method="post">
        <table>
            <tr>
                <td>用户ID</td>
                <td><input type="text" name="user_id" value="${user1.user_id}" style="display: none">${user1.user_id}</td>
            </tr>
            <tr>
                <td>用户名称</td>
                <td><input type="text" name="name" value="${user1.name}"></td>
            </tr>
            <tr>
                <td>年龄</td>
                <td><input type="text" name="age" value="${user1.age}"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><input type="text" name="sex" value="${user1.sex}"></td>
            </tr>
            <tr>
                <td>爱好</td>
                <td><input type="text" name="hobby" value="${user1.hobby}"></td>
            </tr>
            <tr>
                <td>登录名</td>
                <td><input type="text" name="login_name" value="${user1.login_name}"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="text" name="password" value="${user1.password}"></td>
            </tr>
            <tr>
                <td><input type="submit" value="修改"></td>

            </tr>
        </table>
    </form>
</center>
</body>
</html>