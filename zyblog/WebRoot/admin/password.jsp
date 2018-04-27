<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
    <title>${grzl.nc }的博客</title>
    <link rel="stylesheet" href="../static/libs/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="../static/libs/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="../static/css/main.css">
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
            <a class="navbar-brand" href="index.jsp">${grzl.nc }的博客</a>
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
                <h1>修改密码</h1>
                <form class="form-horizontal" role="form" action="/zyblog/UpdatePassword">
                    <div class="form-group">
                        <label for="old-password" class="col-sm-2 control-label">原密码：</label>
                        <div class="col-sm-4">
                            <input type="password" class="form-control" name="ymm" id="ymm" value="" placeholder="请输入原密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="new-password" class="col-sm-2 control-label">新密码：</label>
                        <div class="col-sm-4">
                            <input type="password" class="form-control" name="xmm" id="xmm" value="" placeholder="请输入新密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="confirm-password" class="col-sm-2 control-label">新密码：</label>
                        <div class="col-sm-4">
                            <input type="password" class="form-control" name="qrmm" id="qrmm" value="" placeholder="请再次输入新密码">
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
<script src="../static/libs/jquery/jquery.js"></script>
<script src="../static/libs/bootstrap/js/bootstrap.js"></script>

</html>