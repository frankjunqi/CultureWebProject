package com.lxy.ecs.model;

import com.lxy.base.model.Need2JSON;

public class EcsSystemParameter extends EcsModel {
	private static final long serialVersionUID = 1186432480691046495L;
	public static String REF = "EcsSystemParameter";
	public static String PROP_PARA_VALUE = "paraValue";
	public static String PROP_PARA_DESC = "paraDesc";
	public static String PROP_PARA_NAME = "paraName";
	public static String PROP_SYSTEM_PARAM = "systemPara";
	
	
	@Need2JSON
	private java.lang.String paraName;
	@Need2JSON
	private java.lang.String paraValue;
	@Need2JSON
	private java.lang.String paraDesc;
	
	@Need2JSON
	private boolean systemPara;

	public java.lang.String getParaName() {
		return paraName;
	}
	public void setParaName(java.lang.String paraName) {
		this.paraName = paraName;
	}
	public java.lang.String getParaValue() {
		return paraValue;
	}
	public void setParaValue(java.lang.String paraValue) {
		this.paraValue = paraValue;
	}
	public java.lang.String getParaDesc() {
		return paraDesc;
	}
	public void setParaDesc(java.lang.String paraDesc) {
		this.paraDesc = paraDesc;
	}

	public boolean isSystemPara() {
		return systemPara;
	}

	public void setSystemPara(boolean systemPara) {
		this.systemPara = systemPara;
	}
	@Override
	public String getUniqueColumn() {
		// TODO Auto-generated method stub
		return this.paraName;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj, this.getClass());
	}
}