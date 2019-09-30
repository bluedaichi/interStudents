package com.internousdev.InterStudents.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.InterStudents.dao.BoardDAO;
import com.opensymphony.xwork2.ActionSupport;

public class TeamBoardUpdateAction extends ActionSupport implements SessionAware{

	private Map <String,Object> session;
	private String team;
	private String title;
	private String comment;
	private String id;

	public String execute(){
		String ret = SUCCESS;

		BoardDAO bdao = new BoardDAO();
		team = session.get("team_name").toString();
		bdao.updateComment(session.get("user_name").toString(), team, title, comment,id);

		return ret;
	}


	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
