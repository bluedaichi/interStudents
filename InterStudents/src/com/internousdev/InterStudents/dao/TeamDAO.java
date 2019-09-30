package com.internousdev.InterStudents.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.InterStudents.dto.TeamDTO;
import com.internousdev.InterStudents.util.DBConnector;

public class TeamDAO {

	public ArrayList <TeamDTO> getAllTeamList(){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList <TeamDTO> dtoList = new ArrayList<TeamDTO>();

		String sql = "SELECT *"
				+ " FROM team_table";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				TeamDTO dto = new TeamDTO();
				dto.setId(rs.getString("id"));
				dto.setTeamName(rs.getString("name"));
				dto.setGeneration(rs.getString("generation"));
				dtoList.add(dto);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return dtoList;
	}

	public ArrayList <TeamDTO> getTeamList(String generation){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList <TeamDTO> dtoList = new ArrayList<TeamDTO>();

		String sql = "SELECT *"
				+ " FROM team_table"
				+ " WHERE generation = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, generation);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				TeamDTO dto = new TeamDTO();
				dto.setId(rs.getString("id"));
				dto.setTeamName(rs.getString("name"));
				dto.setGeneration(rs.getString("generation"));
				dtoList.add(dto);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return dtoList;
	}

	public void teamAdd(String teamName , String generation){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "INSERT INTO"
				+ " team_table"
				+ " (name,"
				+ " generation)"
				+ " VALUES(?,?)";
		try{
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, teamName);
		ps.setString(2, generation);
		ps.execute();


		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	public int teamDelete(String id) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql ="DELETE FROM"
				+ " team_table"
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
}