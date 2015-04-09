var clickDicCheckBtn = function(){
	var grid = Ecp.components.dictionaryGrid.grid.getSelectedRecord();
	if (!grid){
		return;
	}
	Ecp.DictionaryWindow.createWindow({
		'formFun':function(obj){
			Ecp.components.dictionaryForm = obj;
		},
		'winFun':function(obj){
			Ecp.components.seqInfoWin=obj;
		},
		'gridFun' : function(obj) {
			Ecp.components.dicDataGrid = obj;
		}
	}).show();
	var statue = grid.processStatus;
	if (TXT.common_processStatus_value.MUR == statue || TXT.common_processStatus_value.ZA == statue) {
		Ecp.components.dictionaryWindow.window.window.buttons[0].disable();
		Ecp.components.dictionaryWindow.window.window.buttons[1].disable();
	}
	showData();
	loadData();
}

var showData = function(){
	var record = Ecp.components.dictionaryGrid.grid.getSelectedRecord()
	Ecp.components.dictionaryForm.form.setValues(record);
}

var loadData = function(){
	var params = {};
	var id = Ecp.components.dictionaryGrid.grid.getSelectedId();
	params['cmd'] = "cricodelookupAction";
	params['action'] = "getCriCodeLookupById";
	params['kind'] = 'check';
	params['id'] = id;
	Ecp.components.dicDataGrid.loadData(params);
}

var selectChangeShowGridData = function(id,values){
	var params = {};
	var statue =  Ecp.components.dictionaryForm.form.findFieldById('statue').value;
	var type = Ecp.components.dictionaryGrid.grid.getSelectedRecord().type;
	params['cmd'] = "cricodelookupAction";
	params['action'] = "getDictionaryByType";
	params['statue'] = statue;
	params['type'] = type;
	Ecp.components.dicDataGrid.loadData(params);
}

var dblEditDicWin = function(){
	clickDicCheckBtn();
}
var clickSearchDicBtn = function(){
	var form = Ecp.components.dictionaryQueryForm.form;
	if (form.isValid()) {
		var params = form.getValues();
		params['cmd'] = "cricodelookupAction";
		params['action'] = "find";
		params['kind'] = "check";
		Ecp.components.dictionaryGrid.search(params);
	}
}
var clickResetDicBtn = function(){
	Ecp.components.dictionaryQueryForm.form.reset();
}

var clickDicDataCheckBtn = function(){
	var dicDataList = Ecp.components.dicDataGrid.getData();
	var id = Ecp.components.dictionaryGrid.grid.getSelectedId();
	var params={
			cmd : 'cricodelookupAction',
			action :  'checkCode',
			id : id,
			dicDataList : dicDataList
	};
	Ecp.Ajax.request(params, function(result) {
		if (result['message'] != null && result['message'] != '') {
			Ecp.MessageBox.alert(TXT.common_message_approve_success);
			Ecp.components.dictionaryWindow.close();
			Ecp.components.dictionaryGrid.dataStore.store.reload();
		}else {
			Ecp.MessageBox.alert(TXT.common_access_fail);
		}
	})
}

var clickDicRejectBtn = function(){
	var dicDataList = Ecp.components.dicDataGrid.getData();
	var id = Ecp.components.dictionaryGrid.grid.getSelectedId();
	var params={
			cmd : 'cricodelookupAction',
			action :  'rejectCode',
			id : id,
			dicDataList : dicDataList
	};
	Ecp.Ajax.request(params, function(result) {
		if (result['message'] != null && result['message'] != '') {
			Ecp.MessageBox.alert(TXT.common_message_reject_success);
			Ecp.components.dictionaryWindow.close();
			Ecp.components.dictionaryGrid.dataStore.store.reload();
		}else {
			Ecp.MessageBox.alert(TXT.common_access_fail);
		}
	})
}

/**
 * radio选择
 */
var gridSelect = function()
{
	var values = disableRow();
	if(values == null)
	{
		return;
	}
	
	var id = values['id'];
	Ext.getDom('radio_' + id).checked = true;
}

//选择行，读取该行数据
var disableRow = function(){
	var grid = Ecp.components.dictionaryGrid.grid;
	if(grid.getSelectedCount() == 0){
		return null;
	}
	return Ecp.components.dictionaryGrid.grid.getSelectedRecord(); 
}

