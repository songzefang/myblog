<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0">
<title>博客登录</title>
<link rel="stylesheet" href="../static/libs/bootstrap/css/bootstrap.css">
<link rel="stylesheet"
	href="../static/libs/font-awesome/css/font-awesome.css">
<link rel="stylesheet" href="../static/css/main.css">
</head>

<body>

	<main>
	<div class="container">
		<div class="row signin">
			<form action="/zyblog/Login" method="post">
				<div class="logo">
					<img src="../static/images/logo.png">
				</div>
				<input type="text" class="form-control" name="name" ng-model="name"
					placeholder="姓名" autofocus=""> <input type="password"
					class="form-control" name="password" ng-model="password"
					placeholder="密码">
				<button class="btn btn-lg btn-success btn-block" type="submit"
					ng-click="signin()">登录</button>
			</form>
		</div>
	</div>
	</main>
</body>
<script src="../static/libs/jquery/jquery.js"></script>
<script src="../static/libs/bootstrap/js/bootstrap.js"></script>

</html>