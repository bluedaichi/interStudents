package com.internousdev.InterStudents.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.InterStudents.dao.BoardDAO;
import com.internousdev.InterStudents.dto.BoardDTO;
import com.opensymphony.xwork2.ActionSupport;

public class TeamBoardEditAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private String team;
	private ArrayList <BoardDTO> boardList;

	public String execute(){
		String ret = SUCCESS;
		team = session.get("team_name").toString();
		//チームの掲示板リストの作成
		BoardDAO bdao = new BoardDAO();
		boardList = bdao.getBoardInfo(team);

		return ret;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public ArrayList<BoardDTO> getBoardList() {
		return boardList;
	}

	public void setBoardList(ArrayList<BoardDTO> boardList) {
		this.boardList = boardList;
	}


}
