package travel.dao;

import java.sql.Connection;

import travel.vo.Stats;

public interface IStatsDao {
	boolean selectDay(Connection conn, Stats stats) throws Exception;
	void insertStats(Connection conn, Stats stats) throws Exception;
	void updateStats(Connection conn, Stats stats) throws Exception;
	Stats selectCnt(Connection conn, Stats stats) throws Exception;
	int selectSumCnt(Connection conn) throws Exception;
}
