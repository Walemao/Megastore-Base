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
		    <c:set var="method" value="POST" />
		    <c:set var="title" value="添加商品" />
			<c:url var="productUrl" value="/admin/product" />
			<c:url value="/admin/product/color?${_csrf.parameterName}=${_csrf.token}" var="typeUrl"/>
			<c:if test="${param.add == null }">
				<c:set var="method" value="PUT" />
				<c:set var="title" value="修改商品" />
			</c:if>
			<ul id="nav-info" class="clearfix">
				<li><a href="#"><i class="icon-gift"></i></a></li>
				<li><a href="#">商品管理</a></li>
				<li class="active"><a href="#">${title}</a></li>
			</ul>
			<!-- 商品基本信息 -->
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
							<c:forEach items="${types}" var="type">
							<option value="<c:out value="${type.id}"></c:out>" <c:if test="${type.id == productBase.classify}"> selected</c:if>><c:out value="${type.name}"></c:out></option>
							</c:forEach>
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
							<c:if test="${productBase.id !=null}">
							 <form:hidden path="id"/>
							 <c:forEach items="${productBase.productInfos}" var="productInfo">
							  <p class="form-control-static clearfix" data-str="<c:out value="${productInfo.thummd5 }"/>" data-id="<c:out value="${productInfo.id }"/>">
							   <input type="radio" name="mainImg" class="main-img-radio" data-toggle="tooltip" data-original-title="设为主图" value="<c:out value="${productInfo.thumbnail }"/>" <c:if test="${productBase.thumbnail==productInfo.thumbnail}"> checked</c:if> />
							   <a class="thumbnail" data-toggle="modal" data-original-title="#product-color-modal-update">
							     <img src="<c:out value="${productInfo.thumbnail }"/>" width="50" height="50"/>
							   </a>
							   <span class="color-text"><c:out value="${productInfo.name}"/></span>
							   <span class="color-delete" data-toggle="tooltip" data-original-title="删除" onclick="deleteInfo(<c:out value="${productInfo.id}"/>)"><i class="icon-trash"></i></span>
							   <input type="hidden" name="colorId" value="<c:out value="${productInfo.id}"/>" />
							  </p>
							 </c:forEach>
							</c:if>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2">商品描述：</label>
						<div class="col-md-6">
							<form:textarea path="desc" rows="5"
								cssClass="form-control input-sm" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-2">商品备注：</label>
						<div class="col-md-6">
							<form:input path="remark" cssClass="form-control input-sm" />
						</div>
					</div>					
					<div class="img_hidden_ids">
					 <c:if test="${productBase.id !=null}">
					    <%int i=1; %>
					    <c:forEach items="${productBase.productImages}" var="productImage">
					       <input type="hidden" name="imageId" id="img_<c:out value="${productImage.id}" />" value="<c:out value="${productImage.id}" />">
					       <input type="hidden" name="imageUrl" class="product-image-onserver-<%=i%> image-count" value="<c:out value="${productImage.picSrc}" />" >
					     <%i++; %>
					    </c:forEach>
					 </c:if>
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
            
            <!-- 商品展示图片 -->
			<div class="form-box">
			    <h4 class="form-box-header form-box-header-push">商品展示图片<small>将图片拖入下面区域上传，只允许上传jpg、png和gif格式</small></h4>
			    <div class="form-box-content">
			      <div class="dropzone push dz-clickable">
			          <div class="dz-default dz-message">
			             <span>图片上传区域</span>
			          </div>
			       </div>
			    </div>
			</div>
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
    
    <!-- 型号分类编辑modal -->
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
<script type="text/javascript" src="<c:url value="/resources-admin/js/dropzone.js"/>"></script>
<script type="text/javascript">
    /** 添加型号分类 **/
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
    
    /** 修改型号分类 **/
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
    
    /** 删除型号分类 **/
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
    
    /** 添加和删除展示图片  **/
    window.sort = 1;
    $('.dropzone').dropzone({
        url: '<c:url value="/admin/product/img?${_csrf.parameterName}=${_csrf.token}&productId=${productBase.id}" />',
        paramName: 'productImg',
        maxFiles: 10,
        maxFilesize: 1024,
        acceptedFiles: '.jpg,.png,.gif',
        addRemoveLinks: true,
        init: function() {
        	var count = $('.image-count').length;
        	if(count > 0){
        		for(var i=1; i<=count; i++){
    				var mockFile = { name: '已上传的图片', size: 12345};
    				this.options.addedfile.call(this, mockFile);
    				this.options.thumbnail.call(this, mockFile, $('.product-image-onserver-'+i).val());	
    			} 
        	}    
        	
            this.on("success", function(file, data) {
            	var sort = window.sort;
            	window.sort = sort + 1;
            	var image_id_input = $('<input/>').attr('type', 'hidden').attr('name', 'imageId').attr('id','img_' + data.imgId).val(data.imgId);
            	$('.img_hidden_ids').append(image_id_input);
            	file.fileId = data.imgId;
            });
            
            this.on("removedfile", function(file) {
                $.post('<c:url value="/admin/product/img?${_csrf.parameterName}=${_csrf.token}" />', {_method : 'DELETE', imageId : file.fileId}, function(data){
                	if(data.status == 'success'){
                		$('#img_'+ file.fileId).remove();
                	}
                });
            });
        }
    });
    
  
</script>
</html>