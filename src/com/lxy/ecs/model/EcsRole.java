package com.lxy.ecs.model;

import java.util.Arrays;
import java.util.List;

import com.lxy.base.model.Need2JSON;

public class EcsRole extends EcsModel {
	private static final long serialVersionUID = 1L;
	public static final List<String> ADMIN = Arrays.asList(new String[]{"ADMIN" , "SecurityAdmin"});
	public static String REF = "EcsRole";
	public static String PROP_LONG_DESC = "longDesc";
	public static String PROP_ROLE_NAME = "roleName";

	// fields
	@Need2JSON
	private java.lang.String roleName;
	@Need2JSON
	private java.lang.String longDesc;
	
	@Need2JSON("displayName")
	public String getRoleDisplay(){
		return ( this.roleName == null ? "" : this.roleName ) + "(" + ( this.longDesc == null ? "" : this.longDesc ) + ")";
	}

	// collections
	private java.util.Set<String> privileges;


	public void addToPrivileges (String privilege) {
		if (null == getPrivileges()) 
			setPrivileges(new java.util.HashSet<String>());
		getPrivileges().add(privilege);
	}

	/**
	 * Return the value associated with the column: Role_Name
	 */
	public java.lang.String getRoleName () {
		return roleName;
	}

	/**
	 * Set the value related to the column: Role_Name
	 * @param roleName the Role_Name value
	 */
	public void setRoleName (java.lang.String roleName) {
		this.roleName = roleName;
	}



	/**
	 * Return the value associated with the column: Long_Desc
	 */
	public java.lang.String getLongDesc () {
		return longDesc;
	}

	/**
	 * Set the value related to the column: Long_Desc
	 * @param longDesc the Long_Desc value
	 */
	public void setLongDesc (java.lang.String longDesc) {
		this.longDesc = longDesc;
	}

	/**
	 * Return the value associated with the column: privileges
	 */
	public java.util.Set<String> getPrivileges () {
		return privileges;
	}

	/**
	 * Set the value related to the column: privileges
	 * @param privileges the privileges value
	 */
	public void setPrivileges (java.util.Set<String> privileges) {
		this.privileges = privileges;
	}
	public void copy(EcsRole from) {	
		this.setLongDesc(from.getLongDesc());
		this.setRoleName(from.getRoleName());
	}

	@Override
	public String getUniqueColumn() {
		return this.getRoleName();
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