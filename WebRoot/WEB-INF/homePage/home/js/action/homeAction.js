function loginAdminAction(){
	window.open ('../../../../common/login/html/login.html', 'newwindow', 'height=100, width=400, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no')
}

function login(){
	$.ajax({  
        url:"http://127.0.0.1:8080/lxyweb/initWebSite/homePageInitAction.ajax" , 
        type:"POST", 
        success:function(data){  
             
        }  
   });  
}

function createCompDetailWindow(){
	OpenWindow = window.open ('../../aboutus/html/aboutus.html','newwindow');
}