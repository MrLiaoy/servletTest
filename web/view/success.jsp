<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/8/6
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePah = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    /*
     * request.getScheme()获取连接是http还是https
     * request.getServerName()获取服务器域名
     * request.getServerPort()获取端口
     * request.getContextPath()获取项目路（项目名称）
     * */
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>登陆成功</h1>
    <hr>
</center>
<a href="<%=basePah%>/userContraller?method=query">查询用户</a>
</body>
</html>
