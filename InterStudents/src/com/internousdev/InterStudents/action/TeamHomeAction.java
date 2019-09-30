package com.internousdev.InterStudents.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.InterStudents.dao.BoardDAO;
import com.internousdev.InterStudents.dao.NewsDAO;
import com.internousdev.InterStudents.dao.StudentsListDAO;
import com.internousdev.InterStudents.dto.BoardDTO;
import com.internousdev.InterStudents.dto.NewsDTO;
import com.internousdev.InterStudents.dto.StudentsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class TeamHomeAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private ArrayList <BoardDTO> boardList;
	private ArrayList <NewsDTO> newsList;
	private ArrayList <StudentsDTO> prevStudentsList;
	private ArrayList <StudentsDTO> studentsList;
	private String team;

	public  String execute(){
	String ret = SUCCESS;
	team = session.get("team_name").toString();

	//チームの掲示板リストの作成
	BoardDAO bdao = new BoardDAO();
	boardList = bdao.getBoardInfo(team);

	//チームのお知らせリストの作成
	NewsDAO ndao = new NewsDAO();
	newsList = ndao.getNewsList(team);

	//チームメンバーリストの作成
	StudentsListDAO sdao = new StudentsListDAO();
	prevStudentsList = sdao.getTeamMemberInfo(team);

	//チームメンバーを席に格納する処理
	studentsList = new ArrayList <StudentsDTO>() ;
	for(int i=1; i <= 12 ; i++){
		StudentsDTO student = new StudentsDTO();
		student.setTeamName(team);
		student.setUserName("　");
		student.setTableNumber(i);
		studentsList.add(student);
	}
	for(StudentsDTO s:prevStudentsList){
		studentsList.set(s.getTableNumber()-1, s);
	}

	return ret;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<BoardDTO> getBoardList() {
		return boardList;
	}

	public void setBoardList(ArrayList<BoardDTO> boardList) {
		this.boardList = boardList;
	}

	public ArrayList<NewsDTO> getNewsList() {
		return newsList;
	}

	public void setNewsList(ArrayList<NewsDTO> newsList) {
		this.newsList = newsList;
	}

	public ArrayList<StudentsDTO> getStudentsList() {
		return studentsList;
	}

	public void setStudentsList(ArrayList<StudentsDTO> studentsList) {
		this.studentsList = studentsList;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

}
