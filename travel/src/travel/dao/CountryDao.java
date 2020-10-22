package travel.dao;

import java.util.ArrayList;
import java.util.List;

import travel.quary.CountryQuary;
import travel.vo.Continent;
import travel.vo.ContinentAndCountry;
import travel.vo.Country;

import java.sql.*;

public class CountryDao implements ICountryDao{
	private CountryQuary countryQuary;
	
	@Override	// 대륙을 선택하였을 때 나오는 나라
	public List<ContinentAndCountry> selectCountryByContinent(Connection conn, String continentName) throws Exception{
		List<ContinentAndCountry> list = new ArrayList<ContinentAndCountry>();
			
		countryQuary = new CountryQuary();
		PreparedStatement stmt = conn.prepareStatement(countryQuary.SELECT_COUNTRY_BY_CONTINENT);
		stmt.setString(1, continentName);
			
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			ContinentAndCountry cac = new ContinentAndCountry();
			cac.setCountry(new Country());
			cac.setContinent(new Continent());
				
			cac.getCountry().setCountryName(rs.getString("ct.country_name"));
			cac.getContinent().setContinentName(rs.getString("co.continent_name"));
			cac.getCountry().setCountryPic(rs.getString("ct.country_pic"));
			
			list.add(cac);
		}
		
		rs.close();
		conn.close();
				
		return list;
	}
}
