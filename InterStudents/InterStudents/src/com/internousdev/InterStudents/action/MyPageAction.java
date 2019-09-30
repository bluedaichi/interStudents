package com.internousdev.InterStudents.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.InterStudents.dao.MyPageDAO;
import com.internousdev.InterStudents.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{

	public Map<String,Object>session;

	public String execute(){
		String ret = ERROR;

		if(!session.containsKey("login_user_id")) {
			return ret;
		}
		String ret1 = SUCCESS;

		MyPageDAO myDAO = new MyPageDAO();

		MyPageDTO myDTO = myDAO.getMyStudyInfo(session.get("login_user_id").toString());
		session.put("studyInfo",myDTO);

		return ret1;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
