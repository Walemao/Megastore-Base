<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/views/includes/taglibs.jspf"%>
<!DOCTYPE HTML>
<html lang="zh_CN">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>商城管理系统</title>
<%@ include file="/WEB-INF/views/includes/admin_head_scripts_links.jspf"%>
</head>
<body>
	<!-- 引用页面header模板 -->
	<%@ include file="/WEB-INF/views/includes/admin_header.jspf"%>

	<div id="container">
		<!-- 引用页面侧边栏模板 -->
		<%@ include file="/WEB-INF/views/includes/admin_aside.jspf"%>
		<div id="content">
			<ul id="nav-info" class="clearfix">
				<li><a href="#"><i class="icon-gift"></i></a></li>
				<li class="active"><a href="#">用户管理</a></li>
			</ul>
			
			<h3 class="page-header page-header-top">用户列表</h3>
			<div class="well clearfix">
				<form action="<c:url value="/admin/user" />" method="get"
					class="form-inline product-search-form" role="form">
					<div class="form-group">
						<label class="control-label" for="userName">用户名称：</label> <input
							type="text" class="form-control" id="userName"
							name="userName" placeholder="输入用户"
							value="<c:out value="${userName}"></c:out>">
					</div>
					<button type="submit" class="btn btn-success">
						<i class="icon-search"></i>查询
					</button>
				</form>
			</div>
			
			
			<table class="table product-list-table">
				<thead>
					<tr>
						<th>#</th>
						<th><i class="icon-camera-retro"></i>头像</th>
						<th><i class="icon-book"></i>用户名</th>
						<th><i class="icon-time"></i>注册时间</th>
						<th><i class="icon-bolt"></i>操作</th>
					</tr>
				</thead>
				<tbody>
				    <%int i = 1;%>
					<c:forEach items="${users}" var="user">
					  <tr>
						<td class="product-list"><%=i%></td>
						<td><a class="thumbnail"><img src="<c:out value="${user.head_portrait}" />" width="60" height="60"></a></td>
						<td class="product-list"><c:out value="${user.userName}" /></td>
						<td class="product-list">
						<fmt:formatDate value="${user.createTime}" type="date" pattern="yyyy/MM/dd HH:mm:ss"/></td>
						<td class="product-list">
							<div class="btn-group">
								<a class="btn btn-xs btn-info" data-toggle="tooltip"
									data-original-title="查看" href="<c:url value="/admin/user/${user.id}"/>"><i class="icon-info-sign"></i></a>
								<a class="btn btn-xs btn-success" data-toggle="tooltip"
									data-original-title="编辑" href="<c:url value="/admin/user/${user.id}"/>"><i class="icon-pencil"></i></a>
								<a class="btn btn-xs btn-danger delete-product-trigger" data-id="<c:out value="${user.userName}"/>" data-toggle="tooltip"
									data-original-title="删除"><i class="icon-trash"></i></a>
							</div>
						</td>
					</tr>
					<%i++;%>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="6">
							<ul class="pagination" style="float: right;">
								<li><a href="#"><i class="icon-chevron-left"></i></a></li>
								<li class="active"><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#"><i class="icon-chevron-right"></i></a></li>
							</ul>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/includes/admin_footer.jspf"%>
</body>
<%@ include file="/WEB-INF/views/includes/admin_foot_scripts_links.jspf"%>
<script type="text/javascript">
	$('.delete-product-trigger').click(function(){
		if(window.confirm('你确定要删除吗？')){
		   var userName = $(this).attr('data-id');
		   $.post('<c:url value="/admin/user?${_csrf.parameterName}=${_csrf.token}"/>', {_method : 'DELETE', username : userName}, function(data){
			  if(data.status == 'success'){
				  window.location.reload();
			  }else{
				  alert('删除失败！');
			  }
		   });
		}
	});
</script>
</html>