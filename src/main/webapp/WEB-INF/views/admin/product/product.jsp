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
			<c:url value="/admin/product/color?${_csrf.parameterName}=${_csrf.token}" var="typeUrl"/>
			<c:if test="${param.add == null }">
				<c:set var="method" value="PUT" />
			</c:if>
			<form:form action="${productUrl}" method="${method}"
				class="form-horizontal form-box" modelAttribute="productBase">
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
								<option value="0">--所有商品--</option>
								<option value="1">积木</option>
								<option value="2">模型</option>
								<option value="3">益智</option>
							</select>
						</div>
						<label class="control-label col-md-2">商品货号：</label>
						<div class="col-md-3">
							<form:input path="number" cssClass="form-control input-sm" />
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
						<label class="control-label col-md-2">商品折扣：</label>
						<div class="col-md-3">
							<form:input path="discount" cssClass="form-control input-sm" />
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
						<label class="control-label col-md-2">型号分类：</label>
						<div class="col-md-4 product-color-info">
							<a class="btn btn-default add-color-btn" data-toggle="modal" data-target="#product-color-modal-add"><i class="icon-plus"></i>添加型号分类</a>
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
	
	<!-- 型号分类添加modal -->
	<div id="product-color-modal-add" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel"><i class="icon-magic"></i>添加型号分类</h4>
            </div>
          <div class="modal-body">
            <form:form id="product-color-form-add" action="${typeUrl}" method="POST" cssClass="form-horizontal" enctype="multipart/form-data" modelAttribute="productInfo">
               <input type="hidden" name="productId" value="${productBase.id}"/>
               <div class="form-group">
                  <label class="control-label col-md-3">型号名称：</label>
                  <div class="col-md-8">
                    <form:input path="name" cssClass="form-control"/>
				  </div>
               </div>
               <div class="form-group">
                  <label class="control-label col-md-3">型号价格：</label>
                  <div class="col-md-8">
                    <div class="input-group">
                     <span class="input-group-addon"><i class="icon-money"></i></span>
                     <form:input path="price" cssClass="form-control"/>
                    </div>
                  </div>
               </div>
               <div class="form-group">
                  <label class="control-label col-md-3">型号毛重：</label>
                  <div class="col-md-8">
                    <div class="input-group">
                     <span class="input-group-addon"><i class="icon-glass"></i></span>
                     <form:input path="weight" cssClass="form-control"/>
                    </div>
                  </div>
               </div>
               <div class="form-group">
                  <label class="control-label col-md-3">型号库存：</label>
                  <div class="col-md-8">
                   <div class="input-group">
                     <span class="input-group-addon"><i class="icon-truck"></i></span>
                     <form:input path="amount" cssClass="form-control"/>
                   </div>
                  </div>
               </div>
               <div class="form-group">
                  <label class="control-label col-md-3">缩略图：</label>
                  <div class="col-md-8">
                  <div class="input-group">
                     <span class="input-group-addon"><i class="icon-camera-retro"></i></span>
                     <input type="file" name="thumbnailImg" class="form-control" />
                  </div>
                  </div>
               </div>
            </form:form>
            <div class="alert alert-danger alert-dismissible alert-option-error" role="alert" style="display: none;">
				<button type="button" class="close" data-dismiss="alert">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<strong class="alert-option-error-info"></strong> 
			</div>
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
                <h4 class="modal-title" id="myModalLabel"><i class="icon-magic"></i>修改型号分类</h4>
            </div>
          <div class="modal-body">
            <form:form id="product-color-form-update" action="${typeUrl}" method="POST" class="form-horizontal" modelAttribute="productInfo">
               <input type="hidden" name="_method" value="PUT" />
               <form:hidden path="id"/>
               <form:hidden path="productid"/>
               <form:hidden path="thumbnail"/>
               <form:hidden path="thummd5"/>
               <div class="form-group">
                  <label class="control-label col-md-3">型号名称：</label>
                  <div class="col-md-8">
                    <form:input path="name" cssClass="form-control"/>
				  </div>
               </div>
               <div class="form-group">
                  <label class="control-label col-md-3">型号价格：</label>
                  <div class="col-md-8">
                    <div class="input-group">
                     <span class="input-group-addon"><i class="icon-money"></i></span>
                     <form:input path="price" cssClass="form-control"/>
                    </div>
                  </div>
               </div>
               <div class="form-group">
                  <label class="control-label col-md-3">型号毛重：</label>
                  <div class="col-md-8">
                    <div class="input-group">
                     <span class="input-group-addon"><i class="icon-glass"></i></span>
                     <form:input path="weight" cssClass="form-control"/>
                    </div>
                  </div>
               </div>
               <div class="form-group">
                  <label class="control-label col-md-3">型号库存：</label>
                  <div class="col-md-8">
                   <div class="input-group">
                     <span class="input-group-addon"><i class="icon-truck"></i></span>
                     <form:input path="amount" cssClass="form-control"/>
                   </div>
                  </div>
               </div>
               <div class="form-group">
                  <label class="control-label col-md-3">缩略图：</label>
                  <div class="col-md-9 color-img">
                  </div>
               </div>
            </form:form>
            <div class="alert alert-danger alert-dismissible alert-option-error" role="alert" style="display: none;">
				<button type="button" class="close" data-dismiss="alert">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<strong class="alert-option-error-info"></strong> 
			</div>
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
    /** 添加颜色分类 **/
    $('#product-color-modal-add').modal('hide');
    $('#product-color-modal-add').on('hidden.bs.modal', function(){
    	$('#product-color-form-add input').val('');
    	$('.alert-option-error').hide();
    });
    
    $('#product-color-modal-add .submit').on('click',function(){
    	$('#product-color-form-add').ajaxSubmit(function(data){
    		if(data.status == 'success'){
    			appendProductColor(data.productInfo.thumbnail, data.productInfo.name, data.productInfo.thummd5, data.productInfo.id);
    			$('#product-color-modal-add').modal('hide');
    		}else{
    			$('.alert-option-error-info').text(data.message);
    			$('.alert-option-error').show();
    		}
    	});
    });
    
    /** 修改颜色分类 **/
    $('#product-color-modal-update').on('shown.bs.modal', function(e){
    	var $invoker = $(e.relatedTarget);
    	window.invoker = $invoker;
    	var thummd5 = $invoker.parent().attr('data-str');
    	$.get('<c:url value="/admin/product/color" />', {thumbnailMD5 : thummd5}, function(data){
    		$('#product-color-form-update input[name=id]').val(data.id);
    		$('#product-color-form-update input[name=thumbnail]').val(data.thumbnail);
    		$('#product-color-form-update input[name=thummd5]').val(thummd5);
    		$('#product-color-form-update input[name=productid]').val(data.productid);
    		$('#product-color-form-update input[name=price]').val(data.price);
	    	$('#product-color-form-update input[name=weight]').val(data.weight);
    		$('#product-color-form-update input[name=name]').val(data.name);
	    	$('#product-color-form-update input[name=amount]').val(data.amount);
    		var img =  $('<img/>').attr('src', data.thumbnail).attr('width','300');
        	$('.color-img').append(img);
    	});
    });
    
    $('#product-color-modal-update').on('hidden.bs.modal', function(){
    	$('#product-color-form-update input').val('');
    	$('#product-color-form-update input[name=_method]').val('PUT');
    	$('.color-img').html('');
    	$('.alert-option-error').hide();
    });
    
    $('#product-color-modal-update .submit').on('click',function(){
    	$('#product-color-form-update').ajaxSubmit(function(data){
    		if(data.status == 'success'){
    			var $invoker = window.invoker;
    			var name = $('#product-color-form-update input[name=name]').val();
    	    	var amount = $('#product-color-form-update input[name=amount]').val();
 
    	    	$invoker.parent().find('.color-text').text(name);
    			$('#product-color-modal-update').modal('hide');
    		}else{
    			$('.alert-option-error-info').text(data.message);
    			$('.alert-option-error').show();
    		}
    	});   	
    });
    
    /** 删除颜色分类 **/
    function deleteInfo(id){
    	if(window.confirm('你确定要删除吗？')){
    		$.post('<c:url value="/admin/product/color?${_csrf.parameterName}=${_csrf.token}" />',{_method : 'DELETE', id : id},function(data){
        		if(data.status == 'success'){
        			$('.form-control-static').each(function(){
        				if($(this).attr("data-id") == id){
        					$(this).remove();
        				}
        			});
        		}else{
        			alert(data.message);
        		}
        	});
    	}
    }
  
</script>
</html>