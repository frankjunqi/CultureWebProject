package com.lxy.ecs.model;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lxy.base.model.BaseModel;

public abstract class EcsModel extends BaseModel{

	private static final long serialVersionUID = 5442168791478739517L;

	public abstract String getUniqueColumn();
	
	public static class ActionResult{
		public static ActionResult getInstance(String result, String uniqueColumn, Long entityId){
			ActionResult ar = new ActionResult();
			ar.setEntityId(entityId);
			ar.setResult(result);
			ar.setUniqueColumn(uniqueColumn);
			return ar;
		}
		private String result;
		private String uniqueColumn;
		public String getUniqueColumn() {
			return uniqueColumn;
		}
		public void setUniqueColumn(String uniqueColumn) {
			this.uniqueColumn = uniqueColumn;
		}
		public String getResult() {
			return result;
		}
		public void setResult(String result) {
			this.result = result;
		}
		public Long getEntityId() {
			return entityId;
		}
		public void setEntityId(Long entityId) {
			this.entityId = entityId;
		}
		private Long entityId;
	}
	
	public boolean equals(Object obj, Class<? extends EcsModel> current) {
		if (null == obj)
			return false;
		if ( obj.getClass() != current )
			return false;
		else {
			EcsModel model = (EcsModel) obj;
			if (null == this.getId() && null == model.getId()) {
				if( this.getUniqueColumn() != null )
					return this.getUniqueColumn().equals(model.getUniqueColumn());
				else
					return model.getUniqueColumn() == null;
			} else if( this.getId() != null || model.getId() != null){
				return false;
			} else {
				if( this.getUniqueColumn() != null )
					return this.getUniqueColumn().equals(model.getUniqueColumn());
				else
					return model.getUniqueColumn() == null;
			}
		}
	}

	public int hashCode() {
		if (null != this.getId()) {
			String hashStr = this.getClass().getName() + ":"
					+ this.getId().hashCode();
			return hashStr.hashCode();
		} else if (null != this.getUniqueColumn()) {
			String hashStr = this.getClass().getName() + ":"
					+ this.getUniqueColumn().hashCode();
			return hashStr.hashCode();
		} else {
			return super.hashCode();
		}
	}
	public static final String PROCESS_STATUS_NPI="NPI";			//未处理
	
	public static final String PROCESS_STATUS_ZA="ZA";				//正常

	public static final String PROCESS_STATUS_AT = "AT";			//新增临时保存
	public static final String PROCESS_STATUS_AU = "AU"; 			//新增待复核
	public static final String PROCESS_STATUS_AUR = "AUR"; 			//新增复核拒绝
	public static final String PROCESS_STATUS_AA = "AA"; 	 		//新增待批准
	public static final String PROCESS_STATUS_AAR = "AAR"; 	 		//新增批准拒绝

	public static final String PROCESS_STATUS_MT = "MT";			//修改临时保存
	public static final String PROCESS_STATUS_MU = "MU";			//修改待复核	
	public static final String PROCESS_STATUS_MUR = "MUR";			//修改复核拒绝
	public static final String PROCESS_STATUS_MA = "MA";			//修改待批准
	public static final String PROCESS_STATUS_MAR = "MAR";			//修改批准拒绝

	public static final String PROCESS_STATUS_DT = "DT";			//删除临时保存
	public static final String PROCESS_STATUS_DU = "DU";			//删除待复核
	public static final String PROCESS_STATUS_DUR = "DUR";			//删除复核拒绝
	public static final String PROCESS_STATUS_DA = "DA";			//删除待批准
	public static final String PROCESS_STATUS_DAR = "DAR";			//删除批准拒绝
	
	public static final String PROCESS_STATUS_WFFU = "WFFU";		//关闭工作流待复核
	public static final String PROCESS_STATUS_WFFUR = "WFFUR";		//关闭工作流复核拒绝
	public static final String PROCESS_STATUS_WFFA = "WFFA";		//关闭工作流待批准
	public static final String PROCESS_STATUS_WFFAR = "WFFAR";		//关闭工作流待批准拒绝
	
