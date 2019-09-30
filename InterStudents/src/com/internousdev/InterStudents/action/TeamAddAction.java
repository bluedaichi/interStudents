package com.internousdev.InterStudents.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.InterStudents.dao.TeamDAO;
import com.opensymphony.xwork2.ActionSupport;

public class TeamAddAction extends ActionSupport implements SessionAware{

	private Map <String,Object>session;
	private String teamName1;
	private String teamName2;
	private String teamName3;
	private String generation;

	public String execute(){
		String ret = SUCCESS;

		if(teamName1 != null){
			TeamDAO tdao = new TeamDAO();
			tdao.teamAdd(teamName1, generation);
		}
		if(teamName2 != null){
			TeamDAO tdao = new TeamDAO();
			tdao.teamAdd(teamName2, generation);
		}
		if(teamName3 != null){
			TeamDAO tdao = new TeamDAO();
			tdao.teamAdd(teamName3,generation);
		}
		return ret;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getTeamName1() {
		return teamName1;
	}

	public void setTeamName1(String teamName1) {
		this.teamName1 = teamName1;
	}

	public String getTeamName2() {
		return teamName2;
	}

	public void setTeamName2(String teamName2) {
		this.teamName2 = teamName2;
	}

	public String getTeamName3() {
		return teamName3;
	}

	public void setTeamName3(String teamName3) {
		this.teamName3 = teamName3;
	}

	public String getGeneration() {
		return generation;
	}

	public void setGeneration(String generation) {
		this.generation = generation;
	}

}
