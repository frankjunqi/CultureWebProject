package com.lxy.base.model;

import java.io.Serializable;
import java.util.List;

public class EmailModel implements Serializable{
	private static final long serialVersionUID = 7334824377466774628L;
	private String from;
	private List<String> to; 
	private String subject;
	private String msg;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public List<String> getTo() {
		return to;
	}
	public void setTo(List<String> to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
