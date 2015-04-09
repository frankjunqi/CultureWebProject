//toolbar define
Ecp.UserMainWidgetToolBar=function(){
	Ecp.ServiceToolbar.call(this);
	this.defaultToolBarItemConfig = [
	                                 totalToolBarItem.addUser,
	                                 totalToolBarItem.editUser,
	                                 totalToolBarItem.delUser,
	                                 totalToolBarItem.setCheckType,
	                                 totalToolBarItem.unLockUser,
	                                 totalToolBarItem.downloadUser
	                               ];
	this.defaultToolBarConfig={
			id:'userMainWidgetToolBar'
	};
}
Ecp.extend(Ecp.UserMainWidgetToolBar.prototype,new Ecp.ServiceToolbar()); 

Ecp.BranchStore = function(selectAll, form, additional, field, value, callback){
	if( !field )
		field = 'branchId';
	if( !value )
		value = curBranch;
	Ecp.ServiceDataStore.call(this);
	this.defaultStoreConfig={
			url:ECP_DISPATCH_SERVLET_URL,
			listeners : {
				load : function() {
					if( Ecp.manulCheck ){
						Ecp.manulCheck += 1;
					} else {
						Ecp.manulCheck = 1;
					}
					if( selectAll ){
						var newRecord = new Ext.data.Record({
							branchCode : '',
							shortName : TXT.common_all,
							longName : TXT.common_all,
							englishName : TXT.common_all,
							id : ''
						});
						this.insert(0, newRecord);
					}
					if( callback ){
	        			callback.call(null);
	        		}
				}
			},
			fields:[
			        {name: 'branchCode'},
			        {name: 'id'},
			        {name: 'shortName'},
			        {name: 'longName'},
			        {name: 'englishName'}]
	};
	this.baseParams={
			cmd:'ecsBranchMaintAction',
			action:'findAllBranch'
	};
	
	if( additional ){
		Ext.apply(this.baseParams, additional);
	}
}
Ecp.extend(Ecp.BranchStore.prototype,new Ecp.ServiceDataStore());

