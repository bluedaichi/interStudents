package com.internousdev.InterStudents.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.InterStudents.dao.StudentsListDAO;
import com.internousdev.InterStudents.dao.TeamDAO;
import com.internousdev.InterStudents.dto.StudentsDTO;
import com.internousdev.InterStudents.dto.TeamDTO;
import com.opensymphony.xwork2.ActionSupport;

public class StudentsListAction extends ActionSupport implements SessionAware{

	private ArrayList<String> generationArray;
	private String generation;
	private String search;
	private Map<String,Object>session;
	private ArrayList<StudentsDTO> studentsList;
	private ArrayList<TeamDTO> teamList;

	public String execute(){
		String ret = SUCCESS;

		studentsList = new ArrayList<StudentsDTO>();
		StudentsListDAO slDAO = new StudentsListDAO();

		//セレクトタグの生成
		generationArray = new ArrayList<String>();
		generationArray.add("生徒一覧");
		for(int i=1;i<=12;i++){
			String array = i + "月生";
			generationArray.add(array);
		}

		//アドミンがアクセスしたときに利用する「チームリスト」を作成する。
		TeamDAO tdao = new TeamDAO();
		if(generation != null){
			teamList = tdao.getTeamList(generation);
		}

		//「生徒一覧」を選択されている場合はすべての生徒を表示させる。
		if(generation != null){
			if(search != null) {
				if(generation.equals("生徒一覧")){
					studentsList = slDAO.searchAllStudents(search);
				}else{
					studentsList = slDAO.searchStudents(generation,search);
				}
			}else{
				if(generation.equals("生徒一覧")){
					studentsList = slDAO.getAllStudentsInfo();
				}else{
					studentsList = slDAO.getGenerationInfo(generation);
				}
			}
			session.put("studentsList",studentsList);
		}

		return ret;
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

	public ArrayList<StudentsDTO> getStudentsList() {
		return studentsList;
	}

	public void setStudentsList(ArrayList<StudentsDTO> studentsList) {
		this.studentsList = studentsList;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public ArrayList<String> getGenerationArray() {
		return generationArray;
	}

	public void setGenerationArray(ArrayList<String> generationArray) {
		this.generationArray = generationArray;
	}

	public ArrayList<TeamDTO> getTeamList() {
		return teamList;
	}

	public void setTeamList(ArrayList<TeamDTO> teamList) {
		this.teamList = teamList;
	}

}