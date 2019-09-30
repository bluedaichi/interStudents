package com.internousdev.InterStudents.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.InterStudents.dto.ProfileDTO;
import com.internousdev.InterStudents.util.DBConnector;

public class ProfileDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private ProfileDTO profileDTO = new ProfileDTO();

	public ProfileDTO getProfileInfo(String userName) {

		String sql = "SELECT"
				+ " lut.user_name,"
				+ " lut.user_hobby,"
				+ " lut.generation,"
				+ " lut.birthplace,"
				+ " lut.team_name,"
				+ " lut.profile_img_pass,"
				+ " lut.header_img_pass,"
				+ " lut.user_comment,"
				+ " spt.study_name,"
				+ " spt.study_homework,"
				+ " spt.study_period,"
				+ " spt.update_date"
				+ " FROM study_progress_table spt"
				+ " LEFT JOIN login_user_table lut"
				+ " ON spt.user_master_id = lut.login_id"
				+ " WHERE lut.user_name = ?";


		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				profileDTO.setUserName(rs.getString("user_name"));
				profileDTO.setUserHobby(rs.getString("user_hobby"));
				profileDTO.setGeneration(rs.getString("generation"));
				profileDTO.setBirthplace(rs.getString("birthplace"));
				profileDTO.setTeamName(rs.getString("team_name"));
				profileDTO.setProfileImgPass(rs.getString("profile_img_Pass"));
				profileDTO.setTeamName(rs.getString("header_img_pass"));
				profileDTO.setUserComment(rs.getString("user_comment"));
				profileDTO.setStudyName(rs.getString("study_name"));
				profileDTO.setStudyHomework(rs.getString("study_homework"));
				profileDTO.setStudyPeriod(rs.getString("study_period"));
				profileDTO.setUpdateDate(rs.getString("update_date"));

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
		return profileDTO;
	}
}
