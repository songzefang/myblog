<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <h1>个人资料</h1>
                <form id="uptx" class="form-horizontal" method="post" enctype="multipart/form-data" role="form">
                 	<div class="form-group">
                        <label class="col-sm-2 col-xs-4 control-label">
                            <img id="touxiang" src="${grzl.tx }" class="img-circle" alt="" style="width: 100px;height: 100px">
                        </label>
                        <div class="col-sm-2 col-xs-8" id="change-avatar">
                            <button class="btn btn-default btn-block" type="button" onclick="openBrowse()">更换头像</button>
                            <input type="file" id="avatar"  name="avatar" onchange="ooo()" class="hidden" >
                        </div>
                    </div>
                </form>
                
                
                <form class="form-horizontal" role="form" action="/zyblog/UpdateGrzlServlet" method="get">
                    <div class="form-group">
                        <label for="userName" class="col-sm-2 control-label">昵称：</label>
                        <div class="col-sm-4">
                        	<input id="tx2" type="text" value="${grzl.tx }" class="hidden" >
                            <input type="text" class="form-control" name="nc" id="nc" value="${grzl.nc }">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="introduce" class="col-sm-2 control-label">介绍：</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" name="js" rows="3" id="js">${grzl.js }</textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="motto" class="col-sm-2 control-label">座右铭：</label>
                        <div class="col-sm-7">
                            <input type="text" name="zym" class="form-control" id="zym" value=${grzl.zym }>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">邮件：</label>
                        <div class="col-sm-5">
                            <input type="text" name="yj" class="form-control" id="yj" value=${grzl.yj }>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="weibo" class="col-sm-2 control-label">微博：</label>
                        <div class="col-sm-5">
                            <input type="text" name="wb" class="form-control" id="wb" value=${grzl.wb }>
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
<script type="text/javascript">
function openBrowse() {
	$('#avatar').click();
}


function ooo(){
	var formData = new FormData($( "#uptx" )[0]);   
	$.ajax({
		url:"/zyblog/Uptx",
		type:"POST",
		data:formData,
		async: false,    
     	cache: false,    
      	contentType: false,    
      	processData: false, 
		success:
		function(data){
			 $("#touxiang").attr('src',data);
			 $("#tx2").attr('value',data);
		},
		error:
		function(data){
		
		}
	
	})


}


</script>

</html>