//search Form
Ecp.UserSearchForm = function(){
	Ecp.ServiceForm.call(this); 
	this.branchStore = new Ecp.BranchStore(true, this).render();
	this.branchStore['ecpOwner']['ecpOwner'].load();
	delete this.config.defaultType;
	this.delimitedManner = null;
	this.config={ 
			padding : 10,
			height : 160,
			labelWidth : 60, 
			labelAlign : 'right',
			region : 'north',
			height : 155,
			title : TXT.userMain_query,
			frame:true
	};
	
	var statusStore = new Ext.data.SimpleStore({
		fields: ['name','value'],
		data: [
		       [TXT.common_all,''],
		       [TXT.userStatus_LOCKED,'LOCKED'],
		       [TXT.userStatus_NORMAL,'ZA']
		       ]
	});

	this.buttons=[{
		xtype : 'button',
		text : TXT.common_query,
		width : 100,
		iconCls:'icoFind',
		handler : clickSearchBtn,
		scope:this
	},{ 
		xtype : 'button',
		width : 100,
		handler : resetForm,
		text :TXT.common_reset,
		iconCls : 'icoReset',
		scope:this
	}]; 
	this.items=[{
		layout : 'column',
		items: [{
			columnWidth : .333,
			layout : 'form',
			defaultType : 'textfield',
			defaults : {
				anchor : '90%'
			},
			items : [{
				fieldLabel : TXT.user_name,
				width:130,
				id : 'lanId',
				name : 'lanId',
				maxLength : 40,
				tabIndex:1
			},{
				fieldLabel : TXT.user_cName,
				width:130,
				id : 'userName',
				name : 'userName',
				maxLength : 40,
				tabIndex:4
			},{ 
				fieldLabel : TXT.user_englishName,
				width:130,
				id : 'englishName',
				name : 'englishName',
				maxLength : 250,
				tabIndex:7
			}]
		},{
			columnWidth : .333,
			layout : 'form',
			defaultType : 'textfield',
			defaults : {
				anchor : '90%'
			},
			items : [{ 
				xtype:'combo',
				fieldLabel : TXT.log_message_branch,
				store : this.branchStore, 
				displayField : 'shortName',
				forceSelection : true,
				value : '',
				valueField : 'id',
				width : 130,
				mode : 'local',  
				triggerAction : 'all',
				selectOnFocus : true,
				id : 'branchId',
				name : 'branchId',
				tabIndex : 5
			},{ 
				xtype:'combo',
				fieldLabel : TXT.user_role,
				editable:true,
				store : new Ext.data.JsonStore({
					url : ECP_DISPATCH_SERVLET_URL,
					baseParams : {
						cmd : 'ecsRoleMaintAction',
						action : 'getAllRole'
					},
					listeners : {
						load : function() {
							var newRecord = new Ext.data.Record({
								displayName : TXT.common_all,
								id : null
							});
							this.insert(0, newRecord);
						}
					},
					fields : [{
						name : 'displayName'
					},{
						name : 'id'
					}]
				}),
				displayField:'displayName',
				forceSelection : true,
				valueField: 'id',
				width:130,
//				typeAhead: true, 
				mode: 'remote',  
				triggerAction: 'all',
				selectOnFocus: true,
				id : 'role',
				name : 'role'
			}]
		},{
			columnWidth : .333,
			layout : 'form',
			defaultType : 'textfield',
			defaults : {
				anchor : '90%'
			},
			items : [{
				xtype : 'textfield',
				fieldLabel : TXT.user_oper,
				id : 'operId',
				name : 'operId',
				maxLength : 20
			},{ 
				xtype:'combo',
				fieldLabel : TXT.user_status,
				editable:true,
				forceSelection : true,
				store:statusStore, 
				displayField:'name',
				valueField: 'value',
				width:130,
				value : '',
				typeAhead: true, 
				mode: 'local',  
				triggerAction: 'all',
				selectOnFocus: true,
				id : 'processStatus',
				name : 'processStatus',
				tabIndex:2
			}]
		}]
	}];
}

Ecp.extend(Ecp.UserSearchForm.prototype, new Ecp.ServiceForm());

//search Grid
Ecp.UserSearchGrid=function(){
	Ecp.ServiceGrid.call(this); 
	this.defaultStoreConfig={
			url:ECP_DISPATCH_SERVLET_URL+'/ecsUserMainAction/query',
			root :'items',
			id : 'id',
			totalProperty :'totalCount',
			fields:[
			        {name: 'id'},
			        {name: 'lanId'},
			        {name: 'userName'},
			        {name: 'operId'},
			        {name: 'version'},
			        {name: 'loginIpAddress'},
			        {name: 'processStatus'},
			        {name: 'branch.shortName'},
			        {name: 'englishName'},
			        {name: 'email'},
			        {name: 'createBy'},
			        {name: 'makerBy'}
			        ]
	};

	this.defaultCmConfig = [{
		header : TXT.user_oper,
		dataIndex : 'operId',
		menuDisabled : true,
		sortable: true,
		width : 80
	}, {
		header : TXT.user_name,
		dataIndex : 'lanId',
		menuDisabled : true,
		width : 100
	}, {
		header : TXT.user_cName,
		dataIndex : 'userName',
		menuDisabled : true,
		width : 100
	}, {
		header : TXT.user_englishName,
		dataIndex : 'englishName',
		menuDisabled : true,
		width : 100
	}, {
		header : TXT.log_message_branch,
		dataIndex : 'branch.shortName',
		menuDisabled : true,
		width : 100
	}, {
		header : TXT.user_email,
		dataIndex : 'email',
		menuDisabled : true,
		width : 100
	},{
		header : TXT.user_status,
		dataIndex : 'processStatus',
		menuDisabled : true,
		width : 80,
		renderer:function(val){
			return TXT['userStatus_' + val]; 
		}
	},{
		header : TXT.common_createBy,
		dataIndex : 'createBy',
		menuDisabled : true,
		width : 80
	},{
		header : TXT.common_modifyBy,
		dataIndex : 'makerBy',
		menuDisabled : true,
		width : 80
	}];

	this.defaultGridConfig = { 
			title:TXT.userMain_result,
			id : 'userSearchGrid', 
			pagination : true,
			margins : '5 0 0 0',
			width:'92%',
			region : 'center',
			autoScroll :true,
			anchor : '100% 77%',
			stripeRows : true
	};

}
Ecp.extend(Ecp.UserSearchGrid.prototype, new Ecp.ServiceGrid());
Ecp.UserSearchGrid.prototype.show = function(params) {
	this.dataStore.store['baseParams'] = params;
	this.dataStore.store.load({
		params : {
			start : 0,
			limit : PAGE_SIZE
		}
	});
}
Ecp.UserSearchGrid.prototype.load = function(obj){
	this.dataStore.store['baseParams'] = params;
	this.dataStore.store.load();
}
Ecp.UserSearchGrid.prototype.reload = function(params) {
	this.dataStore.store.reload();
}
Ecp.UserSearchGrid.prototype.search=function(params){
	if(this.grid['pagination']!=null)
	{
		params['start']=0;
		params['limit']=PAGE_SIZE;
	}
	this.dataStore.store['baseParams']=params;
	this.dataStore.store.load(params);
}

