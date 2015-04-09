function userSearchLayout() {
	Ecp.components.globalView = new Ecp.GlobalView('userMain');

	var userSearchGrid = new Ecp.UserSearchGrid();
	
	var userMainWidgetToolBar=new Ecp.UserMainWidgetToolBar();
	
	userMainWidgetToolBar.setWidgetEvent({
		addUser:showAddUserWin,
        editUser:showEditUserWin,
        delUser:clickDelBtn,
        setCheckType:showSetUserWin,
        unLockUser:clickUnLockBtn,
        downloadUser:clickDownloadBtn
	}); 
	userSearchGrid.setToolBar(userMainWidgetToolBar.render());

	userSearchGrid.setWidgetEvent({
		grid : {
//			rowclick : disableGridToolBar,
//			rowdblclick : showEditUserWin
		}
	});
	Ecp.components.userSearchGrid = userSearchGrid;

	var userSearchForm = new Ecp.UserSearchForm();
	Ecp.components.userSearchForm=userSearchForm;

	Ecp.UserSearchPanel = function(form, grid) {
		var panel = new Ext.Panel({
			border : false,
			frame : true,
			anchor : '100% 100%',
			layout : 'border',
			items : [form,grid]
		});
		return panel;
	}
	
	var userSearchPane = new Ecp.UserSearchPanel(userSearchForm.render(),userSearchGrid.render());

	Ecp.components.globalView.addModuleComp(userSearchPane);
	Ecp.components.globalView.render(TXT.user_edit); 

};

Ecp.onReady(userSearchLayout);