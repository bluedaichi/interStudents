package com.internousdev.InterStudents.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.InterStudents.dao.StudyCreateCompleteDAO;
import com.internousdev.InterStudents.dto.StudyDTO;
import com.opensymphony.xwork2.ActionSupport;

public class StudyCreateConfirmAction extends ActionSupport implements SessionAware {

	private String studyName;
	private String studyHomework;
	private String studyPeriod;

	List<StudyDTO>studyDTOList = new ArrayList<StudyDTO>();
	public Map<String,Object> session;

	public String execute() {
		String result = ERROR;
		StudyCreateCompleteDAO studyCreateCompleteDAO = new StudyCreateCompleteDAO();

		int count = studyCreateCompleteDAO.INSERT(studyName,studyHomework,studyPeriod);
		if(count > 0 ) {
			studyDTOList = studyCreateCompleteDAO.select();
			session.put("studyDTOList",studyDTOList);

			result= SUCCESS;
		}
		return result;
	}


	public List<StudyDTO> getStudyDTOList() {
		return studyDTOList;
	}

	public void setStudyDTOList(List<StudyDTO> studyDTOList) {
		this.studyDTOList = studyDTOList;
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


