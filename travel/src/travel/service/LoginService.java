package travel.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import travel.commons.DBUtil;
import travel.dao.LoginDao;
import travel.vo.Login;

public class LoginService {
	private LoginDao loginDao;
	private DBUtil dbUtil;
	
	public Login getLoginCk(String loginId, String loginPw){
		Login getLogin = null;
		Connection conn = null;
		
		loginDao = new LoginDao();
		dbUtil = new DBUtil();
		
		try {
			conn = dbUtil.getConnection();
			conn.setAutoCommit(false);
			
			getLogin = new Login();
			getLogin.setLoginId(loginId);
			getLogin.setLoginPw(loginPw);
			
			getLogin = loginDao.loginCk(conn, getLogin);
			
			conn.commit();
			
		} catch(Exception e) {
			try {conn.rollback();} catch(SQLException e1) {e1.printStackTrace();}			
		} finally {
			try {conn.close();} catch(SQLException e) {e.printStackTrace();}
		}
		
		return getLogin;
	}
}
