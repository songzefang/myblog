<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
    <title></title>
    <link rel="stylesheet" href="/zyblog/static/libs/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="/zyblog/static/libs/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="/zyblog/static/css/main.css">
</head>
<body>
				<div class="panel">
                    <a onclick="xbk()" type="button" class="btn btn-success btn-block btn-lg">写博客</a>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            统计
                        </h3>
                    </div>
                    <div class="list-group">
                        <a href="admin/index.jsp" class="list-group-item">文章数(${BlogListCount})</a>
                        <a  class="list-group-item">阅读量(${Sum})</a>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            管理
                        </h3>
                    </div>
                    <div class="list-group">
                        <a onclick="bkgl()" class="list-group-item">博客管理</a>
                        <a onclick="flgl()" class="list-group-item">分类管理</a>
                        <a onclick="xgzl()" class="list-group-item">修改资料</a>
                        <a onclick="zdsz()" class="list-group-item">站点设置</a>
                    </div>
                </div>
</body>

<script type="text/javascript">
function xbk(){
	parent.location.href="/zyblog/GetFlmcServlet";
}

function bkgl() {
	parent.location.href="index.jsp";
	
}

function flgl() {
	parent.location.href="/zyblog/OpenCategoryServlet";
}

function xgzl() {
	parent.location.href="profile.jsp";
}

function zdsz() {
	parent.location.href="/zyblog/SetingList";
}


</script>
</html>