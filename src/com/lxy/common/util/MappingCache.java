package com.lxy.common.util;

import java.util.HashMap;
import java.util.Map;

import com.lxy.common.constants.CriConstants;

public class MappingCache {
	public static Map<String, String> UserOperIdAndUserNameMapping = new HashMap<String, String>();
	
	public static String getUserName(String optId){
		if(optId == null){
			return "";
		}
		String userName = UserOperIdAndUserNameMapping.get(optId);
		if(userName == null || "".equals(userName.trim())){
			userName = optId;
		}
		return userName;
	}
	
	public static Map<String, String> CODE_LOOKUP_MAPPING_REPORT_RATE = new HashMap<String, String>();
	public static Map<String, String> CODE_LOOKUP_MAPPING_CHECK_TYPE = new HashMap<String, String>();
	public static Map<String, String> CODE_LOOKUP_MAPPING_ON_CHECK_INSTITUTION = new HashMap<String, String>();
	public static Map<String, String> CODE_LOOKUP_MAPPING_OFF_CHECK_INSTITUTION = new HashMap<String, String>();
	public static Map<String, String> CODE_LOOKUP_MAPPING_IA_CHECK_INSTITUTION = new HashMap<String, String>();
	public static Map<String, String> CODE_LOOKUP_MAPPING_SI_CHECK_INSTITUTION = new HashMap<String, String>();
	public static Map<String, String> CODE_LOOKUP_MAPPING_CO_CHECK_INSTITUTION = new HashMap<String, String>();
	public static Map<String, String> CODE_LOOKUP_MAPPING_PUNISH_TYPE = new HashMap<String, String>();
	public static Map<String, String> CODE_LOOKUP_MAPPING_MAPPING_OUT_QCR_REASON = new HashMap<String, String>();
	public static Map<String, String> CODE_LOOKUP_MAPPING_INSPECTION_NOTICE_TYPE = new HashMap<String, String>();
	public static Map<String, String> CODE_LOOKUP_MAPPING_RECEIVE_REMARK_TYPE = new HashMap<String, String>();
	public static Map<String, String> CODE_LOOKUP_MAPPING_SI_STATUS = new HashMap<String, String>();
	public static Map<String, String> CODE_LOOKUP_MAPPING_CO_SAMPLE_TYPE = new HashMap<String, String>();
	public static Map<String, String> CODE_LOOKUP_MAPPING_RISK_LEVEL = new HashMap<String, String>();
	public static Map<String, String> CODE_LOOKUP_MAPPING_RISK_TYPE = new HashMap<String, String>();
	public static Map<String, String> CODE_LOOKUP_MAPPING_BUSI_TYPE = new HashMap<String, String>();
	public static Map<String, String> CODE_LOOKUP_MAPPING_ERROR_TYPE = new HashMap<String, String>();
	public static Map<String, String> CODE_LOOKUP_MAPPING_ERROR_OWNER = new HashMap<String, String>();
	public static Map<String, String> CODE_LOOKUP_MAPPING_OUT_LINE_VALUE = new HashMap<String, String>();
	public static Map<String, String> CODE_LOOKUP_MAPPING_DEPARTMENT = new HashMap<String, String>();

