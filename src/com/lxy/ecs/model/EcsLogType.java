package com.lxy.ecs.model;

import com.lxy.base.model.Need2JSON;

public class EcsLogType extends EcsModel {

	private static final long serialVersionUID = 6790084356472949351L;
	private String businessTypeCn;
	private String businessType;
	private String actionTypeCn;
	private String actionType;
	private String action;

	public String getBusinessTypeCn() {
		return this.businessTypeCn;
	}

	public void setBusinessTypeCn(String businessTypeCn) {
		this.businessTypeCn = businessTypeCn;
	}

	public String getBusinessType() {
		return this.businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getActionTypeCn() {
		return this.actionTypeCn;
	}

	public void setActionTypeCn(String actionTypeCn) {
		this.actionTypeCn = actionTypeCn;
	}

	public String getActionType() {
		return this.actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	@Need2JSON
	public String getUniqueColumn() {
		return null;
	}
}