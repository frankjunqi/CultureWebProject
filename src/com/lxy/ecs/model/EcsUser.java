package com.lxy.ecs.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lxy.base.model.Need2JSON;

public class EcsUser extends EcsModel {
	private static final long serialVersionUID = 1L;
	public static Map<String,String> USER_STATUS = new HashMap<String, String>();
	static{
		USER_STATUS.put("NORMAL", "正常");
		USER_STATUS.put("LOCKED", "锁定");
		USER_STATUS.put("LEAVE", "离职");
		USER_STATUS.put("NEW", "新增");
		USER_STATUS.put("", "");
		USER_STATUS.put(null, "");
	}
	
	public static String REF = "EcsUser";
	public static String PROP_OPER_ID = "operId";
	public static String PROP_REAL_NAME = "realName";
	public static String PROP_LAST_LOGIN_TIME = "lastLoginTime";
	public static String PROP_EMAIL = "email";
	public static String PROP_LOGIN_FLAG = "loginFlag";
	public static String PROP_EXPIRE_DATE = "expireDate";
	public static String PROP_USER_NAME = "userName";
	public static String PROP_USER_ENGLISHNAME = "englishName";
	public static String PROP_USER_STATUS = "userStatus";
	public static String PROP_LOGIN_FAILURE_TIMES = "loginFailureTimes";
	public static String PROP_USER_LOCALE = "locale";
	public static String PROP_USER_IP = "userIp";
	public static String PROP_BRANCH = "branch";
	public static String PROP_USER_LANID = "lanId";
	
	public static String USER_STATUS_NEW = "NEW";
	public static String USER_STATUS_NORMAL = "NORMAL";
	public static String USER_STATUS_LOCKED = "LOCKED";
	public static String USER_STATUS_LEAVE = "LEAVE";
	

	private String[] privilegesDesc;
	public String[] getPrivilegesDesc() {
		return privilegesDesc;
	}
	public void setPrivilegesDesc(String[] privilegesDesc) {
		this.privilegesDesc = privilegesDesc;
	}
	
	@Need2JSON
	private String lanId;
	@Need2JSON
	private String englishName;
	@Need2JSON
	private EcsBranch branch;
	@Need2JSON
	private java.lang.String operId;
	@Need2JSON
	private java.lang.String userName;
	@Need2JSON
	private java.lang.String realName;
	@Need2JSON
	private java.lang.String loginFlag;	
	private java.util.Date lastLoginTime;
	private java.util.Date expireDate;
	@Need2JSON
	private java.lang.String email;
	private Integer loginFailureTimes;
	@Need2JSON
	private String loginIpAddress;
	@Need2JSON
	private String userStatus;
	@Need2JSON
	public  String locale;
	@Need2JSON
	private String userIp;	
	@Need2JSON
	private String checkTypes;
	@Need2JSON
	private Set<EcsRole> roles = new HashSet<EcsRole>();

