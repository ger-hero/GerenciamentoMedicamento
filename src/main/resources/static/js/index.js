$(window).scroll(function() {
	var max = 0.7; //Valor inicial, que também deve ser ajustado no css
	var opacity = max * (1 - $(this).scrollTop() / $(window).height());
	
	$('header-home').css('opacity', opacity);

});