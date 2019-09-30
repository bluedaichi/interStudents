package com.internousdev.InterStudents.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.InterStudents.dao.NewsDAO;
import com.internousdev.InterStudents.dto.NewsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class TeamNewsEditAction extends ActionSupport implements SessionAware{

private Map <String,Object> session;
private ArrayList <NewsDTO> newsList;
private String team;

	public String execute(){
		team = session.get("team_name").toString();
		String ret = SUCCESS;

		NewsDAO ndao = new NewsDAO();
		newsList = ndao.getNewsList(team);

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

public String getTeam() {
	return team;
}

public void setTeam(String team) {
	this.team = team;
}

}
