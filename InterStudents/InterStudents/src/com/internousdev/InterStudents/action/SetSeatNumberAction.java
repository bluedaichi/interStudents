package com.internousdev.InterStudents.action;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.InterStudents.dao.StudentsListDAO;
import com.internousdev.InterStudents.dto.StudentsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SetSeatNumberAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;
	private ArrayList <StudentsDTO> studentsList;
	private ArrayList <StudentsDTO> studentsNameList;
	private String nowGrade;
	private int grade;


	public String execute(){
		String ret = SUCCESS;

		studentsList = new ArrayList <StudentsDTO>() ;
		String nowGrade = String.valueOf(session.get("nowGrade"));

		LocalDate ld = LocalDate.now();
		int nowMonth = ld.getMonthValue();
		String generation = null;

		if(nowGrade == "1ヵ月目生"){
			for(int i=1; i <= 35 ; i++){
				StudentsDTO student = new StudentsDTO();
				generation = nowMonth+"月生";

				if(i%7==4){
					student.setUserName(String.valueOf(i));
				}else{
					student.setUserName("　");
				}
				student.setTableNumber(i);
				studentsList.add(student);
			}

			StudentsListDAO sdao = new StudentsListDAO();
			studentsNameList = sdao.getGenerationInfo(generation);
			grade = 1;
		}

		if(nowGrade == "2ヵ月目生"){
			for(int i=1; i <= 30 ; i++){
				StudentsDTO student = new StudentsDTO();

				nowMonth -= 1;
				if(nowMonth<1){
					nowMonth += 12;
				}
				generation = nowMonth+"月生";

				student.setUserName(String.valueOf(i));
				student.setTableNumber(i);
				studentsList.add(student);
				grade = 2;
			}
		}

		if(nowGrade == "3ヵ月目生"){
			for(int i=1; i <= 30 ; i++){
				StudentsDTO student = new StudentsDTO();

				nowMonth -= 2;
				if(nowMonth<1){
					nowMonth += 12;
				}
				generation = nowMonth+"月生";

				student.setUserName(String.valueOf(i));
				student.setTableNumber(i);
				studentsList.add(student);
				grade = 3;
			}
		}

		return ret;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public ArrayList<StudentsDTO> getStudentsList() {
		return studentsList;
	}
	public void setStudentsList(ArrayList<StudentsDTO> studentsList) {
		this.studentsList = studentsList;
	}
	public String getNowGrade() {
		return nowGrade;
	}
	public void setNowGrade(String nowGrade) {
		this.nowGrade = nowGrade;
	}

	public ArrayList<StudentsDTO> getStudentsNameList() {
		return studentsNameList;
	}

	public void setStudentsNameList(ArrayList<StudentsDTO> studentsNameList) {
		this.studentsNameList = studentsNameList;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

}
