package com.internousdev.InterStudents.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.InterStudents.dto.BoardDTO;
import com.internousdev.InterStudents.util.DBConnector;
import com.internousdev.InterStudents.util.DateUtil;

public class BoardDAO {

	private DateUtil dU = new DateUtil();
	ArrayList<BoardDTO> boardDTOList = new ArrayList<BoardDTO>();

	public void contribute(String contributorName, String attribute, String title, String comment) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "INSERT INTO"
				+ " board_table"
				+ "(contributor_name,"
				+ " attribute,"
				+ " title,"
				+ " comment,"
				+ " insert_date)"
				+ "VALUES(?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, contributorName);
			ps.setString(2, attribute);
			ps.setString(3, title);
			ps.setString(4, comment);
			ps.setString(5, dU.getDate());

			ps.execute();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}


	public ArrayList<BoardDTO> getBoardInfo(String attribute){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT * FROM board_table WHERE attribute = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, attribute);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				BoardDTO boardDTO= new BoardDTO();
				boardDTO.setId(rs.getInt("id"));
				boardDTO.setContributorName(rs.getString("contributor_name"));
				boardDTO.setAttribute(rs.getString("attribute"));
				boardDTO.setTitle(rs.getString("title"));
				boardDTO.setComment(rs.getString("comment"));
				boardDTO.setInsertDate(rs.getString("insert_date"));
				boardDTOList.add(boardDTO);


			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return boardDTOList;
	}

	public int boardCommentDelete(String id) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql ="DELETE FROM"
				+ " board_table"
				+ " WHERE id = ?";
		int ret = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ret = ps.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	public void updateComment(String contributorName, String attribute, String title, String comment,String id) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "UPDATE"
				+ " board_table"
				+ " SET contributor_name = ?,"
				+ " attribute = ?,"
				+ " title = ?,"
				+ " comment = ?,"
				+ " insert_date = ?"
				+ " WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, contributorName);
			ps.setString(2, attribute);
			ps.setString(3, title);
			ps.setString(4, comment);
			ps.setString(5, dU.getDate());
			ps.setString(6, id);
			ps.execute();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}