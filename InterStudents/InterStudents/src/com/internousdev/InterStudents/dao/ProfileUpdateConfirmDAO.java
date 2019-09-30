package com.internousdev.InterStudents.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.InterStudents.util.DBConnector;
import com.internousdev.InterStudents.util.DateUtil;

public class ProfileUpdateConfirmDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private DateUtil dU = new DateUtil();

	public void profileUpdate(String login_id, String userName, String furigana,
			String birthplace, String userHobby,String userComment, String generation){

		String sql = "UPDATE"
				+ " login_user_table"
				+ " SET user_name = ?,"
				+ " furigana = ?,"
				+ " birthplace = ?,"
				+ " user_hobby = ?,"
				+ " user_comment = ?,"
				+ " generation = ?,"
				+ " updated_date = ?"
				+ " WHERE login_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, furigana);
			ps.setString(3, birthplace);
			ps.setString(4, userHobby);
			ps.setString(5, userComment);
			ps.setString(6, generation);
			ps.setString(7, dU.getDate());
			ps.setString(8, login_id);

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
}
