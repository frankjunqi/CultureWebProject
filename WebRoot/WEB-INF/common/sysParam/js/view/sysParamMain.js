Ecp.components.globalView = new Ecp.GlobalView('sysParamMain');

function ParamMsgLayout() {
	var paramMainForm = new Ecp.ParamMainForm();
	var paramMainGrid = new Ecp.ParamMainGrid();
	var paramMainToolbar = new Ecp.ParamGridToolbar();
	
	paramMainToolbar.setWidgetEvent({
		addParamMain:showAddSysParaWin,
		editParamMain:showEditSysParaWin,
		delParamMain:clickDelSysParaBtn,
		downLoadParam:downLoadParam
	})
	paramMainGrid.setToolBar(paramMainToolbar.render());
	
	paramMainGrid.setWidgetEvent({
		grid : {
			rowdblclick : showEditSysParaWin
		}
	})
	
	var panel=new Ext.Panel({
		border :false,
		layout:'border',
		items:[paramMainGrid.render(), paramMainForm.render()]
	});

	Ecp.components.globalView.addModuleComp(panel);

	Ecp.components.globalView.render(TXT.paramMain_sysParameterManage);
	Ecp.components.paramMainForm = paramMainForm;
	Ecp.components.paramMainGrid = paramMainGrid;
//	paramMainGrid.show();
};

Ecp.onReady(ParamMsgLayout);
