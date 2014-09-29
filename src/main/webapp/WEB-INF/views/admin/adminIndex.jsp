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
				<li><a href="#"><i class="icon-dashboard"></i></a></li>
				<li class="active"><a href="#">仪表盘</a></li>
			</ul>
			<ul class="nav-dash">
			    <li><a href="#" data-toggle="tooltip" class="animation-fadeIn" data-original-title="最新用户"><i class="icon-user"></i><span class="badge badge-default">3</span></a></li>
			    <li><a href="#" data-toggle="tooltip" class="animation-fadeIn" data-original-title="最新订单"><i class="icon-tasks"></i><span class="badge badge-success">4</span></a></li>
			    <li><a href="#" data-toggle="tooltip" class="animation-fadeIn" data-original-title="商品上架"><i class="icon-fire"></i></a></li>
			    <li><a href="#" data-toggle="tooltip" class="animation-fadeIn" data-original-title="最新评论"><i class="icon-comments-alt"></i><span class="badge badge-warning">6</span></a></li>
			    <li><a href="#" data-toggle="tooltip" class="animation-fadeIn" data-original-title="服务信息"><i class="icon-coffee"></i><span class="badge badge-danger">2</span></a></li>
			    <li><a href="#" data-toggle="tooltip" class="animation-fadeIn" data-original-title="文件上传"><i class="icon-cloud-upload"></i></a></li>
			</ul>




		</div>
	</div>

	<!-- 引用页面底部模板 -->
	<%@ include file="/WEB-INF/views/includes/admin_footer.jspf"%>
</body>
<%@ include file="/WEB-INF/views/includes/admin_foot_scripts_links.jspf"%>
</html>