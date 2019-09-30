package com.internousdev.InterStudents.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.InterStudents.dao.TeamDAO;
import com.internousdev.InterStudents.dto.TeamDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoTeamAddAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private ArrayList<TeamDTO> teamList;

	public String execute(){
		String ret = SUCCESS;
		TeamDAO tdao = new TeamDAO();
		teamList = tdao.getAllTeamList();

		return ret;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<TeamDTO> getTeamList() {
		return teamList;
	}

	public void setTeamList(ArrayList<TeamDTO> teamList) {
		this.teamList = teamList;
	}

}
