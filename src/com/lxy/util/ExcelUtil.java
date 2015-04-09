package com.lxy.util;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelUtil {
	private static void writeLoop(int columnIndex,int rowIndex, Iterator<String> keys, WritableSheet ws, Map<String, String> queryCriteria, WritableCellFormat wcf, int loopCount) throws RowsExceededException, WriteException{
		if( loopCount > 0 ){
			if( keys.hasNext() ){
				String key = keys.next();
				ws.addCell(new Label(columnIndex ++, rowIndex, key, wcf));
				ws.addCell(new Label(columnIndex ++, rowIndex, queryCriteria.get( key ), wcf));
			}
			writeLoop(columnIndex, rowIndex, keys, ws, queryCriteria, wcf, loopCount - 1);
		}
	}

	public static void exceptionToExcel(OutputStream os, Exception e){
		WritableWorkbook wwb;
		try {
			wwb = Workbook.createWorkbook(os);
			WritableSheet ws = wwb.createSheet("Exception",0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.RED);
			ws.setColumnView(0, 150);
			ws.setRowView(0, 8181);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setWrap(true);
			wcf.setAlignment(Alignment.LEFT);
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			ws.addCell(new Label(0, 0,sw.getBuffer().toString(), wcf));
			sw.close();
			wwb.write();
			wwb.close();
			os.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}


	/**
	 * 
	 * @param title 标题
	 * @param op 输出流
	 * @param queryCriteria 查询条件(字段说明 =查询值)
	 * @param everyCount 查询条件每一行输出的数量
	 * @param data 查询结果
	 */
	public static void commonQueryToExcel(String title, OutputStream os, Map<String, String> queryCriteria, int everyCount, List<String[]> datas){
		int len = 8;
		if( datas != null && datas.size() > 0 ){
			int i = datas.get(0).length;
			len = (i > 8 ? i : 8);
		}
		int x = 0;
		if( queryCriteria != null )
			x = (everyCount > queryCriteria.size() ? queryCriteria.size() : everyCount);
		len = ((x * 2) > len ? (x * 2) : len);
		try {
			WritableWorkbook wwb = Workbook.createWorkbook(os);
			WritableSheet ws = wwb.createSheet(title, 0);
			WritableFont wf = new WritableFont(WritableFont.createFont("宋体"), 15,
					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.DARK_BLUE);
			WritableFont wf2 = new WritableFont(WritableFont.createFont("宋体"), 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.BROWN);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setAlignment(Alignment.LEFT);
			ws.setRowView(0, 500);

			int rowIndex = 0;
			wcf.setBorder(Border.BOTTOM, BorderLineStyle.THICK,Colour.DARK_BLUE);
			ws.addCell(new Label(0, rowIndex++, title, wcf));
			ws.mergeCells(0, 0, len - 1, 0);
			wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.BOTTOM, BorderLineStyle.THICK,Colour.BLUE_GREY);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setAlignment(Alignment.LEFT);
			WritableCellFormat wcf1 = new WritableCellFormat(wf2);
			ws.addCell(new Label(0, rowIndex++, "", wcf1));
			ws.mergeCells(0, rowIndex, len - 1, rowIndex);
			ws.addCell(new Label(0, rowIndex++, "查询条件", wcf));
			if( queryCriteria != null ){
				for(Iterator<String> keys = queryCriteria.keySet().iterator(); keys.hasNext();){
					writeLoop(0, rowIndex++, keys, ws, queryCriteria, wcf1, everyCount);
				}
			}
			ws.addCell(new Label(0, rowIndex++, "", wcf1));
			ws.mergeCells(0, rowIndex, len - 1, rowIndex);
			ws.addCell(new Label(0, rowIndex++, "查询结果", wcf));
			ws.getSettings().setVerticalFreeze( rowIndex + 1 );
			if( datas != null ){
				for( String[] data : datas ){
					for( int i = 0; i < data.length; i++ )
						ws.addCell(new Label(i, rowIndex, data[i], wcf1));
					rowIndex++;
				}
			}

			wwb.write();
			wwb.close();
			os.close();
		} catch (Exception e) {
			exceptionToExcel(os, e);
		}
	}
	
	public static void resultSetToExcel(List<ResultSet> sets , OutputStream os) throws IOException, SQLException, RowsExceededException, WriteException{
		WritableWorkbook wwb = Workbook.createWorkbook(os);
		int i = -1;
		for( ResultSet set : sets ){
			if( set != null ){
				WritableSheet ws = wwb.createSheet("查询结果(" + ( ++i + 1 ) +  ")", i);
				ws.getSettings().setVerticalFreeze( 1 );
				ResultSetMetaData metaData = set.getMetaData();
				int count = metaData.getColumnCount();
				int rowIndex = 0;
				for( int j = 1; j <= count; j++ ){
					ws.addCell( new Label(j - 1, rowIndex, metaData.getColumnName(j)) );
				}
				while( set.next() ){
					rowIndex++;
					for( int j = 1; j <= count; j++ ){
						ws.addCell( new Label(j - 1, rowIndex, set.getString(j)) );
					}
				}
			}
			set.getStatement().close();
		}
		wwb.write();
		wwb.close();
		os.close();
	}

}
