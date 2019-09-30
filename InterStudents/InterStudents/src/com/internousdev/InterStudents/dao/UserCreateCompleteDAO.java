package com.internousdev.InterStudents.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.InterStudents.util.DBConnector;
import com.internousdev.InterStudents.util.DateUtil;

public class UserCreateCompleteDAO {

	private DateUtil dU = new DateUtil();

	private String lSql = "INSERT INTO"
			+ " login_user_table"
			+ " (login_id,"
			+ " login_pass,"
			+ " user_name,"
			+ " generation,"
			+ " furigana,"
			+ " user_hobby,"
			+ " birthplace,"
			+ " user_comment,"
			+ " insert_date)"
			+ " VALUES(?, ? ,?, ?, ?, ?, ?, ?, ?)";

	private String sSql ="INSERT INTO study_progress_table"
			+ "(user_master_id)VALUES(?)";

	public void createUser(String loginUserId, String loginUserPassword, String userName,  String generation, String furigana, String userHobby, String birthplace, String  userComment){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();


		try {
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(lSql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginUserPassword);
			ps.setString(3, userName);
			ps.setString(4, generation);
			ps.setString(5, furigana);
			ps.setString(6, userHobby);
			ps.setString(7, birthplace);
			ps.setString(8, userComment);
			ps.setString(9, dU.getDate());

			ps.execute();

			PreparedStatement ps1 = con.prepareStatement(sSql);
			ps1.setString(1, loginUserId);

			ps1.execute();

			con.commit();
			con.setAutoCommit(true);

		}catch(Exception e) {
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