package com.internousdev.InterStudents.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.InterStudents.dao.NewsDAO;
import com.internousdev.InterStudents.dto.NewsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoHomeAction extends ActionSupport implements SessionAware{

	public Map<String,Object>session;
	private ArrayList <NewsDTO> newsList;

	public String execute() {
		String ret = ERROR;

		NewsDAO newsDAO = new NewsDAO();
		newsList = newsDAO.getNewsList("admin");

		ret = SUCCESS;

		return ret;
	}
	public ArrayList<NewsDTO> getNewsList() {
		return newsList;
	}
	public void setNewsList(ArrayList<NewsDTO> newsList) {
		this.newsList = newsList;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