	public static String getCodeLookupValue(String codeType, String key, String check_type){
		String value = "";
		if(CriConstants.CODE_LOOKUP_REPORT_RATE.equals(codeType)){
			value = CODE_LOOKUP_MAPPING_REPORT_RATE.get(key);
		}else if(CriConstants.CODE_LOOKUP_CHECK_TYPE.equals(codeType)){
			value = CODE_LOOKUP_MAPPING_CHECK_TYPE.get(key);
		}else if(CriConstants.CODE_LOOKUP_CHECK_INSTITUTION.equals(codeType)){
			if("ON".equals(check_type)){
				value = CODE_LOOKUP_MAPPING_ON_CHECK_INSTITUTION.get(key);
			}else if("OFF".equals(check_type)){
				value = CODE_LOOKUP_MAPPING_OFF_CHECK_INSTITUTION.get(key);
			}else if("IA".equals(check_type)){
				value = CODE_LOOKUP_MAPPING_IA_CHECK_INSTITUTION.get(key);
			}else if("SI".equals(check_type)){
				value = CODE_LOOKUP_MAPPING_SI_CHECK_INSTITUTION.get(key);
			}else if("CO".equals(check_type)){
				value = CODE_LOOKUP_MAPPING_CO_CHECK_INSTITUTION.get(key);
			}
		}else if(CriConstants.CODE_LOOKUP_ON_CHECK_INSTITUTION.equals(codeType)){
			value = CODE_LOOKUP_MAPPING_ON_CHECK_INSTITUTION.get(key);
		}else if(CriConstants.CODE_LOOKUP_OFF_CHECK_INSTITUTION.equals(codeType)){
			value = CODE_LOOKUP_MAPPING_OFF_CHECK_INSTITUTION.get(key);
		}else if(CriConstants.CODE_LOOKUP_IA_CHECK_INSTITUTION.equals(codeType)){
			value = CODE_LOOKUP_MAPPING_IA_CHECK_INSTITUTION.get(key);
		}else if(CriConstants.CODE_LOOKUP_SI_CHECK_INSTITUTION.equals(codeType)){
			value = CODE_LOOKUP_MAPPING_SI_CHECK_INSTITUTION.get(key);
		}else if(CriConstants.CODE_LOOKUP_CO_CHECK_INSTITUTION.equals(codeType)){
			value = CODE_LOOKUP_MAPPING_CO_CHECK_INSTITUTION.get(key);
		}else if(CriConstants.CODE_LOOKUP_PUNISH_TYPE.equals(codeType)){
			value = CODE_LOOKUP_MAPPING_PUNISH_TYPE.get(key);
		}else if(CriConstants.CODE_LOOKUP_OUT_QCR_REASON.equals(codeType)){
			value = CODE_LOOKUP_MAPPING_MAPPING_OUT_QCR_REASON.get(key);
		}else if(CriConstants.CODE_LOOKUP_INSPECTION_NOTICE_TYPE.equals(codeType)){
			value = CODE_LOOKUP_MAPPING_INSPECTION_NOTICE_TYPE.get(key);
		}else if(CriConstants.CODE_LOOKUP_RECEIVE_REMARK_TYPE.equals(codeType)){
			value = CODE_LOOKUP_MAPPING_RECEIVE_REMARK_TYPE.get(key);
		}else if(CriConstants.CODE_LOOKUP_SI_STATUS.equals(codeType)){
			value = CODE_LOOKUP_MAPPING_SI_STATUS.get(key);
		}else if(CriConstants.CODE_LOOKUP_CO_SAMPLE_TYPE.equals(codeType)){
			value = CODE_LOOKUP_MAPPING_CO_SAMPLE_TYPE.get(key);
		}else if(CriConstants.CODE_LOOKUP_RISK_LEVEL.equals(codeType)){
			value = CODE_LOOKUP_MAPPING_RISK_LEVEL.get(key);
		}else if(CriConstants.CODE_LOOKUP_RISK_TYPE.equals(codeType)){
			value = CODE_LOOKUP_MAPPING_RISK_TYPE.get(key);
		}else if(CriConstants.CODE_LOOKUP_BUSI_TYPE.equals(codeType)){
			value = CODE_LOOKUP_MAPPING_BUSI_TYPE.get(key);
		}else if(CriConstants.CODE_LOOKUP_ERROR_TYPE.equals(codeType)){
			value = CODE_LOOKUP_MAPPING_ERROR_TYPE.get(key);
		}else if(CriConstants.CODE_LOOKUP_ERROR_OWNER.equals(codeType)){
			value = CODE_LOOKUP_MAPPING_ERROR_OWNER.get(key);
		}else if(CriConstants.CODE_LOOKUP_OUT_LINE_VALUE.equals(codeType)){
			value = CODE_LOOKUP_MAPPING_OUT_LINE_VALUE.get(key);
		}else if(CriConstants.CODE_LOOKUP_DEPARTMENT.equals(codeType)){
			value = CODE_LOOKUP_MAPPING_DEPARTMENT.get(key);
		}
		if(value == null || "".equals(value.trim())){
			value = key;
		}
		return value;
	}
}
