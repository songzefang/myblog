<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
    <title>${grzl.nc}的博客</title>
    <link rel="stylesheet" href="static/libs/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="static/libs/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="static/css/main.css">
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
            <a class="navbar-brand" href="/zyblog/IndexInfo">${grzl.nc }的博客</a>
        </div>

        <div class="collapse navbar-collapse" id="global-nav">
            <ul class="nav navbar-nav">
                <li>
                    <a>${grzl.zym }</a>
                </li>
            </ul>
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="搜索博客" id = "select" name="select">
                        <span class="input-group-btn">
                            <a onclick="select()" class="btn btn-default glyphicon glyphicon-search" type="button"></a>
                        </span>
                    </div>
                </div>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="admin/signin.jsp">登录</a></li>
            </ul>
        </div>
    </div>
</nav><main>
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="article">
                    <h1>${blog.bt}</h1>
                    <p class="c-888">
                        发布于 ${blog.cjsj} &nbsp;&nbsp;
                        阅读量 ${blog.djl}
                    </p>
                    <div class="text">
                        <p>写在前面：</p>
                        <p>${blog.zw}</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            个人简介
                        </h3>
                    </div>
                    <div class="panel-body">
                        <div class="media">
                            <a class="pull-left" href="#">
                                <img id="touxiang" src="${grzl.tx }" class="img-circle" alt="" style="width: 100px;height: 100px">
                            </a>
                            <div class="media-body">
                                <h4 class="media-heading">${grzl.nc }</h4>
                                ${grzl.js }
                            </div>
                        </div>
                    </div>
                    <div class="list-group">
                        <a href="#" class="list-group-item"><span class="fa fa-weibo">&#x3000;微博：</span>${grzl.wb }</a>
                        <a href="#" class="list-group-item"><span class="fa fa-envelope-o">&#x3000;邮箱：</span>${grzl.yj }</a>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            主题分类
                        </h3>
                    </div>	
                    <div class="list-group">
                    <c:forEach var="bkfl" items="${BkflList}" varStatus="status">
                    	<a onclick="update('${bkfl.flmc}')" class="list-group-item">${bkfl.flmc }(${bkfl.bwsl })</a>
                    </c:forEach>
                        <input class="hidden" id="flmc" name="flmc">
                    </div>
                </div>
                
            </div>
        </div>
    </div>
</main>

<div class="text-center page-footer">
    <p class="visible-xs-block visible-sm-block visible-md-inline visible-lg-inline">智游教育 &copy;zhiyou100.com</p>
    <p class="visible-md-inline visible-lg-inline">&nbsp;&nbsp;</p>
    <p class="visible-xs-block visible-sm-block visible-md-inline visible-lg-inline">河南智游臻龙教育科技有限公司</p>
</div>

</body>
<script src="static/libs/jquery/jquery.js"></script>
<script src="static/libs/bootstrap/js/bootstrap.js"></script>
</html>