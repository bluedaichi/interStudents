package com.internousdev.InterStudents.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.InterStudents.dto.NewsDTO;
import com.internousdev.InterStudents.util.DBConnector;
import com.internousdev.InterStudents.util.DateUtil;

public class NewsDAO {
	private DateUtil dU = new DateUtil();

	public void contribute(String templateImgPass, String attribute, String title, String comment) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "INSERT INTO"
				+ " news_table"
				+ "(template_img_pass,"
				+ " attribute,"
				+ " title,"
				+ " comment,"
				+ " insert_date)"
				+ "VALUES(?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, templateImgPass);
			ps.setString(2, attribute);
			ps.setString(3, title);
			ps.setString(4, comment);
			ps.setString(5, dU.getDate());
			ps.execute();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}


	public ArrayList<NewsDTO> getNewsList(String attribute) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<NewsDTO> newsDTOList = new ArrayList<NewsDTO>();

		String sql = "SELECT * FROM"
				+ " news_table"
				+ " WHERE attribute = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, attribute);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				NewsDTO newsDTO = new NewsDTO();
				newsDTO.setId(rs.getInt("id"));
				newsDTO.setTemplateImgPass(rs.getString("template_img_pass"));
				newsDTO.setAttribute(rs.getString("attribute"));
				newsDTO.setTitle(rs.getString("title"));
				newsDTO.setComment(rs.getString("comment"));
				newsDTO.setInsertDate(rs.getString("insert_date"));
				newsDTOList.add(newsDTO);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return newsDTOList;
	}

	public int newsCommentDelete(String id) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql ="DELETE FROM"
				+ " news_table"
				+ " WHERE id = ?";
		int ret = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ret = ps.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	public void newsUpdate(String templateImgPass, String attribute, String title, String comment, String id) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "UPDATE"
				+ " news_table"
				+ " SET template_img_pass = ?,"
				+ " attribute = ?,"
				+ " title = ?,"
				+ " comment = ?,"
				+ " insert_date = ?"
				+ " WHERE id=? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, templateImgPass);
			ps.setString(2, attribute);
			ps.setString(3, title);
			ps.setString(4, comment);
			ps.setString(5, dU.getDate());
			ps.setString(6, id);
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public NewsDTO getNews(String id) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		NewsDTO dto = new NewsDTO();

		String sql = "SELECT * FROM"
				+ " news_table"
				+ " WHERE id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();


			if(rs.next()) {
				dto.setId(rs.getInt("id"));
				dto.setTemplateImgPass(rs.getString("template_img_pass"));
				dto.setAttribute(rs.getString("attribute"));
				dto.setTitle(rs.getString("title"));
				dto.setComment(rs.getString("comment"));
				dto.setInsertDate(rs.getString("insert_date"));
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
}