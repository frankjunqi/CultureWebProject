/**
 * 页面初始化 
 */
jQuery(document).ready(function() {    

   App.init(); // initlayout and core plugins
   
   loadProductType();

});
/**
 * 加载种类
 */
function loadProductType(){
	//TODO 获取当前用户Id
	
	var operId = "";
	$.ajax({
		type:"POST", 
		url:"http://127.0.0.1:8080/lxyweb/productType/getRootProductType.ajax",
        data:{operId:operId
        		},
		success:function(msg){
			$.each(msg,function(i,v){
				$("#product_sub-menu").append("<li><a href="+ v.typeName +".html>"+ v.typeValue +"</a></li>");
			});
		},
		error:function(msg){
		}
	});
	
}
