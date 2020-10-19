package travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import commons.DBUtil;
import travel.quary.LoginQuary;
import travel.vo.Login;

public class LoginDao {
	// login체크 메서드
	public Login loginCk(Connection conn, Login login) throws Exception{
		Login getLogin = null;
		LoginQuary loginQuary = new LoginQuary();
			
		PreparedStatement stmt = conn.prepareStatement(loginQuary.LOGIN_CK);
			
		stmt.setString(1, login.getLoginId());
		stmt.setString(2, login.getLoginPw());
			
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			getLogin = new Login();
			getLogin.setLoginId(rs.getString("login_id"));
		}
			
		rs.close();
		conn.close();
		
		return getLogin;
	}	
}