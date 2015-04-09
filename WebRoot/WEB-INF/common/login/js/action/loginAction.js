function clickLoginButton() {
	
	var userName = $("#userName").val();
	var password = $("#password").val();
	
	$.ajax({  
        url:"http://127.0.0.1:8080/lxyweb/common/user/login.ajax" , 
        type:"POST", 
        data:{password:password,
    		  userName:userName},   
        success:function(data){  
             if("success" == data){
            	 window.location.href = "../../../common/stageDoor/common/home/html/homepage.html"
             }else if("failed == data"){
            	 alert("用户名或密码错误!");
             }
        }  
	});
}