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
	<c:url var="loginUrl" value="/login" />
	<div id="login-container">
		<div id="login-logo">
		
		
		</div>
		<div id="login-form">
		
		</div>
		
		<!-- 登陆验证信息 -->
			<c:if test="${param.error != null}">
				<div class="msg">
					Failed to login.
					<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
              			Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION. 
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