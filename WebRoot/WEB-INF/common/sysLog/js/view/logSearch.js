function logSearchLayout() {
	Ecp.components.globalView = new Ecp.GlobalView('logSearch');
	// grid
	var logSearchGrid = new Ecp.LogSearchGrid();
	var logSearchGridToolbar=new Ecp.LogSearchGridToolbar();
	logSearchGridToolbar.setWidgetEvent({
		downloadLog:downloadLog
	});

	var logSearchForm = new Ecp.LogSearchForm();
	
	Ecp.components.LogSearchGrid = logSearchGrid;
	Ecp.components.LogSearchForm = logSearchForm;
	
	logSearchGrid.setToolBar(logSearchGridToolbar.render());
	//main form
	var panel = new Ext.Panel({
				border : false,
				region : 'center',
				layout : 'border',
				items : [logSearchForm.render(), logSearchGrid.render()]
			});
	
	Ecp.components.globalView.addModuleComp(panel);
	Ecp.components.globalView.render(TXT.log_search);
};

Ecp.onReady(logSearchLayout);