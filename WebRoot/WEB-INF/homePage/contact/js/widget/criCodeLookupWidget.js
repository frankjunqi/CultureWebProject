Ecp.DictionaryGrid=function(){
	Ecp.ServiceGrid.call(this);
	this.defaultStoreConfig={
		url:ECP_DISPATCH_SERVLET_URL,
		root:'items',
		idProperty:'id',
		fields:[
				{name: 'id'},
				{name: 'version'},
			    {name: 'type'},
			    {name: 'description'},
			    {name: 'processStatus'},
			    {name: 'modifyBy'},
				{name: 'modifyOn'},
				{name: 'authorizerBy'},
				{name: 'authorizerOn'}
			   ]
	};
	
	this.defaultStoreConfig.baseParams={
		cmd:'cricodelookupAction',
		action:'find'
	};
	this.defaultCmConfig=[   
			{
				header : '<center>' + TXT.common_select + '</center>',
				align : 'center',
				dataIndex : 'id',
				menuDisabled : true,
				width : 70,
				renderer : function(value) {
					return '<input id="radio_' + value + '" type="radio" name="123"></input>';
				}
			},
			{header:TXT.dictionary_type,dataIndex: 'type',menuDisabled: true,width:120},
			{header:TXT.dictionary_status,	dataIndex:'processStatus',menuDisabled: true,width:120,
				renderer : function(value){
					return TXT.codeLookup_processStatus[value];
				}
			},
			{header:TXT.common_description,dataIndex: 'description',menuDisabled: true,width:120},
			{header:TXT.common_modifyBy,dataIndex:'modifyBy',menuDisabled: true,width:120},
			{header:TXT.common_modifyOn,dataIndex:'modifyOn',menuDisabled: true,width:120},
			{header:TXT.common_auditerBy,dataIndex:'authorizerBy',menuDisabled: true,width:120},
			{header:TXT.common_auditerOn,dataIndex:'authorizerOn',menuDisabled: true,width:120}
	];
	
	this.defaultGridConfig={
		title: TXT.data_Dictionary,
		id:'dictionaryGrid',
		region :'center',
		stripeRows :true,
		pagination:true
	};
}

Ecp.DictionaryGrid.prototype.reload=function(){
	this.dataStore.store.reload();
}

Ecp.DictionaryGrid.prototype.search = function(params) {
	if (this.grid['pagination'] != null) {
		params['start'] = 0;
		params['limit'] = PAGE_SIZE;
	}
	this.dataStore.store['baseParams'] = params;
	this.dataStore.store.load(params);
}
 
Ecp.extend(Ecp.DictionaryGrid.prototype, new Ecp.ServiceGrid());

Ecp.DictionaryGridToolbar=function(){
	Ecp.ServiceToolbar.call(this);
	this.defaultToolBarConfig={
		id:'dictionaryGridToolbar'
	};
}
Ecp.extend(Ecp.DictionaryGridToolbar.prototype,new Ecp.ServiceToolbar());