	public static final String PROCESS_STATUS_FU = "FU";			//关闭检查待复核
	public static final String PROCESS_STATUS_FUR = "FUR";			//关闭检查拒绝
	public static final String PROCESS_STATUS_FA= "FA";				//关闭检查待批准
	public static final String PROCESS_STATUS_FAR = "FAR";			//关闭检查批准拒绝
	
	public static final String PROCESS_STATUS_ACTIONU = "ACTIONU";			//激活待复核
	public static final String PROCESS_STATUS_ACTIONUR = "ACTIONUR";	    //激活复核拒绝
	public static final String PROCESS_STATUS_ACTIONA= "ACTIONA";		     //激活待批准
	public static final String PROCESS_STATUS_ACTIONAR = "ACTIONAR";		//激活批准拒绝
	
	public static final String PROCESS_STATUS_CU = "CU";			//取消待复核
	public static final String PROCESS_STATUS_CUR = "CUR";			//取消复核拒绝
	public static final String PROCESS_STATUS_CA= "CA";				//取消待批准
	public static final String PROCESS_STATUS_CAR = "CAR";			//取消批准拒绝
	public static final String PROCESS_STATUS_CN="CN";				//已取消
	
	public static final String PROCESS_STATUS_STOP = "STOP";		//停用
	public static final String PROCESS_STATUS_LOCKED = "LOCKED";	//锁定
	public static final String PROCESS_STATUS_DELETED = "DELETED";	//已删除
	
	public static final Map<String, String> PROCESS_STATUS = new HashMap<String, String>();
	static{

		PROCESS_STATUS.put(PROCESS_STATUS_AU, "新增待复核");
		PROCESS_STATUS.put(PROCESS_STATUS_AT, "新增临时保存");
		PROCESS_STATUS.put(PROCESS_STATUS_AUR, "新增复核拒绝");
		PROCESS_STATUS.put(PROCESS_STATUS_AA, "新增待批准");
		PROCESS_STATUS.put(PROCESS_STATUS_AAR, "新增批准拒绝");
		PROCESS_STATUS.put(PROCESS_STATUS_MU, "修改待复核");
		PROCESS_STATUS.put(PROCESS_STATUS_MT, "修改临时保存");
		PROCESS_STATUS.put(PROCESS_STATUS_MUR, "修改复核拒绝");
		PROCESS_STATUS.put(PROCESS_STATUS_MA, "修改待批准");
		PROCESS_STATUS.put(PROCESS_STATUS_MAR, "修改批准拒绝");
		PROCESS_STATUS.put(PROCESS_STATUS_DU, "删除待复核");
		PROCESS_STATUS.put(PROCESS_STATUS_DUR, "删除复核拒绝");
		PROCESS_STATUS.put(PROCESS_STATUS_DA, "删除待批准");
		PROCESS_STATUS.put(PROCESS_STATUS_DAR, "删除批准拒绝");
		PROCESS_STATUS.put(PROCESS_STATUS_DELETED, "已删除");
		PROCESS_STATUS.put(PROCESS_STATUS_LOCKED, "锁定");
		PROCESS_STATUS.put(PROCESS_STATUS_STOP, "停用");
		PROCESS_STATUS.put(PROCESS_STATUS_ZA, "正常");
		
		PROCESS_STATUS.put(PROCESS_STATUS_NPI, "未处理");
		PROCESS_STATUS.put(PROCESS_STATUS_WFFU, "关闭工作流待复核");
		PROCESS_STATUS.put(PROCESS_STATUS_WFFUR, "关闭工作流复核拒绝");
		PROCESS_STATUS.put(PROCESS_STATUS_WFFA, "关闭工作流待批准");
		PROCESS_STATUS.put(PROCESS_STATUS_WFFAR, "关闭工作流待批准拒绝");
		PROCESS_STATUS.put(PROCESS_STATUS_FU, "关闭检查待复核");
		PROCESS_STATUS.put(PROCESS_STATUS_FUR, "关闭检查复核拒绝");
		PROCESS_STATUS.put(PROCESS_STATUS_FA, "关闭检查待批准");
		PROCESS_STATUS.put(PROCESS_STATUS_FAR, "关闭检查批准拒绝");
		
		PROCESS_STATUS.put(PROCESS_STATUS_CU, "取消待复核");
		PROCESS_STATUS.put(PROCESS_STATUS_CUR, "取消复核拒绝");
		PROCESS_STATUS.put(PROCESS_STATUS_CA, "取消待批准");
		PROCESS_STATUS.put(PROCESS_STATUS_CAR, "取消批准拒绝");
		PROCESS_STATUS.put(PROCESS_STATUS_CN, "已取消");
		
		PROCESS_STATUS.put(PROCESS_STATUS_ACTIONU, "激活待复核");
		PROCESS_STATUS.put(PROCESS_STATUS_ACTIONUR, "激活复核拒绝");
		PROCESS_STATUS.put(PROCESS_STATUS_ACTIONA, "激活待批准");
		PROCESS_STATUS.put(PROCESS_STATUS_ACTIONAR, "激活批准拒绝");
	}
	
