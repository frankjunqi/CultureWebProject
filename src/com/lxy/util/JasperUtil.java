package com.lxy.util;


public class JasperUtil {/*
	private static Log logger = LogFactory.getLog(JasperUtil.class);
	public static final String DB_PROPERTIES = "db.properties";
	private static Connection conn;
	
	public static void generateListDataOfPDF(JasperReportModel jasperReportModel) throws Exception{
		logger.info("generateListDataOfPDF......begin");
		generatePDF(jasperReportModel, new JRBeanCollectionDataSource(jasperReportModel.getSourceList()));
		logger.info("generateListDataOfPDF......end");
	}
	
	public static void generateEmptyDataOfPDF(JasperReportModel jasperReportModel) throws Exception{
		logger.info("generateEmptyDataOfPDF......begin");
		generatePDF(jasperReportModel, new JREmptyDataSource());
		logger.info("generateEmptyDataOfPDF......end");
	}
	
	public static void generateJDBCDataOfPDF(JasperReportModel jasperReportModel) throws Exception{
		logger.info("generateJDBCDataOfPDF......begin");
		generatePDF(jasperReportModel, getJDBCConnection());
		dispose();
		logger.info("generateJDBCDataOfPDF......end");
	}
	
	public static void generateJndiNameDataOfPDF(JasperReportModel jasperReportModel) throws Exception{
		logger.info("generateJndiNameDataOfPDF......begin");
		generatePDF(jasperReportModel, getJndiNameConnection());
		dispose();
		logger.info("generateJndiNameDataOfPDF......end");
	}
	
	public static void generateListDataOfXLS(JasperReportModel jasperReportModel) throws Exception{
		logger.info("generateListDataOfXLS......begin");
		generateXLS(jasperReportModel, new JRBeanCollectionDataSource(jasperReportModel.getSourceList()));
		logger.info("generateListDataOfXLS......end");
	}
	
	public static void generateEmptyDataOfXLS(JasperReportModel jasperReportModel) throws Exception{
		logger.info("generateEmptyDataOfXLS......begin");
		generateXLS(jasperReportModel, new JREmptyDataSource());
		logger.info("generateEmptyDataOfXLS......end");
	}

	public static void generateJDBCDataOfXLS(JasperReportModel jasperReportModel) throws Exception{
		logger.info("generateJDBCDataOfXLS......begin");
		generateXLS(jasperReportModel, getJDBCConnection());
		dispose();
		logger.info("generateJDBCDataOfXLS......end");
	}

	public static void generateJndiNameDataOfXLS(JasperReportModel jasperReportModel) throws Exception{
		logger.info("generateJndiNameDataOfXLS......begin");
		generateXLS(jasperReportModel, getJndiNameConnection());
		dispose();
		logger.info("generateJndiNameDataOfXLS......end");
	}
	
	public static void generateListDataOfDOC(JasperReportModel jasperReportModel) throws Exception{
		logger.info("generateListDataOfDOC......begin");
		generateDOC(jasperReportModel, new JRBeanCollectionDataSource(jasperReportModel.getSourceList()));
		logger.info("generateListDataOfDOC......end");
	}
	
	public static void generateEmptyDataOfDOC(JasperReportModel jasperReportModel) throws Exception{
		logger.info("generateEmptyDataOfDOC......begin");
		generateDOC(jasperReportModel, new JREmptyDataSource());
		logger.info("generateEmptyDataOfDOC......end");
	}

	public static void generateJDBCDataOfDOC(JasperReportModel jasperReportModel) throws Exception{
		logger.info("generateJDBCDataOfDOC......begin");
		generateDOC(jasperReportModel, getJDBCConnection());
		dispose();
		logger.info("generateJDBCDataOfDOC......end");
	}

	public static void generateJndiNameDataOfDOC(JasperReportModel jasperReportModel) throws Exception{
		logger.info("generateJndiNameDataOfDOC......begin");
		generateDOC(jasperReportModel, getJndiNameConnection());
		dispose();
		logger.info("generateJndiNameDataOfDOC......end");
	}
	
	
	*//**
	 * pdf设置要点：
	 * 一、背景色设置   1.Opaque 打钩,2.设置BackColor属性
	 * 二、序号设置   1。新增一项Variables取名index，修改属性Variable Class=java.lang.Integer,Calculation=Count,Variable Expression=$V{index}.valueOf(1),Init Value Expression=1
	 * 三、时间格式化  1.设置属性Pattern=yyyy-MM-dd
	 * 四、字体编码设置
	 *      1.在ireport中classpath中引用包iTextAsian.jar
     *		3.所有项目设置PDF font name: STSong-Light
     *		4.所有项目设置PDF Encoding: UniGB-UCS2-H(Chinese Simplified)
     *		5.所有项目设置PDF Embeded: √
	 * @param jasperReportModel
	 * @param dataSource
	 * @throws Exception
	 *//*
	private static void generatePDF(JasperReportModel jasperReportModel, Object dataSource) throws Exception{
		JasperPrint jasperPrint = getJasperPring(jasperReportModel, dataSource);
		
		JRPdfExporter pdfExporter = new JRPdfExporter();
		pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		pdfExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, jasperReportModel.getOutPutFilePath());
		pdfExporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
		pdfExporter.exportReport();
	}
	
	*//**
	 * excel设置要点：
	 * 一、背景色设置   1.Opaque 打钩,2.设置BackColor属性
	 * 二、去除记录最下面的行1.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS=true,
	 * 		2.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS=true,
	 *      3.删除多余的ColumnHeaderIS_ONE_PAGE_PER_SHEET=false
	 * 三、序号设置   1。新增一项Variables取名index，修改属性Variable Class=java.lang.Integer,Calculation=Count,Variable Expression=$V{index}.valueOf(1),Init Value Expression=1
	 * 四、时间格式化  1.设置属性Pattern=yyyy-MM-dd
	 * 五、设置边框    1。选择Field框，设置borders框的定位并设置Line width
	 * @param jasperReportModel
	 * @param dataSource
	 * @throws Exception
	 *//*
	private static void generateXLS(JasperReportModel jasperReportModel, Object dataSource) throws Exception{
		JasperPrint jasperPrint = getJasperPring(jasperReportModel, dataSource);
		
		JRXlsExporter xlsExporter = new JRXlsExporter();
		xlsExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		xlsExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, jasperReportModel.getOutPutFilePath());
		xlsExporter.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,true);
		xlsExporter.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,true);
		xlsExporter.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);   
//		xlsExporter.setParameter(JRXlsAbstractExporterParameter.IS_COLLAPSE_ROW_SPAN,Boolean.TRUE);
		xlsExporter.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
		xlsExporter.exportReport();
	}

	private static void generateDOC(JasperReportModel jasperReportModel, Object dataSource) throws Exception{
		JasperPrint jasperPrint = getJasperPring(jasperReportModel, dataSource);
		
		JRDocxExporter docExporter = new JRDocxExporter();
		docExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		docExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, jasperReportModel.getOutPutFilePath());
		docExporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
		docExporter.exportReport();
	}
	
	private static JasperPrint getJasperPring(JasperReportModel jasperReportModel, Object dataSource)throws Exception {
		logJasperReportInfo(jasperReportModel);

		JasperPrint jasperPrint;
		if(dataSource instanceof JRDataSource){
			jasperPrint = (JasperPrint) JRLoader.loadObject(JasperFillManager.fillReportToFile(jasperReportModel.getJasperFilePath(), jasperReportModel.getParamter(), (JRDataSource)dataSource));
		}else if(dataSource instanceof Connection){
			jasperPrint = (JasperPrint) JRLoader.loadObject(JasperFillManager.fillReportToFile(jasperReportModel.getJasperFilePath(), jasperReportModel.getParamter(), (Connection)dataSource));
		}else{
			throw new Exception("Unknow DataSource Type");
		}
		return jasperPrint;
	}

	private static Connection getJDBCConnection() throws Exception{
		SystemProperty.init(DB_PROPERTIES);
		
		Class.forName(SystemProperty.getProperty("db.driver")).newInstance();
	    String URL=SystemProperty.getProperty("db.url");
	    conn=DriverManager.getConnection(URL,SystemProperty.getProperty("db.username"),SystemProperty.getProperty("db.password"));
	    
	    return conn;
	}
	
	private static Connection getJndiNameConnection() throws Exception{
		Context ctx = new InitialContext();
		DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/" + SystemProperty.getProperty("jndiName"));
		conn = dataSource.getConnection();

	    return conn;
	}
	
	public static void dispose(){
		if (conn != null){
			try{
				conn.close();
			}catch (Exception ex){
				if (logger.isErrorEnabled())
					logger.error("Error while closing the connection.", ex);
			}
		}
	}

	private static void logJasperReportInfo(JasperReportModel jasperReportModel){
		if(jasperReportModel != null){
			logger.info("......JasperFilePath......" + jasperReportModel.getJasperFilePath());
			logger.info("......OutPutFilePath......" + jasperReportModel.getOutPutFilePath());
		}
	}
	
*/}
