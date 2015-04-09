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
			fieldLabel : TXT.log_business_type,
			id : 'businessType',
			name : 'businessType',
			store : new Ext.data.JsonStore({
				url : ECP_DISPATCH_SERVLET_URL,
				root : 'message',
				baseParams : {
					cmd : 'ecsLogTypeAction',
					action : 'findAll'
				},
				listeners : {
					load : function() {
						var newRecord = new Ext.data.Record({
							businessTypeCn : TXT.common_all,
							businessType : ''
						});
						if(this.getTotalCount()>0){
							this.insert(0, newRecord);
						}
					}
				},
				fields : [{
					name : 'businessType'
				}, {
					name : 'businessTypeCn'
				}]
			}),
			forceSelection : true,
			displayField : 'businessTypeCn',
			valueField : 'businessType',
			mode : 'remote',
			triggerAction : 'all',
			tabIndex : 2,
			selectOnFocus : true,
			listeners : {
				select : function() {
					var actionType = Ecp.components.LogSearchForm.form.findFieldById('actionType');
					actionType.store.removeAll();
					actionType.clearValue();
					if (this.value != '') {
						actionType.store.reload({
							params : {
								businessType : this.value
							}
						});
					}
				}
			}
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
		}, {
			xtype : 'combo',
			editable : true,
			fieldLabel : TXT.log_operator_type,
			id : 'actionType',
			name : 'actionType',
			tabIndex : 2,
			store : new Ext.data.JsonStore({
				url : ECP_DISPATCH_SERVLET_URL,
				root : 'message',
				idProperty: 'actionType',
				baseParams : {
					cmd : 'ecsLogTypeAction',
					action : 'findByBusinessType'
				},
				listeners : {
					load : function() {
						if(this.getTotalCount()>0){
							var newRecord = new Ext.data.Record({
							actionTypeCn : TXT.common_all,
							actionType : ''
						});
						this.insert(0, newRecord);
						}
					}
				},
				fields : [{
					name : 'actionType'
				}, {
					name : 'actionTypeCn'
				}]
			}),
			forceSelection : true,
			displayField : 'actionTypeCn',
			valueField : 'actionType',
			mode : 'local',
			triggerAction : 'all',
			selectOnFocus : true
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
