package com.internousdev.InterStudents.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.InterStudents.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class ProfileUpdateConfirmAction extends ActionSupport implements SessionAware{

	private String userName;
	private String furigana;
	private String birthplace;
	private String userHobby;
	private String userComment;
	private String generation;
	public Map<String,Object>session;
	private List<String> userNameErrorMessageList;
	private List<String> furiganaErrorMessageList;
	private List<String> generationErrorMessageList;
	private List<String> userHobbyErrorMessageList;
	private List<String> birthplaceErrorMessageList;
	private List<String> userCommentErrorMessageList;

	public String execute() {
		String  ret = ERROR;
		InputChecker inputChecker = new InputChecker();
		userNameErrorMessageList = inputChecker.doCheck("ユーザー名前", userName, 1, 16, true, true, true, false, true, false);
		furiganaErrorMessageList = inputChecker.doCheck("ふりがな", furigana, 1, 32, false, false, true, false, false, false);
		generationErrorMessageList = inputChecker.doCheck("入学月", generation, 0, 8, true, true, true, true, true, true);
		userHobbyErrorMessageList = inputChecker.doCheck("趣味", userHobby, 0, 20, true, true, true, true, true, true);
		birthplaceErrorMessageList = inputChecker.doCheck("出身地", birthplace, 0, 16, true, true, true, true, true, true);
		userCommentErrorMessageList = inputChecker.doCheck("コメント", userComment, 0, 50, true, true, true, true, true, true);
		if(
				userNameErrorMessageList.size()> 0 || furiganaErrorMessageList.size() > 0 || generationErrorMessageList.size()> 0 ||
				userHobbyErrorMessageList.size()> 0 || birthplaceErrorMessageList.size()> 0 || userCommentErrorMessageList.size()> 0){
			return ret;
		}
		ret = SUCCESS;
			session.put("userName",userName);
			session.put("furigana", furigana);
			session.put("birthplace", birthplace);
			session.put("userHobby", userHobby);
			session.put("userComment", userComment);
			session.put("generation", generation);
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

	public List<String> getUserNameErrorMessageList() {
		return userNameErrorMessageList;
	}

	public void setUserNameErrorMessageList(List<String> userNameErrorMessageList) {
		this.userNameErrorMessageList = userNameErrorMessageList;
	}

	public List<String> getFuriganaErrorMessageList() {
		return furiganaErrorMessageList;
	}

	public void setFuriganaErrorMessageList(List<String> furiganaErrorMessageList) {
		this.furiganaErrorMessageList = furiganaErrorMessageList;
	}

	public List<String> getGenerationErrorMessageList() {
		return generationErrorMessageList;
	}

	public void setGenerationErrorMessageList(List<String> generationErrorMessageList) {
		this.generationErrorMessageList = generationErrorMessageList;
	}

	public List<String> getUserHobbyErrorMessageList() {
		return userHobbyErrorMessageList;
	}

	public void setUserHobbyErrorMessageList(List<String> userHobbyErrorMessageList) {
		this.userHobbyErrorMessageList = userHobbyErrorMessageList;
	}

	public List<String> getBirthplaceErrorMessageList() {
		return birthplaceErrorMessageList;
	}

	public void setBirthplaceErrorMessageList(List<String> birthplaceErrorMessageList) {
		this.birthplaceErrorMessageList = birthplaceErrorMessageList;
	}

	public List<String> getUserCommentErrorMessageList() {
		return userCommentErrorMessageList;
	}

	public void setUserCommentErrorMessageList(List<String> userCommentErrorMessageList) {
		this.userCommentErrorMessageList = userCommentErrorMessageList;
	}
}