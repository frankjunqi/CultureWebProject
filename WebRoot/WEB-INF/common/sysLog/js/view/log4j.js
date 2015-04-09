// 显示该页面时高亮显示queryAnswer菜单
Ecp.components.globalView = new Ecp.GlobalView('log4j');
function log4jLayout() {
	var cPanel = new Ext.Panel({
				id : 'log4j',
				region : 'center',
				margins : '5 0 0 5',
				width : '70%',
				bodyStyle : {
					background : '#DFE8F6',
					padding : '7px'
				},
				autoLoad :{
					url : '../jsp/log4j.jsp',
					scripts : true,
                    scope : this
				}
			})
	var bottomPanel = new Ext.Panel({
				title : '<b>' + TXT.log4j_Search + '</b>',
				border : false,
				layout : 'border',
				items : [ cPanel]
			});
	Ecp.components.globalView.addModuleComp(bottomPanel);
	Ecp.components.globalView.render(TXT.log4j_Search);
};
Ecp.onReady(log4jLayout);
