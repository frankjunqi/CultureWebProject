package com.lxy.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.lxy.util.StringUtils;

public class DateUtil extends com.lxy.util.DateUtil{

	private static final String TIME_PATTERN = "HH:mm";

	public static final String DATE_TIME_PATTERN = "yyyyMMddHHmmss";

	public static final String TIME_STAMP_YYYY_MM_DD = "yyyy-MM-dd";

	public static final String TIME_STAMP_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public static final String XML_DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
	
	public static final String DATE_YEAR_MONTH_DAYS = "yyyy年MM月dd日";

	private DateUtil() {
	}
	/**
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param strDate
	 *            a string representation of a date
	 * @param local
	 *            lingual localization
	 * @return Date
	 */
	public static Date convertStringToDateByGivenLocal(String aMask, String strDate, Locale local) throws ParseException {
		SimpleDateFormat df;
		Date date;
		if (local == null)
			df = new SimpleDateFormat(aMask);
		else
			df = new SimpleDateFormat(aMask, local);

		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return (date);
	}

	/**
	 * This method generates a string representation of a date/time in the
	 * format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param strDate
	 *            a string representation of a date
	 * @return a converted Date object
	 * @see java.text.SimpleDateFormat
	 * @throws ParseException
	 *             when String doesn't match the expected format
	 */
	public static Date convertStringToDate(String aMask, String strDate) throws ParseException {
		return convertStringToDateByGivenLocal(aMask, strDate, null);
	}

	/**
	 * This method returns the current date time in the format: MM/dd/yyyy HH:MM
	 * a
	 * 
	 * @param theTime
	 *            the current time
	 * @return the current date/time
	 */
	public static String getTimeNow(Date theTime) {
		return getDateTime(TIME_PATTERN, theTime);
	}

	/**
	 * This method generates a string representation of a date's date/time in
	 * the format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param aDate
	 *            a date object
	 * @return a formatted string representation of the date
	 * 
	 * @see java.text.SimpleDateFormat
	 */
	public static String getDateTime(String aMask, Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate == null) {
			return "";
		} else {
			df = new SimpleDateFormat(aMask);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 * This method generates a string representation of a date based on the
	 * System Property 'dateFormat' in the format you specify on input
	 * 
	 * @param pattern
	 *            String
	 * @param aDate
	 *            A date to convert
	 * @return a string representation of the date
	 */
	public static String convertDateToString(String pattern, Date aDate) {
		return getDateTime(pattern, aDate);
	}

	/**
	 * This method converts a String to a date using the datePattern
	 * 
	 * @param pattern
	 *            String
	 * @param dateTime
	 *            the date to convert (in format MM/dd/yyyy)
	 * @return a date object
	 */
	public static String convertDateTime(String pattern, String dateTime) {
		if(StringUtils.isNullOrEmpty(dateTime))
		{
			return "";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = sdf.parse(dateTime);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		
		return convertDateToString(pattern,date);
	}

	/**
	 * Convert the current date to string.For example: if the current date is
	 * 2009-01-16, the method will return "16Jan09".
	 * 
	 * @return SimpleDateFormat
	 */
	public static String convertCurrentTimeByUSLocale() {
		return new SimpleDateFormat("ddMMMyy", Locale.US).format(new Date());
	}
	
	/**
	 * Convert the current String to string.For example: if the current date is
	 * 2009-01-16, the method will return "16-Jan-2009".
	 * 
	 * @return String
	 */
	public static String convertDateByUSLocale(String fromMask,String date) {
		String d = "";
		if(StringUtils.isNullOrEmpty(date)){
			return d;
		}
		try {
			d =  new SimpleDateFormat("dd-MMM-yyyy", Locale.US).format(convertStringToDate(fromMask,date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	/**
	 * Convert the current date to string.For example: if the current date is
	 * 2009-01-16, the method will return "16-Jan-2009".
	 * 
	 * @return String
	 */
	public static String convertDateByUSLocale(Date date) {
		if(date == null){
			return "";
		}
		return new SimpleDateFormat("dd-MMM-yyyy", Locale.US).format(date);
	}
	/**
	 * Convert the current date to string.For example: if the current date is
	 * 2012-12-28, the method will return "2012年12月28日".
	 */
	public static String convertDateByCHLocale(Date date) {
		if(date == null){
			return "";
		}
		return new SimpleDateFormat("yyyy年MM月dd日", Locale.US).format(date);
	}
	public static Date[] getFirstAndLastDayOfMonth(Date date) {
		Date[] ds = new Date[2];
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 1);
		ds[0] = new Date(c.getTimeInMillis());
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH),
				c.getActualMaximum(Calendar.DAY_OF_MONTH), 23, 59, 59);
		ds[1] = new Date(c.getTimeInMillis());
		return ds;
	}
	public static Date[] getFirstAndLastDayOfLastMonth(Date date) {
		Date[] ds = new Date[2];
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, -1);
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 1);
		ds[0] = new Date(c.getTimeInMillis());
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.getActualMaximum(Calendar.DAY_OF_MONTH), 23, 59, 59);
		ds[1] = new Date(c.getTimeInMillis());
		return ds;
	}
	
