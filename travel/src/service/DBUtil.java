package service;

import java.sql.*;

public class DBUtil {
	public Connection getConnection() throws Exception{
		Class.forName("org.mariadb.jdbc.Driver");		
		String driver = "jdbc:mariadb://localhost:3306/travel";
		String dbId = "root";
		String dbPw = "java1004";
		Connection connection = DriverManager.getConnection(driver, dbId, dbPw);
		
		return connection;
	}
}
