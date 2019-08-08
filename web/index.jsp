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
   /*
   * request.getScheme()获取连接是http还是https
   * request.getServerName()获取服务器域名
   * request.getServerPort()获取端口
   * request.getContextPath()获取项目路（项目名称）
   * */
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>纸叠效果会员登录界面模板</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <link rel="stylesheet" type="text/css" href="css/body.css"/>
</head>
<body>
<div class="container">
    <section id="content">
        <form action="<%=basePah%>userContraller?method=login" method="post">
            <h1>会员登录</h1>
            <div>
                <input type="text" placeholder="邮箱" required="" id="username" name="login_name"/>
            </div>
            <div>
                <input type="password" placeholder="密码" required="" id="password" name="password"/>
            </div>
            <div class="">
                <span class="help-block u-errormessage">&nbsp;</span></div>
            <div>
                <!-- <input type="submit" value="Log in" /> -->
                <input type="submit" value="登录" class="btn btn-primary" id="js-btn-login"/>
            </div>
        </form><!-- form -->

    </section><!-- content -->
</div>
<!-- container -->
</body>
</html>