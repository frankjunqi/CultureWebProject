var clickFileSearchBtn=function(){ 
	var form= Ecp.components.FileSearchForm.form;
	if(!form.isValid()){
		return ;
	}
	var params=form.getValues();
	Ecp.components.FileSearchGrid.dataStore.store['baseParams']=params; 
	Ecp.components.FileSearchGrid.dataStore.store.load();
}

var resetForm=function(){
	Ecp.components.FileSearchForm.form.reset();
}

var showFileContent=function(){
	var data = Ecp.components.FileSearchGrid.grid.getSelectedRecord();
	var url = "../jsp/file.jsp?fileName=" + data['fileName'] + "&filePath=" + data['filePath'] + "&suffix=" + data['suffix'];
	document.getElementById("fileContent").src = url;
}

var downloadFile=function(){
	var data = Ecp.components.FileSearchGrid.grid.getSelectedRecord();
	if(data){
		window.location.href=ECP_DISPATCH_SERVLET_URL+"?cmd=FileUtilAction&action=download&fileName="+data['fileName']+"&filePath="+data['filePath'];
	}else{
		Ecp.MessageBox.alert(TXT.common_selectOneRecord);
	}
}

var deleteFile=function(){
	var data = Ecp.components.FileSearchGrid.grid.getSelectedRecord();

	var values={};
	values['cmd']='FileUtilAction';
	values['action']='delete';
	values['fileName'] = data['fileName'];
	values['filePath'] = data['filePath'];
	Ecp.Ajax.request(values,function(result){
		if (result['message'] != null && result['message'] != '') {
			var errMsg = TXT.report_msg_info[result['message']];
			if (errMsg == null || errMsg == '')
				errMsg = result['message'];
			Ecp.MessageBox.alert(errMsg);
			return;
		}else{
			Ecp.components.FileSearchGrid.dataStore.store.reload();
		}
	});
}

var clickUploadWin  = function() {
	Ecp.FileUploadWindow.createWindow({
		'formFun' : function(obj) {
			Ecp.components.fileUploadForm = obj;
		},
		'winFun' : function(obj) {
			Ecp.components.fileUploadWin = obj;
		}
	}).show();
}

var uploadFile=function(){
	var form = Ecp.components.fileUploadForm.form;
	if (form.isValid()) {
		if(form.findById('uploadfile') == ''){
			Ecp.MessageBox.alert(TXT.common_file_notfound);
		}
		var formValue={};
		formValue.filePath = Ecp.components.FileSearchForm.form.findById('filePath');
		formValueJson=Ext.util.JSON.encode(formValue);
		
		var fileUploadForm =form.formPanel;
		fileUploadForm.getForm().submit({
			url: ECP_DISPATCH_SERVLET_URL+"?cmd=FileUtilAction&action=upload&formValueJson="+formValueJson,
			waitTitle:TXT.common_uploadFile,
			waitMsg:TXT.common_uploadFile,
			success:function(tt, action){
				Ecp.components.FileSearchGrid.dataStore.store.reload();
				Ecp.components.fileUploadWin.window.window.close();
			},
			failure: function(tt, action){
				Ecp.MessageBox.alert(TXT.common_file_upload_fail);
			}
		});
	}
}