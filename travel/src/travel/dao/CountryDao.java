package travel.dao;

import java.util.ArrayList;
import java.util.List;

import travel.quary.CountryQuary;
import travel.vo.Continent;
import travel.vo.ContinentAndCountry;
import travel.vo.Country;

import java.sql.*;

public class CountryDao {
	// 대륙을 선택하였을 때 나오는 나라
	public List<ContinentAndCountry> selectCountryByContinent(Connection conn, String continentName) throws Exception{
		List<ContinentAndCountry> list = new ArrayList<ContinentAndCountry>();
			
		CountryQuary countryQuary = new CountryQuary();
		PreparedStatement stmt = conn.prepareStatement(countryQuary.SELECT_COUNTRY_BY_CONTINENT);
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
