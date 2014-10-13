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
				<form action="<c:url value="/admin/users" />" method="get"
					class="form-inline content-search-form" role="form">
					<div class="form-group">
						<label class="control-label" for="username">用户名称：</label> <input
							type="text" class="form-control" id="username" name="username"
							placeholder="输入用户" value="<c:out value="${username}"></c:out>">
					</div>
					
					<div class="form-group">
						<label class="control-label" for="enabled">用户状态：</label>
						 <select class="form-control" name="enabled" id="userStatus">
							<option value="1">启用中</option>
							<option value="0">已禁用</option>
							<option value="2">所有用户</option>
						</select>
					</div>
					
					<button type="submit" class="btn btn-success">
						<i class="icon-search"></i>查询
					</button>
				</form>
			</div>


			<table class="table content-list-table">
				<thead>
					<tr>
						<th>#</th>
						<th><i class="icon-camera-retro"></i>头像</th>
						<th><i class="icon-user"></i>用户名</th>
						<th><i class="icon-flag"></i>用户状态</th>
						<th><i class="icon-time"></i>注册时间</th>
						<th><i class="icon-bolt"></i>操作</th>
					</tr>
				</thead>
				<tbody>
					<%
						int i = 1;
					%>
					<c:forEach items="${curretPage.pageItems}" var="user">
						<tr>
							<td class="content-list"><%=i%></td>
							<td><a class="thumbnail"><img
									src="<c:out value="${user.head_portrait}" />" width="60"
									height="60"></a></td>
							<td class="content-list"><c:out value="${user.username}" /></td>
							<td class="content-list">
							   <c:if test="${user.enabled==true}">
							      启用中
							   </c:if>
							   <c:if test="${user.enabled==false}">
							      已禁用
							   </c:if>
							</td>
							
							<td class="content-list"><fmt:formatDate
									value="${user.createTime}" type="date"
									pattern="yyyy/MM/dd HH:mm:ss" /></td>
							<td class="content-list">
								<div class="btn-group">
									<a class="btn btn-xs btn-info" data-toggle="tooltip"
										data-original-title="查看"
										href="<c:url value="/admin/user/${user.id}"/>"><i
										class="icon-info-sign"></i></a>
								    <c:if test="${user.enabled==true}">
									<a class="btn btn-xs btn-danger control-user-status"
										data-id="<c:out value="${user.username}"/>" data-status="0"
										data-toggle="tooltip" data-original-title="禁用"><i
										class="icon-remove-sign"></i></a>
									</c:if>
									<c:if test="${user.enabled==false}">
									<a class="btn btn-xs btn-success control-user-status"
										data-id="<c:out value="${user.username}"/>" data-status="1"
										data-toggle="tooltip" data-original-title="启用"><i
										class="icon-ok-sign"></i></a>
									</c:if>
								</div>
							</td>
						</tr>
						<%
							i++;
						%>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="6">
							<!-- 分页显示 -->
							<ul class="pagination" style="float: right;">
								<li
									<c:if test="${curretPage.pageNo == 1}">class="disabled"</c:if>><a
									href="<c:url value="/admin/users?pageNo=${curretPage.pageNo - 1}&pageSize=${curretPage.pageSize}"/> "><i
										class="icon-chevron-left"></i></a></li>
								<c:forEach begin="1" end="${curretPage.pageAvailable}" var="i">
									<li
										<c:if test="${curretPage.pageNo == i}">class="active"</c:if>><a
										href="<c:url value="/admin/users?pageNo=${i}&pageSize=${curretPage.pageSize}"/>"><c:out
												value="${i}" /></a></li>
								</c:forEach>
								<li
									<c:if test="${curretPage.pageNo == curretPage.pageAvailable}">class="disabled"</c:if>><a
									href="<c:url value="/admin/users?pageNo=${curretPage.pageNo + 1}&pageSize=${curretPage.pageSize}" />"><i
										class="icon-chevron-right"></i></a></li>
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
   var select_status = '<c:out value="${enabled}"/>';
   $('#userStatus').val(select_status);
   
   /** 禁用和启用用户 **/
   $('.control-user-status').click(function() {
						var status = $(this).attr('data-status');
						var text = (status = 0)? '启用' : '禁用';
						if (window.confirm('你确定要' + text + '吗？')) {
							var username = $(this).attr('data-id');
							$.post('<c:url value="/admin/user?${_csrf.parameterName}=${_csrf.token}"/>',
											{
												_method : 'DELETE',
												username : username,
												enabled : status
											}, function(data) {
												if (data.status == 'success') {
													window.location.reload();
												} else {
													alert( text + '失败！');
												}
											});
						}
					});
</script>
</html>