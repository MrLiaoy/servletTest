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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title>后台管理中心</title>
    <link rel="stylesheet" href="<%=basePah%>css/pintuer.css">
    <link rel="stylesheet" href="<%=basePah%>css/admin.css">
    <script src="<%=basePah%>js/jquery.js"></script>
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
        <h1><img src="<%=basePah%>images/y.jpg" class="radius-circle rotate-hover" height="50" alt=""/>后台管理中心</h1>
    </div>
    <div class="head-l"><a class="button button-little bg-green" href="" target="_blank"><span class="icon-home"></span>
        前台首页</a> &nbsp;&nbsp;<a href="##" class="button button-little bg-blue"><span class="icon-wrench"></span>
        清除缓存</a> &nbsp;&nbsp;<a class="button button-little bg-red" href="login.html"><span
            class="icon-power-off"></span> 退出登录</a></div>
</div>
<div class="leftnav">
    <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
    <h2><span class="icon-user"></span>基本设置</h2>
    <ul style="display:block">
        <li><a href="info.html" target="right"><span class="icon-caret-right"></span>网站设置</a></li>
        <li><a href="<%=basePah%>/userContraller?method=query" target="right"><span class="icon-caret-right"></span>用户管理</a></li>
        <li><a href="page.html" target="right"><span class="icon-caret-right"></span>添加用户</a></li>
    </ul>
    <h2><span class="icon-pencil-square-o"></span>栏目管理</h2>
    <ul>
        <li><a href="list.html" target="right"><span class="icon-caret-right"></span>内容管理</a></li>
        <li><a href="add.html" target="right"><span class="icon-caret-right"></span>添加内容</a></li>
        <li><a href="cate.html" target="right"><span class="icon-caret-right"></span>分类管理</a></li>
    </ul>
</div>
<script type="text/javascript">
    $(function () {
        $(".leftnav h2").click(function () {
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function () {
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });
</script>
<div class="admin">
    <iframe scrolling="auto" rameborder="0" src="<%=basePah%>cinfo.html" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
    <p>来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
</div>
</body>
</html>