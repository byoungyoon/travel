package travel.quary;

public class LoginQuary {
	/*
	 * SELECT
	 * login_id
	 * FROM
	 * login
	 * WHERE
	 * login_id - ? and login_pw = ?
	 */
	public static final String LOGIN_CK = "SELECT login_id FROM login WHERE login_id=? and login_pw=?";
}
