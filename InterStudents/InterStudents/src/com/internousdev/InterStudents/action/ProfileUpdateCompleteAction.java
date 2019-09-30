package com.internousdev.InterStudents.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.InterStudents.dao.ProfileUpdateConfirmDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ProfileUpdateCompleteAction extends ActionSupport implements SessionAware{

	private String userName;
	private String furigana;
	private String birthplace;
	private String userHobby;
	private String userComment;
	private String generation;
	public Map<String,Object>session;

	public String execute()throws SQLException{
		ProfileUpdateConfirmDAO profileUCDAO = new ProfileUpdateConfirmDAO();
		profileUCDAO.profileUpdate(
				session.get("login_user_id").toString(),
				session.get("userName").toString(),
				session.get("furigana").toString(),
				session.get("birthplace").toString(),
				session.get("userHobby").toString(),
				session.get("userComment").toString(),
				session.get("generation").toString()
				);

		String ret = SUCCESS;
		return ret;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFurigana() {
		return furigana;
	}

	public void setFurigana(String furigana) {
		this.furigana = furigana;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getUserHobby() {
		return userHobby;
	}

	public void setUserHobby(String userHobby) {
		this.userHobby = userHobby;
	}

	public String getUserComment() {
		return userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

	public String getGeneration() {
		return generation;
	}

	public void setGeneration(String generation) {
		this.generation = generation;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
