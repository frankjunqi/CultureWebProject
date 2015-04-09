
package com.lxy.common.constants;

import java.util.HashMap;
import java.util.Map;


public class CriConstants {

	/**
	 * 报表状态<br/>
	 * NPI--------------未处理<br/>
	 * DELETED----------已删除<br/>
	 * UC---------------上传待复核 <br/>
	 * UCR--------------上传待复核拒绝<br/>
	 * ZA---------------正常<br/>
	 * PC---------------归档待复核<br/>
	 * PCR--------------归档待复核拒绝<br/>
	 * PA---------------归档待批准<br/>
	 * PAR--------------归档待批准拒绝<br/>
	 * PH---------------已归档
	 */
	public enum REPORT_CHECK_STUTE{
		STATUS_NPI("NPI"),	
		STATUS_UPLOAD_WAIT_CHECK("UC"),
		STATUS_UPLOAD_REJECT("UCR"),
		STATUS_ZA("ZA"),	
		STATUS_WAIT_CHECK("PC"),
		STATUS_CHECK_REJECT("PCR"),
		STATUS_WAIT_AUTHORIZE("PA"),
		STATUS_AUTHORIZE_REJECT("PAR"),
		STATUS_PIGEONHOLE("PH"),
		STATUS_DELETED("DELETED");
		
		public final String code;
		REPORT_CHECK_STUTE(String code){
			this.code = code;
		}
	};
	public enum CODE_TYPE{
		RISK_LEVEL("RISK_LEVEL");
		public final String code;
		CODE_TYPE(String code){
			this.code = code;
		}
	};
	
	public enum COMP_CHECK {
		CHECK("checker"),RECHECK("reChecker");
		public final String code;
		COMP_CHECK(String code){
			this.code = code;
		}
	};
	public enum FINDING_FINISH_STATUS {
		UNFINISH("0"),FINISH("1");
		public final String code;
		FINDING_FINISH_STATUS(String code){
			this.code = code;
		}
	};
	public enum COMMON_YES_OR_NO_STATUS {
		NO("0"),YES("1");
		public final String code;
		COMMON_YES_OR_NO_STATUS(String code){
			this.code = code;
		}
	};
	public enum INSPECTION_FINISH_STATUS {
		WORKFLOWING,WORKFLOWFINISH,INSPECTIONGFINISH
	};
	
	public enum SYS_PARAM{
		DOCUMENT_PATH("DOCUMENT_PATH"),
		FILE_PATH("FILE_PATH"),
		FILE_CACHE_PATH("FILE_CACHE_PATH"),
		FILE_SPEED("FILE_SPEED"),
		FILE_TEMPORARY_PATH("FILE_TEMPORARY_PATH");
		
		
		public final String code ;
		SYS_PARAM(String code){
			this.code = code;
		}
	}
	
	public static final String ONTIME_REPORT_PATH= "ON_TIME_REPORT";
	public static final String TASK_PATH= "TASK";
	
	
	public static final String FINDING_FINISH_STATUS_FINISH= "1";
	public static final String FINDING_FINISH_STATUS_NOT_FINISH= "0";
	
	
	public enum FILELIST_TYPE{
		INSPECTION("INSPECTION"),
		INSPECTIONCHECKTIME("INSPECTIONCHECKTIME"),
		INSPECTIONCHECKTOP("INSPECTIONCHECKTOP"),
		SIINSPECTIONRESULT("SIINSPECTIONRESULT"),
		SIFILE("SIFile"),
		SIINSPECTIONRESULT_CHECKTOP("SIINSPECTIONRESULT_CHECKTOP"),
		NOTICE("NOTICE"),
		REPORT_I("I"),
		REPORT_O("O"),
		FILE("FILE"),
		FINDING("FINDING"),
		RECTIFY("RECTIFY");
		public final String code ;
		FILELIST_TYPE(String code){
			this.code = code;
		}
	}
	public enum INSPECTION_CHECK_TYPE{
		ON("ON"),
		OFF("OFF"),
		IA("IA"),
		CO("CO"),
		SI("SI"),
		EX("EX"),
		SC("SC"),
		OTHER("OTHER");
		public final String code ;
		INSPECTION_CHECK_TYPE(String code){
			this.code = code;
		}
	};
	public enum MODIFY_STATUS{
		ADD,MODIFY,DEL,CLEAN
	};

