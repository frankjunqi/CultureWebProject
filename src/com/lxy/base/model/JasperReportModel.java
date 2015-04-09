package com.lxy.base.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class JasperReportModel implements Serializable{
	private static final long serialVersionUID = -8347398689294690915L;

	private List sourceList = new ArrayList();
	private String jasperFilePath;
	private String outPutFilePath;
	private HashMap paramter = new HashMap();
	
	public List getSourceList() {
		return sourceList;
	}
	public void setSourceList(List sourceList) {
		this.sourceList = sourceList;
	}
	public String getJasperFilePath() {
		return jasperFilePath;
	}
	public void setJasperFilePath(String jasperFilePath) {
		this.jasperFilePath = jasperFilePath;
	}
	public String getOutPutFilePath() {
		return outPutFilePath;
	}
	public void setOutPutFilePath(String outPutFilePath) {
		this.outPutFilePath = outPutFilePath;
	}
	public HashMap getParamter() {
		return paramter;
	}
	public void setParamter(HashMap paramter) {
		this.paramter = paramter;
	}
}
