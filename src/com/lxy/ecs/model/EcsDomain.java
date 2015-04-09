package com.lxy.ecs.model;

import java.util.Date;

import com.lxy.base.model.Need2JSON;

public class EcsDomain extends EcsModel {
	private static final long serialVersionUID = 3048737746766928718L;
	@Need2JSON
	private String code;
	@Need2JSON
	private String description;
	@Need2JSON
	private String dnsName;
	private String ip;
	private Date lastFailTime;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getLastFailTime() {
		return lastFailTime;
	}
	public void setLastFailTime(Date lastFailTime) {
		this.lastFailTime = lastFailTime;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDnsName() {
		return dnsName;
	}
	public void setDnsName(String dnsName) {
		this.dnsName = dnsName;
	}
	@Override
	public String getUniqueColumn() {
		return this.dnsName;
	}
	public String getFullDNSName(){
		return this.dnsName + "." + this.code;
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj, this.getClass());
	}
}
