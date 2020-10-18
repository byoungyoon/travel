package service;

import java.util.ArrayList;
import java.sql.*;

public class CountryDao {
	// ����� �����Ͽ��� �� ������ ����
	public ArrayList<ContinentAndCountry> selectContinent(String continentName){
		ArrayList<ContinentAndCountry> list = new ArrayList<ContinentAndCountry>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		try {
			DBUtil dbUtil = new DBUtil();
			connection = dbUtil.getConnection();
			
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
			
			String sql = "SELECT ct.country_name FROM country ct INNER JOIN continent co ON ct.continent_no = co.continent_no WHERE co.continent_name like ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, continentName);
			
			rs = statement.executeQuery();
			while(rs.next()) {
				ContinentAndCountry cac = new ContinentAndCountry();
				cac.country = new Country();
				cac.continent = new Continent();
				
				cac.country.setCountryName(rs.getString("ct.country_name"));
				
				list.add(cac);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("��� ���� �������� ���� �߻�");
		} finally {
			try {
				statement.close();
			} catch(Exception e) {}
			try {
				connection.close();
			} catch(Exception e) {}
		}
		
		return list;
	}
}
