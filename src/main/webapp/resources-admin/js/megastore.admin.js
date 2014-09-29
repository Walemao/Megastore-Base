$(function(){
	var a = $('#to-top');
	$(window).scroll(function(){
		$(this).scrollTop() > 150 ? a.fadeIn(150) : a.fadeOut(150);
	});
	
	a.click(function(){
		$("html, body").animate({
			scrollTop : 0
		}, 300);
	});
});