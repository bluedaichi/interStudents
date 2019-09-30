package com.internousdev.InterStudents.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.InterStudents.dao.NewsDAO;
import com.internousdev.InterStudents.dto.NewsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class NewsDetailsAction extends ActionSupport implements SessionAware{

	private String id;
	private Map<String,Object>session;

	public String execute() {
		String ret = ERROR;

		NewsDAO newsDAO = new NewsDAO();

		NewsDTO newsDTO = newsDAO.getNews(id);
		session.put("newsDTO", newsDTO);

		ret = SUCCESS;

		return ret;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