	public String getLanId() {
		return lanId;
	}
	public void setLanId(String lanId) {
		this.lanId = lanId;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public EcsBranch getBranch() {
		return branch;
	}
	public void setBranch(EcsBranch branch) {
		this.branch = branch;
	}
	public java.lang.String getOperId() {
		return operId;
	}
	public void setOperId(java.lang.String operId) {
		this.operId = operId;
	}
	public java.lang.String getUserName() {
		return userName;
	}
	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}
	public java.lang.String getRealName() {
		return realName;
	}
	public void setRealName(java.lang.String realName) {
		this.realName = realName;
	}
	public java.lang.String getLoginFlag() {
		return loginFlag;
	}
	public void setLoginFlag(java.lang.String loginFlag) {
		this.loginFlag = loginFlag;
	}
	public java.util.Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(java.util.Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public java.util.Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(java.util.Date expireDate) {
		this.expireDate = expireDate;
	}
	public java.lang.String getEmail() {
		return email;
	}
	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	public Integer getLoginFailureTimes() {
		return loginFailureTimes;
	}
	public void setLoginFailureTimes(Integer loginFailureTimes) {
		this.loginFailureTimes = loginFailureTimes;
	}
	public String getLoginIpAddress() {
		return loginIpAddress;
	}
	public void setLoginIpAddress(String loginIpAddress) {
		this.loginIpAddress = loginIpAddress;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public Set<EcsRole> getRoles() {
		return roles;
	}
	public void setRoles(Set<EcsRole> roles) {
		this.roles = roles;
	}
	public String getCheckTypes() {
		return checkTypes;
	}
	public void setCheckTypes(String checkTypes) {
		this.checkTypes = checkTypes;
	}
	@Need2JSON
	public boolean isAdmin(){
		if(this.roles.size()>0){
			for (EcsRole role : this.roles) {
				if(EcsRole.ADMIN.contains( role.getRoleName() )){
					return true;
				}
			}
		}
		return false;
	}
	@Need2JSON
	public boolean isCenterBanck(){
		if(this.branch.getParent()==null){
			return true;
		}
		return false;
	}
	public boolean notAdmin(){
		return (!isAdmin());
	}

	/* 
	 * @param String operatorID-操作员代码
	 * @param String plainPass-操作员密码
	 * @return 加密后密码
	 */
	public static String crypt2(String operatorID, String plainPass) {
		int i, j, k, xx;
		int idx[] = new int[13];
		String rr;
		String cryptPass = "";

		idx[0] = 13;
		idx[1] = 41;
		idx[2] = 7;
		idx[3] = 17;
		idx[4] = 29;
		idx[5] = 5;
		idx[6] = 19;
		idx[7] = 37;
		idx[8] = 11;
		idx[9] = 47;
		idx[10] = 31;
		idx[11] = 23;
		idx[12] = 53;

		if (operatorID == null || plainPass == null)
			return "";
		if (operatorID.length() < 7)
			operatorID = operatorID + "       ";
		if (plainPass.length() < 12)
			plainPass = plainPass + "            ";

		//补充长度到24位，使中心点在 plainPass 之前
		rr = operatorID.substring(0, 7) + " CMIS" + plainPass.substring(0, 12);
		xx = 0;
		k = 24;

		while (k != 0)
			xx += (rr.charAt(--k) & 0x7f);
		for (i = 0; i < 12; i++) {
			j = ((rr.charAt(i) & 0x7f) + (rr.charAt(23 - i) & 0x7f)) / 2;
			k = ((xx % j) * idx[i] + idx[i]) % j;
			while (k < 48)
				k += idx[i];
			while (k > 57 && k < 65)
				k += (i + 1);
			while (k > 'Z')
				k -= (i + 1);
			while (k > 57 && k < 65)
				k += i;
			cryptPass = cryptPass + String.valueOf((char) k);
		}

		return cryptPass;
	}

	@Need2JSON("privileges")
	public String[] getPrivileges() { 
		if(getRoles().size()==0)
			return new String[0];
		List<String> l = new ArrayList<String>();
		for (EcsRole role : roles) {
			Set<String> privileges = role.getPrivileges();
			for(String p: privileges){
				l.add(p);
			}
		}
		String[] s = new String[l.size()];
		return (String[]) l.toArray(s);
	}
	public Set<String> getPrivilegesList() { 
		if(getRoles().size()==0)
			return null;
		Set<String> l = new HashSet<String>();
		for (EcsRole role : roles) {
			Set<String> privileges = role.getPrivileges();
			l.addAll(privileges);
		}
		return l;
	}
	@Need2JSON("roleIds")
	public String[] getRoleIds(){
		if(getRoles().size()==0)
			return new String[0];
		List<String> l = new ArrayList<String>();
		for (EcsRole role : roles) {
			l.add(role.getId().toString());
		}
		String[] s = new String[l.size()];
		return (String[]) l.toArray(s);
	}
	
	public void copy(EcsUser from) {
		this.setUserName(from.getUserName());
		this.setEmail(from.getEmail());
		this.setExpireDate(from.getExpireDate());
		this.setLoginFlag(from.getLoginFlag());
		this.setOperId(from.getOperId());
		this.setRealName(from.getRealName());
		this.setLastLoginTime(from.getLastLoginTime());
		this.setUserStatus(from.getUserStatus());
		this.setRoles(from.getRoles());
		this.setBranch(from.getBranch());
		this.setEnglishName( from.getEnglishName() );
		this.setLanId( from.getLanId() );
	}
	
	@Override
	public String getUniqueColumn(){
		return getOperId();
	}
}