/**  ©2012, NCS (China) CO.LTD.All rights reserved.
 *
 *   Foreign Exchange Clearing System - version 1.2.0
 *
 *   This software is the property of NCS and its licensors and is protected by copyright. 
 *   Any reproduction in whole or in part is strictly prohibited.
 *  
 *   you can use the production compliance with the License. 
 *
 *   You can obtain a copy of the License at
 *
 *   http://www.ncs.com.sg
 *
 *   Unless required by applicable law or agreed to in writing.
 *   Source coding and software can be distributed  by the authorization of NCS,only.
 *   All other related product, document and logos are trademarks or registered trademarks of NCS.
 */
/*
 * Change Revision
 * ---------------
 * Date     		Author    			Remarks
 * 2012-2-4   		xiaoxia  		    initial files
 */

package com.lxy.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * FXCS Date Utils
 * <p>
 * Module: FXCS CLEARING
 * 
 * @author xiaoxia
 * @version
 * @see DateUtil
 */
public class DateUtil {
	private static Log log = LogFactory.getLog(DateUtil.class);
	public static final int _Year = 1;
	public static final int _Month = 2;
	public static final int _Date = 3;
	public static final int auditlogDownloadDateIntervalMax = 7;
	public static final String FORMAT_YYYYMMDD = "yyyyMMdd";
	public static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

	/**
	 * get system date
	 * 
	 * @return date
	 */
	public static Date getSystemDate() {
		return new Date(System.currentTimeMillis());
	}
	
