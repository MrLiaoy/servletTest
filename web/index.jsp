<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/8/6
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePah = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<center>
    <h1>欢迎来到xxx系统</h1>
    <hr>
    
    <form action="<%=basePah%>userContraller" method="post">
        账户：<input type="text" name="user_id"><br>
        密码<input type="password" name="password"><br>
        <input type="submit" value="登录"><input type="reset" value="重置">
</center>
</form>
</body>
</html>