Ecp.RoleGrid=function(){
	Ecp.ServiceGrid.call(this);
	this.defaultSelModel = 2;
	this.defaultStoreConfig={
			url:ECP_DISPATCH_SERVLET_URL+'/ecsRoleMaintAction/queryForUser',
			fields:[
					{name: 'id'},
				    {name: 'roleName'},
				    {name: 'longDesc'},
				    {name: 'checkStatus'}
			        ],
			listeners : {
				load : function(){
					var data = this.data;
					for(var i = 0;i < data.length;i ++){
						if(data.items[i].data.checkStatus){
							Ecp.components.roleGrid.grid.selectRow(i,true);
						}
					}
					setTimeout(function(){
						Ecp.components.roleGrid.grid.grid.view.refresh();
					},100)
				}
			}
	};
	
	this.defaultCmConfig=[{
		header : TXT.role_roleName,
		dataIndex : 'roleName',
		menuDisabled : true,
		sortable: true,
		width : 250
	}, {
		header : TXT.role_roleDesc,
		dataIndex : 'longDesc',
		menuDisabled : true,
		width : 250
	}, {
		hidden : true,
		dataIndex : 'checkStatus'
//		renderer : function(a,b,c,d){
//			if(a){
//				Ecp.components.roleGrid.grid.selectRow(d,true);
//			}
//		}
	}];

	this.defaultGridConfig = {
			title : TXT.user_roleSet,
			id : 'roleGrid', 
//			margins : '5 0 0 0',
			region : 'center',
			height : 225,
			width : "100%",
//			autoScroll : true,
			stripeRows : true
	};
}
Ecp.extend(Ecp.RoleGrid.prototype, new Ecp.ServiceGrid());
Ecp.RoleGrid.prototype.load = function(params){
	this.dataStore.store['baseParams'] = params;
	this.dataStore.store.load();
}

selectBranchStore = new Ecp.BranchStore(false, this).render();
selectBranchStore['ecpOwner']['ecpOwner'].load();

var branchCloneData = {};

