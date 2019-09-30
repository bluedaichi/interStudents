package com.internousdev.InterStudents.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.InterStudents.dto.StudentsDTO;
import com.internousdev.InterStudents.util.DBConnector;

public class StudentsListDAO {

	public ArrayList <StudentsDTO> getAllStudentsInfo(){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<StudentsDTO> dtoList = new ArrayList<StudentsDTO>();

		String sql = "SELECT"
				+ " lut.id,"
				+ " lut.user_name,"
				+ " lut.generation,"
				+	" lut.team_name,"
				+ " spt.study_name,"
				+ " spt.study_homework,"
				+ " spt.study_period,"
				+ " spt.update_date"
				+ " FROM login_user_table lut"
				+ " LEFT JOIN study_progress_table spt"
				+ " ON lut.login_id = spt.user_master_id"
				+ " ORDER BY furigana ASC";

		try{
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				StudentsDTO studentsDTO = new StudentsDTO();
				studentsDTO.setId(rs.getString("id"));
				studentsDTO.setUserName(rs.getString("user_name"));
				studentsDTO.setGeneration(rs.getString("generation"));
				studentsDTO.setTeamName(rs.getString("team_name"));
				studentsDTO.setStudyName(rs.getString("study_name"));
				studentsDTO.setStudyHomework(rs.getString("study_homework"));
				studentsDTO.setStudyPeriod(rs.getString("study_period"));
				studentsDTO.setUpdateDate(rs.getString("update_date"));
				dtoList.add(studentsDTO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return dtoList;
	}
	public ArrayList<StudentsDTO> getGenerationInfo(String generation) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<StudentsDTO> dtoList = new ArrayList<StudentsDTO>();

		String sql = "SELECT"
				+ " lut.id,"
				+ " lut.user_name,"
				+ " lut.generation,"
				+	" lut.team_name,"
				+ " spt.study_name,"
				+ " spt.study_homework,"
				+ " spt.study_period,"
				+ " spt.update_date"
				+ " FROM login_user_table lut"
				+ " LEFT JOIN study_progress_table spt"
				+ " ON lut.login_id = spt.user_master_id"
				+ " WHERE lut.generation = ?"
				+ " ORDER BY furigana ASC";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, generation);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				StudentsDTO studentsDTO = new StudentsDTO();
				studentsDTO.setId(rs.getString("id"));
				studentsDTO.setUserName(rs.getString("user_name"));
				studentsDTO.setGeneration(rs.getString("generation"));
				studentsDTO.setTeamName(rs.getString("team_name"));
				studentsDTO.setStudyName(rs.getString("study_name"));
				studentsDTO.setStudyHomework(rs.getString("study_homework"));
				studentsDTO.setStudyPeriod(rs.getString("study_period"));
				studentsDTO.setUpdateDate(rs.getString("update_date"));
				dtoList.add(studentsDTO);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return dtoList;
	}


	public ArrayList<StudentsDTO> searchStudents(String generation, String search) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<StudentsDTO> dtoList = new ArrayList<StudentsDTO>();

		String sql = "SELECT"
				+ " lut.id,"
				+ " lut.user_name,"
				+ " lut.generation,"
				+	" lut.team_name,"
				+ " spt.study_name,"
				+ " spt.study_homework,"
				+ " spt.study_period,"
				+ " spt.update_date"
				+ " FROM login_user_table lut"
				+ " LEFT JOIN study_progress_table spt"
				+ " ON lut.login_id = spt.user_master_id"
				+ " WHERE lut.generation = ?"
				+ " AND lut.furigana LIKE ? "
				+ " ORDER BY furigana ASC";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, generation);
			ps.setString(2, search = search + "%");
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				StudentsDTO studentsDTO = new StudentsDTO();
				studentsDTO.setId(rs.getString("id"));
				studentsDTO.setUserName(rs.getString("user_name"));
				studentsDTO.setGeneration(rs.getString("generation"));
				studentsDTO.setTeamName(rs.getString("team_name"));
				studentsDTO.setStudyName(rs.getString("study_name"));
				studentsDTO.setStudyHomework(rs.getString("study_homework"));
				studentsDTO.setStudyPeriod(rs.getString("study_period"));
				studentsDTO.setUpdateDate(rs.getString("update_date"));
				dtoList.add(studentsDTO);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return dtoList;
	}

	public ArrayList<StudentsDTO> searchAllStudents(String search) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<StudentsDTO> dtoList = new ArrayList<StudentsDTO>();

		String sql = "SELECT"
				+ " lut.id,"
				+ " lut.user_name,"
				+ " lut.generation,"
				+	" lut.team_name,"
				+ " spt.study_name,"
				+ " spt.study_homework,"
				+ " spt.study_period,"
				+ " spt.update_date"
				+ " FROM login_user_table lut"
				+ " LEFT JOIN study_progress_table spt"
				+ " ON lut.login_id = spt.user_master_id"
				+ " WHERE lut.furigana LIKE ? "
				+ " ORDER BY furigana ASC";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, search = search + "%");
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				StudentsDTO studentsDTO = new StudentsDTO();
				studentsDTO.setId(rs.getString("id"));
				studentsDTO.setUserName(rs.getString("user_name"));
				studentsDTO.setGeneration(rs.getString("generation"));
				studentsDTO.setTeamName(rs.getString("team_name"));
				studentsDTO.setStudyName(rs.getString("study_name"));
				studentsDTO.setStudyHomework(rs.getString("study_homework"));
				studentsDTO.setStudyPeriod(rs.getString("study_period"));
				studentsDTO.setUpdateDate(rs.getString("update_date"));
				dtoList.add(studentsDTO);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return dtoList;
	}

	public ArrayList<StudentsDTO> getTeamMemberInfo(String team){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<StudentsDTO> dtoList = new ArrayList<StudentsDTO>();

		String sql = "SELECT user_name,"
				+ "table_number "
				+ "FROM login_user_table "
				+ "WHERE team_name = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, team);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				StudentsDTO studentsDTO = new StudentsDTO();
				studentsDTO.setUserName(rs.getString("user_name"));
				studentsDTO.setTableNumber(rs.getInt("table_number"));
				dtoList.add(studentsDTO);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return dtoList;
	}

	public int deleteStudents(String id){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "DELETE FROM"
				+ " login_user_table"
				+ " WHERE id = ?";

		int ret = 0;

		try{
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, id);
			ret = ps.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return ret;
	}

	public int setTeamStudents(String id,String team){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "UPDATE"
				+ " login_user_table"
				+ " SET team_name = ?"
				+ " WHERE id = ?";

		int ret = 0;

		try{
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, team);
			ps.setString(2, id);
			ret = ps.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return ret;
	}

	public boolean checkExistsUser(String userId){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		boolean ret = false;

		String sql = "SELECT *"
				+ " FROM login_user_table"
				+ " WHERE login_id = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				ret = true;
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
		return ret;
	}
}
