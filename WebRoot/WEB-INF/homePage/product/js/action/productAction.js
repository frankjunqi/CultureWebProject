/**
 * product model init
 */
function initProduct(){
	$.ajax({  
        url:"http://127.0.0.1:8080/lxyweb/initWebSite/productPageInitAction.ajax" , 
        type:"POST", 
        dataType:"json",
        data:{page:"home"},    
        success:function(data){
        	var newsList = data.newsList;
        	var productList = data.productList;
        	$.each(newsList,function(i,v){
        		$("#foolderImageShow").html(" <li class=featureBox><div class=box> <a href='12'>" +
        				"<img src='../../../public/homePage/images/cpzs_07_11381.jpg'  width='157' height='105' /></a><!-- /box --></li>" +
        				"<li class=featureBox><div class=box> <a href='12'>" +
        				"<img src='../../../public/homePage/images/cpzs_07_11381.jpg'  width='157' height='105' /></a><!-- /box --></li>" +
        				"<li class=featureBox><div class=box> <a href='12'>" +
        				"<img src='../../../public/homePage/images/cpzs_07_11381.jpg'  width='157' height='105' /></a><!-- /box --></li>" +
        				"<li class=featureBox><div class=box> <a href='12'>" +
        				"<img src='../../../public/homePage/images/cpzs_07_11381.jpg'  width='157' height='105' /></a><!-- /box --></li>" +
        				"<li class=featureBox><div class=box> <a href='12'>" +
        				"<img src='../../../public/homePage/images/cpzs_07_11381.jpg'  width='157' height='105' /></a><!-- /box --></li>");
			});
       }  
   });  
}

function productChange(){
	$("#productButton").click(function(){
		$("#all").hide();
		$("#zipper").hide();
		$("#button").show();
	});
	$("#productZipper").click(function(){
		$("#all").hide();
		$("#button").hide();
		$("#zipper").show();
	});
}