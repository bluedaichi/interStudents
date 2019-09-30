package com.internousdev.InterStudents.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.InterStudents.dao.TeamDAO;
import com.opensymphony.xwork2.ActionSupport;

public class TeamDeleteAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;
	private String[] checkList;

	public String execute(){
		String ret = SUCCESS;
		int count = 0;

		TeamDAO tdao = new TeamDAO();

		for(String teamtId : checkList){
			count += tdao.teamDelete(teamtId);
		}
		if(count != checkList.length){
			ret = ERROR;
		}
		return ret;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String[] getCheckList() {
		return checkList;
	}

	public void setCheckList(String[] checkList) {
		this.checkList = checkList;
	}

}
