package com.internousdev.InterStudents.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.InterStudents.dao.StudyCreateCompleteDAO;
import com.internousdev.InterStudents.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class StudyCreateCompleteAction extends ActionSupport implements SessionAware {

	private String studyName;
	private String studyHomework;
	private String studyPeriod;
	public Map<String,Object> session;
	StudyCreateCompleteDAO dao = new StudyCreateCompleteDAO();

	public String execute() {
		String ret = ERROR;

		MyPageDTO dto = (MyPageDTO) session.get("studyInfo");

		if(dto.getStudyName() == null) {
			dao.Create(session.get("login_user_id").toString(), studyName, studyHomework, studyPeriod);
		}else {
			dao.Update(session.get("login_user_id").toString(), studyName, studyHomework, studyPeriod);
		}
		ret = SUCCESS;
		return ret;
	}

	public String getStudyName() {
		return studyName;
	}

	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}

	public String getStudyHomework() {
		return studyHomework;
	}

	public void setStudyHomework(String studyHomework) {
		this.studyHomework = studyHomework;
	}

	public String getStudyPeriod() {
		return studyPeriod;
	}

	public void setStudyPeriod(String studyPeriod) {
		this.studyPeriod = studyPeriod;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}