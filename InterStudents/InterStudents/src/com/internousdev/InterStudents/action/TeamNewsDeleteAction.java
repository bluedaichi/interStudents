package com.internousdev.InterStudents.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.InterStudents.dao.NewsDAO;
import com.opensymphony.xwork2.ActionSupport;

public class TeamNewsDeleteAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private String[] checkList;

	public String execute(){
		String ret = SUCCESS;
		int count = 0;

		NewsDAO ndao = new NewsDAO();

		for(String commentId : checkList){
			count += ndao.newsCommentDelete(commentId);
		}
		if(count != checkList.length){
			ret = ERROR;
		}

		return ret;
	}

	public String[] getCheckList() {
		return checkList;
	}

	public void setCheckList(String[] checkList) {
		this.checkList = checkList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}

