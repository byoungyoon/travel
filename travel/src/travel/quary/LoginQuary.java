package travel.quary;

public class LoginQuary {
	/*
	 * SELECT
	 * ct.country_name
	 * FROM
	 * country ct INNER JOIN continent co
	 * ON
	 * ct.continent_no = co.continent_no
	 * WHERE
	 * co.continent_name like ?
	 */
	public static final String SELECT_CONTINENT = "SELECT ct.country_name FROM country ct INNER JOIN continent co ON ct.continent_no = co.continent_no WHERE co.continent_name like ?";
	
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
