<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/views/includes/taglibs.jspf"%>
<!DOCTYPE HTML>
<html lang="zh_CN">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>管理员登录</title>
<%@ include file="/WEB-INF/views/includes/admin_head_scripts_links.jspf"%>
</head>
<body class="login">
	<c:url var="loginUrl" value="/admin/login" />
	<div id="login-container">
		<div id="login-logo">
			<a><img alt="logo"
				src="<c:url value="/resources-admin/images/admin_logo.png"/>" /> </a>

		</div>
		<div id="login-form">
			<h5 class="page-header-sub">管理员登录</h5>
			<form:form action="${loginUrl}" method="POST" class="form-horizontal"
				role="form" id="admin-login-form">
				<div class="form-group">
					<label for="admin-username-input" class="col-sm-4 control-label"><span
						class="glyphicon glyphicon-user"></span>用户名：</label>
					<div class="col-sm-8">
						<input type="text" name="username" class="form-control" id="admin-username-input" />
					</div>
				</div>
				<div class="form-group">
					<label for="admin-password-input" class="col-sm-4 control-label"><span
						class="glyphicon glyphicon-lock"></span>密码：</label>
					<div class="col-sm-8">
						<input type="password" name="password" class="form-control"
							id="admin-password-input" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">登录</button>
						<button type="reset" class="btn btn-default">重置</button>
					</div>
				</div>
			</form:form>
		</div>

		<!-- 登陆验证信息 -->
		<c:if test="${param.error != null}">
			<div class="msg">
				Failed to login.
				<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
              			Reason: <c:out
						value="${SPRING_SECURITY_LAST_EXCEPTION. 
              			message}" />
				</c:if>
			</div>
		</c:if>
		<c:if test="${param.logout != null}">
			<div class="msg">You have been logged out.</div>
		</c:if>
	</div>
</body>
<%@ include file="/WEB-INF/views/includes/admin_foot_scripts_links.jspf"%>
</html>