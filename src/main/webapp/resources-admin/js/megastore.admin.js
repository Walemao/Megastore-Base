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
	})
});