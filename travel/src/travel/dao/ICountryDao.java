package travel.dao;

import java.sql.Connection;
import java.util.List;

import travel.vo.ContinentAndCountry;

public interface ICountryDao {
	List<ContinentAndCountry> selectCountryByContinent(Connection conn, String continentName) throws Exception;
}
