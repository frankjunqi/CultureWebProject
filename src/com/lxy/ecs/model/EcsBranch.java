package com.lxy.ecs.model;

import java.util.HashSet;
import java.util.Set;

import com.lxy.base.model.Need2JSON;

public class EcsBranch extends EcsModel {
	private static final long serialVersionUID = 1L;
	
	public static String REF = "EcsBranch";
	public static String PROP_PARENT = "parent";
	public static String PROP_SHORT_NAME = "shortName";
	public static String PROP_LONG_NAME = "longName";
	public static String PROP_ENGLISH_NAME = "englishName";
	public static String PROP_BRANCH_CODE = "branchCode";

	@Need2JSON
	private java.lang.String branchCode;
	@Need2JSON
	private java.lang.String shortName;
	@Need2JSON
	private java.lang.String longName;
	@Need2JSON
	private java.lang.String englishName;
	private EcsBranch parent;
	private Set childen = new HashSet();
	
	public java.lang.String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(java.lang.String branchCode) {
		this.branchCode = branchCode;
	}

	public java.lang.String getShortName() {
		return shortName;
	}

	public void setShortName(java.lang.String shortName) {
		this.shortName = shortName;
	}

	public java.lang.String getLongName() {
		return longName;
	}

	public void setLongName(java.lang.String longName) {
		this.longName = longName;
	}

	public java.lang.String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(java.lang.String englishName) {
		this.englishName = englishName;
	}

	public EcsBranch getParent() {
		return parent;
	}

	public void setParent(EcsBranch parent) {
		this.parent = parent;
	}
	
	public Set getChilden() {
		return childen;
	}

	public void setChilden(Set childen) {
		this.childen = childen;
	}
	
	public void copy(EcsBranch from) {
		this.setBranchCode(from.getBranchCode());
		this.setEnglishName(from.getEnglishName());
		this.setLongName(from.getLongName());
		this.setShortName(from.getShortName());
		this.setParent(from.getParent());
	}

	@Need2JSON
	public String getUniqueColumn() {
		return this.getBranchCode();
	}

	@Need2JSON
	public String getDisplayBranch() {
		return getBranchCode() + "(" + getShortName() + ")";
	}
	@Need2JSON
	public Boolean isBEACN(){
		if(this.parent == null && "BEA CN".equals(this.branchCode)){
			return true;
		}
		return false;
	}
}