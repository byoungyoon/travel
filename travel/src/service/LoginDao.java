package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	// login체크 메서드
	public Login loginCk(Login login) {
		DBUtil dbUtil = new DBUtil();
		
		Login returnLogin = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dbUtil.getConnection();
			
			/*
			 * SELECT
			 * login_id
			 * FROM
			 * login
			 * WHERE
			 * login_id - ? and login_pw = ?
			 */
			
			String sql = "SELECT login_id FROM login WHERE login_id=? and login_pw=?";
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, login.getLoginId());
			statement.setString(2, login.getLoginPw());
			
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				returnLogin = new Login();
				returnLogin.setLoginId(resultSet.getString("login_id"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("로그인 과정 예외 발생");
		} finally {
			try {
				statement.close();
			} catch(Exception e) {}
			try {
				connection.close();
			} catch(Exception e) {}
		}
		
		
		
		return returnLogin;
	}	
}