package travel.quary;

public class CountryQuary {
	/*
	 * SELECT
	 * ct.country_name, co.continent_name
	 * FROM
	 * country ct INNER JOIN continent co
	 * ON
	 * ct.continent_no = co.continent_no
	 * WHERE
	 * co.continent_name like ?
	 */
	public static final String SELECT_COUNTRY_BY_CONTINENT = "SELECT ct.country_name, co.continent_name FROM country ct INNER JOIN continent co ON ct.continent_no = co.continent_no WHERE co.continent_name like ?";
}
