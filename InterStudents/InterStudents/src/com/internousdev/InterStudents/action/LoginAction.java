package com.internousdev.InterStudents.action;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.InterStudents.dao.LoginDAO;
import com.internousdev.InterStudents.dto.LoginDTO;
import com.internousdev.InterStudents.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private String result;
	private boolean loginFlg;
	private Map<String, Object>session;
	private List<String>loginUserIdErrorMessageList;
	private List<String>passwordErrorMessageList;
	private String errorMessage;

	public String execute() {
		LoginDAO loginDAO = new LoginDAO();
		LoginDTO loginDTO = new LoginDTO();
		String nowGrade = "卒業生";
		String ret = ERROR;

		InputChecker inputChecker = new InputChecker();
		loginUserIdErrorMessageList = inputChecker.doCheck("ユーザーID", loginUserId, 1, 16, true, false, false, true, false, false);
		passwordErrorMessageList = inputChecker.doCheck("ユーザーPassword", loginPassword, 1, 16, true, false, false, true, false, false);
		if(loginUserIdErrorMessageList.size()> 0 || passwordErrorMessageList.size()> 0) {
			return ret;
		}

		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", loginDTO);

		if(((LoginDTO) session.get("loginUser")).getLoginFlg()) {
			ret = SUCCESS;

			session.put("login_user_id",loginDTO.getLoginId());
			session.put("user_name",loginDTO.getUserName());
			session.put("adminFlg", loginDTO.getAdminFlg());
			session.put("loginFlg", loginFlg);
			if(loginDTO.getTeamName() != null){
				session.put("team_name", loginDTO.getTeamName());
			}
			if(loginDTO.getGeneration() != null){
				String generation = loginDTO.getGeneration();
				session.put("generation", generation);
				int whenEnter = Integer.parseInt(generation.substring(0, 1));

				LocalDate ld = LocalDate.now();
				int nowMonth = ld.getMonthValue();

				if(nowMonth<3 && whenEnter>10){
					nowMonth += 12;
				}
				int grade = nowMonth - whenEnter;
				if(0<= grade && grade < 3){
					grade += 1;
					nowGrade = String.valueOf(grade)+"ヵ月目生";
				}
			}
			session.put("nowGrade", nowGrade);
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public boolean isLoginFlg() {
		return loginFlg;
	}

	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<String> getLoginUserIdErrorMessageList() {
		return loginUserIdErrorMessageList;
	}

	public void setLoginUserIdErrorMessageList(List<String> loginUserIdErrorMessageList) {
		this.loginUserIdErrorMessageList = loginUserIdErrorMessageList;
	}

	public List<String> getPasswordErrorMessageList() {
		return passwordErrorMessageList;
	}

	public void setPasswordErrorMessageList(List<String> passwordErrorMessageList) {
		this.passwordErrorMessageList = passwordErrorMessageList;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}