package com.internousdev.InterStudents.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {
	public Map<String,Object>session;
	public String execute() {
		return SUCCESS;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}