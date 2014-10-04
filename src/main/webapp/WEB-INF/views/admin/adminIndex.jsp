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
			
			<div class="dash-tiles row">
			    <div class="col-sm-3">
			        <div class="dash-tile dash-tile-ocean clearfix animation-pullDown">
			             <div class="dash-tile-header">
			                 <div class="dash-tile-options">
			                     <a class="btn btn-default" data-toggle="tooltip" data-original-title="查看详情" href="#">
			                         <i class="icon-th-list"></i>
			                     </a>
			                 </div>
			                           用户总计
			             </div>
			             <div class="dash-tile-icon"><i class="icon-group"></i></div>
			             <div class="dash-tile-text">265K</div>
			        </div>        
			        <div class="dash-tile dash-tile-leaf clearfix animation-pullDown">
			             <div class="dash-tile-header">
			                 <div class="dash-tile-options">
			                     <a class="btn btn-default" data-toggle="tooltip" data-original-title="查看详情" href="#">
			                         <i class="icon-th-list"></i>
			                     </a>
			                 </div>
			                           昨日注册
			             </div>
			             <div class="dash-tile-icon"><i class="icon-upload-alt"></i></div>
			             <div class="dash-tile-text">78</div>
			        </div>
			    </div>
			    <div class="col-sm-3">
			        <div class="dash-tile dash-tile-flower clearfix animation-pullDown">
			             <div class="dash-tile-header">
			                 <div class="dash-tile-options">
			                     <a class="btn btn-default" data-toggle="tooltip" data-original-title="查看详情" href="#">
			                         <i class="icon-th-list"></i>
			                     </a>
			                 </div>      
			                          昨日销量
			             </div>
			             <div class="dash-tile-icon"><i class="icon-money"></i></div>
			             <div class="dash-tile-text">146</div>
			        </div>
			        <div class="dash-tile dash-tile-fruit clearfix animation-pullDown">
			             <div class="dash-tile-header">
			                 <div class="dash-tile-options">
			                     <a class="btn btn-default" data-toggle="tooltip" data-original-title="查看详情" href="#">
			                         <i class="icon-th-list"></i>
			                     </a>
			                 </div>
			                          销量增长率
			             </div>
			             <div class="dash-tile-icon"><i class="icon-signal"></i></div>
			             <div class="dash-tile-text">+5%</div>
			        </div>
			    </div>
			    <div class="col-sm-3">
			        <div class="dash-tile dash-tile-oil clearfix animation-pullDown">
			             <div class="dash-tile-header">
			                 <div class="dash-tile-options">
			                     <a class="btn btn-default" data-toggle="tooltip" data-original-title="查看详情" href="#">
			                         <i class="icon-th-list"></i>
			                     </a>
			                 </div>
			                          评论数量
			             </div>
			             <div class="dash-tile-icon"><i class="icon-comment"></i></div>
			             <div class="dash-tile-text">265K</div>
			        </div>
			        <div class="dash-tile dash-tile-dark clearfix animation-pullDown">
			             <div class="dash-tile-header"> 
			                 <div class="dash-tile-options">
			                     <a class="btn btn-default" data-toggle="tooltip" data-original-title="查看详情" href="#">
			                         <i class="icon-th-list"></i>
			                     </a>
			                 </div>
			                          好评数量
			             </div>
			             <div class="dash-tile-icon"><i class="icon-thumbs-up"></i></div>
			             <div class="dash-tile-text">5K</div>
			        </div>
			    </div>
			    <div class="col-sm-3">
			        <div class="dash-tile dash-tile-balloon clearfix animation-pullDown">
			             <div class="dash-tile-header">
			                 <div class="dash-tile-options">
			                     <a class="btn btn-default" data-toggle="tooltip" data-original-title="查看详情" href="#">
			                         <i class="icon-th-list"></i>
			                     </a>
			                 </div>
			                          退换数量
			             </div>
			             <div class="dash-tile-icon"><i class="icon-exchange"></i></div>
			             <div class="dash-tile-text">243</div>
			        </div>
			        <div class="dash-tile dash-tile-doll clearfix animation-pullDown">
			             <div class="dash-tile-header">
			                 <div class="dash-tile-options">
			                     <a class="btn btn-default" data-toggle="tooltip" data-original-title="查看详情" href="#">
			                         <i class="icon-th-list"></i>
			                     </a>
			                 </div>
			                          昨日退换
			             </div>
			             <div class="dash-tile-icon"><i class="icon-undo"></i></div>
			             <div class="dash-tile-text">3</div>
			        </div>
			    </div>
			</div>

            <!-- 第一行信息 -->
            <div class="row">
                <div class="col-sm-6">
                    <div class="dash-tile dash-tile-2x">
                        <div class="dash-tile-header">
			                 <i class="icon-tasks"></i>
			                           今日订单
			             </div>
			             <div class="dash-tile-content">
			                  <table id="today-orders-table" class="table table-striped table-bordered dataTable">
			                     <thead>
			                        <tr>
			                           <th>序号</th>
			                           <th>订单</th>
			                           <th>用户</th>
			                           <th>状态</th>
			                        </tr>
			                     </thead>
			                     <tbody>
			                        <tr>
			                           <td>1</td>
			                           <td>order1</td>
			                           <td>user1</td>
			                           <td><span class="label label-default">Inactive</span></td>
			                        </tr>
			                        <tr>
			                           <td>2</td>
			                           <td>order2</td>
			                           <td>user2</td>
			                           <td><span class="label label-default">Inactive</span></td>
			                        </tr>
			                        <tr>
			                           <td>3</td>
			                           <td>order3</td>
			                           <td>user3</td>
			                           <td><span class="label label-default">Inactive</span></td>
			                        </tr>
			                        <tr>
			                           <td>4</td>
			                           <td>order4</td>
			                           <td>user4</td>
			                           <td><span class="label label-default">Inactive</span></td>
			                        </tr>
			                        <tr>
			                           <td>5</td>
			                           <td>order5</td>
			                           <td>user5</td>
			                           <td><span class="label label-default">Inactive</span></td>
			                        </tr>
			                        <tr>
			                           <td>6</td>
			                           <td>order6</td>
			                           <td>user6</td>
			                           <td><span class="label label-default">Inactive</span></td>
			                        </tr>
			                        <tr>
			                           <td>7</td>
			                           <td>order7</td>
			                           <td>user7</td>
			                           <td><span class="label label-default">Inactive</span></td>
			                        </tr>
			                     </tbody>
			                  </table>
			             </div>
                    </div>
                </div>
                
                <div class="col-sm-6">
                    <div class="dash-tile dash-tile-2x">
                        <div class="dash-tile-header">
			                 <i class="icon-user"></i>
			                          用户概览
			             </div>
			             <div class="dash-tile-content">
			                 <ul class="nav nav-tabs" role="tablist" data-toggle="tabs">
                               <li role="presentation" class="active"><a href="#dash-tabs-admin">管理员</a></li>
                               <li role="presentation"><a href="#dash-tabs-newusers">今日注册</a></li>
                             </ul>
			                 <div class="tab-content">
			                   <div class="tab-pane active" id="dash-tabs-admin">
			                       <ul class="thumbnails clearfix remove-margin" data-toggle="gallery-options">
			                          <li>
			                             <a class="thumbnail"><img src="<c:url value="/resources-admin/images/user_image.png"/>"/></a>
			                             <a class="thumbnail thumbnail-borderless text-center">tyjuncai</a>
			                          </li>
			                          <li>
			                             <a class="thumbnail"><img src="<c:url value="/resources-admin/images/user_image.png"/>"/></a>
			                             <a class="thumbnail thumbnail-borderless text-center">lijianbin</a>
			                          </li>
			                          <li>
			                             <a class="thumbnail"><img src="<c:url value="/resources-admin/images/user_image.png"/>"/></a>
			                             <a class="thumbnail thumbnail-borderless text-center">testAdmin</a>
			                          </li>
			                          <li>
			                             <a class="thumbnail"><img src="<c:url value="/resources-admin/images/user_image.png"/>"/></a>
			                             <a class="thumbnail thumbnail-borderless text-center">abc</a>
			                          </li>
			                          <li>
			                             <a class="thumbnail"><img src="<c:url value="/resources-admin/images/user_image.png"/>"/></a>
			                             <a class="thumbnail thumbnail-borderless text-center">admin1</a>
			                          </li>
			                          <li>
			                             <a class="thumbnail"><img src="<c:url value="/resources-admin/images/user_image.png"/>"/></a>
			                             <a class="thumbnail thumbnail-borderless text-center">admin2</a>
			                          </li>
			                       </ul>
			                   </div>
			                   <div class="tab-pane" id="dash-tabs-newusers">
			                       <ul class="thumbnails clearfix remove-margin" data-toggle="gallery-options">
			                          <li>
			                             <a class="thumbnail"><img src="<c:url value="/resources-admin/images/user_image.png"/>" class="img-circle"/></a>
			                             <a class="thumbnail thumbnail-borderless text-center">user1</a>
			                          </li>
			                          <li>
			                             <a class="thumbnail"><img src="<c:url value="/resources-admin/images/user_image.png"/>" class="img-circle"/></a>
			                             <a class="thumbnail thumbnail-borderless text-center">user2</a>
			                          </li>
			                          <li>
			                             <a class="thumbnail"><img src="<c:url value="/resources-admin/images/user_image.png"/>" class="img-circle"/></a>
			                             <a class="thumbnail thumbnail-borderless text-center">user3</a>
			                          </li>
			                          <li>
			                             <a class="thumbnail"><img src="<c:url value="/resources-admin/images/user_image.png"/>" class="img-circle"/></a>
			                             <a class="thumbnail thumbnail-borderless text-center">user4</a>
			                          </li>
			                          <li>
			                             <a class="thumbnail"><img src="<c:url value="/resources-admin/images/user_image.png"/>" class="img-circle"/></a>
			                             <a class="thumbnail thumbnail-borderless text-center">user5</a>
			                          </li>
			                          <li>
			                             <a class="thumbnail"><img src="<c:url value="/resources-admin/images/user_image.png"/>" class="img-circle"/></a>
			                             <a class="thumbnail thumbnail-borderless text-center">user6</a>
			                          </li>
			                          <li>
			                             <a class="thumbnail"><img src="<c:url value="/resources-admin/images/user_image.png"/>" class="img-circle"/></a>
			                             <a class="thumbnail thumbnail-borderless text-center">user7</a>
			                          </li>
			                          <li>
			                             <a class="thumbnail"><img src="<c:url value="/resources-admin/images/user_image.png"/>" class="img-circle"/></a>
			                             <a class="thumbnail thumbnail-borderless text-center">user8</a>
			                          </li>
			                          <li>
			                             <a class="thumbnail"><img src="<c:url value="/resources-admin/images/user_image.png"/>" class="img-circle"/></a>
			                             <a class="thumbnail thumbnail-borderless text-center">user9</a>
			                          </li>
			                          <li>
			                             <a class="thumbnail"><img src="<c:url value="/resources-admin/images/user_image.png"/>" class="img-circle"/></a>
			                             <a class="thumbnail thumbnail-borderless text-center">user10</a>
			                          </li>
			                          <li>
			                             <a class="thumbnail"><img src="<c:url value="/resources-admin/images/user_image.png"/>" class="img-circle"/></a>
			                             <a class="thumbnail thumbnail-borderless text-center">user11</a>
			                          </li>
			                          <li>
			                             <a class="thumbnail"><img src="<c:url value="/resources-admin/images/user_image.png"/>" class="img-circle"/></a>
			                             <a class="thumbnail thumbnail-borderless text-center">user12</a>
			                          </li>
			                       </ul>
			                   </div>
			                 </div>
			             </div>
                    </div>
                </div>
            </div>
            
            <!-- 第二行信息-->
            <div class="row">
			   <div class="col-sm-6">
			       <div class="dash-tile dash-tile-2x">
			           <div class="dash-tile-header">
			                 <div class="dash-tile-options">
			                     <div id="advanced-daterangepicker" class="btn btn-default">
			                         <i class="icon-calendar"></i>
			                         <span class="daterange"><span class="start-date-span">2014/09/26</span> 至 <span class="end-date-span">2014/10/01</span></span>
			                         <b class="caret"></b>
			                     </div>
			                 </div>
			                 <i class="icon-bar-chart"></i>
			                          销量统计
			             </div>
			             <div class="dash-tile-content">
			             </div>
			       </div>
			   </div>
			   
			   <div class="col-sm-3">
			       <div class="dash-tile dash-tile-2x">
			           <div class="dash-tile-header">
			                 <i class="icon-exchange"></i>
			                          退换信息
			             </div>
			             <div class="dash-tile-content">
			             </div>
			       </div>
			   </div>
			   
			   <div class="col-sm-3">
			       <div class="dash-tile dash-tile-2x">
			           <div class="dash-tile-header">
			                 <i class="icon-comments"></i>
			                          今日评论
			             </div>
			             <div class="dash-tile-content">
			             </div>
			       </div>
			   </div>
			</div>
			
			
		</div>
	</div>

	<!-- 引用页面底部模板 -->
	<%@ include file="/WEB-INF/views/includes/admin_footer.jspf"%>
</body>
<%@ include file="/WEB-INF/views/includes/admin_foot_scripts_links.jspf"%>
<script type="text/javascript">
$(function(){	
	$('#today-orders-table').DataTable({iDisplayLength:6, aLengthMenu:[[6,10,30,-1],[6,10,30,"All"]]});
	setDataTableSearchInput();	
});
</script>
</html>