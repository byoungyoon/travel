package travel.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DayDV;

import travel.commons.DBUtil;
import travel.commons.DayUtil;
import travel.dao.IStatsDao;
import travel.dao.StatsDao;
import travel.vo.Stats;

public class StatsService {
	private IStatsDao iStatsDao;
	
	public StatsService(IStatsDao iStatsDao) {
		this.iStatsDao = iStatsDao;
	}
	
	private DBUtil dbUtil;
	private DayUtil dayUtil;
	
	// Dao에서 값을 가져와 작동
	public void countStats() {
		Connection conn = null;
		
		dbUtil = new DBUtil();
		dayUtil = new DayUtil();
		
		try {
			conn = dbUtil.getConnection();
			conn.setAutoCommit(false);
			System.out.println(conn + ": countStats의 conn확인");
			
			String day = dayUtil.getToday();
			System.out.println(day + ": countStats의 day확인");
			
			Stats stats = new Stats();
			stats.setDay(day);
			
			if(iStatsDao.selectDay(conn, stats)) {
				iStatsDao.updateStats(conn, stats);
			}
			else {
				iStatsDao.insertStats(conn, stats);
			}
			
			conn.commit();
		} catch (Exception e) {
			System.out.println("statsService 예외발생");
			try {conn.rollback();} catch (SQLException e1) {e1.printStackTrace();}
		} finally {
			try {conn.close();} catch (SQLException e1) {e1.printStackTrace();}
		}
	}
	
	public Map<String, Object> getStats(){
		Map<String, Object> map = new HashMap<String, Object>();

		dbUtil = new DBUtil();
		dayUtil = new DayUtil();
		
		Connection conn = null;
		
		try {
			conn = dbUtil.getConnection();
			conn.setAutoCommit(false);
			System.out.println(conn + ": getStats의 conn확인");
			
			String day = dayUtil.getToday();
			System.out.println(conn + ": getStats의 day확인");
			
			Stats Setstats = new Stats();
			Setstats.setDay(day);
			
			Stats stats = iStatsDao.selectCnt(conn, Setstats);
			int sumCnt = iStatsDao.selectSumCnt(conn);
			
			System.out.println(stats + "<--- 최종  stats");
			System.out.println(sumCnt + "<--- 최종 sumCnt");
			
			map.put("stats", stats);
			map.put("sumCnt", sumCnt);
			
		} catch (Exception e) {
			System.out.println("statsService 에외발생");
			e.printStackTrace();
			try {conn.rollback();} catch (SQLException e1) {e1.printStackTrace();}
		} finally {
			try {conn.close();} catch (SQLException e1) {e1.printStackTrace();}
		}
		
		return map;
	}
	
}