	public void setNextRejectProcessStatus(String oper) {
		Date date = new Date();
		if( PROCESS_STATUS_AU.equals( getProcessStatus() ) ){
			setProcessStatus( PROCESS_STATUS_AUR );
			setCheckerBy( oper );
			setCheckerOn( date );
		} else if( PROCESS_STATUS_AA.equals( getProcessStatus() ) ){
			setProcessStatus( PROCESS_STATUS_AAR );
			setAuthorizerBy( oper );
			setAuthorizerOn( date );
		} else if( PROCESS_STATUS_MU.equals( getProcessStatus() ) ){
			setProcessStatus( PROCESS_STATUS_MUR );
			setCheckerBy( oper );
			setCheckerOn( date );
		} else if( PROCESS_STATUS_MA.equals( getProcessStatus() ) ){
			setProcessStatus( PROCESS_STATUS_MAR );
			setAuthorizerBy( oper );
			setAuthorizerOn( date );
		} else if( PROCESS_STATUS_DU.equals( getProcessStatus() ) ){
			setProcessStatus( PROCESS_STATUS_DUR );
			setCheckerBy( oper );
			setCheckerOn( date );
		} else if( PROCESS_STATUS_DA.equals( getProcessStatus() ) ){
			setProcessStatus( PROCESS_STATUS_DAR );
			setAuthorizerBy( oper );
			setAuthorizerOn( date );
		}
	}

	public void setNextApproveProcessStatus(String oper) {
		Date date = new Date();
		if( null == getProcessStatus() ){
			setProcessStatus( PROCESS_STATUS_AU );
			setCreateBy( oper );
			setCreateOn( date );
			setMakerBy( oper );
			setMakerOn( date );
		} else if( PROCESS_STATUS_AU.equals( getProcessStatus() ) ){
			setProcessStatus( PROCESS_STATUS_AA );
			setCheckerBy( oper );
			setCheckerOn( date );
		} else if( PROCESS_STATUS_AA.equals( getProcessStatus() ) ){
			setProcessStatus( PROCESS_STATUS_ZA );
			setAuthorizerBy( oper );
			setAuthorizerOn( date );
		} else if( PROCESS_STATUS_MU.equals( getProcessStatus() ) ){
			setProcessStatus( PROCESS_STATUS_MA );
			setCheckerBy( oper );
			setCheckerOn( date );
		} else if( PROCESS_STATUS_MA.equals( getProcessStatus() ) ){
			setProcessStatus( PROCESS_STATUS_ZA );
			setAuthorizerBy( oper );
			setAuthorizerOn( date );
		} else if( PROCESS_STATUS_DU.equals( getProcessStatus() ) ){
			setProcessStatus( PROCESS_STATUS_DA );
			setCheckerBy( oper );
			setCheckerOn( date );
		} else if( PROCESS_STATUS_DA.equals( getProcessStatus() ) ){
			setProcessStatus( PROCESS_STATUS_DELETED );
			setAuthorizerBy( oper );
			setAuthorizerOn( date );
		} else if( PROCESS_STATUS_ZA.equals( getProcessStatus() ) ){
			setProcessStatus( PROCESS_STATUS_MU );
			setMakerBy( oper );
			setMakerOn( date );
		} else if( isCanModify() ){
			setModifyBy( oper );
			if( PROCESS_STATUS_AUR.equals( getProcessStatus() ) || PROCESS_STATUS_AAR.equals( getProcessStatus() ) )
				setProcessStatus( PROCESS_STATUS_AU );
			else
				setProcessStatus( PROCESS_STATUS_MU );
			setModifyOn( date );
		}
	}


