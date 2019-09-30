package com.internousdev.InterStudents.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.InterStudents.util.DBConnector;
import com.internousdev.InterStudents.util.DateUtil;

public class StudyCreateCompleteDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private DateUtil dateUtil =new DateUtil();

	public int Create(String userId, String studyName,String studyHomework,String studyPeriod) {
		String sql = "INSERT INTO study_progress_table"
				+ "(user_master_id,study_name,study_homework,study_period,update_date)VALUE(?,?,?,?,?)";
		int result = 0;

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, studyName);
			ps.setString(3, studyHomework);
			ps.setString(4, studyPeriod);
			ps.setString(5, dateUtil.getDate());

			result = ps.executeUpdate();

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

		return result;
	}

	public void Update(String userId, String studyName,String studyHomework,String studyPeriod) {
		String sql = "UPDATE"
				+ " study_progress_table"
				+ " SET study_name = ?,"
				+ " study_homework  = ?,"
				+ " study_period = ?,update_date = ?"
				+ " WHERE user_master_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, studyName);
			ps.setString(2, studyHomework);
			ps.setString(3, studyPeriod);
			ps.setString(4, dateUtil.getDate());
			ps.setString(5, userId);
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