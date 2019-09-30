package com.internousdev.InterStudents.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.InterStudents.dao.ProfileDAO;
import com.internousdev.InterStudents.dto.ProfileDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProfileAction extends ActionSupport implements SessionAware{

	private String userName;
	private Map<String,Object>session;

	public String execute() {
		String ret = SUCCESS;

		ProfileDAO profileDAO = new ProfileDAO();

		ProfileDTO profileDTO = profileDAO.getProfileInfo(userName);
		session.put("ProfileInfo", profileDTO);

		return ret;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
