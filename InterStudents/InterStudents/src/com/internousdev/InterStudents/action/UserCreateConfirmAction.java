package com.internousdev.InterStudents.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.InterStudents.dao.StudentsListDAO;
import com.internousdev.InterStudents.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private String userName;
	private String furigana;
	private String generation;
	private String userHobby;
	private String birthplace;
	private String userComment;
	public Map<String,Object>session;
	private List<String> loginIdErrorMessageList;
	private List<String> loginPasswordErrorMessageList;
	private List<String> userNameErrorMessageList;
	private List<String> furiganaErrorMessageList;
	private List<String> generationErrorMessageList;
	private List<String> userHobbyErrorMessageList;
	private List<String> birthplaceErrorMessageList;
	private List<String> userCommentErrorMessageList;
	private String checkExistsUserErrorMessage;
	StudentsListDAO studentsDAO = new StudentsListDAO();

	public String execute() {
		String  ret = ERROR;
		InputChecker inputChecker = new InputChecker();
		loginIdErrorMessageList = inputChecker.doCheck("ログインID", loginUserId, 1, 16, true, false, false, false, false, false);
		loginPasswordErrorMessageList = inputChecker.doCheck("ログインPassword", loginPassword, 1, 16, true, false, false, true, false, false);
		userNameErrorMessageList = inputChecker.doCheck("ユーザー名前", userName, 1, 16, true, true, true, false, true, false);
		furiganaErrorMessageList = inputChecker.doCheck("ふりがな", furigana, 1, 32, false, false, true, false, false, false);
		generationErrorMessageList = inputChecker.doCheck("入学月", generation, 0, 8, true, true, true, true, true, false);
		userHobbyErrorMessageList = inputChecker.doCheck("趣味", userHobby, 0, 20, true, true, true, true, true, true);
		birthplaceErrorMessageList = inputChecker.doCheck("出身地", birthplace, 0, 16, true, true, true, true, true, true);
		userCommentErrorMessageList = inputChecker.doCheck("コメント", userComment, 0, 50, true, true, true, true, true, true);
		if(
				loginIdErrorMessageList.size()> 0 || loginPasswordErrorMessageList.size()> 0 || userNameErrorMessageList.size()> 0 ||
				furiganaErrorMessageList.size() > 0 || generationErrorMessageList.size()> 0 || userHobbyErrorMessageList.size()> 0 ||
				birthplaceErrorMessageList.size()> 0 || userCommentErrorMessageList.size()> 0){
			return ret;
		}
		ret = SUCCESS;
		session.put("loginUserId",loginUserId);
		session.put("loginPassword", loginPassword);
		session.put("userName", userName);
		session.put("furigana", furigana);
		session.put("generation", generation);
		session.put("userHobby", userHobby);
		session.put("birthplace", birthplace);
		session.put("userComment", userComment);

		if(studentsDAO.checkExistsUser(loginUserId)){
			checkExistsUserErrorMessage = "使用できないユーザーIDです。";
			ret = ERROR;
			return ret;
		}
		return ret;
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
		public String getFurigana() {
			return furigana;
		}
		public void setFurigana(String furigana) {
			this.furigana = furigana;
		}
		public String getGeneration() {
			return generation;
		}
		public void setGeneration(String generation) {
			this.generation = generation;
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
		public List<String> getLoginIdErrorMessageList() {
			return loginIdErrorMessageList;
		}
		public void setLoginIdErrorMessageList(List<String> loginIdErrorMessageList) {
			this.loginIdErrorMessageList = loginIdErrorMessageList;
		}
		public List<String> getLoginPasswordErrorMessageList() {
			return loginPasswordErrorMessageList;
		}
		public void setLoginPasswordErrorMessageList(List<String> loginPasswordErrorMessageList) {
			this.loginPasswordErrorMessageList = loginPasswordErrorMessageList;
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
		public String getCheckExistsUserErrorMessage() {
			return checkExistsUserErrorMessage;
		}
		public void setCheckExistsUserErrorMessage(String checkExistsUserErrorMessage) {
			this.checkExistsUserErrorMessage = checkExistsUserErrorMessage;
		}
	}