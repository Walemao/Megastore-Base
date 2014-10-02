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
	
	$('#advanced-daterangepicker').click(function(){
		var top = $(this).offset().top;
		var left = $(this).offset().left;
		$('.daterangepicker').css("left", left);
		$('.daterangepicker').css("top", top + 34);
		$('.daterangepicker').show();
		return false;
	});
	
	$('#startDate').click(function(){
		return false;
	}).datetimepicker({
		format: 'yyyy/mm/dd',
		minView: 'month',
        maxView: 'decade',
        autoclose: true,
        endDate: $('#endDate').val()
	}).on('changeDate', function(ev){
		$('#endDate').datetimepicker('setStartDate', new Date(ev.date.valueOf()));
		$('.start-date-span').text($('#startDate').val());
	});
	
	$('#endDate').click(function(){
		return false;
	}).datetimepicker({
		format: 'yyyy/mm/dd',
		minView: 'month',
        maxView: 'decade',
        autoclose: true,
        startDate: $('#startDate').val()
	}).on('changeDate', function(ev){
		$('#startDate').datetimepicker('setEndDate', new Date(ev.date.valueOf()));
		$('.end-date-span').text($('#endDate').val());
	});
	
	$('body').click(function(){
		$('.daterangepicker').hide();
	});
	
});