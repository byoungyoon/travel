package travel.dao;

import java.sql.Connection;

import travel.vo.Login;

public interface ILoginDao {
	Login loginCk(Connection conn, Login login) throws Exception;
}
