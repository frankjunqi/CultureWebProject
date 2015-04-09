var criCodeLookupStatus = new Ext.data.SimpleStore({
	fields : [ 'value','label' ],
	data : [
	        [TXT.common_all, '' ],
			[TXT.common_processStatus['ZA'] ,'ZA'],
			[TXT.common_processStatus['MU'] ,'AU'],
			[TXT.common_processStatus['MUR'] ,'MUR'],
			[TXT.common_processStatus['DELETE'] ,'DELETE']]
	});