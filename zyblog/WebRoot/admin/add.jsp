<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
    <title>${grzl.nc }的博客</title>
    <link rel="stylesheet" href="/zyblog/static/libs/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="/zyblog/static/libs/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="/zyblog/static/libs/simditor/styles/simditor.css">
    <link rel="stylesheet" href="/zyblog/static/css/main.css">
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
                <h1>发表博客</h1>
                <form class="form-horizontal" role="form" action="AddBlogServlet">
                    <div class="form-group">
                        <label for="tags" class="col-sm-2 control-label">分类：</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="fl" id="fl">
                           	 	<c:forEach var ="fl" items = "${list}" >
                            		<option>${fl.flmc}</option>
                            	</c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="title" class="col-sm-2 control-label">标题：</label>
                        <div class="col-sm-6">
                            <!--标题长度请不要超过30个字-->
                            <input type="text" class="form-control" name="bt" id="bt" placeholder="请输入标题">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cover" class="col-sm-2 control-label">上传封面：</label>
                        <div class="col-sm-2" id="cover">
                            <button class="btn btn-default btn-block" type="button" onclick="openBrowse()">上传图片</button>
                            <input type="file" name="cover" class="hidden" id="cover" onchange="ooo()">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="post" class="col-sm-2 control-label">正文：</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" name="zw" rows="6" id="zw"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-4">
                            <button type="submit" class="btn btn-success btn-block">发表博客</button>
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
<script src="/zyblog/static/libs/jquery/jquery.js"></script>
<script src="/zyblog/static/libs/bootstrap/js/bootstrap.js"></script>
<script src="/zyblog/static/libs/simditor/scripts/module.min.js"></script>
<script src="/zyblog/static/libs/simditor/scripts/hotkeys.min.js"></script>
<script src="/zyblog/static/libs/simditor/scripts/simditor.min.js"></script>
<script>
    $(function(){
        // 上传文件按钮触发
        $('#cover').find('button').click(function () {
            $('#cover').find('input[type=file]').click();
        });

        // 创建编辑器
        new Simditor({
            // 必选项，选定元素
            textarea: $('#post'),
            // 设定工具栏功能
            toolbar: ['title', 'bold', 'italic', 'underline', 'strikethrough', 'fontScale', 'color',
                '|', 'ol', 'ul', 'blockquote', 'code', 'table',
                '|', 'link', 'image', 'hr',
                '|', 'indent', 'outdent', 'alignment']
        })
    })
</script>
<script type="text/javascript">
function openBrowse() {
	$('#cover').click();
}


function ooo(){
	var formData = new FormData($( "#uptx" )[0]);   
	$.ajax({
		url:"/zyblog/UpCover",
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