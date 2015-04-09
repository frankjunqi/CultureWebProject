Ecp.FileSearchGrid = function() {
	Ecp.ServiceGrid.call(this);
	this.defaultStoreConfig = {
		url : ECP_DISPATCH_SERVLET_URL + '/FileUtilAction/find',
		root : 'fileInfos',
		totalProperty : 'totalCount',
		id : 'id',
		fields : [{
			name : 'fileName'
		}, {
			name : 'filePath'
		}, {
			name : 'suffix'
		}]
	};

	this.defaultCmConfig = [{
		header : '<center>' + TXT.common_file_name + '</center>',
		dataIndex : 'fileName',
		menuDisabled : true,
		sortable : false,
		width : 250
	}];

	this.defaultGridConfig = {
		title : TXT.messageProcess_result,
		id : 'FileSearchGrid',
		pagination : true,
		margins : '5 0 0 0',
		stripeRows : true,
		columnLines : true,
		region : 'center'
	};
}
Ecp.extend(Ecp.FileSearchGrid.prototype, new Ecp.ServiceGrid());

Ecp.FileSearchGridToolbar = function() {
	Ecp.ServiceToolbar.call(this);
	this.defaultToolBarConfig = {
		id : 'fileSearchGridToolbar'
	};
	this.defaultToolBarItemConfig = [totalToolBarItem.downloadFile,
	                                 totalToolBarItem.deleteFile,
	                                 totalToolBarItem.uploadFile];
}
Ecp.extend(Ecp.FileSearchGridToolbar.prototype, new Ecp.ServiceToolbar());

Ecp.FileSearchForm = function() {
	Ecp.ServiceForm.call(this);
	this.config = {
		title : '<b>文件查找 </b>',
		height : 100,
		labelWidth : 65,
		region : 'north',
		layout : 'column',
		frame : true
	};
	this.items = [{
		columnWidth : .8,
		border : false,
		defaultType : 'textfield',
		layout : 'form',
		defaults : {
			anchor : '90%'
		},
		items : [{
			fieldLabel : '路径',
			tabIndex : 1,
			allowBlank : false,
			id : 'filePath',
			name : 'filePath'
		}]
	}];
	this.buttons = [{
		xtype : 'button',
		text : TXT.common_query,
		iconCls : 'icoFind',
		tabIndex : 3,
		handler : clickFileSearchBtn,
		scope : this
	}, {
		xtype : 'button',
		handler : resetForm,
		tabIndex : 4,
		text : TXT.common_reset,
		iconCls : 'icoReset',
		scope : this
	}]
}
Ecp.extend(Ecp.FileSearchForm.prototype, new Ecp.ServiceForm());

Ecp.FileUploadForm = function() {
	Ecp.ServiceForm.call(this);
	this.config = {
		labelAlign : 'left',
		region : 'center',
		defaultType: 'form',
		labelWidth : 100,
		margins : '0 0 5 0',
		cmargins : '0 0 5 0',
		layout : 'form',
		fileUpload : true,
		frame : true
	};

	this.items = [{
		xtype : 'textfield',
		fieldLabel : TXT.common_file_name,
		name : 'uploadfile',
		id : 'uploadfile',
		width : 350,
		maxLength : 500,
		inputType : 'file',
		defaults : {
			anchor : '90%'
		}
	} ];
}
Ecp.extend(Ecp.FileUploadForm.prototype, new Ecp.ServiceForm());

Ecp.FileUploadWindow = function() {
	Ecp.ServiceWindow.call(this);
	this.config = {
		title : TXT.common_file_upload ,
		width : 500,
		height : 120,
		autoScroll : false,
		layout : 'border',
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
		text : TXT.common_ok,
		handler : uploadFile
	}, {
		text : TXT.common_cancel,
		handler : function() {
			this['ecpOwner'].window.close();
		}
	} ];
}
Ecp.extend(Ecp.FileUploadWindow.prototype, new Ecp.ServiceWindow());

Ecp.FileUploadWindow.createWindow = function(callbackFun) {
	var fileUploadForm = new Ecp.FileUploadForm();
	if (callbackFun && callbackFun['formFun']
			&& typeof callbackFun['formFun'] == 'function') {
		fileUploadForm.handleWidgetConfig(callbackFun['formFun']);
	}
	var fileUploadWindow = new Ecp.FileUploadWindow();
	fileUploadWindow.handleWidgetConfig(function(obj) {
		if (callbackFun && callbackFun['winFun']
				&& typeof callbackFun['winFun'] == 'function')
			fileUploadWindow.handleWidgetConfig(callbackFun['winFun']);
		fileUploadWindow.items = [ fileUploadForm.render() ];
	});
	fileUploadWindow.render();
	return fileUploadWindow.window;
}
