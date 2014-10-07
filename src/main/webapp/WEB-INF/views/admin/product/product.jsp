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
				<li><a href="#">商品管理</a></li>
				<li class="active"><a href="#">添加商品</a></li>
			</ul>
			<!-- 商品基本信息 -->
			<c:set var="method" value="POST" />
			<c:url var="productUrl" value="/admin/product" />
			<c:if test="${param.add == null }">
				<c:set var="method" value="PUT" />
			</c:if>
			<form:form action="${productUrl}" method="${method}"
				class="form-horizontal form-box" modelAttribute="productInfo">
				<h4 class="form-box-header">商品信息</h4>
				<div class=" form-box-content">
					<div class="form-group">
						<label class="control-label col-md-2">商品名称：</label>
						<div class="col-md-6">
							<form:input path="name" cssClass="form-control input-sm" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2">商品类型：</label>
						<div class="col-md-3">
							<select class="form-control" name="productType" id="productType">
								<option>--所有商品--</option>
								<option>积木</option>
								<option>模型</option>
								<option>益智</option>
							</select>
						</div>
						<label class="control-label col-md-2">商品货号：</label>
						<div class="col-md-3">
							<form:input path="number" cssClass="form-control input-sm" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2">商品价格：</label>
						<div class="col-md-3">
							<div class="input-group">
								<span class="input-group-addon">￥</span>
								<form:input path="price" cssClass="form-control input-sm" />
							</div>
						</div>
						<label class="control-label col-md-2">商品折扣：</label>
						<div class="col-md-3">
							<form:input path="discount" cssClass="form-control input-sm" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2">商品产地：</label>
						<div class="col-md-3">
							<form:input path="orgin" cssClass="form-control input-sm" />
						</div>
						<label class="control-label col-md-2">商品材质：</label>
						<div class="col-md-3">
							<form:input path="materials" cssClass="form-control input-sm" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2">商品毛重：</label>
						<div class="col-md-4">
							<form:input path="weight" cssClass="form-control input-sm" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2">是否推荐：</label>
						<div class="col-md-4">
							<label class="radio-inline"> <form:radiobutton
									path="recommend" value="0" />是
							</label> <label class="radio-inline"> <form:radiobutton
									path="recommend" value="1" />否
							</label>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2">颜色分类：</label>
						<div class="col-md-4 product-color-info">
							<a class="btn btn-default add-color-btn" data-toggle="modal" data-target="#product-color-modal-add"><i class="icon-plus"></i>添加颜色分类</a>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2">商品描述：</label>
						<div class="col-md-6">
							<form:textarea path="desc" rows="3"
								cssClass="form-control input-sm" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2">商品备注：</label>
						<div class="col-md-6">
							<form:input path="remark" cssClass="form-control input-sm" />
						</div>
					</div>
					<div class="form-group form-actions">
						<div class="col-md-10 col-md-offset-2">
							<input type="submit" value="确定" class="btn btn-success" /> <input
								type="reset" value="重置" class="btn btn-danger" />
						</div>
					</div>
				</div>
			</form:form>
			<c:if test="${status!=null}">
			<div class="alert alert-${status} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<strong><c:out value="${messageStatus}"></c:out></strong> <c:out value="${message}"></c:out>
			</div>
            </c:if>
            
			<!-- 商品展示图片上传 -->
			
		</div>

	</div>
	
	<!-- 颜色分类添加modal -->
	<div id="product-color-modal-add" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel"><i class="icon-magic"></i>添加颜色分类</h4>
            </div>
          <div class="modal-body">
            <form id="product-color-form-add" action="<c:url value="/admin/product/color?${_csrf.parameterName}=${_csrf.token}" />" method="POST" class="form-horizontal" role="form" enctype="multipart/form-data">
               <div class="form-group">
                  <label class="control-label col-md-3">分类名称：</label>
                  <div class="col-md-9">
                    <input id="typeName" type="text" name="typeName" class="form-control" />
				  </div>
               </div>
               <div class="form-group">
                  <label class="control-label col-md-3">分类库存：</label>
                  <div class="col-md-9">
                     <input id="amount"  type="number" name="amount" class="form-control" />
                  </div>
               </div>
               <div class="form-group">
                  <label class="control-label col-md-3">缩略图：</label>
                  <div class="col-md-9">
                     <input type="file" name="thumbnail" class="form-control" />
                  </div>
               </div>
            </form>
          </div>
          <div class="modal-footer">
             <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
             <button type="button" class="btn btn-primary submit">确定</button>
          </div>
       </div>
     </div>
    </div>
    
    <!-- 颜色分类编辑modal -->
	<div id="product-color-modal-update" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel"><i class="icon-magic"></i>修改颜色分类</h4>
            </div>
          <div class="modal-body">
            <form id="product-color-form-update" action="<c:url value="/admin/product/color?${_csrf.parameterName}=${_csrf.token}" />" method="POST" class="form-horizontal" role="form">
               <input type="hidden" name="_method" value="PUT">
               <input type="hidden" id="thumbnailMD5" name="id" value="">
               <div class="form-group">
                  <label class="control-label col-md-3">分类名称：</label>
                  <div class="col-md-9">
                    <input type="text" name="typeName" class="form-control" />
				  </div>
               </div>
               <div class="form-group">
                  <label class="control-label col-md-3">分类库存：</label>
                  <div class="col-md-9">
                     <input type="number" name="amount" class="form-control" />
                  </div>
               </div>
               <div class="form-group">
                  <label class="control-label col-md-3">缩略图：</label>
                  <div class="col-md-9 color-img">
                  </div>
               </div>
            </form>
          </div>
          <div class="modal-footer">
             <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
             <button type="button" class="btn btn-primary submit">确定</button>
          </div>
       </div>
     </div>
    </div>
    
	<!-- 引用页面底部模板 -->
	<%@ include file="/WEB-INF/views/includes/admin_footer.jspf"%>
</body>
<%@ include file="/WEB-INF/views/includes/admin_foot_scripts_links.jspf"%>
<script type="text/javascript">
    $('#product-color-modal-add').modal('hide');
    $('#product-color-modal-add').on('hidden.bs.modal', function(){
    	$('#product-color-form-add input').val('');
    });
    
    $('#product-color-modal-add .submit').on('click',function(){
    	$('#product-color-form-add').ajaxSubmit(function(data){
    		if(data.status == 'success'){
    			appendProductColor(data.thumbnailUrl, $('#typeName').val(), data.thumbnailMD5, $('#amount').val());
    			$('#product-color-modal-add').modal('hide');
    		}
    	});
    });
    	
    $('#product-color-modal-update').on('shown.bs.modal', function(e){
    	var $invoker = $(e.relatedTarget);
    	var id = $invoker.parent().attr('data-id');
    	var url = $invoker.parent().attr('data-url');
    	var name = $invoker.parent().attr('data-name');
    	var amount = $invoker.parent().attr('data-amount');
    	$('#thumbnailMD5').val(id);
    	$('#product-color-form-update input[name=typeName]').val(name);
    	$('#product-color-form-update input[name=amount]').val(amount);
    	var img =  $('<img/>').attr('src', url).attr('width','300');
    	$('.color-img').append(img);
    });
    
    $('#product-color-modal-update').on('hidden.bs.modal', function(){
    	$('#product-color-form-update input').val('');
    	$('.color-img').html('');
    });
    
  
</script>
</html>