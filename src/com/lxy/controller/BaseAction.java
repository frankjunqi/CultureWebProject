package com.lxy.controller;

/**   
 * 	©2012, lxy (China) CO.LTD.All rights reserved.
 *
 *   Foreign Exchange Clearing System - version 1.2.0
 *
 *   This software is the property of lxy and its licensors and is protected by copyright. 
 *   Any reproduction in whole or in part is strictly prohibited.
 *  
 *   you can use the production compliance with the License. 
 *
 *   You can obtain a copy of the License at
 *
 *   http://www.lxy.com.sg
 *
 *   Unless required by applicable law or agreed to in writing.
 *   Source coding and software can be distributed  by the authorization of lxy,only.
 *   All other related product, document and logos are trademarks or registered trademarks of lxy.
 */
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.lxy.base.model.Need2JSON;
import com.lxy.ecs.model.EcsModel;
import com.lxy.ecs.model.EcsUser;
import com.lxy.common.constants.CriConstants;
import com.lxy.common.constants.EcsCommonConstants;
import com.lxy.common.util.MappingCache;
import com.lxy.log.LogContext;
import com.lxy.util.DateUtil;
import com.lxy.util.ExcelUtil;
import com.lxy.util.StringUtils;


/**
 * @author Felix
 */
public abstract class BaseAction {	
	protected String versionChanged = "VERSION_CHANGED";

	protected static class Result{
		@Need2JSON
		String message;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}
	
	public EcsUser getCurrentUser(HttpServletRequest request){
		return (EcsUser)request.getSession().getAttribute(EcsCommonConstants.CURRENT_USER);
	}

	protected List<String[]> fillValues(List<Object> obj, HttpServletRequest request){
		List<String[]> values = new ArrayList<String[]>();
		if( obj != null ){
			String[] dataIndexes = request.getParameterValues("dataIndex");
			for(Object o : obj){
				String[] v = new String[dataIndexes.length];
				for(int i = 0; i < dataIndexes.length; i++){
					v[i] = getField(dataIndexes[i] , o).toString();
				}
				values.add(v);
			}
		}
		
		return values;
	}
	
	protected List<String[]> fillValues(List<Object> obj, String[] dataIndexes){
		List<String[]> values = new ArrayList<String[]>();
		if( obj != null ){
			for(Object o : obj){
				String[] v = new String[dataIndexes.length];
				for(int i = 0; i < dataIndexes.length; i++){
					v[i] = getField(dataIndexes[i] , o).toString();
				}
				values.add(v);
			}
		}
		
		return values;
	}

	public abstract List<String[]> getDownloadData(HttpServletRequest request);

	@SuppressWarnings("unchecked")
	public void downloadQueryExcel(HttpServletRequest request, HttpServletResponse response) throws IOException{
		EcsUser user = getCurrentUser(request);
		if( user == null ){
			String fileName = new String( ( "您已超时.xls" ).getBytes("GBK"), "iso-8859-1");
			response.setHeader("Content-disposition", "attachment; filename=" + fileName);
			response.setContentType("application/msexcel");
			ExcelUtil.commonQueryToExcel("对不起您已超时，请重新登陆后下载！", response.getOutputStream() , null, 4, null);
		} else {
			List<String[]> listData = getDownloadData( request );
			Map<String, String[]> keyValue = request.getParameterMap();

			String formLabelKey[] = keyValue.get("formLabelKey");

			String formLabelValue[] = keyValue.get("formLabelValue");

			String header[] = keyValue.get("header");

			String title = request.getParameter("title");

			String preColumns = request.getParameter("preColumns");

			int columns = ( StringUtils.isNotEmpty( preColumns ) ? Integer.valueOf( preColumns ) : 4 );
			Map<String, String> queryCriteria = new HashMap<String, String>();
			
			if( StringUtils.arrayIsNotEmpty( formLabelKey ) ){
				for( int i = 0 ; i < formLabelKey.length ; i ++ ){
					queryCriteria.put(formLabelKey[i], formLabelValue[i]);
				}
			}
			
			List<String[]> datas = new ArrayList<String[]>();
			datas.add(header);
			if( listData != null && listData.size() > 0 )
				datas.addAll( listData );
			String fileName = new String( (title + ".xls").getBytes("GBK"), "iso-8859-1");
			response.setHeader("Content-disposition", "attachment; filename=" + fileName);
			response.setContentType("application/msexcel");
			ExcelUtil.commonQueryToExcel(title, response.getOutputStream() , queryCriteria, columns, datas);
		}
	}

