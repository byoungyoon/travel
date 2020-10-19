package travel.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import travel.commons.DBUtil;
import travel.dao.CountryDao;
import travel.vo.ContinentAndCountry;

public class MapService {
	private CountryDao countryDao;
	public List<ContinentAndCountry> getSelectCountryByContinent(String continentName){
		Connection conn = null;
		List<ContinentAndCountry> list = new ArrayList<ContinentAndCountry>();
		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			conn.setAutoCommit(false);
			
			System.out.println(continentName);
			
			list = countryDao.selectCountryByContinent(conn, continentName);
			
			System.out.println(conn + "<-- service conn");
			System.out.println(list + "<-- service list");
			
			conn.commit();
		} catch(Exception e) {
			System.out.println("¿¹¿Ü");
			try {conn.rollback();} catch(SQLException e1) {e1.printStackTrace();}
		} finally {
			try {conn.close();} catch(SQLException e) {e.printStackTrace();}
		}
		return list;
	}
}
