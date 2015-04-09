var clickLogSearchBtn=function(){ 
	var form= Ecp.components.LogSearchForm.form;
	if(!form.isValid()){
		return ;
	}
	var params=form.getValues();  
	params['start']=0;
	params['limit']=PAGE_SIZE; 
	Ecp.components.LogSearchGrid.dataStore.store['baseParams']=params; 
	Ecp.components.LogSearchGrid.dataStore.store.load();
}

var resetForm=function(){
	Ecp.components.LogSearchForm.form.reset();
	Ecp.components.LogSearchForm.form.findFieldById('actionType').store.removeAll();
}

var downloadLog=function(){
	var count = Ecp.components.LogSearchGrid.grid.getDataCount();
	if(count>0){
		var form=Ecp.components.LogSearchForm.form;
		downLoadQueryExcel( {
			form : form,
			dataGrid : Ecp.components.LogSearchGrid,
			cmd : 'ecsLogQueryAction',
			title : TXT.log_search
		} );
	}else{
		Ecp.MessageBox.alert(TXT.log_noDownload_alert);
	}
}