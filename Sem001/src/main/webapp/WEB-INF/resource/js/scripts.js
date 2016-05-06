$(document).ready(function(){ 
	randomBannerItem('.banners-nav');
	randomBannerItem('.banners-top');
	randomBannerItem('.banners-bottom');
});	

function randomBannerItem(name){
	var max = $(name + ' .item').length - 1;
	var rand = Math.floor(Math.random() * (max + 1));
	$(name + ' .item').eq(rand).addClass('active');
}