	private Field getFieldByAnnotation(String fieldName , Class<?> c){
		for(Field f : c.getDeclaredFields()){
			Need2JSON need = f.getAnnotation(Need2JSON.class);
			if( need != null && need.value().equals(fieldName) )
				return f;
		}
		return null;
	}

	protected Object getField(String fieldName , Object o){
		int indexLen = fieldName.indexOf(".");
		Object returnValue = "";
		if( fieldName != null && indexLen != -1 ){
			String tempName = fieldName.substring(0, indexLen);
			Object value = getField(tempName, o);
			if( value == "" )
				return "";
			else
				returnValue = getField(fieldName.substring(indexLen + 1), value);
		} else {
			Class<?> c = o.getClass();
			Field f = null;
			while( c != null ){
				try {
					f = c.getDeclaredField(fieldName);
					f.setAccessible(true);
					Object ob = f.get(o);
					returnValue = (ob == null ? "" : ob);
					break;
				} catch (NoSuchFieldException e) {
					try{
						String method = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
						Object ob  = c.getDeclaredMethod(method).invoke(o, new Object[]{});
						returnValue = (ob == null ? "" : ob);
						break;
					}catch(Exception e1){
						try {
							String method = "is" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
							Object ob = c.getDeclaredMethod(method).invoke(o, new Object[]{});
							returnValue = (ob == null ? "" : ob);
							break;
						} catch (Exception e2) {
//							e2.printStackTrace();
						}
					}
					
					f = getFieldByAnnotation(fieldName , c);
					if( f == null )
						c = c.getSuperclass();
					else{
						f.setAccessible(true);
						try {
							Object ob = f.get(o);
							returnValue = (ob == null ? "" : ob);
						} catch (Exception e1) {
//							e1.printStackTrace();
						}
						break;
					}
				}  catch (Exception e1) {
//					e1.printStackTrace();
					break;
				}
			}
			
			if( f == null ){
				Method[] methods = o.getClass().getMethods();
				for( Method m : methods ) {
					Need2JSON ann = m.getAnnotation( Need2JSON.class );
					if( ann == null ) 
						continue;
					
					String name = ann.value();
					
					if( m.getName().equals( fieldName ) || name.equals( fieldName ) ){
						try {
							returnValue = m.invoke(o);
						} catch (Exception e) {
							returnValue = "";
						}
					}
					
				}
			}
		}

		if( returnValue.getClass() == BigDecimal.class ){
			BigDecimal bd = (BigDecimal)returnValue;
			NumberFormat nf = new DecimalFormat("#,##0.00");
			return nf.format( bd );
		} else if( returnValue.getClass() == Date.class || returnValue.getClass() == Timestamp.class ){
			Date date = (Date) returnValue;
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format( date );
		}
		if( EcsModel.PEOPLE.contains( fieldName ) ){
			Object ob = MappingCache.UserOperIdAndUserNameMapping.get( returnValue );
			if( ob != null ){
				returnValue = ob;
			}
		}
		return returnValue;
	}

	public static void addLog(String entityType ,String logInfo ,Long entityId,String operId, EcsUser currUser){
		LogContext.BusinessLog bl = LogContext.addLogToCurrrentContext();
		bl.setEntityType(entityType);
		if(logInfo != null && logInfo.length()>0){
			bl.setLogInfo(logInfo);
		}
		bl.setEntityId(entityId);
		if(currUser != null && currUser.getId()!= null){
			bl.setOperateEntity(currUser);
		}else{
			bl.setOperateEntity(operId);
		}
	}

	public Map<String, String> convertParamterMap(Map<String, String[]> map) {
		Map<String, String> newMap = new HashMap<String, String>();
		for( Map.Entry<String, String[]> en : map.entrySet() ) {
			newMap.put( en.getKey(), en.getValue()[0] );
		}
		return newMap;
	}

	/**
	 * jsonHasKeyToValue
	 * @param json
	 * @param key
	 * @return
	 * @throws JSONException
	 */
	public static String jsonHasKeyToValue(JSONObject json,String key)throws JSONException {
		if(json.has(key)){
			return json.getString(key);
		}else{
			return "";
		}
	}
	
