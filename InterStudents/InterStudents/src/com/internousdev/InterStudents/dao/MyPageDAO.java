package com.internousdev.InterStudents.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.InterStudents.dto.MyPageDTO;
import com.internousdev.InterStudents.util.DBConnector;

public class MyPageDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private MyPageDTO myDTO = new MyPageDTO();

	public MyPageDTO getMyStudyInfo(String loginId){
		String sql = "SELECT"
				+ " spt.user_master_id,"
				+ " spt.study_name,"
				+ " spt.study_homework,"
				+ " spt.study_period,"
				+ " spt.update_date,"
				+ " lut.user_name,"
				+ " lut.user_hobby,"
				+ " lut.generation,"
				+ " lut.birthplace,"
				+ " lut.team_name,"
				+ " lut.profile_img_pass,"
				+ " lut.header_img_pass,"
				+ " lut.user_comment"
				+ " FROM study_progress_table spt"
				+ " LEFT JOIN login_user_table lut"
				+ " ON spt.user_master_id = lut."
				+ " login_id WHERE spt.user_master_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				myDTO.setUserMasterId(rs.getString("user_master_id"));
				myDTO.setStudyName(rs.getString("study_name"));
				myDTO.setStudyHomework(rs.getString("study_homework"));
				myDTO.setStudyPeriod(rs.getString("study_period"));
				myDTO.setUpdateDate(rs.getString("update_date"));
				myDTO.setUserName(rs.getString("user_name"));
				myDTO.setUserHobby(rs.getString("user_hobby"));
				myDTO.setGeneration(rs.getString("generation"));
				myDTO.setBirthplace(rs.getString("birthplace"));
				myDTO.setTeamName(rs.getString("team_name"));
				myDTO.setTeamName(rs.getString("profile_img_pass"));
				myDTO.setTeamName(rs.getString("header_img_pass"));
				myDTO.setUserComment(rs.getString("user_comment"));

			}else {
				System.out.print("該当のデータがありません");
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
		return myDTO;
	}
}