Ecp.DictionaryQueryForm=function()
{
	Ecp.ServiceForm.call(this);
	this.config={
			title:'<b>' + TXT.dictionary_query + '</b>',
			labelAlign: 'left',
			region: 'north',
			labelWidth:100,
			height : 120,
		    margins:'0 0 5 0',
			cmargins:'0 0 5 0',
		    layout:'column',
			frame:true
	};
	this.items=[{
			columnWidth:.33,
			layout: 'form',
			defaultType: 'textfield',
	        defaults:{anchor:'95%'},
	        items : [{
					width:220,
					id : 'type',
					name : 'type',
					maxLength : 100,
					fieldLabel:TXT.dictionary_type,
					allowBlank:true
				},{
					xtype : 'datefield',
	                fieldLabel: TXT.modify_on_start,
	                id : 'timeStart',
	                name : 'timeStart',
	                format: 'Y-m-d',
	                editable: false,
	                allowBlank: true,
	                blankText: TXT.dictionary_choose_date,
	                vtype : 'daterange',
	        		endDateField :'timeEnd'
	            }]
		},{
			columnWidth:.34,
			layout: 'form',
			defaultType: 'textfield',
	        defaults:{anchor:'95%'},
	        items : [{
				xtype : 'combo',
				fieldLabel :TXT.dictionary_status,
				id :'statue',
				name :'statue', 
				store : criCodeLookupStatus,
				forceSelection :true,
				displayField :'value',
				valueField :'label',
				mode :'local',
				triggerAction :'all',
				editable : true,
				selectOnFocus :true,
				allowBlank:true,
				width:220
			},{
				xtype : 'datefield',
                fieldLabel: TXT.modify_on_end ,
                format: 'Y-m-d',
                id : 'timeEnd',
                name : 'timeEnd',
                editable: false,
                allowBlank: true,
                blankText:TXT.dictionary_choose_date,
                vtype : 'daterange',
				startDateField :'timeStart'
	        }]
		},{
			columnWidth:.33,
			layout: 'form',
			defaultType: 'textfield',
	        defaults:{anchor:'95%'},
	        items : [{
					width:220,
					id : 'description',
					name : 'description',
					maxLength : 200,
					fieldLabel:TXT.dictionary_description,
					allowBlank:true
				}]
		}];
		this.buttons=[{
						text : TXT.common_query,
						handler : clickSearchDicBtn,
						iconCls:'icoFind',
						scope:this
					},{
						text : TXT.common_reset,
						handler : clickResetDicBtn,
						iconCls : 'icoReset',
						scope:this
					}];
}
Ecp.extend(Ecp.DictionaryQueryForm.prototype,new Ecp.ServiceForm());

Ecp.DictionaryForm=function()
{
	Ecp.ServiceForm.call(this);
	this.config={
			labelAlign: 'left',
			region: 'north',
			defaultType: 'textfield',
			labelWidth:80,
			height:80,
		    margins:'0 0 5 0',
			cmargins:'0 0 5 0',
		    layout:'form',
			frame:true
	};
	this.items=[{
				xtype : 'textfield',
				fieldLabel :TXT.common_status,
				id :'type',
				name :'type', 
				maxLength : 200,
				disabled : true,
				width:220
		},{
			width:220,
			id : 'description',
			name : 'description',
			maxLength : 400,
			fieldLabel:TXT.common_description
		}];
}
Ecp.extend(Ecp.DictionaryForm.prototype,new Ecp.ServiceForm());
Ecp.DicDataGrid=function(){
	Ecp.ServiceGrid.call(this);
	
	this.defaultStoreConfig={
		url:ECP_DISPATCH_SERVLET_URL,
		idProperty:'id',
		fields:[{name: 'id'},
		        {name: 'name'},
			    {name: 'value'} ]
	};
	this.defaultStoreConfig.baseParams={
			cmd:'cricodelookupAction',
			action:'getCriCodeLookupById'
		};
	this.defaultCmConfig=[{header:TXT.dictionary_name,
							dataIndex:'name',
							menuDisabled: true,
							width:100,
							allowBlank : false,
							editor:{
								xtype: 'textfield'
//								listeners : {
//								change : function(id, values) {
//									nameChange(id, values);
//								}
//							}
							}},
	                      {header:TXT.dictionary_value,
							dataIndex:'value',
							menuDisabled: true,
							width:150,
							allowBlank : false,
							editor:{
								xtype: 'textfield'
//								listeners : {
//		              			change : function(id, values) {
//		              				valueChange(id, values);
//		              			}
//		              		}
							}}];
	
	this.defaultGridConfig={
		id:'dicDataGrid',
		region :'center',
		stripeRows :true,
		title:TXT.dictionary_data,
		type:'edit',
		selType: 'cellmodel'
	};
	this.defaultSelModel=2;
}

Ecp.DicDataGrid.prototype.addRecord=function(){
	this.dataStore.store.add([new Ext.data.Record()]);
}
Ecp.DicDataGrid.prototype.validate=function(){
	var records=this.dataStore.store.getRange();
	for(var i=0;i<records.length;i++)
	{
		if(records[i].data['name']==null||records[i].data['value']==null){
			Ecp.MessageBox.alert(TXT.codeLookup_need_require);
			return false;
		}
	}
	return true;
}

Ecp.DicDataGrid.prototype.loadData = function(params){
	this.dataStore.store['baseParams'] = params;
	this.dataStore.store.load(params);
}
Ecp.extend(Ecp.DicDataGrid.prototype, new Ecp.ServiceGrid());

