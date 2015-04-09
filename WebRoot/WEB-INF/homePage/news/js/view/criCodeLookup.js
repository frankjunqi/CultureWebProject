Ecp.components.globalView=new Ecp.GlobalView('dictionary');
function dictionaryLayout(){
	var dictionaryQueryForm=new Ecp.DictionaryQueryForm();
	Ecp.components.dictionaryQueryForm=dictionaryQueryForm;
	var dictionaryGrid=new Ecp.DictionaryGrid();
	Ecp.components.dictionaryGrid=dictionaryGrid;
	var dictionaryForm = new Ecp.DictionaryForm();
	Ecp.components.dictionaryForm = dictionaryForm;
	var dicDataGrid = new Ecp.DicDataGrid();
	Ecp.components.dicDataGrid = dicDataGrid;
	var dictionaryGridToolbar=new Ecp.DictionaryGridToolbar();
	dictionaryGridToolbar.defaultToolBarItemConfig=[totalToolBarItem.clickDicRepairBtn];
	dictionaryGridToolbar.setWidgetEvent({
		clickDicRepairBtn:clickDicRepairBtn
	});
	dictionaryGrid.setWidgetEvent({
		grid:{
			rowclick:gridSelect,
			rowdblclick:dblEditDicWin
		}
	});
	dictionaryGrid.setToolBar(dictionaryGridToolbar.render());
	var mainForm = new Ext.Panel({
				border : false,
				region : 'center',
				layout : 'border',
				items : [dictionaryQueryForm.render(),dictionaryGrid.render()]
	});
	Ecp.components.globalView.addModuleComp(mainForm);
	Ecp.components.globalView.render(TXT.data_management);
};
Ecp.onReady(dictionaryLayout);
