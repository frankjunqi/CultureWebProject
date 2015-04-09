Ecp.ParamMainGrid = function() {
	Ecp.ServiceGrid.call(this);
	this.defaultStoreConfig = {
		url : ECP_DISPATCH_SERVLET_URL,
		root : 'sysParamMain',
		idProperty : 'id',
		fields : [{
			name : 'id'
		}, {
			name : 'version'
		}, {
			name : 'paraName'
		}, {
			name : 'paraValue'
		}, {
			name : 'paraDesc'
		}, {
			name : 'processStatus'
		}, {
			name : 'createBy'
		}, {
			name : 'createOn'
		}, {
			name : 'modifyBy'
		}, {
			name : 'modifyOn'
		}, {
			name : 'makerBy'
		}, {
			name : 'makerOn'
		},{
			name :'systemPara'
		}]
	};
	this.defaultCmConfig = [{
			header : '<center>' + TXT.paramMain_paramName + '</center>',
			dataIndex : 'paraName',
			id : 'paraName',
			menuDisabled : true,
			width : 180
		},
		{
			header : '<center>' + TXT.paramMain_paramValue + '</center>',
			dataIndex : 'paraValue',
			id : 'paraValue',
			menuDisabled : true,
			width : 250
		},
		{
			header : '<center>' + TXT.paramMain_paramDescription + '</center>',
			dataIndex : 'paraDesc',
			id : 'paraDesc',
			menuDisabled : true,
			width : 150
		},
		{
			header : '<center>' + TXT.paramMain_isSystemPara + '</center>',
			dataIndex : 'systemPara',
			id : 'systemPara',
			renderer:function(value){
				if(value==false){						
					return TXT.common_no;						
				}else if(value==true){						
					return TXT.common_yes;
				}
			},
			menuDisabled : true,
			width : 100
		},
		{
			header : '<center>' + TXT.common_makerBy + '</center>',
			dataIndex : 'makerBy',
			id : 'makerBy',
			menuDisabled : true,
			width : 100
		},
		{
			header : '<center>' + TXT.common_makerOn + '</center>',
			dataIndex : 'makerOn',
			id : 'makerOn',
			align : 'right',
			menuDisabled : true,
			width : 90
		}];

	this.defaultStoreConfig.baseParams = {
		cmd : 'sysParamMainAction',
		action : 'findSysParamMana'
	};

	this.defaultGridConfig = {
		title : TXT.paramMain_sysParameterManage_info,
		margins : '5 0 0 0',
		id : 'paramMainGrid',
		region : 'center',
		columnLines : true,
		stripeRows : true
	};
}
Ecp.extend(Ecp.ParamMainGrid.prototype, new Ecp.ServiceGrid());

Ecp.ParamMainGrid.prototype.show = function(params) {
	this.dataStore.store['baseParams'] = params;
	this.dataStore.store.load({
		params : {
			start : 0,
			limit : PAGE_SIZE
		}
	});
}

Ecp.ParamMainGrid.prototype.load = function(obj){
	this.dataStore.store['baseParams'] = params;
	this.dataStore.store.load();
}

Ecp.ParamMainGrid.prototype.reload = function(params) {
	this.dataStore.store.reload();
}

// 查询条件 form
Ecp.ParamMainForm = function() {
	// 调用基类的构造函数
	Ecp.ServiceForm.call(this);
	// from配置信息
	this.config = {
		title : '<b>'+TXT.paramMain_sysParameterManage_query+'</b>',
		id : 'paramMainForm',
		labelAlign : 'center',
		frame : true,
		autoHeight : true,
		width : '100%',
		region : 'north',
		layout : 'column',
		labelWidth : 60
	};
	this.items = [ {
		columnWidth : .3,
		border : false,
		defaultType : 'textfield',
		layout : 'form',
		labelAlign : 'center',
		align : 'center',
		defaults : {
			anchor : '90%'
		},
		items : [ {
			id : 'paraName',
			name : 'paraName',
			fieldLabel : TXT.paramMain_paramName,
			forceSelection : true,
			displayField : 'paraName',
			tabIndex : 1,
			valueField : 'paraName',
			typeAhead : true,
			mode : 'local',
			triggerAction : 'all',
			selectOnFocus : true,
			editable : false
		} ]
	}, {
		columnWidth : .3,
		border : false,
		defaultType : 'textfield',
		layout : 'form',
		labelAlign : 'center',
		align : 'center',
		defaults : {
			anchor : '90%'
		},
		items : [ {
			id : 'paraValue',
			name : 'paraValue',
			fieldLabel : TXT.paramMain_paramValue,
			forceSelection : true,
			displayField : 'paraValue',
			valueField : 'paraValue',
			typeAhead : true,
			mode : 'local',
			tabIndex : 1,
			triggerAction : 'all',
			selectOnFocus : true,
			editable : false
		} ]
	} ];

	this.buttons = [ {
		text : TXT.common_query,
		width : 80,
		tabIndex : 3,
		iconCls : 'icoFind',
		handler : clickSearchBtn
	}, {
		text : TXT.common_reset,
		width : 80,
		tabIndex : 4,
		iconCls : 'icoReset',
		handler : resetForm
	} ];
}
Ecp.extend(Ecp.ParamMainForm.prototype, new Ecp.ServiceForm());

