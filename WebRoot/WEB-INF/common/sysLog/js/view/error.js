// 显示该页面时高亮显示queryAnswer菜单
Ecp.components.globalView = new Ecp.GlobalView('error');
function errorLayout() {
	var cPanel = new Ext.Panel({
				id : 'error',
				region : 'center',
				margins : '5 0 0 5',
				width : '70%',
				bodyStyle : {
					background : '#DFE8F6',
					padding : '7px'
				},
				autoLoad :{
					url : '../jsp/error.jsp',
					scripts : true,
                    scope : this
				}
			})
	var bottomPanel = new Ext.Panel({
				title : '<b>' + TXT.error_Search + '</b>',
				border : false,
				layout : 'border',
				items : [ cPanel]
			});
	Ecp.components.globalView.addModuleComp(bottomPanel);
	Ecp.components.globalView.render(TXT.error_Search);
};
Ecp.onReady(errorLayout);
