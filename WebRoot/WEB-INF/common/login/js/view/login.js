function loginLayout(){
	Ecp.components.globalView=new Ecp.GlobalView('login',true);
	var loginWin = Ecp.LoginWindow.createLoginWindow({});
	var win=loginWin.window;
	
	win.on('show', function(){
		var f = loginWin.getItem(1).formPanel.items.itemAt(0);
		f.focus.defer(100, f); 
	});
	win.addListener('render',function(){
		Ext.EventManager.addListener(this.el,'keyup',function(evt){
			if(evt.getKey()=='13'){
				clickLoginBtn(this);
			}
		},this);
	});
	
	win.show();

	Ecp.components.globalView.render(TXT.login_title);
	resizeDiv();
};
var resizeDiv = function(){
	if( Ecp.LoginWindow && Ecp.LoginWindow.loginWindow )
		 Ecp.LoginWindow.loginWindow.window.center();
	var waringDiv = document.getElementById('waring');
	var loginDiv = document.getElementById('loginWin');
	if( loginDiv ){
		waringDiv.style.width = loginDiv.style.width;
		waringDiv.style.left = loginDiv.style.left;
		waringDiv.style.top = (loginDiv.offsetHeight + loginDiv.offsetTop + 30) + 'px';
	}
}
Ext.onReady(loginLayout);
