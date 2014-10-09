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
				<li class="active"><a href="#">商品管理</a></li>
			</ul>
			<h3 class="page-header page-header-top">商品列表</h3>
			<div class="well">
				<form action="/" method="get" class="form-inline product-search-form" role="form">
					<div class="form-group">
						<label class="control-label" for="productType">商品类型：</label> <select
							class="form-control" name="productType" id="productType">
							<option>--所有商品--</option>
							<option>积木</option>
							<option>模型</option>
							<option>益智</option>
						</select>
						<a class="product-type-edit" data-toggle="tooltip" data-original-title="管理类型"><i class="icon-edit"></i></a>
					</div>
					<div class="form-group">
						<label class="control-label" for="productName">商品名称：</label>
						<input type="text" class="form-control"
							id="productName" name="productName" placeholder="输入商品名称">
					</div>
					<div class="form-group">
					    <label class="control-label">选择时间：</label>
					    <div id="advanced-daterangepicker" class="btn btn-default">
			                         <i class="icon-calendar"></i>
			                         <span class="daterange"><span class="start-date-span">${startDate}</span> 至 <span class="end-date-span">${endDate}</span></span>
			                         <b class="caret"></b>
			                         <input id="startDate" type="hidden" name="startDate" value="${startDate}" />
			                         <input id="endDate" type="hidden" name="endDate" value="${endDate}">
			            </div>
					</div>
					<button type="submit" class="btn btn-success"><i class="icon-search"></i>查询</button>
				</form>
				<a class="btn btn-default add-product-btn" href="<c:url value="/admin/product?add" />"><i class="icon-plus"></i>添加商品</a>
			</div>
			<table class="table product-list-table">
				<thead>
					<tr>
						<th>#</th>
						<th><i class="icon-camera-retro"></i>缩略图</th>
						<th><i class="icon-book"></i>商品名称</th>
						<th><i class="icon-tag"></i>商品类型</th>
						<th><i class="icon-time"></i>添加时间</th>
						<th><i class="icon-bolt"></i>操作</th>
					</tr>
				</thead>
				<tbody>
				    <%int i = 1;%>
					<c:forEach items="${products}" var="product">
					  <tr>
						<td><%=i%></td>
						<td><a class="thumbnail"><img src="<c:out value="${product.thumbnail}" />" width="60" height="60"></a></td>
						<td><c:out value="${product.name}" /></td>
						<td><c:out value="${product.productClassification.name}" /></td>
						<td>
						<fmt:formatDate value="${product.creattime}" type="date" pattern="yyyy/MM/dd HH:mm:ss"/></td>
						<td>
							<div class="btn-group">
								<a class="btn btn-xs btn-info" data-toggle="tooltip"
									data-original-title="查看" href="<c:url value="/admin/product/${product.id}"/>"><i class="icon-info-sign"></i></a>
								<a class="btn btn-xs btn-success" data-toggle="tooltip"
									data-original-title="编辑" href="<c:url value="/admin/product/${product.id}"/>"><i class="icon-pencil"></i></a>
								<a class="btn btn-xs btn-danger" data-toggle="tooltip"
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

	<!-- 引用页面底部模板 -->
	<%@ include file="/WEB-INF/views/includes/admin_footer.jspf"%>
</body>
<%@ include file="/WEB-INF/views/includes/admin_foot_scripts_links.jspf"%>
<script type="text/javascript">
	
</script>
</html>