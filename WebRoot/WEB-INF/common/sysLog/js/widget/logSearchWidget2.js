Ecp.LogSearchGrid = function() {
	var reqType = '';

	Ecp.ServiceGrid.call(this);
	this.defaultStoreConfig = {
		url : ECP_DISPATCH_SERVLET_URL + '/ecsLogQueryAction/findPage',
		root : 'logInfos',
		totalProperty : 'totalCount',
		id : 'id',
		fields : [{
			name : 'occurTime'
		}, {
			name : 'lanId'
		}, {
			name : 'auditDesc'
		}, {
			name : 'EntityId'
		}, {
			name : 'tableFlag'
		}]
	};

	this.defaultCmConfig = [{
		header : '<center>' + TXT.log_lanId + '</center>',
		dataIndex : 'lanId',
		menuDisabled : true,
		sortable : false,
		width : 130
	}, {
		header : '<center>' + TXT.log_data + '</center>',
		dataIndex : 'occurTime',
		menuDisabled : true,
		sortable : false,
		width : 150
	}, {
		header : '<center>' + TXT.log_discription + '</center>',
		dataIndex : 'auditDesc',
		menuDisabled : true,
		sortable : false,
		width : 670
	}, {
		header : '<center>' + TXT.log_entityId + '</center>',
		dataIndex : 'EntityId',
		menuDisabled : true,
		sortable : false,
		width : 100
	}];

	this.defaultGridConfig = {
		title : TXT.messageProcess_result,
		id : 'LogSearchGrid',
		pagination : true,
		margins : '5 0 0 0',
		stripeRows : true,
		columnLines : true,
		region : 'center'
	};
	

}

Ecp.extend(Ecp.LogSearchGrid.prototype, new Ecp.ServiceGrid());

Ecp.LogSearchGridToolbar = function() {
	Ecp.ServiceToolbar.call(this);
	this.defaultToolBarConfig = {
		id : 'logSearchGridToolbar'
	};
	this.defaultToolBarItemConfig = [totalToolBarItem.downloadLog];
}
var actTy = new Ext.data.SimpleStore({
	fields : [ 'label','value' ],
	data : [['用户管理','EcsUserMaintAction'],
			['机构管理','EcsBranchMaintAction'],
			['登入登出','EcsLoginAction']]
});
Ecp.LogSearchForm = function() {
	Ecp.ServiceForm.call(this);
	this.config = {
		title : '<b>' + TXT.log_search + '</b>',
		height : 125,
		labelWidth : 65,
		region : 'north',
		layout : 'column',
		frame : true
	};


	this.items = [{
		columnWidth : .31,
		border : false,
		defaultType : 'textfield',
		layout : 'form',
		defaults : {
			anchor : '90%'
		},
		items : [{
			xtype : 'datefield',
			fieldLabel : TXT.common_time_start,
			editable : true,
			id : 'fromDate',
			name : 'fromDate',
			tabIndex : 1,
			vtype : 'daterange',
			endDateField :'toDate',
			allowBlank : false,
			format : 'Y-m-d'
		}, {
			xtype : 'combo',
			editable : true,
			fieldLabel : TXT.log_operator_type,
			id : 'actionType',
			name : 'actionType',
			tabIndex : 2,
			store :actTy,
			forceSelection : true,
			displayField : 'label',
			valueField : 'value',
			mode : 'local',
			triggerAction : 'all',
			selectOnFocus : true,
			value: 'EcsUserMaintAction'
		}]
	}, {
		columnWidth : .31,
		border : false,
		defaultType : 'textfield',
		layout : 'form',
		defaults : {
			anchor : '90%'
		},
		items : [{
			xtype : 'datefield',
			fieldLabel : TXT.common_time_end,
			editable : true,
			id : 'toDate',

			tabIndex : 1,
			name : 'toeDate',
			vtype : 'daterange',
			startDateField :'fromDate',
			allowBlank : false,
			format : 'Y-m-d'
		},{
			xtype : 'hidden',
			name : 'businessType',
			id : 'businessType',
			value: 'hardCode_hid'
		}]
	}, {
		columnWidth : .31,
		border : false,
		defaultType : 'textfield',
		layout : 'form',
		defaults : {
			anchor : '90%'
		},
		items : [{
			fieldLabel : TXT.log_lanId,
			tabIndex : 1,
			id : 'lanId',
			name : 'lanId',
			regex : /^[A-Za-z0-9]*$/,
			maxLength:22,
			regexText : TXT.user_name_err
		}]
	}];
	this.buttons = [{
		xtype : 'button',
		text : TXT.common_query,
		iconCls : 'icoFind',
		tabIndex : 3,
		handler : clickLogSearchBtn,
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

Ecp.extend(Ecp.LogSearchForm.prototype, new Ecp.ServiceForm());

Ecp.extend(Ecp.LogSearchGridToolbar.prototype, new Ecp.ServiceToolbar());