	public static String[] getFirstAndLastDayofSeason(String strSource)
	{
		Date dateSource = getDateFromString(strSource,"yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(dateSource);
		int month = c.get(Calendar.MONDAY) + 1;
		
		//获得本季度   
        int array[][] = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};   
        int season = 1;   
        if(month>=1&&month<=3){   
            season = 1;   
        }   
        if(month>=4&&month<=6){   
            season = 2;   
        }   
        if(month>=7&&month<=9){   
            season = 3;   
        }   
        if(month>=10&&month<=12){   
            season = 4;   
        }   
        
        int start_month = array[season-1][0];   
        int end_month = array[season-1][2];   
       
        int year = c.get(Calendar.YEAR);
           
        int start_days = 1;
        
        c.setTime(getFirstAndLastDayOfMonth(dateSource)[1]);
        int end_days =  c.get(Calendar.DAY_OF_MONTH);
        
        String[] seasonDate = new String[2];
        c.set(year, start_month-1, start_days);
        
        seasonDate[0] = getStringFromDate(new Date(c.getTimeInMillis()),"yyyy-MM-dd");
        
        c.set(year, end_month-1, end_days);
        seasonDate[1] = getStringFromDate(new Date(c.getTimeInMillis()),"yyyy-MM-dd");
        
        return seasonDate;
	}
	
	public static String getThisSeasonTime(int month){     
        String quarter="";    
        if(month>=1&&month<=3){     
            quarter="Q1";     
        }     
        if(month>=4&&month<=6){     
            quarter="Q2";       
        }     
        if(month>=7&&month<=9){     
            quarter = "Q3";     
        }     
        if(month>=10&&month<=12){     
            quarter = "Q4";     
        }
        return quarter;
    }
	
	public static boolean isWorkDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if(calendar.get(Calendar.DAY_OF_WEEK)==1||calendar.get(Calendar.DAY_OF_WEEK)==7){
			return false;
		}
		return true;
	}
	public static Date getYesterday(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE,-1 );
		return calendar.getTime();
	}
	public static String getStringFromDate(Date date) {
		if (date == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return sdf.format(date);
	}
	public static Date getDateTimeFromString(String str) throws Exception {
		if (StringUtils.isEmpty(str))
			return null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.parse(str);
		} catch (Exception e) {
			return null;
		}
	}
    public static Date getFirstDayOfWeek(Date date) {
    	Calendar calendar = Calendar.getInstance();
 	   	calendar.setTime(date);  
 	   	int min = calendar.getActualMinimum(Calendar.DAY_OF_WEEK); //获取周开始基准
 	   	int current = calendar.get(Calendar.DAY_OF_WEEK); //获取当天周内天数
 	   	calendar.add(Calendar.DAY_OF_WEEK, min-current); //当天-基准，获取周开始日期
 	   	return calendar.getTime();
	}
	public static Date getLastDayOfWeek(Date date) {   
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);  
		int min = calendar.getActualMinimum(Calendar.DAY_OF_WEEK); //获取周开始基准
		int current = calendar.get(Calendar.DAY_OF_WEEK); //获取当天周内天数
		calendar.add(Calendar.DAY_OF_WEEK, min-current); //当天-基准，获取周开始日期
		Date start = calendar.getTime();
		calendar.add(Calendar.DAY_OF_WEEK, 6); //开始+6，获取周结束日期
	   	return calendar.getTime();
	}
	public static Date getLastDayOfPreviousWeek(Date date) {   
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);  
		calendar.add(Calendar.WEEK_OF_YEAR, -1); 
		int min = calendar.getActualMinimum(Calendar.DAY_OF_WEEK); //获取周开始基准
		int current = calendar.get(Calendar.DAY_OF_WEEK); //获取当天周内天数
		calendar.add(Calendar.DAY_OF_WEEK, min-current); //当天-基准，获取周开始日期
		Date start = calendar.getTime();
		calendar.add(Calendar.DAY_OF_WEEK, 6); //开始+6，获取周结束日期
	   	return calendar.getTime();
	}
}