Ecp.DicDataGrid.prototype.delRecord=function(){
	this.dataStore.store.removeAt(this.grid.getSelected()[0]);
}
Ecp.extend(Ecp.DicDataGrid.prototype,new Ecp.ServiceGrid());

Ecp.DicDataGridToolbar=function(){
	Ecp.ServiceToolbar.call(this);
	this.defaultToolBarConfig={
		id:'dicDataGridToolbar'
	};
}
Ecp.extend(Ecp.DicDataGridToolbar.prototype,new Ecp.ServiceToolbar());

Ecp.DictionaryWindow=function(){
	Ecp.ServiceWindow.call(this);
	this.config={
		    title:TXT.data_Dictionary,
	        width:400,
	        height:400,
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
}

Ecp.DictionaryWindow.createWindow=function(callbackFun){
	var dictionaryForm=new Ecp.DictionaryForm();
	Ecp.components.dictionaryForm = dictionaryForm;
	if(callbackFun && callbackFun['formFun'] && typeof callbackFun['formFun']=='function')
		dictionaryForm.handleWidgetConfig(callbackFun['formFun']);
	var dicDataGrid=new Ecp.DicDataGrid();
	Ecp.components.dicDataGrid = dicDataGrid;
	if(callbackFun && callbackFun['gridFun'] && typeof callbackFun['gridFun']=='function')
		if (callbackFun['type']!='repair') {
			dicDataGrid.defaultSelModel=1;
			dicDataGrid.defaultCmConfig=[{header:TXT.dictionary_name,dataIndex:'name',menuDisabled: true,width:100},
			                             {header:TXT.dictionary_value,dataIndex:'value',menuDisabled: true,width:150}];
		}else {
			dicDataGrid.setWidgetEvent({
				grid:{
					beforeedit : unEditDicData
				}
			});
		}
		dicDataGrid.handleWidgetConfig(callbackFun['gridFun']);
	var dicDataGridToolbar=new Ecp.DicDataGridToolbar();
	Ecp.components.dicDataGridToolbar = dicDataGridToolbar;
	if (callbackFun['type']=='repair') {
		dicDataGridToolbar.defaultToolBarItemConfig=[totalToolBarItem.clickDicDataAddBtn,totalToolBarItem.clickDicDataDelBtn];
		dicDataGridToolbar.setWidgetEvent({
			clickDicDataAddBtn:clickDicDataAddBtn,
			clickDicDataDelBtn:clickDicDataDelBtn
		});
	}
	dicDataGrid.setToolBar(dicDataGridToolbar.render());
	var dictionaryWindow = new Ecp.DictionaryWindow();
	Ecp.components.dictionaryWindow = dictionaryWindow;
	dictionaryWindow.handleWidgetConfig(function(obj){
		if(callbackFun && callbackFun['winFun'] && typeof callbackFun['winFun']=='function')
			if (callbackFun['type']=='repair'){
				dictionaryWindow.buttons=[{
								text:TXT.common_commit,
				  				handler : clickCommitDictionarybtn,
				  				iconCls:'icoAccept'
				  			},{
				  				text :TXT.dictionary_btnClose,
				  				iconCls : 'icoReject',
				  				handler : function() {
				  					this['ecpOwner'].window.close();
				  				}
				  	}];
			}else{
			dictionaryWindow.buttons=[{
										id : 'clickDicDataCheckBtn',
										name : 'clickDicDataCheckBtn',
						  				text :TXT.common_approve,
						  				handler : clickDicDataCheckBtn,
						  				iconCls:'icoAccept'
						  			},{
						  				id : 'clickDicRejectBtn',
										name : 'clickDicRejectBtn',
						  				text :TXT.common_reject,
						  				handler : clickDicRejectBtn,
						  				iconCls:'icoReject'
						  			}];
			}
			dictionaryWindow.handleWidgetConfig(callbackFun['winFun']);
		dictionaryWindow.items=[dictionaryForm.render(),dicDataGrid.render()];
	});
	dictionaryWindow.render();
	return dictionaryWindow.window;
}
Ecp.extend(Ecp.DictionaryWindow.prototype,new Ecp.ServiceWindow());