Ecp.UserInfoForm=function(){
	if(selectBranchStore.data){
		branchCloneData = selectBranchStore.data.clone();
	}else{
		selectBranchStore.data = branchCloneData.clone();
	}
	Ecp.ServiceForm.call(this);
	this.config={
		id: "userInfoForm",
		frame:true,
		labelWidth:80,
//		labelAlign: 'left',
		region: 'north',
		autoHeight: true,
		margins:'0 0 5 0'
	};
	this.items=[{
		layout : 'column',
		items: [{
			columnWidth : .333,
			layout : 'form',
			defaultType : 'textfield',
			defaults : {
				anchor : '90%'
			},
			items : [{
				fieldLabel : TXT.user_name,
				width:130,
				id : 'lanId',
				name : 'lanId',
				allowBlank : false,
				maxLength : 40
			},{
				xtype : 'textfield',
				fieldLabel : TXT.user_oper,
				id : 'operId',
				name : 'operId',
				allowBlank : false,
				maxLength : 10
			}]
		},{
			columnWidth : .333,
			layout : 'form',
			defaultType : 'textfield',
			defaults : {
				anchor : '90%'
			},
			items : [{
				fieldLabel : TXT.user_cName,
				width:130,
				id : 'userName',
				name : 'userName',
				maxLength : 40
			},{ 
				xtype:'combo',
				fieldLabel : TXT.log_message_branch,
				id : 'branchId',
				name : 'branchId',
				store : selectBranchStore, 
				displayField : 'shortName',
				forceSelection : true,
				valueField : 'id',
				width : 130,
				mode : 'local',  
				triggerAction : 'all',
				selectOnFocus : true,
				allowBlank : false
			}]
		},{
			columnWidth : .333,
			layout : 'form',
			defaultType : 'textfield',
			defaults : {
				anchor : '90%'
			},
			items : [{ 
				fieldLabel : TXT.user_englishName,
				width:130,
				id : 'englishName',
				name : 'englishName',
				maxLength : 50
			},{ 
				fieldLabel : TXT.user_email,
				width:130,
				id : 'email',
				name : 'email',
				regex : /^(\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*)(,\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*)*$/,
				maxLength : 100,
				allowBlank : false
			}]
		}]
	}];
}
Ecp.extend(Ecp.UserInfoForm.prototype,new Ecp.ServiceForm());

Ecp.UserInfoWindow=function(){
	Ecp.ServiceWindow.call(this);
	this.config = {
		title : TXT.user_edit,
		width : 600,
		height : 430,
		autoScroll : false,
		hideBorders : true,
		border : false,
		minimizable : false,
		maximizable : false,
		resizable : false,
//		layout : 'border',
		modal : true,
		layoutConfig : {
			animate : false
		},
		buttonAlign : 'center'
	};
	this.buttons = [ {
		text : TXT.common_save,
		tabIndex : 6,
		handler : function() {
			this['ecpOwner'].window.close();
		}
	}, {
		text : TXT.common_close,
		tabIndex : 7,
		handler : function() {
			this['ecpOwner'].window.close();
		}
	} ];
}
Ecp.extend(Ecp.UserInfoWindow.prototype, new Ecp.ServiceWindow());

Ecp.UserCheckType = function(){
	return new Ext.Panel({
		title : TXT.comp_checkType,
//		width : 600,
		height : 100,
		region : 'south',
		frame : true,
		border : true,
		items : [{
			layout : 'column',
			items :[{
				columnWidth : .25,
				anchor : '100%',
				defaultType : 'checkbox',
				items : [{
					id : 'ON',
					checked : false,
					name : 'ON',
					boxLabel : TXT.userCheckType.ON
				},{
					id : 'OFF',
					checked : false,
					name : 'OFF',
					boxLabel : TXT.userCheckType.OFF
				}]
				
			},{
				columnWidth : .25,
				anchor : '90%',
				defaultType : 'checkbox',
				items : [{
					id : 'IA',
					checked : false,
					name : 'IA',
					boxLabel : TXT.userCheckType.IA
				},{
					id : 'CO',
					checked : false,
					name : 'CO',
					boxLabel : TXT.userCheckType.CO
				}]
				
			},{
				columnWidth : .25,
				anchor : '90%',
				defaultType : 'checkbox',
				items : [{
					id : 'SI',
					checked : false,
					name : 'SI',
					boxLabel : TXT.userCheckType.SI
				},{
					id : 'EX',
					checked : false,
					name : 'EX',
					boxLabel : TXT.userCheckType.EX
				}]
				
			},{
				columnWidth : .25,
				anchor : '90%',
				defaultType : 'checkbox',
				items : [{
					id : 'SC',
					checked : false,
					name : 'SC',
					boxLabel : TXT.userCheckType.SC
				},{
					id : 'OTHER',
					checked : false,
					name : 'OTHER',
					boxLabel : TXT.userCheckType.OTHER
				}]
				
			}]
		}]
	});
}

