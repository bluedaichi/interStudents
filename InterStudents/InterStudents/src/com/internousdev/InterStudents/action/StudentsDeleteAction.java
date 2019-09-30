package com.internousdev.InterStudents.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.InterStudents.dao.StudentsListDAO;
import com.opensymphony.xwork2.ActionSupport;

public class StudentsDeleteAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private String checked;
	private String[] checkList;

	public String execute(){
		String ret = SUCCESS;

		checkList = checked.split(",");

		StudentsListDAO sdao = new StudentsListDAO();
		int count = 0 ;

		for(String students:checkList){
			count += sdao.deleteStudents(students);
		}
		if(count != checkList.length){
			ret = ERROR;
		}

		session.remove("studentsList");
		return ret;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String[] getCheckList() {
		return checkList;
	}

	public void setCheckList(String[] checkList) {
		this.checkList = checkList;
	}

}
