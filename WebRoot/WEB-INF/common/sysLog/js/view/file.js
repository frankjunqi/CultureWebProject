function fileLayout() {
	Ecp.components.globalView = new Ecp.GlobalView('file');
	// grid
	var fileGrid = new Ecp.FileSearchGrid();
	var fileGridToolbar=new Ecp.FileSearchGridToolbar();
	fileGrid.setWidgetEvent({
		grid : {
			rowclick : showFileContent
		}
	});
	fileGridToolbar.setWidgetEvent({
		downloadFile:downloadFile,
		deleteFile:deleteFile,
		uploadFile:clickUploadWin
	});

	var fileForm = new Ecp.FileSearchForm();
	
	Ecp.components.FileSearchGrid = fileGrid;
	Ecp.components.FileSearchForm = fileForm;

	fileGrid.setToolBar(fileGridToolbar.render());
	//main form
	var htm = "<iframe id='fileContent' frameBorder=0 width=100% height=100% src='../jsp/file.jsp'></iframe>";
	var vPanel = new Ext.Panel({
   	 	id : 'textpanel',
   	 	title : '内容',
		region : 'east',
		margins : '5 0 0 5',
		autoScroll : true,
		split : true,
		minSize : 600,
		maxSize : 1000,
		width : '70%',
   	 	border : true,
   	 	html:htm,
		bodyStyle : {
			background : '#DFE8F6',
			padding : '7px'
		}
	});
	
	var cpanel = new Ext.Panel({
				border : false,
				region : 'north',
				layout : 'border',
		 		anchor : '100% 83%',
				items : [fileGrid.render(), vPanel]
			});
	var panel = new Ext.Panel({
		border : false,
		region : 'center',
		layout : 'anchor',
		margins : '0 5 5 5',
		items : [ fileForm.render(), cpanel ]
	});
	Ecp.components.globalView.addModuleComp(panel);
	Ecp.components.globalView.render('文件管理');
};

Ecp.onReady(fileLayout);