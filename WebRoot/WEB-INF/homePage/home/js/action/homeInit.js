$(document).ready(function(){
	
//	loadCompSummary();
	getNewContent();
	//setNewContentScoller();
});

function getNewContent(){
	$.ajax({  
        url:"http://127.0.0.1:8080/lxyweb/initWebSite/homePageInitAction.ajax" , 
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

//function loadCompSummary(){
//    $.post("http://127.0.0.1:8080/lxyweb/product/getImgPaths.ajax", null,  
//        function(map){    
//	         var info = '';   
//	         $.each(map,function(key,values) {   
//	               info += "key="+key+"<br>";  
//	               $(values).each(function(){        
//	                       info += "姓名: " + this.name+",年龄: " + this.age + ",地址: " + this.address + ",性别: " + (this.sex == 1 ? "男" : "女")+",密码: " + this.password+"<br>";  
//	                    });      
//	             });  
//        });  
//}