package com.lxy.base.model;

import java.io.Serializable;
import java.util.Date;

public class BaseModel implements Serializable{
	private static final long serialVersionUID = -8347398689294690915L;
	
	public static String PROP_ID = "id";
	public static String PROP_OLD_ID = "oldId";
	public static String PROP_version = "version";
	public static String PROP_CHECKER_ON = "checkerOn";
	public static String PROP_CHECKER_BY = "checkerBy";
	public static String PROP_MAKER_BY = "makerBy";
	public static String PROP_MAKER_ON = "makerOn";
	public static String PROP_MODIFY_BY = "modifyBy";
	public static String PROP_MODIFY_ON = "modifyOn";
	public static String PROP_CREATE_BY = "createBy";
	public static String PROP_CREATE_ON = "createOn";
	public static String PROP_AUTHORIZER_BY = "authorizerBy";
	public static String PROP_AUTHORIZER_ON = "authorizerOn";
	public static String PROP_PROCESS_STATUS = "processStatus";
	
	@Need2JSON
	private Long id;
	@Need2JSON
	private Integer version;
	@Need2JSON
	private Date makerOn;
	@Need2JSON
	private String makerBy;
	@Need2JSON
	private Date checkerOn;
	@Need2JSON
	private String checkerBy;
	@Need2JSON
	private Date authorizerOn;
	@Need2JSON
	private String authorizerBy;
	@Need2JSON
	private Date createOn;
	@Need2JSON
	private String createBy;
	@Need2JSON
	private Date modifyOn;
	@Need2JSON
	private String modifyBy;
	@Need2JSON
	private String processStatus;
	@Need2JSON
	private String checkStatus;
	private Long oldId;
	public Long getOldId() {
		return oldId;
	}
	public void setOldId(Long oldId) {
		this.oldId = oldId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Date getMakerOn() {
		return makerOn;
	}
	public void setMakerOn(Date makerOn) {
		this.makerOn = makerOn;
	}
	public String getMakerBy() {
		return makerBy;
	}
	public void setMakerBy(String makerBy) {
		this.makerBy = makerBy;
	}
	public Date getCheckerOn() {
		return checkerOn;
	}
	public void setCheckerOn(Date checkerOn) {
		this.checkerOn = checkerOn;
	}
	public String getCheckerBy() {
		return checkerBy;
	}
	public void setCheckerBy(String checkerBy) {
		this.checkerBy = checkerBy;
	}
	public Date getAuthorizerOn() {
		return authorizerOn;
	}
	public void setAuthorizerOn(Date authorizerOn) {
		this.authorizerOn = authorizerOn;
	}
	public String getAuthorizerBy() {
		return authorizerBy;
	}
	public void setAuthorizerBy(String authorizerBy) {
		this.authorizerBy = authorizerBy;
	}
	public Date getCreateOn() {
		return createOn;
	}
	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getModifyOn() {
		return modifyOn;
	}
	public void setModifyOn(Date modifyOn) {
		this.modifyOn = modifyOn;
	}
	public String getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	public String getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	public String getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}
}