	public static final List<String> CAN_MODIFY = Arrays.asList(new String[]{
		PROCESS_STATUS_ZA,
		PROCESS_STATUS_AUR , 
		PROCESS_STATUS_AAR , 
		PROCESS_STATUS_MUR , 
		PROCESS_STATUS_MAR , 
		PROCESS_STATUS_DUR , 
		PROCESS_STATUS_DAR 
	});
	
	public boolean isCanModify(){
		if( CAN_MODIFY.contains( getProcessStatus() ) )
			return true;
		return false;
	}
	
	/*
	 * 两级批核
	 * */
	public void setNextApproveStatus(String oper) {
		Date date = new Date();
		if( null == getProcessStatus() ){
			setProcessStatus( PROCESS_STATUS_AU );
			setCreateBy( oper );
			setCreateOn( date );
			setMakerBy( oper );
			setMakerOn( date );
			setModifyBy( oper );
			setModifyOn( date );
		} else if( PROCESS_STATUS_AU.equals( getProcessStatus() ) ){
			setProcessStatus( PROCESS_STATUS_ZA );
			setCheckerBy( oper );
			setCheckerOn( date );
		} else if( PROCESS_STATUS_MU.equals( getProcessStatus() ) ){
			setProcessStatus( PROCESS_STATUS_ZA );
			setCheckerBy( oper );
			setCheckerOn( date );
		} else if(PROCESS_STATUS_DU.equals(getProcessStatus())){
			setProcessStatus( PROCESS_STATUS_DELETED );
			setCheckerBy( oper );
			setCheckerOn( date );
		} else if( isCanModify() ){
			if( PROCESS_STATUS_AUR.equals( getProcessStatus() )){
				setProcessStatus( PROCESS_STATUS_AU );
			}else{
				setProcessStatus( PROCESS_STATUS_MU );
			}
			setModifyBy( oper );
			setModifyOn( date );
		} else {
			setProcessStatus( PROCESS_STATUS_ZA );
			setCheckerBy( oper );
			setCheckerOn( date );
		}
	}
	
	/*
	 * 两级拒批
	 */
	public void setNextRejectStatus(String oper) {
		Date date = new Date();
		if( PROCESS_STATUS_AU.equals(getProcessStatus() )){
			setProcessStatus( PROCESS_STATUS_AUR );
			setCheckerBy( oper );
			setCheckerOn( date );
		} else if( PROCESS_STATUS_MU.equals( getProcessStatus() ) ){
			setProcessStatus( PROCESS_STATUS_MUR );
			setCheckerBy( oper );
			setCheckerOn( date );
		} else if(PROCESS_STATUS_DU.equals(getProcessStatus())){
			setProcessStatus( PROCESS_STATUS_DUR );
			setCheckerBy( oper );
			setCheckerOn( date );
		}else {
			setProcessStatus( PROCESS_STATUS_MUR );
			setCheckerBy( oper );
			setCheckerOn( date );
		}
	}

	public static final List<String> PEOPLE = Arrays.asList(new String[]{
			"makerBy",
			"checkerBy",
			"authorizerBy",
			"createBy",
			"modifyBy"
	});
}
