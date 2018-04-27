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
</nav>
<main>
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <c:forEach var="blog" items="${BlogList}" varStatus="status" begin="${(Page-1)*5 }"
							end="${Page*5-1}">
                <ul class="list-group">
                    <!--列表单元开始-->
                    <li class="list-group-item">
                        <div class="media" style="height: 150px">
                            <a class="pull-right hidden-xs" href="#">
                                <img id="touxiang" src="${blog.fm }"  alt="" style="width: 300px;height: 150px">
                            </a>
                            <div class="media-body">
                                <a  style="color:#333" onclick="showBkwz('${blog.bt}')">
                                    <h4 class="media-heading">
                                        ${blog.bt }
                                    </h4>
                                </a>
                                <p class="c-888">
                                    发布于：${blog.cjsj }&nbsp;&nbsp;
                                    阅读量：${blog.djl} &nbsp;&nbsp;
                                    分类：${blog.fl}
                                </p>
                                ${blog.zw}
                            </div>
                        </div>
                    </li>
                    <!--列表单元结束-->
                </ul>
                
                </c:forEach>
					<ul class="pagination">
						<c:if test="${Page>1}">
							<li>
								<a href="PageSetServlet?page=1">首页</a>
							</li>
							<li>
								<a href="PageSetServlet?page=${Page-1 }">上一页</a>
							</li>
						</c:if>
						<c:if test="${Page <MaxPage }">
							<li class="active">
								<a href="PageSetServlet?page=${Page+1 }">下一页</a>
							</li>
							<li>
								<a href="PageSetServlet?page=${MaxPage }">末页</a>
							</li>
						</c:if>
						<br>
						<br>
						<form action="PageSetServlet" method="post"">
							共&nbsp;${MaxPage}&nbsp;页
							<input type="text" value="${Page}" name="page" size="1">
							页
							<input type="submit" value="跳转">
						</form>
					</ul>
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

<iframe  src = "/zyblog/admin/bottom.jsp"  width="100%" height="10%" scrolling = "no" frameborder = "0"></iframe>

</body>
<script src="static/libs/jquery/jquery.js"></script>
<script src="static/libs/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
	function update(flmc) {
		window.parent.location="BlogListQt?flmc="+flmc;
	}

</script>

<script type="text/javascript">
 function select() {
 		  var select=$("#select").val();
	      parent.location.href='SelectBlogServlet?select='+select
	}
 
 function showBkwz(bt) {
     parent.location.href='BkwzServlet?bt='+bt
}

</script>

</html>