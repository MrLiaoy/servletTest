<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/8/6
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title></title>
</head>
<body>
<center>
    <h1>用户页面</h1>

</center>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="addUser.jsp">增加</a>
<center>
    <hr>

    <table border="1" width="80%">
        <tr>
            <td>用户ID</td>
            <td>用户名称</td>
            <td>年龄</td>
            <td>性别</td>
            <td>爱好</td>
            <td>登录名</td>
            <td>密码</td>
            <td>创建时间</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${userlist}" var="user">
            <tr>
                <td>${user.user_id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.sex}</td>
                <td>${user.hobby}</td>
                <td>${user.login_name}</td>
                <td>${user.password}</td>
                <td>${user.create_time}</td>
                <td><a href="<%=basePath%>userContraller?method=delet&user_id=${user.user_id}">删除</a></td>
                <td><a href="<%=basePath%>userContraller?method=toUpdate&user_id=${user.user_id}">修改</a></td>
            </tr>
        </c:forEach>
    </table>
</center>

</body>
</html>