	public enum DICTIONARY_STATUE{
		//ZA 正常,MU 修改待复核,MUR 拒绝,DU 删除待复核,DELETE 删除成功
		ZA,MU,MUR,DU,DELETE
	}
	
	public static final String USER_CRI_BATCH = "CRI_BATCH";
	
	public static final int CACHE_FILESPACE_SIZE=1024 * 4;
	
	public static final String PROJECTNO_YEAR="PROJECTNO_YEAR";
	public static final String PROJECTNO_PREFIX="INSPECTION_";
	public static final String PROJECTNO_SUFFIX="_SEQ";
	public static final String PROJECTNO_RELEASE="_RELEASE";
	public static final String ERROR_INFO_RECORD_NOT_EXIST = "recordIsNoExist";
	public static final String ERROR_INFO_RECORD_MODIFY = "recordIsModify";
	public static final String MODIFY_TYPE_TRUNCATION_SIGN="_&_&_";
	public static final String MODIFY_ROW_TRUNCATION_SIGN="_&_";
	public static final int INSPECTION_PROJECT_NO_CODE_LENGTH = 3;
	public static final int INSPECTION_PROJECT_NO_LENGTH = 11;
	public static final String INSPECTION_PROJECT_NO_BEACN_CODE = "BEACN";

	/**
	 * key: 和reportName对应         value：报表判断符
	 */
	public static Map<String,String> REPORTNAME;
	
	static{
		REPORTNAME = new HashMap<String,String>();
		REPORTNAME.put("ON-SITE REGISTER", "ON-SITE REGISTER");
		REPORTNAME.put("OFF-SITE REGISTER", "OFF-SITE REGISTER");
		REPORTNAME.put("SI REGISTER", "SI REGISTER");
		REPORTNAME.put("IA REGISTER", "IA REGISTER");
		REPORTNAME.put("CO REGISTER", "CO REGISTER");
		REPORTNAME.put("ON-SITE STATUS", "ON-SITE STATUS");
		REPORTNAME.put("OPS", "OPS");
		REPORTNAME.put("合规问题整改进度报告-监管现场检查", "合规问题整改进度报告-监管现场检查");
		REPORTNAME.put("合规问题整改进度报告-监管非现场检查", "合规问题整改进度报告-监管非现场检查");
		REPORTNAME.put("合规问题整改进度报告-分行自查", "合规问题整改进度报告-分行自查");
		REPORTNAME.put("合规问题整改进度报告-合规检查", "合规问题整改进度报告-合规检查");
		REPORTNAME.put("合规问题整改进度报告-稽核检查", "合规问题整改进度报告-稽核检查");
		REPORTNAME.put("月度经营管理情况说明表-监管机构检查", "月度经营管理情况说明表-监管机构检查");
		REPORTNAME.put("分行合规考核-监管机构现场检查", "分行合规考核-监管机构现场检查");
		REPORTNAME.put("分行合规考核-合规检查", "分行合规考核-合规检查");
		REPORTNAME.put("QCR-PART IV", "QCR-PART IV");
		REPORTNAME.put("QCR-PART V-SECTION(A)-ON", "QCR-PART V-SECTION(A)-ON");
		REPORTNAME.put("QCR-PART V-SECTION(A)-OFF", "QCR-PART V-SECTION(A)-OFF");
		REPORTNAME.put("QCR-PART V-SECTION(A)-IA", "QCR-PART V-SECTION(A)-IA");
		REPORTNAME.put("QCR-PART V-SECTION(B)-ON", "QCR-PART V-SECTION(B)-ON");
		REPORTNAME.put("QCR-PART V-SECTION(B)-OFF", "QCR-PART V-SECTION(B)-OFF");
		REPORTNAME.put("QCR-PART V-SECTION(B)-IA", "QCR-PART V-SECTION(B)-IA");
		REPORTNAME.put("QCR-PART VI-SECTION(A)", "QCR-PART VI-SECTION(A)");
		REPORTNAME.put("QCR-PART VI-SECTION(B)", "QCR-PART VI-SECTION(B)");
		REPORTNAME.put("QCR-PART VI-SECTION(C)", "QCR-PART VI-SECTION(C)");
		REPORTNAME.put("QCR-PART VI-SECTION(D)-CO", "QCR-PART VI-SECTION(D)-CO");
		REPORTNAME.put("QCR-PART VI-SECTION(D)-SI", "QCR-PART VI-SECTION(D)-SI");
		REPORTNAME.put("整改后续跟踪表(监管机构现场检查意见)", "整改后续跟踪表(监管机构现场检查意见)");
		REPORTNAME.put("整改后续跟踪表(非现场监管意见)", "整改后续跟踪表(非现场监管意见)");
		REPORTNAME.put("整改后续跟踪表(内审意见)", "整改后续跟踪表(内审意见)");
		REPORTNAME.put("整改后续跟踪表(外审意见)", "整改后续跟踪表(外审意见)");
//		REPORTNAME.put("季度合规性报表(本期针对外部监管机构检查的整改情况)", "季度合规性报表(本期针对外部监管机构检查的整改情况)");
		REPORTNAME.put("季度合规性报表(现场)", "季度合规性报表(现场)");
		REPORTNAME.put("季度合规性报表(合规)", "季度合规性报表(合规)");
		REPORTNAME.put("合规问责信息收集表", "合规问责信息收集表");
		REPORTNAME.put("合规问责调查处理表", "合规问责调查处理表");
		REPORTNAME.put("半年度_年度经营情况报告(第五部分合规情况)", "半年度_年度经营情况报告(第五部分合规情况)");
		REPORTNAME.put("合规管理自我评估报告(违规处罚事件)", "合规管理自我评估报告(违规处罚事件)");
		REPORTNAME.put("合规风险管理报告(违规处罚事件)", "合规风险管理报告(违规处罚事件)");
	}
	