Ecp.ParamGridToolbar = function() {
	Ecp.ServiceToolbar.call(this);
	this.defaultToolBarConfig = {
		id : 'ParamGridToolbar'
	};
	this.defaultToolBarItemConfig = [ 
		totalToolBarItem.addParamMain,
		totalToolBarItem.editParamMain, 
		totalToolBarItem.delParamMain,
		totalToolBarItem.downLoadParam];
}
Ecp.extend(Ecp.ParamGridToolbar.prototype, new Ecp.ServiceToolbar());

// 添加参数信息的form
Ecp.SysParaInfoForm = function() {
	Ecp.ServiceForm.call(this);

	this.config = {
		id : "sysParaInfoForm",
		frame : true,
		labelWidth : 50,
		defaults : {
			border : false,
			bodyStyle : 'padding:8px 0 0 0;',
			layout : 'form',
			labelWidth : 80
		},
		autoHeight : true
	};

	this.items = [ {
		defaultType : 'textfield',
		items : [ {
			id : 'paraName',
			name : 'paraName',
			fieldLabel : TXT.paramMain_paramName,
			width : 300,
			tabIndex : 1,
			allowBlank : false,
			maxLength : 60,
			maxLengthText : TXT.paramMain_paramName_regex_info
		} ]
	}	, {
		defaultType : 'textfield',
		items : [ {
			id : 'paraValue',
			name : 'paraValue',
			width : 300,
			fieldLabel : TXT.paramMain_paramValue,
			allowBlank : false,
			maxLength : 500,
			tabIndex : 1,
			maxLengthText : TXT.paramMain_paramValue_regex_info
		} ]
	}, {
		defaultType : 'textarea',
		items : [ {
			id : 'paraDesc',
			name : 'paraDesc',
			fieldLabel : TXT.paramMain_paramDescription,
			allowBlank : true,
			width : 300,
			tabIndex : 1,
			maxLength : 80,
			maxLengthText : TXT.paramMain_paramDesc_regex_info
		} ]
	} ]
}
Ecp.extend(Ecp.SysParaInfoForm.prototype, new Ecp.ServiceForm());

// sysParam的window
Ecp.SysParaInfoWindow = function() {
	Ecp.ServiceWindow.call(this);
	this.config = {
		title : TXT.paramMain_sysParameterManage_add,
		width : 450,
		autoScroll : false,
		hideBorders : true,
		border : false,
		minimizable : false,
		maximizable : false,
		resizable : false,
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

Ecp.SysParaInfoWindow.createWindow = function(callbackFun) {
	var sysParaInfoForm = new Ecp.SysParaInfoForm();
	if (callbackFun && callbackFun['formFun']
			&& typeof callbackFun['formFun'] == 'function') {
		sysParaInfoForm.handleWidgetConfig(callbackFun['formFun']);
	}
	var sysParaInfoWindow = new Ecp.SysParaInfoWindow();
	sysParaInfoWindow.handleWidgetConfig(function(obj) {
		if (callbackFun && callbackFun['winFun']
				&& typeof callbackFun['winFun'] == 'function')
			sysParaInfoWindow.handleWidgetConfig(callbackFun['winFun']);
		sysParaInfoWindow.items = [ sysParaInfoForm.render() ];
	});
	sysParaInfoWindow.render();
	return sysParaInfoWindow.window;
}

// 继承基类
Ecp.extend(Ecp.SysParaInfoWindow.prototype, new Ecp.ServiceWindow());
