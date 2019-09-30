package com.internousdev.InterStudents.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.InterStudents.dao.StudentsListDAO;
import com.internousdev.InterStudents.dto.StudentsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class StudentsListForGeneralAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;
	private String generation;
	private ArrayList<StudentsDTO> studentsList;

	public String execute(){
		String ret = SUCCESS;

		studentsList = new ArrayList<StudentsDTO>();
		StudentsListDAO slDAO = new StudentsListDAO();

		generation = String.valueOf(session.get("generation"));
		studentsList = slDAO.getGenerationInfo(generation);

		return ret;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getGeneration() {
		return generation;
	}

	public void setGeneration(String generation) {
		this.generation = generation;
	}

	public ArrayList<StudentsDTO> getStudentsList() {
		return studentsList;
	}

	public void setStudentsList(ArrayList<StudentsDTO> studentsList) {
		this.studentsList = studentsList;
	}

}
