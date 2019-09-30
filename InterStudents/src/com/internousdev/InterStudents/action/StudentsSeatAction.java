package com.internousdev.InterStudents.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.InterStudents.dto.StudentsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class StudentsSeatAction extends ActionSupport implements SessionAware{

	private Map <String,Object>session;
	private ArrayList <StudentsDTO> prevStudentsList;
	private ArrayList <StudentsDTO> studentsList;
	private String generation;

	public String execute(){
		String ret = SUCCESS;

		String nowGrade = String.valueOf(session.get("nowGrade"));
		if(nowGrade == "1ヵ月目生"){
			
		}

		return ret;
	}


	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public ArrayList<StudentsDTO> getPrevStudentsList() {
		return prevStudentsList;
	}
	public void setPrevStudentsList(ArrayList<StudentsDTO> prevStudentsList) {
		this.prevStudentsList = prevStudentsList;
	}
	public ArrayList<StudentsDTO> getStudentsList() {
		return studentsList;
	}
	public void setStudentsList(ArrayList<StudentsDTO> studentsList) {
		this.studentsList = studentsList;
	}
	public String getGeneration() {
		return generation;
	}
	public void setGeneration(String generation) {
		this.generation = generation;
	}
}