Ecp.UserInfoWindow.createNewWindow=function(callbackFun){
	var userForm=new Ecp.UserInfoForm();
	Ecp.components.userInfoForm = userForm;
	// grid
	var roleGrid=new Ecp.RoleGrid();
	Ecp.components.roleGrid = roleGrid;
	// window
	var userInfoWin = new Ecp.UserInfoWindow();
	userInfoWin.handleWidgetConfig(function(obj){
		if(callbackFun && callbackFun['winFun'] && typeof callbackFun['winFun'] == 'function'){
			userInfoWin.handleWidgetConfig(callbackFun['winFun']);
		}
	});
	userInfoWin.items=[userForm.render(), roleGrid.render()];
	userInfoWin.render();
	return userInfoWin.window;
}

Ecp.UserInfoWindow.createWindow=function(callbackFun){
	var userForm=new Ecp.UserInfoForm();
	Ecp.components.userInfoForm = userForm;
	// grid
	var roleGrid=new Ecp.RoleGrid();
	Ecp.components.roleGrid = roleGrid;
	//panel
	var checkTypePanel = new Ecp.UserCheckType();
	Ecp.components.checkTypePanel = checkTypePanel;
	// window
	var userInfoWin = new Ecp.UserInfoWindow();
	userInfoWin.handleWidgetConfig(function(obj){
		if(callbackFun && callbackFun['winFun'] && typeof callbackFun['winFun'] == 'function'){
			userInfoWin.handleWidgetConfig(callbackFun['winFun']);
		}
	});
	userInfoWin.items=[userForm.render(), roleGrid.render(),checkTypePanel];
	userInfoWin.render();
	return userInfoWin.window;
}

Ecp.SearchUserWindow=function(){
	Ecp.ServiceWindow.call(this);
	this.config={
		    title:TXT.userMain_query,
	        width:800,
	        height:480,
	        autoScroll :false,
	        layout:'border',
	        border:false,
	        minimizable: false,
	        maximizable: false,
	        resizable: false,
	        modal:true,
			layoutConfig: {animate:false},
			buttonAlign: 'center'
	};
	this.buttons=[{
				text :TXT.common_ok,
				handler : function(btn,t) {
				}
			},
			{
				text :TXT.common_close,
				handler : function() {
					this['ecpOwner'].window.close();
				}
			}];
}

Ecp.SearchUserWindow.createWindow=function(fun){
	var searchUserForm = new Ecp.UserSearchForm();
	searchUserForm.buttons[0].handler = clickWinSearchBtn;
	if(fun && fun['formFun'] && typeof fun['formFun']=='function')
		searchUserForm.handleWidgetConfig(fun['formFun']);
	var searchUserGrid = new Ecp.UserSearchGrid();
	searchUserGrid.defaultSelModel=2;
	if(fun && fun['gridFun'] && typeof fun['gridFun']=='function')
		searchUserGrid.handleWidgetConfig(fun['gridFun']);
	var win = new Ecp.SearchUserWindow();
	if(fun && fun['winFun'] && typeof fun['winFun']=='function')
			win.handleWidgetConfig(fun['winFun']);
	win.items=[searchUserForm.render(),searchUserGrid.render()];
	Ecp.components._searchUserMultiChoiceGrid=searchUserGrid;
	searchUserGrid.show();
	win.render();
	return win.window;
}

Ecp.extend(Ecp.SearchUserWindow.prototype,new Ecp.ServiceWindow());


