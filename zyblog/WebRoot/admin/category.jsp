<%@ page language="java" import= "java.util.*" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0">
<title>${grzl.nc }的博客</title>
<link rel="stylesheet" href="../zyblog/static/libs/bootstrap/css/bootstrap.css">
<link rel="stylesheet"
	href="../zyblog/static/libs/font-awesome/css/font-awesome.css">
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
				<h1>
					分类管理
					<button type="button" class="btn btn-default pull-right"
						data-toggle="modal" data-target="#add">添加类别</button>
				</h1>
				<div class="table-responsive">
					<table class="table table-bordered table-hover">
						<tr>
							<th class="text-center">分类名称</th>
							<th class="text-center">分类描述</th>
							<th class="text-center">操作</th>
						</tr>
						<c:forEach var="bkfl" items="${info}" varStatus="status">
							<tr>
								<td style="display: none"> <input type="hidden" id="deleteid" value=${bkfl.id }></td>
								<td style="display: none"><input type="hidden"
									id="deleteid" value=${bkfl.px }></td>
								<td class="text-center">${bkfl.flmc }</td>
								<td class="text-center">${bkfl.flms }</td>
								<td class="text-center">
									<span class="fa fa-arrow-down"	onclick="updatedown(this)"></span>&nbsp;&nbsp;&nbsp;
									<span class="fa fa-arrow-up" onclick="updateup(this)"></span>&nbsp;&nbsp;&nbsp;
									<span class="fa fa-remove" date-toggle="dodal" onclick = "Delete(this)"></span>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<div class="col-md-4">
				<iframe  src = "/zyblog/admin/right.jsp"  width="100%" height="420"  scrolling = "no" frameborder = "0"></iframe>
			</div>
		</div>
	</div>
	</main>

	<!-- 添加模态框（Modal） -->
	<div class="modal fade" id="add" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">添加分类</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" action="/zyblog/CategoryServlet"
						role="form" id="add-form">
						<div class="form-group">
							<label for="family" class="col-sm-2 control-label">分类名称</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="flmc" id="family"
									placeholder="请输入分类名称">
							</div>
						</div>
						<div class="form-group">
							<label for="family" class="col-sm-2 control-label">分类描述</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" name="flms" id="family"
									placeholder="请输入分类描述">
							</div>
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
							<button type="submit" class="btn btn-success"">确定</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 删除模态框（Modal） -->
	<div class="modal fade" id="remove" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">类别删除确认</h4>
				</div>
				<div class="modal-body">确认删除这个类别吗？</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-success" data-dismiss="modal">确定</button>
				</div>
			</div>
		</div>
	</div>

	<iframe  src = "/zyblog/admin/bottom.jsp"  width="100%" height="10%" scrolling = "no" frameborder = "0"></iframe>


</body>
<script src="../zyblog/static/libs/jquery/jquery.js"></script>
<script src="../zyblog/static/libs/bootstrap/js/bootstrap.js"></script>

<script type="text/javascript">
	function showDeleteModel(bkfl){
		var $tds=$(bkfl).parent().parent().children();//获取到所有列
		var bkfl_id=$($tds[0]).children("input").val();
		$("#deleteId").val(bkfl_id);//将模态框中需要删除的ID设置为需要删除的ID
		$("#remove").modal({
			backdrop:'static',
			keyboard:false
		});
	}
	
	function Delete(bkfl){
		var $tds=$(bkfl).parent().parent().children();//获取到所有列
		var bkfl_id=$($tds[0]).children("input").val();
		alert(bkfl_id);
		window.location.href='/zyblog/RemoveBkflServlet?bkflId='+bkfl_id;
	}

	function updateup(bkfl){
		//获取自己的id和px
		var $tds=$(bkfl).parent().parent().children();//获取所有列
		var myid=$($tds[0]).children("input").val();//获取隐藏id
		var mypx=$($tds[1]).children("input").val();//获取隐藏的px
		
		//获取上一个的id和排序
		var $tds=$(bkfl).parent().parent().prev().children();//获取tr上一个兄弟节点下的td所有列
		var upid=$($tds[0]).children("input").val();//获取隐藏id
		var uppx=$($tds[1]).children("input").val();//获取隐藏的px
		
		window.location.href='/zyblog/UpdateUpServlet?myid='+myid+'&mypx='+mypx+'&upid='+upid+'&uppx='+uppx
	}
	
	function updatedown(bkfl){
		//获取自己的id和px
		var $tds=$(bkfl).parent().parent().children();//获取所有列
		var myid=$($tds[0]).children("input").val();//获取隐藏id
		var mypx=$($tds[1]).children("input").val();//获取隐藏的px
		
		//获取下一个的id和排序
		var $tds=$(bkfl).parent().parent().next().children();//获取tr下一个兄弟节点下的td所有列
		var downid=$($tds[0]).children("input").val();//获取隐藏id
		var downpx=$($tds[1]).children("input").val();//获取隐藏的px
		
		window.location.href='/zyblog/UpdateDownServlet?myid='+myid+'&mypx='+mypx+'&downid='+downid+'&downpx='+downpx
	}
	
	
	
	
</script>


</html>