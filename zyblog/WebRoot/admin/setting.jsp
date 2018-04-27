<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
    <title>${grzl.nc }的博客</title>
    <link rel="stylesheet" href="../zyblog/static/libs/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="../zyblog/static/libs/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="../zyblog/static/css/main.css">
</head>

<body>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#global-nav">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">${grzl.nc}的博客</a>
        </div>

        <div class="collapse navbar-collapse" id="global-nav">
            <ul class="nav navbar-nav">
                <li>
                    <a>${grzl.zym }</a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${grzl.nc } <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="password.jsp">修改密码</a></li>
                        <li><a href="profile.jsp">修改资料</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="../index.jsp">退出</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<main>
    <div class="container">
        <div class="row">
            <div class="col-md-8 admin-main">
                <h1>站点设置</h1>
                <form class="form-horizontal" role="form" action="/zyblog/SettingServlet">
                    <div class="form-group">
                        <label for="blogName" class="col-sm-2 control-label">站点名称：</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="blogName" id="blogName" value="${info.bkmc }">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="keywords" class="col-sm-2 control-label">搜索关键词：</label>
                        <div class="col-sm-8">
                            <input type="text" name="keywords" class="form-control" id="keywords" value="${info.ssgjc }">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="description" class="col-sm-2 control-label">搜索描述：</label>
                        <div class="col-sm-9">
                            <input type="text" name="description" class="form-control" id="description" value="${info.ssms }">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="brief" class="col-sm-2 control-label">公司简称：</label>
                        <div class="col-sm-4">
                            <input type="text" name="brief" class="form-control" id="brief" value="${info.gsjc }">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="record" class="col-sm-2 control-label">网站备案号：</label>
                        <div class="col-sm-3">
                            <input type="text" name="record" class="form-control" id="record" value="${info.bah }">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="fullName" class="col-sm-2 control-label">公司全称：</label>
                        <div class="col-sm-5">
                            <input type="text" name="fullName" class="form-control" id="fullName" value="${info.gsqc }">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-5">
                            <button type="submit" class="btn btn-success btn-block">保存修改</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-md-4">
                <iframe  src = "/zyblog/admin/right.jsp"  width="100%" height="420"  scrolling = "no" frameborder = "0"></iframe>
            </div>
        </div>
    </div>
</main>

<iframe  src = "/zyblog/admin/bottom.jsp"  width="100%" height="10%" scrolling = "no" frameborder = "0"></iframe>


</body>
<script src="../zyblog/static/libs/jquery/jquery.js"></script>
<script src="../zyblog/static/libs/bootstrap/js/bootstrap.js"></script>

</html>