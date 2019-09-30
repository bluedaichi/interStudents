package com.internousdev.InterStudents.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.InterStudents.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private String userName;
	private String furigana;
	private String generation;
	private String userHobby;
	private String birthplace;
	private String userComment;
	private Map<String,Object> session;

	public String execute(){
		UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();
		userCreateCompleteDAO.createUser(
				session.get("loginUserId").toString(),
				session.get("loginPassword").toString(),
				session.get("userName").toString(),
				session.get("generation").toString(),
				session.get("furigana").toString(),
				session.get("userHobby").toString(),
				session.get("birthplace").toString(),
				session.get("userComment").toString());

		String result = SUCCESS;
		return result;
	}

	public String getGeneration() {
		return generation;
	}

	public void setGeneration(String generation) {
		this.generation = generation;
	}

	public String getFurigana() {
		return furigana;
	}

	public void setFurigana(String furigana) {
		this.furigana = furigana;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserHobby() {
		return userHobby;
	}

	public void setUserHobby(String userHobby) {
		this.userHobby = userHobby;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getUserComment() {
		return userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}