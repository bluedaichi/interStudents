package com.internousdev.InterStudents.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.InterStudents.dto.LoginDTO;
import com.internousdev.InterStudents.util.DBConnector;

public class LoginDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private LoginDTO loginDTO = new LoginDTO();

	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword) {

		String sql = "SELECT * FROM"
				+ " login_user_table"
				+ " WHERE login_id = ?"
				+ " AND login_pass = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginPassword);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				loginDTO.setLoginId(rs.getString("login_id"));
				loginDTO.setLoginPassword(rs.getString("login_pass"));
				loginDTO.setUserName(rs.getString("user_name"));
				loginDTO.setUserHobby(rs.getString("user_hobby"));
				loginDTO.setBirthplace(rs.getString("birthplace"));
				loginDTO.setTeamName(rs.getString("team_name"));
				loginDTO.setGeneration(rs.getString("generation"));
				loginDTO.setUserComment(rs.getString("user_comment"));
				loginDTO.setAdminComment(rs.getString("admin_comment"));
				loginDTO.setAdminFlg(rs.getString("admin_flg"));

				if(rs.getString("login_id")!=null) {
					loginDTO.setLoginFlg(true);
				}
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
			return loginDTO;
		}
}