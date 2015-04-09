package com.lxy.ecs.model;

import java.util.Date;

import com.lxy.base.model.Need2JSON;


public class EcsAuditLog extends EcsModel {
	private static final long serialVersionUID = 1L;

	private Long EntityId;
	private String EntityType;
	private Integer version;
	private Date occurTime;
	private String functionId;
	private String referenceNo;
	private String auditDesc;
	private EcsUser ecsUser;
	private String operId;
	private String userName;
	private String lanId;

	public Long getEntityId() {
		return EntityId;
	}
	public void setEntityId(Long entityId) {
		EntityId = entityId;
	}
	public String getEntityType() {
		return EntityType;
	}
	public void setEntityType(String entityType) {
		EntityType = entityType;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Date getOccurTime() {
		return occurTime;
	}
	public void setOccurTime(Date occurTime) {
		this.occurTime = occurTime;
	}
	public String getFunctionId() {
		return functionId;
	}
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
	public String getReferenceNo() {
		return referenceNo;
	}
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}
	public String getAuditDesc() {
		return auditDesc;
	}
	public void setAuditDesc(String auditDesc) {
		this.auditDesc = auditDesc;
	}
	public EcsUser getEcsUser() {
		return ecsUser;
	}
	public void setEcsUser(EcsUser ecsUser) {
		this.ecsUser = ecsUser;
	}
	public String getOperId() {
		return operId;
	}
	public void setOperId(String operId) {
		this.operId = operId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLanId() {
		return lanId;
	}
	public void setLanId(String lanId) {
		this.lanId = lanId;
	}
	@Need2JSON
	public String getUniqueColumn() {
		return null;
	}

}