package com.lxy.ecs.model;

import java.io.Serializable;
import java.util.Date;

import com.lxy.base.model.Need2JSON;

public class EcsCalendar  extends EcsModel {
	
	private static final long serialVersionUID = 1948361650074464639L;
	
	@Need2JSON
	private Integer sign;
	@Need2JSON
	private Date savedDate;
	public final static int WORKDAY_SIGN=1;
	public final static int HOLIDAY_SIGN=2;
	
	public Date getSavedDate() {
		return savedDate;
	}

	public void setSavedDate(Date savedDate) {
		this.savedDate = savedDate;
	}
	public Integer getSign() {
		return sign;
	}

	public void setSign(Integer sign) {
		this.sign = sign;
	}

	public String getUniqueColumn() {
		return null;
	}
}

