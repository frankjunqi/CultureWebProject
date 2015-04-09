var resetForm = function() {
	Ecp.components.paramMainForm.form.reset();
}

var clickSearchBtn = function() {
	var paraName = Ecp.components.paramMainForm.form.findById('paraName');
	var paraValue = Ecp.components.paramMainForm.form.findById('paraValue');

	var params = {
			cmd : 'sysParamMainAction',
			action : 'findSysParamMana',
			paraName : paraName,
			paraValue : paraValue
	}
	Ecp.components.paramMainGrid.show(params);
}

var showAddSysParaWin = function(btn) {
	Ecp.SysParaInfoWindow.createWindow({
		'formFun' : function(obj) {
			Ecp.components.sysParaInfoForm = obj;
		},
		'winFun' : function(obj) {
			Ecp.components.sysParaInfoWindow = obj;
			obj.config.title = TXT.paramMain_sysParameterManage_add;
			obj.buttons[0].handler = clickAddSysParaBtn;
		}
	}).show();
}
var showEditSysParaWin = function(btn) {
	var data = Ecp.components.paramMainGrid.grid.getSelectedRecord();
	if (!data)
		return;
	if(data['systemPara']){
		Ecp.MessageBox.alert(TXT.isSystemPara_error);
		return;
	}
	if(data.processStatus != 'ZA' && !data.processStatus.match("R")){
		Ecp.MessageBox.alert(TXT.depositoryBank_edit_cannot);
		return;
	}
	var params = {
			cmd : 'sysParamMainAction',
			action : 'getSysParamMana',
			paraId : data['id']
	};
	Ecp.Ajax.request(params, function(result) {
		Ecp.SysParaInfoWindow.createWindow({
			'formFun' : function(obj) {
				Ecp.components.sysParaInfoForm = obj;
			},
			'winFun' : function(obj) {
				Ecp.components.sysParaInfoWindow = obj;
				obj.config.title = TXT.paramMain_sysParameterManage_edit;
				obj.buttons[0].handler = clickEditSysParaBtn;
			}
		}).show();
		Ecp.components.sysParaInfoForm.form.findFieldById('paraName').setDisabled(true);
		Ecp.components.sysParaInfoForm.form.setValues(data);
		version  = data.version;
	});
}

var clickDelSysParaBtn = function(btn) {
	var data = Ecp.components.paramMainGrid.grid.getSelectedRecord();
	if (!data)
		return;
	if(data['isSystemPara']){
		Ecp.MessageBox.alert(TXT.isSystemPara_error_delete);
		return;
	}
	if(data.processStatus != 'ZA' && !data.processStatus.match("R")){
		Ecp.MessageBox.alert(TXT.depositoryBank_edit_cannot);
		return;
	}
	Ecp.MessageBox.confirm(TXT.common_delComfirm, function() {		
		var params = {};
		params['cmd'] = 'sysParamMainAction';
		params['action'] = 'delete';
		params['paraId'] = data['id'];
		params['version'] = data['version'];
		Ecp.Ajax.request(params, function(r) {
			// 后台处理时是否出现错误，包括业务逻辑上的错误，如所添加的数据重复等
			if (r['message'] != null && r['message'] != '') {
				var errMsg = TXT.app_msg_info[r['message']];
				if (errMsg == null || errMsg == '')
					errMsg = r['message'];
				Ecp.MessageBox.alert(errMsg);
				return;
			} else {
				Ecp.MessageBox.alert(TXT.common_message_delete_success);
				Ecp.components.paramMainGrid.reload();
			}
		})
	});
}

var clickAddSysParaBtn = function(btn) {
	var btn = {};
	btn['cmd'] = 'sysParamMainAction';
	btn['action'] = 'save';
	saveOrUpdSysPara(btn);
}

var clickEditSysParaBtn = function(btn) {
	var data = Ecp.components.paramMainGrid.grid.getSelectedRecord();
	var btn = {};
	btn['action'] = 'modify';
	btn['paraId'] = data['id'];
	btn['version'] = data['version'];
	saveOrUpdSysPara(btn);
}

var validateSpecialSysParam = function(data){
	var sysPattern;
	var paraValue = data['paraValue'];
	if(data['paraName']=='IS_BATCHING'){
		sysPattern = /^Y|N$/;
		if(!sysPattern.test(paraValue)){
			Ecp.MessageBox.alert(TXT.paramMain_value_YorN);
			return false;
		}
	}else if(data['paraName']=='email_from'){
		sysPattern = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
		if(!sysPattern.test(paraValue)){
			Ecp.MessageBox.alert(TXT.paramMain_value_mail);
			return false;
		}
	}
	return true;
}

var saveOrUpdSysPara = function(btn) {
	var form = Ecp.components.sysParaInfoForm.form;
	var paraName = form.findById('paraName');
	if (paraName.replace(/(^\s*)|(\s*$)/g, '') == '') {
		Ecp.MessageBox.alert(TXT.paramMain_paramName_NotIsNull);
		return;
	}
	if (form.isValid()) {
		// 获取form中的数据所组成的json
		var values = form.getValues();
		
		if(!validateSpecialSysParam(values)){
			return;
		}
		
		// 额外添加必要参数
		values['cmd'] = 'sysParamMainAction';
		values['action'] = btn['action'];
		values['version'] = btn['version'];

		// 用于修改功能
		if (btn['paraId'] != undefined)
			values['paraId'] = btn['paraId'];

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
			Ecp.components.sysParaInfoWindow.close();
			Ecp.components.paramMainGrid.reload();
		});
	}
}

var downLoadParam = function(){
	var count = Ecp.components.paramMainGrid.grid.getDataCount();
	if(count>0){
		var form=Ecp.components.paramMainForm.form;
		downLoadQueryExcel( {
			form : form,
			dataGrid : Ecp.components.paramMainGrid,
			cmd : 'sysParamMainAction',
			title : TXT.paramMain_sysParameterManage_query
		} );
	}else{
		Ecp.MessageBox.alert(TXT.log_noDownload_alert);
	}
}
