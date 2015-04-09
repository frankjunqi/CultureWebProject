package com.lxy.util;


public class PDFUtil {/*
	public static void printStringToPDF(OutputStream os, String str){
		try {
			Document document = new Document(PageSize.A4);
			PdfWriter.getInstance(document, os);
			document.open();
			document.add(new Paragraph(str, font));
			document.close();
		} catch (Exception e) {
			LogUtil.logException(e);
		}
	}

	private static String nullValue(Object o, String value){
		if( o == null )
			return value;
		return o.toString();
	}

	public static Font font = getChineseFont( 12 );

	public static PdfPCell getCommonCell(String value) throws DocumentException, IOException{
		PdfPCell cell = new PdfPCell();
		cell.setBorderWidth(1);
		cell.setPaddingBottom(10f);
		cell.setPaddingLeft(5f);
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
		Paragraph p = new Paragraph(value,font);
		p.setAlignment(Paragraph.ALIGN_LEFT);
		cell.addElement(p);
		return cell;
	}

	public static PdfPCell getColspanCell(String value, int colspan) throws DocumentException, IOException{
		PdfPCell cell = new PdfPCell();
		cell.setPaddingBottom(10f);
		cell.setPaddingLeft(5f);
		cell.setBorderWidth(1);
		cell.setColspan(colspan);
		Paragraph p = new Paragraph(value,font);
		p.setAlignment(Paragraph.ALIGN_LEFT);
		cell.addElement(p);
		return cell;
	}

	public static PdfPCell getTitleColspanCell(String value, int colspan) throws DocumentException, IOException{
		PdfPCell cell = new PdfPCell();
		cell.setPaddingBottom(10f);
		cell.setBorderWidth(1);
		cell.setColspan(colspan);
		Paragraph p = new Paragraph(value,font);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		cell.addElement(p);
		return cell;
	}

	public static Font getChineseFont( int size) {
		BaseFont chinese = null;
		try {
			chinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		} catch (Exception e) {
			LogUtil.logException(e);
		}
		return new Font(chinese, size, Font.BOLD);
	}
	
	public static Font getDefaultFont( int size ){
		BaseFont df = null;
		try {
			df = BaseFont.createFont();
		} catch (Exception e) {
			LogUtil.logException(e);
		}
		return new Font(df, size);
	}
	//
	//		public static void main(String args[]) throws FileNotFoundException{
	//			Map<String, String[]> map = new HashMap<String, String[]>();
	//			map.put("userName", new String[]{""});
	//			map.put("lanId", new String[]{""});
	//			map.put("processStatus", new String[]{""});
	//			map.put("userStatus", new String[]{""});
	//			map.put("englishName", new String[]{""});
	//			map.put("operId", new String[]{"04601304"});
	//			ApplicationContext ctx  = new ClassPathXmlApplicationContext(
	//	    			new String[]{
	//	    					"spring/applicationContext-fxcs-dao.xml", 
	//	    					"spring/applicationContext-fxcs-service.xml", 
	//	    					"spring/dataSource.xml"
	//	    			});
	//	    	EcsUserDAO dao = (EcsUserDAO)ctx.getBean("ecsUserDAO");
	//	    	EcsUser user = dao.getUserByUserId(10800);
	//	    	printUserPrivilegesAndAccounts(new FileOutputStream(new File("C://a.pdf")),dao.getPDFUserListByParam(map, user), new String[]{"as","vd",""}, null);
	//		}
*/}
