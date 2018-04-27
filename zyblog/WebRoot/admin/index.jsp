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
    <link rel="stylesheet" href="/zyblog/static/libs/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="/zyblog/static/libs/font-awesome/css/font-awesome.css">
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
                <h1>博客管理</h1>
                <div class="table-responsive">
                    <table id="tabblog" class="table table-bordered table-hover">
                        
                    </table>
                </div>        
            </div>
            <div class="col-md-4">
                <iframe  src = "/zyblog/admin/right.jsp"  width="100%" height="420"  scrolling = "no" frameborder = "0"></iframe>
                
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            主题分类
                        </h3>
                    </div>	
                    <div class="list-group">
                    <c:forEach var="bkfl" items="${BkflList}" varStatus="status">
                    	<a onclick="selectFlmc('${bkfl.flmc}')" class="list-group-item">${bkfl.flmc }(${bkfl.bwsl })</a>
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
<script src="../static/libs/jquery/jquery.js"></script>
<script src="../static/libs/bootstrap/js/bootstrap.js"></script>
<script src="../static/libs/bootstrap/js/bootstrap-table.min.js"></script>
<script src="../static/libs/bootstrap/js/bootstrap-table-zh-CN.min.js"></script>


<script type="text/javascript">
	$('#tabblog').bootstrapTable({ 
		 //请求方法 x
		method: 'get', 
		 //是否显示行间隔色 
		striped: true, 
		//是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）  
		cache: false,  
		//是否显示分页（*）  
		pagination: true,  
		 //是否启用排序  
		sortable: true,  
		 //排序方式  
		sortOrder: "asc",  
		//初始化加载第一页，默认第一页 
		//我设置了这一项，但是貌似没起作用，而且我这默认是0,- - 
		//pageNumber:1,  
		//每页的记录行数（*）  
		pageSize: 10,  
		//可供选择的每页的行数（*）  
		pageList: [10, 25, 50, 100], 
		//这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据  
		url: "BlogList", 
		//默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else 
		//queryParamsType:'',  
		////查询参数,每次调用是会带上这个参数，可自定义   
		
		//分页方式：client客户端分页，server服务端分页（*） 
		sidePagination: "server", 
		//是否显示搜索 
		search: false,  
		//Enable the strict search.  
		strictSearch: true, 
		//Indicate which field is an identity field. 
		idField : "id", 
		columns: [{ 
		 field: 'id',
		 title: 'id', 
		 align: 'center'
		}, { 
		 field: 'bt', 
		 title: '标题', 
		 align: 'center'
		}, { 
		 field: 'fl', 
		 title: '分类', 
		 align: 'center'
		},{ 
		 field: 'id', 
		 title: '操作', 
		 align: 'center', 
         formatter: operateFormatter
		}], 
		pagination:true,
		queryParams: queryParams
		
		});
	
	function queryParams(params) {
	    var temp = {
	         limit: params.limit,
	         offset: params.offset,
	         flmc:$("#flmc").val()
	    };
	    return temp;
	 } 

	function selectFlmc(flmc) {
	      $('#flmc').val(flmc);
	      //window.praent.refresh()
	      $('#tabblog',parent.document).bootstrapTable("refresh")
	}
	

	 function operateFormatter(value, row, index) {
	      return [
	    	 '<span id="blogzd" onclick="blogsc('+value+')" class="fa fa-remove"></span> &nbsp;&nbsp; <span  id="blogsc" onclick="blogzd('+value+')" class="fa fa-arrow-circle-o-up"></span>'
	      ].join('');
	      }
	
		 function blogsc(id,row){
			 window.location.href="/zyblog/DeleteBlogServlet?id="+id
			}
	 
		function blogzd(id){
			window.location.href="/zyblog/BlogZdServlet?id="+id
		}

	</script>
</html>
