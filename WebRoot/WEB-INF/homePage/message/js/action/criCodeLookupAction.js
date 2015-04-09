var clickDicRepairBtn = function(){
	var grid = Ecp.components.dictionaryGrid.grid;
	var records = Ecp.components.dictionaryGrid.grid.getSelectedRecords();
	var length = records.length;
	if (length != 1){
		Ecp.MessageBox.alert(TXT.common_selectOneRecord);
		return;
	}
	Ecp.DictionaryWindow.createWindow({
		'formFun':function(obj){
			Ecp.components.dictionaryForm = obj;
		},
		'winFun':function(obj){
			Ecp.components.dictionaryWin=obj;
		},
		'gridFun' : function(obj) {
			Ecp.components.dicDataGrid = obj;
		},
		'type' : 'repair'
	}).show();
	var statue = grid.getSelectedRecord().processStatus;
	if (TXT.codeLookup_processStatus_AU == statue) {
		Ecp.components.dicDataGridToolbar.toolBar.toolBar.findById('clickDicDataAddBtn').setDisabled(true);
		Ecp.components.dicDataGridToolbar.toolBar.toolBar.findById('clickDicDataDelBtn').setDisabled(true);
		Ecp.components.dictionaryWindow.window.window.buttons[0].disable();
	}
	
	showData();
	loadData();
}

var showData = function(){
	var record = Ecp.components.dictionaryGrid.grid.getSelectedRecord();
	Ecp.components.dictionaryForm.form.setValues(record);
}


var loadData = function(){
	var params = {};
	var grid = Ecp.components.dictionaryGrid.grid;
	var id = grid.getSelectedId();
	var statue = grid.getSelectedRecord().processStatus;
	params['cmd'] = "cricodelookupAction";
	params['action'] = "getCriCodeLookupById";
	params['kind'] = 'repair';
	params['id'] = id;
	params['statue'] = statue;
	Ecp.components.dicDataGrid.loadData(params);
}

var dblEditDicWin = function(){
	clickDicRepairBtn();
}
var clickSearchDicBtn = function(){
	var form = Ecp.components.dictionaryQueryForm.form;
	if(!form.isValid()){
		return ;
	}
	if (form.isValid()) {
		var params = form.getValues();
		params['cmd'] = "cricodelookupAction";
		params['action'] = "find";
		Ecp.components.dictionaryGrid.search(params);
	}
}
var clickResetDicBtn = function(){
	Ecp.components.dictionaryQueryForm.form.reset();
}

var clickCommitDictionarybtn = function(){
	var form = Ecp.components.dictionaryForm.form;
	if(!form.isValid()){
		return ;
	}
	var records=Ecp.components.dicDataGrid.dataStore.store.getRange();
	for ( var i = 0; i < records.length; i++) {
		var value = records[i].data.value;
		var name = records[i].data.name;
		if(name && value){
			for(var j = i + 1;j < records.length &&  records[j].data.value &&  records[j].data.name; j++){
				if(value.toLowerCase() == records[j].data.value.toLowerCase() 
						|| name.toLowerCase() == records[j].data.name.toLowerCase()){
					Ecp.MessageBox.alert(TXT.report_noRepeat_balnk);
					return;
				}
			}
		}else{
			Ecp.MessageBox.alert(TXT.report_noRepeat_balnk);
			return;
		}
	}
	var discription = form.getValues().description;
	var dicDataList = Ecp.components.dicDataGrid.getData();
	var id = Ecp.components.dictionaryGrid.grid.getSelectedId();
	var type = Ecp.components.dictionaryGrid.grid.getSelectedRecord().type;
	var params={
			cmd : 'cricodelookupAction',
			action :  'saveOrUpdate',
			id : id,
			type : type,
			discription : discription,
			dicDataList : dicDataList
	};
	Ecp.Ajax.request(params, function(result) {
		if (result['message'] != null && result['message'] != '') {
			var msg = result['message'];
			var resultMsg = TXT.report_msg_info[msg];
			Ecp.MessageBox.alert(resultMsg);
			Ecp.components.dictionaryWin.close();
			Ecp.components.dictionaryGrid.dataStore.store.reload();
		}else {
			Ecp.MessageBox.alert(TXT.common_access_fail);
		}
	})
}

var clickDicDataAddBtn = function(btn, e) {
	Ecp.components.dicDataGrid.addRecord(new Ext.data.Record());
}

var unEditDicData = function(a){
	var records=Ecp.components.dicDataGrid.dataStore.store.getRange();
	var id = Ecp.components.dicDataGrid.grid.getSelectedId();
	var col = a.column;
	var regs=/^\d+$/;
	var flag ;
	if (!regs.test(id)) {
		id = id.substr(0,4);
	}
	for ( var i = 0; i < records.length; i++) {
		if('ext-' != id && '2' == col){
			flag = false;
		}else {
			flag = true;
		}
	}
	return flag;
}

var clickDicDataDelBtn = function(){
	var grid = Ecp.components.dicDataGrid.grid;
	var records = Ecp.components.dicDataGrid.grid.getSelectedRecords();
	if (!records) {
		Ecp.MessageBox.alert(TXT.common_selectOneRecord);
	}else{
		Ecp.MessageBox.confirm(TXT.common_delComfirm, function() {
			var records = Ecp.components.dicDataGrid.grid.grid.getSelectionModel().getSelections();
			for(var i = 0,len = records.length;i<len;i++ ){
				grid.remove(records[i]);
			}
		});
	}
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