	/**
	 * convert to finding
	 * @param findingJson
	 * @param finding
	 * @param modifyFlag
	 * @param cm
	 * @param modifySb
	 * @throws JSONException
	 */
	/*public static void convertToFinding(JSONObject findingJson, CriFinding finding, boolean modifyFlag,
			CriInspectionModify cm, StringBuffer modifySb,EcsUser user,Map<String,String> isModify) throws JSONException {
		String content = jsonHasKeyToValue(findingJson,"content");
		setParamForObject(finding, content, "content",modifyFlag,modifySb);
		
		String againstLawName = jsonHasKeyToValue(findingJson,"againstLawName");
		setParamForObject(finding, againstLawName, "againstLawName",modifyFlag,modifySb);

		String againstLawFileNo = jsonHasKeyToValue(findingJson,"againstLawFileNo");
		setParamForObject(finding, againstLawFileNo, "againstLawFileNo",modifyFlag,modifySb);

		String againstLawContent = jsonHasKeyToValue(findingJson,"againstLawContent");
		setParamForObject(finding, againstLawContent, "againstLawContent",modifyFlag,modifySb);

		String extraExplain = jsonHasKeyToValue(findingJson,"extraExplain");
		setParamForObject(finding, extraExplain, "extraExplain",modifyFlag,modifySb);
		
		String rectifyStatus = jsonHasKeyToValue(findingJson,"rectifyStatus");
		if(!StringUtils.isNullOrEmpty(rectifyStatus)){
			finding.setRectifyStatus(rectifyStatus);
		}
		String isRefComp = jsonHasKeyToValue(findingJson,"isRefComp");
		setParamForObject(finding, isRefComp, "isRefComp",modifyFlag,modifySb);
		
		String isOPS = jsonHasKeyToValue(findingJson,"isOPS");
		setParamForObject(finding, isOPS, "isOPS",modifyFlag,modifySb);
		
		String finishStatus = jsonHasKeyToValue(findingJson,"finishStatus");
		setParamForObject(finding, finishStatus, "finishStatus",modifyFlag,modifySb);

		String refInstitution = jsonHasKeyToValue(findingJson,"refInstitution");
		setParamForObject(finding, refInstitution, "refInstitution",modifyFlag,modifySb);
		
		String busiType = jsonHasKeyToValue(findingJson,"busiType");
		setParamForObject(finding, busiType, "busiType",modifyFlag,modifySb);
		
		String errorType = jsonHasKeyToValue(findingJson,"errorType");
		setParamForObject(finding, errorType, "errorType",modifyFlag,modifySb);
		
		String errorOwner = jsonHasKeyToValue(findingJson,"errorOwner");
		setParamForObject(finding, errorOwner, "errorOwner",modifyFlag,modifySb);
		
		String riskType = jsonHasKeyToValue(findingJson,"riskType");
		setParamForObject(finding, riskType, "riskType",modifyFlag,modifySb);
		
		String riskLevel = jsonHasKeyToValue(findingJson,"riskLevel");
		setParamForObject(finding, riskLevel, "riskLevel",modifyFlag,modifySb);
		
		String preFinishTime = jsonHasKeyToValue(findingJson,"preFinishTime");
		setParamForObject(finding, preFinishTime, "preFinishTime",modifyFlag,modifySb);
		
		String isPutComp = jsonHasKeyToValue(findingJson,"isPutComp");
		setParamForObject(finding, isPutComp, "isPutComp",modifyFlag,modifySb);
		
		String isPunish = jsonHasKeyToValue(findingJson,"isPunish");
		setParamForObject(finding, isPunish, "isPunish",modifyFlag,modifySb);
		
		String isAgainstSum = jsonHasKeyToValue(findingJson,"isAgainstSum");
		setParamForObject(finding, isAgainstSum, "isAgainstSum",modifyFlag,modifySb);
		
		String againstStandard = jsonHasKeyToValue(findingJson,"againstStandard");
		setParamForObject(finding, againstStandard, "againstStandard",modifyFlag,modifySb);
		
		String againstValue = jsonHasKeyToValue(findingJson,"againstValue");
		setParamForObject(finding, againstValue, "againstValue",modifyFlag,modifySb);
		
		String plan = jsonHasKeyToValue(findingJson,"plan");
		setParamForObject(finding, plan, "plan",modifyFlag,modifySb);
		
		String finishTime = jsonHasKeyToValue(findingJson,"finishTime");
		setParamForObject(finding, finishTime, "finishTime",modifyFlag,modifySb);
		
		String doing = jsonHasKeyToValue(findingJson,"doing");
		setParamForObject(finding, doing, "doing",modifyFlag,modifySb);
		
		String key = content;
		if(StringUtils.isNullOrEmpty(content)&& content.length()>15){
			key = content.substring(15)+"...";
		}
		if(modifyFlag){
			if(!StringUtils.isNullOrEmpty(modifySb.toString())){
				isModify.put("isModify", "1");
				if(!user.getOperId().equals(cm.getModifyBy())){
					cm.setModifyColumn("");
				}
				if(!StringUtils.isNullOrEmpty(cm.getModifyColumn())){
					cm.setModifyColumn(cm.getModifyColumn()+CriConstants.MODIFY_ROW_TRUNCATION_SIGN+modifySb.toString());
				}else{
					cm.setModifyColumn(modifySb.toString());
				}
				cm.setModifyStatus(CriConstants.MODIFY_STATUS.MODIFY.name());
				cm.setModifyBy(user.getOperId());
				cm.setModifyOn(new Timestamp(System.currentTimeMillis()));
			}
		}
		cm.setModifyKey(key);
	}*/
	