	public static Date toDateStart(String dateStr) throws ParseException{
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr + " 00:00:00");
	}
	
	public static Date toDateEnd(String dateStr) throws ParseException{
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr + " 23:59:59");
	}

	/**
	 * get current day, not time
	 * 
	 * @return date
	 */
	public static Date getCurrentDate() {
		return getDateFromString(
				getStringFromDate(getSystemDate(), FORMAT_YYYYMMDD),
				FORMAT_YYYYMMDD);
	}

	/**
	 * check if the date
	 * 
	 * @param str
	 *            -it is the date string
	 * @param format
	 *            -format,eg: yyyyMMdd
	 * @return true/false
	 */
	public static boolean isDate(String str, String format) {
		try {
			if (StringUtils.isEmpty(str)) {
				return false;
			}
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date d = sdf.parse(str);
			if (str.equals(sdf.format(d))) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public static Date[] getStartAndEndOfTheDate(Date date) {
		return new Date[] { getStartOfDay(date), getEndOfDay(date) };
	}

	public static Date getBeforeDate(Date date, int dayNum){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 0-dayNum);
		calendar.set(Calendar.HOUR_OF_DAY , 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	
	public static Date addMonth(Date date, int i) {
		GregorianCalendar c = new GregorianCalendar();
		c.setTimeInMillis(date.getTime());
		c.add(GregorianCalendar.MONTH, i);
		return new Date(c.getTimeInMillis());
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
	public static Date convertStringToDate(String aMask, String strDate)
			throws ParseException {
		SimpleDateFormat df;
		Date date;
		df = new SimpleDateFormat(aMask);

		if (log.isDebugEnabled()) {
			log.debug("converting '" + strDate + "' to date with mask '"
					+ aMask + "'");
		}

		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			// log.error("ParseException: " + pe);
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return (date);
	}

	/**
	 * @param date
	 * @return the start of that day
	 */
	public static Date getStartOfDay(Date date) {
		GregorianCalendar c = new GregorianCalendar();
		c.setTimeInMillis(date.getTime());
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * @param date
	 * @return the end of that day
	 */
	public static Date getEndOfDay(Date date) {
		GregorianCalendar c = new GregorianCalendar();
		c.setTimeInMillis(date.getTime());
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		return c.getTime();
	}

	/**
	 * get the date by format
	 * 
	 * @param str
	 *            -it is the date string
	 * @param format
	 *            -format,eg: yyyyMMdd
	 * @return date
	 */
	public static Date getDateFromString(String str, String format) {
		try {
			if (StringUtils.isEmpty(str)) {
				return null;
			}
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(str);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * compare if dateEnds > dateBegins + interval
	 * 
	 * @param dateBegins
	 *            -begin date
	 * @param dateEnds
	 *            -end date
	 * @param interval
	 *            -the count of the interval
	 * @param format
	 *            -format, eg: yyyyMMdd
	 * @return true/false
	 * @throws Exception
	 *             -parse Exception
	 */
	public static boolean checkBeginEndWithinInterval(String dateBegins,
			String dateEnds, int interval, String format) throws Exception {
		Date beginDate = new SimpleDateFormat(format).parse(dateBegins);
		Date endDate = new SimpleDateFormat(format).parse(dateEnds);

		GregorianCalendar grc = new GregorianCalendar();
		grc.setTime(beginDate);
		grc.add(GregorianCalendar.DATE, interval);

		return grc.getTime().before(endDate);
	}

	/**
	 * get date of beginDate + interval
	 * 
	 * @param beginDate
	 *            -begin date
	 * @param interval
	 *            -the count of interval
	 * @return date
	 */
	public static Date getDatebyInterval(Date beginDate, int interval) {
		GregorianCalendar grc = new GregorianCalendar();
		grc.setTime(beginDate);
		grc.add(GregorianCalendar.DATE, interval);
		return grc.getTime();
	}

	public static boolean isDate(String str) {

		if (StringUtils.isEmpty(str))
			return false;
		if (str.length() != 8 && str.length() != 10)
			return false;
		String test = new String(str);
		if (test.length() == 10) {
			test = test.substring(0, 4) + test.substring(5, 7)
					+ test.substring(8, 10);
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Date d = sdf.parse(test);
			if (test.equals(sdf.format(d)))
				return true;
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public static Date getDateFromString(String str) throws Exception {
		if (StringUtils.isEmpty(str))
			return null;
		if (str.length() != 8 && str.length() != 10)
			return null;
		if (str.length() == 10) {
			str = str.substring(0, 4) + str.substring(5, 7)
					+ str.substring(8, 10);
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			return sdf.parse(str);
		} catch (Exception e) {
			return null;
		}
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

	public static String getStringFromDate(Date date, String format) {
		if (date == null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static String getStringFromDate(Date date) {
		if (date == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return sdf.format(date);
	}

	public static Date moveToDate(int flg, Date date, int count) {
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(date);
			switch (flg) {
			case _Year:
				calendar.add(Calendar.YEAR, count);
			case _Month:
				calendar.add(Calendar.MONTH, count);
			case _Date:
				calendar.add(Calendar.DATE, count);
			}
			return calendar.getTime();
		} catch (Exception e) {
			return null;
		}
	}

	public static Date getCurrentTime() {
		return new Date(System.currentTimeMillis());
	}

	public static boolean isBeginEndWithinInterval(String dateBegins,
			String dateEnds, int interval) throws Exception {
		Date beginDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateBegins);
		Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateEnds);

		GregorianCalendar grc = new GregorianCalendar();
		grc.setTime(beginDate);
		grc.add(GregorianCalendar.DATE, interval);

		return grc.getTime().after(endDate);
	}

	/**
	 * This method attempts to convert an Oracle-formatted date in the form
	 * dd-MMM-yyyy to mm/dd/yyyy.
	 * 
	 * @param aDate
	 *            date from database as a string
	 * @return formatted string for the ui
	 */
	public static String getDate(Date aDate) {
		SimpleDateFormat df;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat(getDatePattern());
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 * Return default datePattern (MM/dd/yyyy)
	 * 
	 * @return a string representing the date pattern on the UI
	 */
	public static String getDatePattern() {
		Locale locale = LocaleContextHolder.getLocale();
		String defaultDatePattern;
		try {
			defaultDatePattern = ResourceBundle.getBundle(
					"ApplicationResources", locale).getString("date.format");
		} catch (MissingResourceException mse) {
			defaultDatePattern = "MM/dd/yyyy";
		}

		return defaultDatePattern;
	}
	
	public static boolean isLastDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int day1 = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (day == day1)
            return true;
        return false;
    }
	public static boolean isfirstDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DAY_OF_MONTH);
        if (day == 1)
            return true;
        return false;
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
            log.error("aDate is null!");
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }
    public static int getDayOfMonth(Date date){
		 Calendar c = Calendar.getInstance();
		 c.setTime(date);
		 return c.get(Calendar.DAY_OF_MONTH);
	}
    
    /*
     * pay attention srcDate&targetDate do not have hour.min.second or 00:00:00
     */
    public static int getBetweenDays(Date srcDate, Date targetDate) {
        Date srcDate1 = DateUtils.truncate(srcDate, Calendar.DATE);
        Date targetDate1 = DateUtils.truncate(targetDate, Calendar.DATE);
        long i = targetDate1.getTime() - srcDate1.getTime() ;
        int result = (int) (i / (1000 * 60 * 60 * 24));
        return result;
    }
    
    public static Date addDate(Date date, int i) {
        GregorianCalendar c = new GregorianCalendar();
        c.setTimeInMillis(date.getTime());
        c.add(GregorianCalendar.DATE, i);
        return new Date(c.getTimeInMillis());

    }
    

    public static boolean isSameDay(Date d1,Date d2){
		if(d1==null||d2==null)
			return false ;
		else
			return getStringFromDate(d1,"yyyyMMdd").equals(getStringFromDate(d2,"yyyyMMdd"));
	}
    public static Timestamp getCurrentTimestamp(){
    	return new Timestamp(new Date().getTime());
    }
    public static Timestamp getTimeStampFormStr(String dateStr) throws ParseException {
		SimpleDateFormat sf = new SimpleDateFormat(FORMAT_YYYYMMDD);
		return new Timestamp(sf.parse(dateStr).getTime());
	}
    
    public static String convertDateStrYYYYMMDD(String date){
    	try{
    		return getStringFromDate(getDateFromString(date),FORMAT_YYYYMMDD);
    	}catch(Throwable t){
    		return "";
    	}
    }
    public static String getFormatStringFormString(String dateStr) throws Exception{
		return getStringFromDate(getDateFromString(dateStr),FORMAT_YYYYMMDD);
	}
    
    public static DateInterval getCurrDateInterval() throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		String month = String.valueOf(calendar.get(Calendar.MONTH)+1);
		String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
		Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(year + "-"
				+ month + "-" + day + " 00:00:00");
		Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(year + "-"
				+ month + "-" + day + " 23:59:59");
		return new DateInterval(startDate, endDate);
	}
    public static DateInterval getCurrDateInterval(Date workingDate) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(workingDate);
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		String month = String.valueOf(calendar.get(Calendar.MONTH)+1);
		String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
		Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(year + "-"
				+ month + "-" + day + " 00:00:00");
		Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(year + "-"
				+ month + "-" + day + " 23:59:59");
		return new DateInterval(startDate, endDate);
	}
    public static DateInterval getDateInterval(String format,String startDateString,String endDateString) throws ParseException{
    	SimpleDateFormat df = new SimpleDateFormat(format);
		try {
			Date startDate = StringUtils.isNotEmpty(startDateString) ? df.parse(startDateString.substring(0, 10)+" 00:00:00") : null;
			Date endDate = StringUtils.isNotEmpty(endDateString) ? df.parse(endDateString.substring(0, 10)+" 23:59:59") : null;
			return new DateInterval(startDate, endDate);
		} catch (ParseException pe) {
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}
    }
    /**
     * convert new Date() to yyyyMMDDHHmmss
     * @return
     */
    public static String convertCurrentDateTimeToString() {
		return new SimpleDateFormat("yyyyMMddHHmmss",Locale.CHINA).format(new Date());
	}
    public static boolean isInPeriod(Date date, Date startDate, Date endDate){
    	if(startDate != null && endDate != null){
        	String d = getStringFromDate(date, FORMAT_YYYYMMDD);
        	String sd = getStringFromDate(startDate, FORMAT_YYYYMMDD);
        	String ed = getStringFromDate(endDate, FORMAT_YYYYMMDD);
        	return d.compareTo(sd) >= 0 && d.compareTo(ed) <= 0;
    	}else if(startDate == null && endDate == null){
    		return true;
    	}else if(startDate != null){
    		String d = getStringFromDate(date, FORMAT_YYYYMMDD);
        	String sd = getStringFromDate(startDate, FORMAT_YYYYMMDD);
        	return d.compareTo(sd) >= 0;
    	}else{
    		String d = getStringFromDate(date, FORMAT_YYYYMMDD);
        	String ed = getStringFromDate(endDate, FORMAT_YYYYMMDD);
        	return d.compareTo(ed) <= 0;
    	}
    }
}