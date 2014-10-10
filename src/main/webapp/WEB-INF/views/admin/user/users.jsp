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
			<div class="well">
				<form action="<c:url value="/admin/users" />" method="get"
					class="form-inline product-search-form" role="form">
					<div class="form-group">
						<label class="control-label" for="userType">用户类型：</label> <select
							class="form-control" name="userType" id="userType">
							<c:forEach items="${types}" var="type">
								<option value="<c:out value="${type.id}"></c:out>"
									<c:if test="${type.id == userType}"> selected</c:if>><c:out
										value="${type.name}"></c:out></option>
							</c:forEach>
						</select> 
					</div>
					<div class="form-group">
						<label class="control-label" for="productName">用户名称：</label> <input
							type="text" class="form-control" id="productName"
							name="productName" placeholder="输入用户"
							value="<c:out value="${productName}"></c:out>">
					</div>
					<button type="submit" class="btn btn-success">
						<i class="icon-search"></i>查询
					</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>