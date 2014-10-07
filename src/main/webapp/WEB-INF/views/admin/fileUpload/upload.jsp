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
<c:url value="/admin/fileUpload/singleUpload" var="url"/>
	<form:form action="${url}?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
		上传文件:
		<input type="file" name="file"><br>
		<input type="submit" value="上传">
	 </form:form>
</body>


<c:url value="/admin/fileUpload/batchUpload" var="url"/>
	<form:form action="${url}?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
		文件1:
		<input type = "file" name="file"><br>
		文件2:
		<input type = "file" name="file"><br/>
		<input type="submit" value="上传">
	 </form:form>
</body>
</html>