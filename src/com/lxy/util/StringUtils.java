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

/**
 * FXCS String Utils
 * <p>
 * Module:   FXCS CLEARING
 *
 * @author   xiaoxia
 * @version  
 * @see      StringUtils
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class StringUtils extends org.apache.commons.lang.StringUtils {
	
	 public String encodingCharactor(String str ,String encode){
		 String resultStr = null;
		 try {
			 resultStr = URLEncoder.encode(str , encode);
		 } catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		 }//前台参数进行转码，这里也需要解码
		 return resultStr;
	 }
	/**
	 * get comma format of a string like xxx,xxx,xxx.00
	 * 
	 * @param strValue
	 * @return
	 */
	public static String getCommaStr(String strValue) {
		if (strValue == null || strValue.length() == 0) {
			return "";
		}

		try {
			String strInsert = ",";
			String strLeft = "";
			strValue = delCommaStr(strValue);
			if (strValue.startsWith("-")) {
				strLeft = "-";
				strValue = strValue.substring(1);
			}
			int iLength, iDotIndex;
			String strSubValue;
			String strSubAfDot;
			iLength = strValue.length();
			iDotIndex = strValue.indexOf(".");
			if (iDotIndex == -1) {
				if (iLength > 3) {
					int n;
					n = iLength / 3;
					if ((iLength % 3) == 0)
						n = n - 1;
					strSubValue = strValue.substring(0, iLength - n * 3);
					strValue = strValue.substring(iLength - n * 3, iLength);
					for (int i = 0; i < n; i++) {
						strSubValue = strSubValue + strInsert;
						strSubValue = strSubValue + strValue.substring(i * 3, i * 3 + 3);
					}
					return strLeft + strSubValue;
				} else {
					return strLeft + strValue;
				}
			} else {
				strSubAfDot = strValue.substring(iDotIndex, iLength);
				strValue = strValue.substring(0, iDotIndex);
				int iSubLength;
				iSubLength = strValue.length();
				if (iSubLength > 3) {
					int n;
					n = iSubLength / 3;
					if ((iSubLength % 3) == 0)
						n = n - 1;
					strSubValue = strValue.substring(0, iSubLength - n * 3);
					strValue = strValue.substring(iSubLength - n * 3, iSubLength);
					for (int i = 0; i < n; i++) {
						strSubValue = strSubValue + strInsert;
						strSubValue = strSubValue + strValue.substring(i * 3, i * 3 + 3);
					}
					strSubValue += strSubAfDot;
					return strLeft + strSubValue;
				} else {
					return strLeft + strValue + strSubAfDot;
				}
			}
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * get comma format of a string and spec the fractional division's length
	 * 
	 * @param strValue
	 * @param tail
	 * @return
	 */
	public static String getCommaStr(String strValue, int tail) {
		strValue = formatNumber(strValue, tail);
		return getCommaStr(strValue);
	}

	/**
	 * del all commas from a str
	 * 
	 * @param strValue
	 * @param tail
	 * @return
	 */
	public static String delCommaStr(String str) {

		if (str == null) {
			return str;
		}
		str = replace(str, ",", "");
		return str;
	}
	
	public static boolean arrayIsEmpty(String[] s){
		return s == null || s.length == 0 || (s.length == 1 && s[0] == null) || (s.length == 1 && s[0].length() == 0);
	}
	public static boolean arrayIsNotEmpty(String[] s){
		return !arrayIsEmpty(s);
	}

	/**
	 * get formatted str of a number
	 * 
	 * @param strValue
	 * @param tail
	 * @return
	 */
	public static String formatNumber(String value, String format) {
		try {
			Double x = new Double(value);
			String retValue = formatNumber(x, format);
			return retValue;

		} catch (Exception e) {
			Double x = new Double(0);
			String retValue = formatNumber(x, format);
			return retValue;
		}
	}

	/**
	 * get formatted str of a number
	 * 
	 * @param strValue
	 * @param tail
	 * @return
	 */
	public static String formatNumber(String strValue, int tail) {
		if (isEmpty(strValue)) {
			return strValue;
		}
		StringBuffer sb = new StringBuffer(strValue);
		int pos = strValue.indexOf(".");
		if (pos == -1) {
			sb.append(".");
			for (int i = 0; i < tail; i++) {
				sb.append("0");
			}
		} else {
			int tailNow = strValue.length() - pos - 1;
			if (tailNow < tail) {
				for (int i = 0; i < tail - tailNow; i++) {
					sb.append("0");
				}
			}
		}
		return sb.toString();
	}

	/**
	 * get formatted str of a number
	 * 
	 * @param strValue
	 * @param tail
	 * @return
	 */
	public static String formatNumber(Number value, String format) {
		if ((value == null) || (format == null)) {
			return "";
		}
		try {
			DecimalFormat df = new DecimalFormat(format);
			double x = value.doubleValue();
			String retValue = df.format(x);
			return retValue;
		} catch (Exception e) {
			Double x = new Double(0);
			String retValue = formatNumber(x, format);
			return retValue;
		}
	}

	/**
	 * make calc between two doubles
	 * 
	 * @param strValue
	 * @param tail
	 * @return
	 */
	public static double calcDecimal(double left, char operator, double right, int scale) {

		return calcDecimal(new BigDecimal(Double.toString(left)), operator, new BigDecimal(Double.toString(right)),
				scale, BigDecimal.ROUND_DOWN);
	}

	/**
	 * make calc between two doubles
	 * 
	 * @param strValue
	 * @param tail
	 * @return
	 */
	public static double calcDecimal(double left, char operator, long right, int scale) {

		return calcDecimal(new BigDecimal(Double.toString(left)), operator, new BigDecimal(Long.toString(right)),
				scale, BigDecimal.ROUND_DOWN);
	}

	/**
	 * make calc between two doubles
	 * 
	 * @param strValue
	 * @param tail
	 * @return
	 */
	public static double calcDecimal(long left, char operator, double right, int scale) {

		return calcDecimal(new BigDecimal(Long.toString(left)), operator, new BigDecimal(Double.toString(right)),
				scale, BigDecimal.ROUND_DOWN);
	}

	/**
	 * make calc between two doubles
	 * 
	 * @param strValue
	 * @param tail
	 * @return
	 */
	public static double calcDecimal(long left, char operator, long right, int scale) {

		return calcDecimal(new BigDecimal(Long.toString(left)), operator, new BigDecimal(Long.toString(right)), scale,
				BigDecimal.ROUND_DOWN);
	}

	/**
	 * make calc between two doubles
	 * 
	 * @param strValue
	 * @param tail
	 * @return
	 */
	public static double calcDecimal(double left, char operator, double right, int scale, int roundingMode) {

		return calcDecimal(new BigDecimal(Double.toString(left)), operator, new BigDecimal(Double.toString(right)),
				scale, roundingMode);
	}

	/**
	 * make calc between two doubles
	 * 
	 * @param strValue
	 * @param tail
	 * @return
	 */
	public static double calcDecimal(BigDecimal left, char operator, BigDecimal right, int scale, int roundingMode) {

		BigDecimal result = null;
		switch (operator) {
		case '+':
			result = left.add(right);
			break;
		case '-':
			result = left.subtract(right);
			break;
		case '*':
			result = left.multiply(right);
			break;
		case '/':
			result = left.divide(right, scale, roundingMode);
			break;
		default:
			result = new BigDecimal(0);
		}
		return result.doubleValue();
	}

	/**
	 * make calc between two doubles
	 * 
	 * @param strValue
	 * @param tail
	 * @return
	 */
	public static String calcDecimal(String leftStr, char operator, String rightStr, int scale, int roundingMode) {
		BigDecimal left = new BigDecimal(leftStr);
		BigDecimal right = new BigDecimal(rightStr);
		BigDecimal result = null;
		switch (operator) {
		case '+':
			result = left.add(right);
			break;
		case '-':
			result = left.subtract(right);
			break;
		case '*':
			result = left.multiply(right);
			break;
		case '/':
			result = left.divide(right, scale, roundingMode);
			break;
		default:
			result = new BigDecimal(0);
		}
		return result.toString();
	}

	/**
	 * convert null to " "
	 * 
	 * @param strValue
	 * @param tail
	 * @return
	 */
	public static String nulltoSpace(String value) {
		if (value == null || value.length() == 0) {
			return " ";
		}
		return value;
	}

	/**
	 * convert null to blank
	 * 
	 * @param strValue
	 * @param tail
	 * @return
	 */
	public static String null2Blank(String value) {
		if (value == null) {
			return "";
		}
		return value;
	}

	public static Object null2Blank(Object value) {
		if (value == null) {
			return "";
		}
		return value;
	}

	/**
	 * convert null to 0
	 * 
	 * @param strValue
	 * @param tail
	 * @return
	 */
	public static String null2zero(String value) {
		if (value == null) {
			return "0";
		}
		return value;
	}

	/**
	 * convert empty to 0
	 * 
	 * @param strValue
	 * @param tail
	 * @return
	 */
	public static String empty2zero(String value) {
		if (value == null || value.equals("")) {
			return "0";
		}
		return value;
	}

	/**
	 * convert convert special chars to html tag
	 * 
	 * @param strValue
	 * @param tail
	 * @return
	 */
	public static String replaceTagChar(String strin) {

		if (strin == null) {
			return strin;
		}
		if (strin.equals("")) {
			return strin;
		}
		strin = replace(strin, "&", "&amp;");
		strin = replace(strin, "<", "&lt;");
		strin = replace(strin, ">", "&gt;");
		strin = replace(strin, "\"", "&quot;");
		strin = replace(strin, "\r\n", "<br>");
		strin = replace(strin, "\n", "<br>");

		return strin;
	}

	/**
	 * before sql's convert in action
	 * 
	 * @param strValue
	 * @param tail
	 * @return
	 */
	public static String replaceSqlLike(String strin, char chEscape) {
		String strEscape = String.valueOf(chEscape);
		strin = replace(strin, strEscape, strEscape + strEscape);
		strin = replace(strin, "%", strEscape + "%");
		strin = replace(strin, "_", strEscape + "_");
		strin = replace(strin, "'", "''");
		return strin;
	}

	/**
	 * return double from string
	 * 
	 * @param strValue
	 * @param tail
	 * @return
	 */
	public static double getDouble(String inputData) {
		double result = 0;
		try {
			if (inputData == null || "".equals(inputData)) {
				result = 0;
			} else {
				result = Double.parseDouble(inputData);
			}
		} finally {

		}
		return result;
	}

	/**
	 * in the select's option
	 * 
	 * @param strValue
	 * @param tail
	 * @return
	 */
	public static String getConvertedStr(String strValue) {
		if (StringUtils.isNotEmpty(strValue)) {
			strValue = StringUtils.replace(strValue, "\\", "\\\\");
			strValue = StringUtils.replace(strValue, "'", "\\'");
		}
		return strValue;
	}

	/**
	 * convert null to html(" ")
	 * 
	 * @param strValue
	 * @param tail
	 * @return
	 */
	public static String nulltoNbsp(String value) {
		if (value == null || value.length() == 0) {
			return "&nbsp;";
		}
		return value;
	}

	public static Integer zeroToNull(Integer input) {
		if (input != null && input.intValue() == 0)
			return null;
		return input;
	}

	public static String readMessageTextFromClobToStr(Clob clob) throws SQLException, IOException {
		Reader r = null;
		BufferedReader br = null;
		StringBuffer sb = null;
		try {
			r = clob.getCharacterStream();
			br = new BufferedReader(r);
			sb = new StringBuffer();
			while (true) {
				String tempStr = br.readLine();
				if (tempStr == null)
					break;
				sb.append(tempStr + "\n");
			}
		} catch (Exception e) {
			return null;
		} finally {
			br.close();
			r.close();
		}
		return sb.toString();
	}
	
	public static boolean isNumberString(String str){
		boolean bRet = true;
		if(StringUtils.isEmpty(str)){
			bRet = false;
		}
		if(!StringUtils.isNumeric(str)){
			bRet = false;
		}
		return bRet;
	}
	
	public static boolean notEmpty(String str) {
		return (str!=null && str.length()>0);
	}
	
	/**
	 * sequence the string
	 * @param c char
	 * @param size int
	 * @return String
	 */
	public static String sequences(char c, int size) {
        final char[] buf = new char[size];
        for (int i = 0; i < buf.length; i++) {
            buf[i] = c;
        }
        return new String(buf);
    }
	
	public static String convertChar(Character ca){
		if(ca == null){
			return null;
		}else{
			return ca.toString();
		}
	}

	public static boolean isContain(String str, String subString, String flag){
		if(str == null){
			return false;
		}
		StringTokenizer subStrList = new StringTokenizer(subString, flag);
		return isContain(str, subStrList);
	}
	
	public static boolean isContain(String str, StringTokenizer subStrList){
		if(str == null){
			return false;
		}
		while (subStrList.hasMoreTokens()) {
			String tmpStr = subStrList.nextToken();
			if(str.indexOf(tmpStr)>=0){
				return true;
			}
		}
		return false;
	}
	public static String generateBizNo(int length) {
		String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(allChar.charAt(random.nextInt(allChar.length())));
		}
		return sb.toString();
	}
	public static boolean isNullOrEmpty(Object object) {
		if (object != null) {
			if (object instanceof Object[]) {
				Object[] objects = (Object[]) object;
				if (objects[0] != null && !objects[0].equals("")) {
					return false;
				}
			}else{
				if (!object.equals("")) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static List<String> getStringListByComma(String str,String comma) {
		if("".equals(str))
			return new ArrayList<String>();
		String[] s = str.split(comma);	 
		return Arrays.asList(s);
	}
	
	public static String getStrValue(Object obj){
		if(obj == null){
			return "";
		}else if(obj instanceof String){
			return (String)obj;
		}else if(obj instanceof Integer || obj instanceof BigDecimal){
			return obj.toString();
		}else if(obj instanceof Date){
			return DateUtil.getStringFromDate((Date)obj, "yyyy-MM-dd HH:mm:ssSSS");
		}else{
			return obj.toString();
		}
	}
	public static String upperFirstChar(String str){
		if(StringUtils.isEmpty(str) || "".equals(str.trim())){
			return "";
		}
		str = str.trim();
		return StringUtils.upperCase(str.substring(0,1)) + str.substring(1, str.length());
	}
	
	public static String intToStr(int num, int count) {
		if (num < 0)
			return "-" + intToStr(-num, count - 1);
		
		if (count <= 0) {
			if (num == 0)
				return "";
			else
				return num + "";
		}
		return intToStr(num / 10, count - 1) + num % 10 + "";
	}
	
	public static boolean isSameIgnoreNullEmpty(String str1, String str2){
		if(str1 == null && str2 == null){
			return true;
		}else if(str1 != null && str2 != null){
			return str1.trim().equals(str2.trim());
		}else if(str1 != null){
			return "".equals(str1.trim());
		}else{
			return "".equals(str2.trim());
		}
	}
}


