/**
 * Login form
 */
Ecp.LoginForm=function()
{
	Ecp.ServiceForm.call(this);
	this.config={
			id: 'loginForm',
			baseCls: 'x-plain',
			height:150,
			width:100,
			labelAlign: 'right',
			defaultType: 'textfield',
			bodyStyle: "padding-left:50px;padding-top:30px;",
			frame: false,
			labelWidth:100,
			region: 'south'
	};
	
	var storeDomain = new Ext.data.Store({
		proxy : new Ext.data.HttpProxy({
			url : ECP_DISPATCH_SERVLET_URL+'/loginAction/getDomainList'
		}),
		reader : new Ext.data.JsonReader({
			idProperty : 'description',
			fields: [{name : 'id'}, {name : 'code'}, {name : 'description'}]
		}),
		listeners : {
			'load' : function(){
				var fpcsDomain = Ecp.CookieHelper.getCookieValue('fpcsDomain');
				if( fpcsDomain && this.getById( fpcsDomain ) )
					Ecp.temp_Domain.setValue( fpcsDomain );
			}
		}
	});
	
	storeDomain.load();

	this.items=[{
		fieldLabel: '<b>'+TXT.user_name+'</b>',
		id:'username',
		listeners : {
			'render' : function(){
				var fpcsUserName = Ecp.CookieHelper.getCookieValue('fpcsUserName');
				if( fpcsUserName )
					this.setValue( fpcsUserName );
			}
		},
		name: 'username',
		allowBlank:false,
		cls:'login-username',
		tabIndex : 1,
		width:200
	},
	{
		inputType: 'password',
		fieldLabel: '<b>'+TXT.user_passwd+'</b>',
		id:'password',
		cls:'login-password',
		name: 'password',
		allowBlank:false,
		tabIndex : 2,
		width:200
	},{
		fieldLabel : '<b>'+TXT.user_domain+'</b>',
		xtype:'combo', 
		editable:false, 
		width:200, 
		id: 'domain',
		name: 'domain',
		cls:'login-domain',
		store: storeDomain,
		listeners : {
			'render' : function(){
				Ecp.temp_Domain = this;
			}
		},
		forceSelection:false,
		displayField:'description',
		valueField: 'description',
		typeAhead: true,
		allowBlank:false,
		mode: 'local',  
		triggerAction: 'all',
		selectOnFocus:true 
	}];
	this.buttons=[];
}


Ecp.extend(Ecp.LoginForm.prototype, new Ecp.ServiceForm());

Ecp.LoginForm.prototype.handleWidgetConfig=function(handler)
{
	handler(this);
}

Ecp.LoginForm.prototype.customization=function(obj)
{
	if(obj.config!=null)
		this.config=obj.config;
	if(obj.buttons!=null)
		this.buttons=obj.buttons;
	if(obj.items!=null)
		this.items=obj.items;
}

Ecp.LoginForm.prototype.render=function()
{
	this.form=new Ecp.FormPanel();
	this.form.init();
	var obj={};
	obj['config']=this.config;
	obj['buttons']=this.buttons;
	obj['items']=this.items;
	this.form.customization(obj);
	this.form['ecpOwner']=this;
	return this.form.render();
}

/**
 * Login window
 */
Ecp.LoginWindow=function()
{
	this.window=null;
	this.config={
			id: 'loginWin',
			defaultButton: 'btnLogin',
			layout: 'border',
			width:550,
			height:275,
			title:'<b>'+'CRI系统---'+TXT.login_title+'</b>',
			closeAction:'hide',
			closable:false,
			plain: false,
			draggable: false,
			resizable: false
	};
	this.buttons=[
	              {
	            	  id: 'btnLogin',
	            	  text: '<b>'+TXT.login_title+'</b>',
	            	  iconCls:'login',
	            	  handler:function(){
	            		  clickLoginBtn(this);
	            	  }

	              }];
	this.items=[];
}

Ecp.LoginWindow.prototype.handleWidgetConfig=function(handler)
{
	handler(this);
}

Ecp.LoginWindow.prototype.customization=function(obj)
{
	if(obj.config!=null)
		this.config=obj.config;
	if(obj.buttons!=null)
		this.buttons=obj.buttons;
}

Ecp.LoginWindow.prototype.render=function()
{
	this.window=new Ecp.Window();
	this.window.init();
	var winObj={};
	winObj['config']=this.config;
	winObj['buttons']=this.buttons;
	winObj['items']=this.items;
	this.window.customization(winObj);
	this.window['ecpOwner']=this;
	return this.window.render();
}
var leftPanel = new Ext.Panel({
    id: "leftPanel",
    bodyStyle: "padding-top:10px;padding-left:10px; background-image: url(../images/loginLogo.gif) ; ",
    baseCls: 'x-plain',
	region: 'center'
});
Ecp.LoginWindow.prototype.getItem=function(index)
{
	return this.window.getItem(index);
}

Ecp.LoginWindow.loginWindow=null;

Ecp.LoginWindow.createLoginWindow=function(windowObj){
	if(!Ecp.LoginWindow.loginWindow)
	{
		var logoPanel = new Ext.Panel({
			baseCls: 'x-plain',
			region: 'center'
		});
	
		var loginForm=new Ecp.LoginForm();

		if(windowObj['items'] && windowObj['items'][0])
			loginForm.customization(windowObj['items'][0]);

		// window
		var loginWindow = new Ecp.LoginWindow();
		loginWindow.handleWidgetConfig(function(obj){
			obj.items=[leftPanel,loginForm.render()];
		});
		loginWindow.customization(windowObj);
		loginWindow.render();
		Ecp.LoginWindow.loginWindow=loginWindow.window;
	}
	return Ecp.LoginWindow.loginWindow;
}