	public static final String CODE_LOOKUP_REPORT_RATE = "REPORT_RATE";
	public static final String CODE_LOOKUP_CHECK_TYPE = "CHECK_TYPE";
	public static final String CODE_LOOKUP_CHECK_INSTITUTION = "CHECK_INSTITUTION";
	public static final String CODE_LOOKUP_ON_CHECK_INSTITUTION = "ON_CHECK_INSTITUTION";
	public static final String CODE_LOOKUP_OFF_CHECK_INSTITUTION = "OFF_CHECK_INSTITUTION";
	public static final String CODE_LOOKUP_IA_CHECK_INSTITUTION = "IA_CHECK_INSTITUTION";
	public static final String CODE_LOOKUP_SI_CHECK_INSTITUTION = "SI_CHECK_INSTITUTION";
	public static final String CODE_LOOKUP_CO_CHECK_INSTITUTION = "CO_CHECK_INSTITUTION";
	public static final String CODE_LOOKUP_PUNISH_TYPE = "PUNISH_TYPE";
	public static final String CODE_LOOKUP_OUT_QCR_REASON = "OUT_QCR_REASON";
	public static final String CODE_LOOKUP_INSPECTION_NOTICE_TYPE = "INSPECTION_NOTICE_TYPE";
	public static final String CODE_LOOKUP_RECEIVE_REMARK_TYPE = "RECEIVE_REMARK_TYPE";
	public static final String CODE_LOOKUP_SI_STATUS = "SI_STATUS";
	public static final String CODE_LOOKUP_CO_SAMPLE_TYPE = "CO_SAMPLE_TYPE";
	public static final String CODE_LOOKUP_RISK_LEVEL = "RISK_LEVEL";
	public static final String CODE_LOOKUP_RISK_TYPE = "RISK_TYPE";
	public static final String CODE_LOOKUP_BUSI_TYPE = "BUSI_TYPE";
	public static final String CODE_LOOKUP_ERROR_TYPE = "ERROR_TYPE";
	public static final String CODE_LOOKUP_ERROR_OWNER = "ERROR_OWNER";
	public static final String CODE_LOOKUP_OUT_LINE_VALUE = "OUT_LINE_VALUE";
	public static final String CODE_LOOKUP_DEPARTMENT = "DEPARTMENT";
	
	public static final String[] MONTH_AB_DESC = new String[]{
		"", "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JULY", "AUG", "SEP", "OCT", "NOV", "DEC"
	};

}
