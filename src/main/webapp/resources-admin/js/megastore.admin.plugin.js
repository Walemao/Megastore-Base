$(function() {
	var a = $('#to-top');
	$(window).scroll(function() {
		$(this).scrollTop() > 150 ? a.fadeIn(150) : a.fadeOut(150);
	});

	a.click(function() {
		$('html, body').animate({
			scrollTop : 0
		}, 300);
	});

	$('[data-toggle="tooltip"]').tooltip({
		container : 'body',
		animation : !1
	});

	$('[data-toggle="tabs"] a').click(function(a) {
		a.preventDefault();
		$(this).tab('show');
	});
	
	//日期控件
	$('#advanced-daterangepicker').click(function(){
		var top = $(this).offset().top;
		var left = $(this).offset().left;
		$('.daterangepicker').css("left", left);
		$('.daterangepicker').css("top", top + 34);
		$('.daterangepicker').show();
		return false;
	});
	
	$('#startDateChoose').click(function(){
		return false;
	}).datetimepicker({
		format: 'yyyy/mm/dd',
		minView: 'month',
        maxView: 'decade',
        autoclose: true,
        endDate: $('#endDateChoose').val()
	}).on('changeDate', function(ev){
		$('#endDateChoose').datetimepicker('setStartDate', new Date(ev.date.valueOf()));
		$('.start-date-span').text($('#startDateChoose').val());
		$('#startDate').val($('#startDateChoose').val());
		$('.ranges li').removeClass('active');
	});
	
	$('#endDateChoose').click(function(){
		return false;
	}).datetimepicker({
		format: 'yyyy/mm/dd',
		minView: 'month',
        maxView: 'decade',
        autoclose: true,
        startDate: $('#startDateChoose').val()
	}).on('changeDate', function(ev){
		$('#startDateChoose').datetimepicker('setEndDate', new Date(ev.date.valueOf()));
		$('.end-date-span').text($('#endDateChoose').val());
		$('#endDate').val($('#endDateChoose').val());
		$('.ranges li').removeClass('active');
	});
	
	$('.ranges li').click(function(){
		var current_date = new Date();
		var current_date_str = dateFormat(new Date());
		var start_date = null;
		
		if($(this).hasClass('7days')){
			start_date = new Date(current_date.getTime() - 7 * 24 * 3600 * 1000);
		}
		if($(this).hasClass('30days')){
			start_date = new Date(current_date.getTime() - 30 * 24 * 3600 * 1000);
		}
		if($(this).hasClass('60days')){
			start_date = new Date(current_date.getTime() - 60 * 24 * 3600 * 1000);
		}
		if($(this).hasClass('90days')){
			start_date = new Date(current_date.getTime() - 90 * 24 * 3600 * 1000);
		}
		
		var start_date_str = dateFormat(start_date);
		$('#startDateChoose').val(start_date_str);
		$('#endDateChoose').val(current_date_str);
		$('#startDateChoose').datetimepicker('setEndDate', current_date);
		$('#endDateChoose').datetimepicker('setStartDate', start_date);
		$('.start-date-span').text($('#startDateChoose').val());
		$('#startDate').val($('#startDateChoose').val());
		$('.end-date-span').text($('#endDateChoose').val());
		$('#endDate').val($('#endDateChoose').val());
		$(this).siblings().removeClass('active');
		$(this).addClass('active');
	});
	
	$('body').click(function(){
		$('.daterangepicker').hide();
	});
	
});

/**
 * 重写dataTable搜索框
 * 
 * */
function setDataTableSearchInput(){
	var table_search_input = $('.dataTables_filter input');
	var table_search_div = $('<div/>').addClass('input-group');
	var table_search_span = $('<span/>').addClass('input-group-addon').html('<i class="icon-search"></i>');
	table_search_div.append(table_search_input).append(table_search_span);
	$('.dataTables_filter label').html(table_search_div);
} 

/**
 * 日期格式化
 * 
 * */
function dateFormat(date){
	var year = date.getFullYear();
	var month = date.getMonth()+1;
	var day = date.getDate();
	
	return year + '/' + month + '/' + day; 
}

/**
 * 商品颜色分类动态生成
 * 
 * */
function appendProductColor(thumbnail, name, thummd5, id){
	var p = $('<p/>').addClass('form-control-static').addClass('clearfix').attr('data-str', thummd5).attr('data-id', id);
	var radio = $('<input/>').attr('type','radio').attr('name','mainImg').addClass('main-img-radio').val(thumbnail).attr('data-toggle','tooltip').attr('data-original-title','设为主图');
	var a = $('<a/>').addClass('thumbnail').attr('data-toggle', 'modal').attr('data-target', '#product-color-modal-update');
	var img = $('<img/>').attr('width','50').attr('height','50').attr('src', thumbnail);
	var color_span = $('<span/>').addClass('color-text').text(name);
	var delete_span = $('<span/>').addClass('color-delete').attr('data-toggle','tooltip').attr('data-original-title','删除').html('<i class="icon-trash"></i>').attr('onclick','deleteInfo('+ id +')');
	var input = $('<input/>').attr('type','hidden').attr('name','colorId').val(id);
	a.append(img);
	p.append(radio).append(a).append(color_span).append(delete_span).append(input);
	
	$('.product-color-info').append(p);
	$('[data-toggle="tooltip"]').tooltip({
		container : 'body',
		animation : !1
	});
}