	/**
	 * reflex param to object nature
	 * @param obj 
	 * @param newParamValue
	 * @param paramName : nature name
	 * @param modifyFlag: whether it is recorded to modify
	 * @param modifySb : appand to modify string
	 * @return
	 */
	public static  Object setParamForObject(Object obj,String newParamValue,String paramName, boolean modifyFlag,StringBuffer modifySb){
		Class cls = obj.getClass();
			Method getMethod;
			try {
				getMethod = cls.getMethod("get" + StringUtils.upperFirstChar(paramName));
				if(getMethod.getReturnType().equals(Date.class)){
					appendModifyColumn(modifyFlag, (Date)getMethod.invoke(obj), modifySb, newParamValue, paramName);
				}else if(getMethod.getReturnType().equals(Integer.class)){
					if(getMethod.invoke(obj)==null){
						appendModifyColumn(modifyFlag, "", modifySb, newParamValue, paramName);
					}else{
						appendModifyColumn(modifyFlag, ((Integer)getMethod.invoke(obj)).toString(), modifySb, newParamValue, paramName);
					}
				}else{
					appendModifyColumn(modifyFlag, (String)getMethod.invoke(obj), modifySb, newParamValue, paramName);
				}
				
				if(!StringUtils.isNullOrEmpty(newParamValue)||(!StringUtils.isNullOrEmpty(getMethod.invoke(obj)))){
					Method method = null;
					if(getMethod.getReturnType().equals(Date.class)){
						method = cls.getMethod("set" + StringUtils.upperFirstChar(paramName), Date.class);
						Date newDate = DateUtil.getDateFromString(newParamValue,DateUtil.FORMAT_YYYY_MM_DD);
						method.invoke(obj, new Object[]{newDate});
					}else if(getMethod.getReturnType().equals(Integer.class)){
						method = cls.getMethod("set" + StringUtils.upperFirstChar(paramName), Integer.class);
						if(StringUtils.isNumberString(newParamValue)){
							method.invoke(obj, new Object[]{Integer.parseInt(newParamValue)});
						}
					}else{
						method = cls.getMethod("set" + StringUtils.upperFirstChar(paramName), String.class);
						method.invoke(obj, new Object[]{newParamValue});
					}
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		return obj;
	}
	/**
	 * appendModifyColumn
	 * @param modifyFlag
	 * @param oldContent
	 * @param modifySb
	 * @param newContent
	 * @param columnName
	 */
	public static  void appendModifyColumn(boolean modifyFlag,String oldContent, StringBuffer modifySb,
			String newContent,String columnName) {
		if((StringUtils.isNullOrEmpty(oldContent)&&!StringUtils.isNullOrEmpty(newContent))
				||(!StringUtils.isNullOrEmpty(oldContent)&&StringUtils.isNullOrEmpty(newContent))){
			if(modifyFlag ){
				modifySb.append(columnName);
				modifySb.append("_");
			}
		}else if(!StringUtils.isNullOrEmpty(oldContent)&&!StringUtils.isNullOrEmpty(newContent)){
			if(modifyFlag && !oldContent.equals(newContent)){
				modifySb.append(columnName);
				modifySb.append("_");
			}
		}
	}
	/**
	 * appendModifyColumn
	 * @param modifyFlag
	 * @param oldContent
	 * @param modifySb
	 * @param newContent
	 * @param columnName
	 */
	public static void appendModifyColumn(boolean modifyFlag,Date oldContent, StringBuffer modifySb,
			String newContent,String columnName) {
		
		if((oldContent==null&&!StringUtils.isNullOrEmpty(newContent))
				||(oldContent!=null&&StringUtils.isNullOrEmpty(newContent))){
			if(modifyFlag ){
				modifySb.append(columnName);
				modifySb.append("_");
			}
		}else if(oldContent!=null&&!StringUtils.isNullOrEmpty(newContent)){
			Date newDate = DateUtil.getDateFromString(newContent,DateUtil.FORMAT_YYYY_MM_DD);
			if(modifyFlag && !newDate.equals(oldContent)){
				modifySb.append(columnName);
				modifySb.append("_");
			}
		}
	}
}