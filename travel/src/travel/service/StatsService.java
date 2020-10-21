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
	
	// Dao���� ���� ������ �۵�
	public void countStats() {
		Connection conn = null;
		
		dbUtil = new DBUtil();
		dayUtil = new DayUtil();
		
		try {
			conn = dbUtil.getConnection();
			conn.setAutoCommit(false);
			System.out.println(conn + ": countStats�� connȮ��");
			
			String day = dayUtil.getToday();
			System.out.println(day + ": countStats�� dayȮ��");
			
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
			System.out.println("statsService ���ܹ߻�");
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
			System.out.println(conn + ": getStats�� connȮ��");
			
			String day = dayUtil.getToday();
			System.out.println(conn + ": getStats�� dayȮ��");
			
			Stats Setstats = new Stats();
			Setstats.setDay(day);
			
			Stats stats = iStatsDao.selectCnt(conn, Setstats);
			int sumCnt = iStatsDao.selectSumCnt(conn);
			
			System.out.println(stats + "<--- ����  stats");
			System.out.println(sumCnt + "<--- ���� sumCnt");
			
			map.put("stats", stats);
			map.put("sumCnt", sumCnt);
			
		} catch (Exception e) {
			System.out.println("statsService ���ܹ߻�");
			e.printStackTrace();
			try {conn.rollback();} catch (SQLException e1) {e1.printStackTrace();}
		} finally {
			try {conn.close();} catch (SQLException e1) {e1.printStackTrace();}
		}
		
		return map;
	}
	
}













