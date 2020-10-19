package travel.dao;

import java.util.ArrayList;
import java.util.List;

import travel.commons.DBUtil;
import travel.quary.LoginQuary;
import travel.vo.Continent;
import travel.vo.ContinentAndCountry;
import travel.vo.Country;

import java.sql.*;

public class CountryDao {
	// ����� �����Ͽ��� �� ������ ����
	public List<ContinentAndCountry> selectContinent(Connection conn, String continentName) throws Exception{
		List<ContinentAndCountry> list = new ArrayList<ContinentAndCountry>();
			
		LoginQuary loginQuary = new LoginQuary();
		PreparedStatement stmt = conn.prepareStatement(loginQuary.SELECT_CONTINENT);
		stmt.setString(1, continentName);
			
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			ContinentAndCountry cac = new ContinentAndCountry();
			cac.country = new Country();
			cac.continent = new Continent();
				
			cac.country.setCountryName(rs.getString("ct.country_name"));
				
			list.add(cac);
		}
		
		rs.close();
		conn.close();
				
		return list;
	}
}