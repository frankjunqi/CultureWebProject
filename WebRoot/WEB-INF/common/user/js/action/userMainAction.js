var clickSearchBtn = function(){
	if(!this.form.isValid()){
		return;
	}
	var params = this.form.getValues(); 
	params['start']=0;
	params['limit']=PAGE_SIZE;
	Ecp.components.userSearchGrid.dataStore.store['baseParams']=params; 
	Ecp.components.userSearchGrid.dataStore.store.load();
}

var clickWinSearchBtn = function(){
	if(!this.form.isValid()){
		return;
	}
	var params = this.form.getValues(); 
	params['start']=0;
	params['limit']=PAGE_SIZE;
	Ecp.components._searchUserMultiChoiceGrid.dataStore.store['baseParams']=params; 
	Ecp.components._searchUserMultiChoiceGrid.dataStore.store.load();
}

var resetForm=function(){
	Ecp.components.userSearchForm.form.reset();
}

var showAddUserWin = function(){
	Ecp.UserInfoWindow.createNewWindow({
		'formFun' : function(obj) {
		Ecp.components.userInfoForm=obj;
		},
		'winFun' : function(obj) {
			Ecp.components.userInfoWin = obj;
			obj.config.title = TXT.user_edit;
			obj.config.height = 400;
			obj.buttons[0].handler = addUserInfo;
		}
	}).show();
	
	Ecp.components.roleGrid.dataStore.store['baseParams'] = {};
	Ecp.components.roleGrid.dataStore.store.load();
}

var addUserInfo = function(){
	var btn = {};
	btn['action'] = 'add';
	saveOrUpdUser(btn);
}

var showEditUserWin = function(){
	var data = Ecp.components.userSearchGrid.grid.getSelectedRecord();
	if(!data)
		return;
	var params = {
			cmd: 'ecsUserMainAction',
			action: 'getUserById',
			userId: data['id']
	};

	Ecp.Ajax.request(params,function(result){
		Ecp.UserInfoWindow.createWindow({
			'winFun' : function(obj) {
				Ecp.components.userInfoWin = obj;
				obj.config.title = TXT.user_edit;
				obj.buttons[0].handler = updateUserInfo;
			}
		}).show();
		
		if(result.branch){
			result.branchId = result.branch.id;
		}
		Ecp.components.userInfoForm.form.setValues(result);
		Ecp.components.roleGrid.dataStore.store['baseParams'] = result;
		Ecp.components.roleGrid.dataStore.store.load();
		var checkTypes = result.checkTypes.split(',');
		var checkBox = Ecp.components.checkTypePanel.findByType('checkbox');
		for(var i = 0;i < checkBox.length;i ++){
			if(checkTypes.include(checkBox[i].id)){
				checkBox[i].setValue(true);
			}
			checkBox[i].setDisabled(true);
		}
	});
}

var updateUserInfo = function(){
	var data = Ecp.components.userSearchGrid.grid.getSelectedRecord();
	var btn = {};
	btn['action'] = 'modify';
	btn['userId'] = data['id'];
	btn['version'] = data['version'];
	saveOrUpdUser(btn);
}

var showSetUserWin = function(){
	var data = Ecp.components.userSearchGrid.grid.getSelectedRecord();
	if(!data)
		return;
	var params = {
			cmd: 'ecsUserMainAction',
			action: 'getUserById',
			userId: data['id']
	};

	Ecp.Ajax.request(params,function(result){
		Ecp.UserInfoWindow.createWindow({
			'winFun' : function(obj) {
				Ecp.components.userInfoWin = obj;
				obj.config.title = TXT.user_edit;
				obj.buttons[0].handler = setUserInfo;
				
				Ecp.components.roleGrid.defaultSelModel=1;
			}
		}).show();
		
		if(result.branch){
			result.branchId = result.branch.id;
		}
		
		var uiForm = Ecp.components.userInfoForm.form;
		uiForm.setValues(result);
		
		var formValue={};
		uiForm.getItemValues(uiForm.items,formValue);
		for( var key in formValue){
			uiForm.setReadOnly(key,true);
		}
		Ecp.components.roleGrid.dataStore.store.loadData(result.roles);
	});
}

var setUserInfo = function(){
	var data = Ecp.components.userSearchGrid.grid.getSelectedRecord();
	var btn = {};
	btn['action'] = 'set';
	btn['userId'] = data['id'];
	btn['version'] = data['version'];
	saveOrUpdUser(btn);
}

var saveOrUpdUser = function(btn) {
	var form = Ecp.components.userInfoForm.form;
	if (form.isValid()) {
		var values = form.getValues();
		
		// 额外添加必要参数
		values['cmd'] = 'ecsUserMainAction';
		values['action'] = btn['action'];
		values['version'] = btn['version'];

		if(values['action'] == 'modify' || values['action'] == 'set'){
			// 用于修改功能
			if (btn['userId'] != undefined)
				values['userId'] = btn['userId'];
		}
		
		if(values['action'] == 'add' || values['action'] == 'modify'){
			var selectRecords = Ecp.components.roleGrid.grid.getSelectedRecords(true);
			var ids="";
			for(var i=0;i<selectRecords.length;i++){
				ids += selectRecords[i].id + ',';
			}
			values['roles'] = ids;
		}
		
		if(values['action'] == 'set'){
			var checkType = '';
			var checkBox = Ecp.components.checkTypePanel.findByType('checkbox');
			for(var i = 0;i < checkBox.length;i ++){
				if(checkBox[i].checked){
					checkType += checkBox[i].id + ','
				}
			}
			values['checkType'] = checkType;
		}
		
		// 发出请求与后台进行交互
		Ecp.Ajax.request(values, function(r) {
			if (r['message'] != null && r['message'] != '') {
				var errMsg = TXT.app_msg_info[r['message']];
				if (errMsg == null || errMsg == '')
					errMsg = r['message'];
				Ecp.MessageBox.alert(errMsg);
				return;
			}
			Ecp.MessageBox.alert(TXT.common_message_save_success);
			// 关闭window
			Ecp.components.userInfoWin.close();
			Ecp.components.userSearchGrid.reload();
		});
	}
}

var clickDelBtn = function(){
	var data = Ecp.components.userSearchGrid.grid.getSelectedRecord();
	if(data != null) {
		changeStatus(data.id, 'DELETED', TXT.common_delComfirm);
	}else{
		Ecp.MessageBox.alert(TXT.common_selectOneRecord);
	}
}

var clickUnLockBtn = function(){
	var data = Ecp.components.userSearchGrid.grid.getSelectedRecord();
	if(data != null) {
		changeStatus(data.id, 'ZA', TXT.common_start_confirm);
	}else{
		Ecp.MessageBox.alert(TXT.common_selectOneRecord);
	}
}

var changeStatus = function(sid, status, confirmStr){
	Ecp.MessageBox.confirm(confirmStr, function() {
		var params = {
			cmd : 'ecsUserMainAction',
			action : 'changeStatus',
			userId : sid,
			status: status
		};
		Ecp.Ajax.request(params, function(result) {
			if (result.result == 'success')
				Ecp.components.userSearchGrid.reload();
			else {
				Ecp.MessageBox.alert(result.message);       
			}
		});
	});
}

var clickDownloadBtn = function(){
	downLoadQueryExcel( {
		form : this.form,
		dataGrid : Ecp.components.userSearchGrid,
		cmd : 'ecsUserMainAction',
		title : TXT.userMain_query
	} );
}
