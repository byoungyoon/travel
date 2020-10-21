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
	private DBUtil dbUtil;
	
	//
	public List<ContinentAndCountry> getSelectCountryByContinent(String continentName){
		Connection conn = null;
		
		List<ContinentAndCountry> list = new ArrayList<ContinentAndCountry>();
		countryDao = new CountryDao();
		dbUtil = new DBUtil();
		
		try {
			conn = dbUtil.getConnection();
			conn.setAutoCommit(false);
			System.out.println(conn + ": countryService(getSelectCountryByContinent) conn확인");
			
			list = countryDao.selectCountryByContinent(conn, continentName);
			System.out.println(list + "<-- countryService(getSelectCountryByContinent) list확인");
			
			conn.commit();
		} catch(Exception e) {
			System.out.println("MapService 예외");
			e.printStackTrace();
			try {conn.rollback();} catch(SQLException e1) {e1.printStackTrace();}
		} finally {
			try {conn.close();} catch(SQLException e) {e.printStackTrace();}
		}
		return list;
	}
}
