package com.internousdev.InterStudents.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.InterStudents.dao.NewsDAO;
import com.internousdev.InterStudents.dto.NewsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class NewsContributeAction extends ActionSupport implements SessionAware{

	private Map <String,Object> session;
	private ArrayList <NewsDTO> newsList;
	private String title;
	private String comment;
	private String templateImgPass;

	public String execute(){
		String ret = SUCCESS;

		NewsDAO ndao = new NewsDAO();
		ndao.contribute(templateImgPass, "admin", title, comment);

		return ret;
	}


	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public ArrayList<NewsDTO> getNewsList() {
		return newsList;
	}
	public void setNewsList(ArrayList<NewsDTO> newsList) {
		this.newsList = newsList;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getTemplateImgPass() {
		return templateImgPass;
	}
	public void setTemplateImgPass(String templateImgPass) {
		this.templateImgPass = templateImgPass;
	}

}
