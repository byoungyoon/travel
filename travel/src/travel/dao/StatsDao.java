package travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import travel.quary.StatsQuary;
import travel.vo.Stats;

public class StatsDao implements IStatsDao{
	private StatsQuary statsQuary;
	
	@Override	// 오늘 날짜가 있는지 없는지 체크
	public boolean selectDay(Connection conn, Stats stats) throws Exception{
		boolean result = false;
		
		statsQuary = new StatsQuary();
		PreparedStatement stmt = conn.prepareStatement(statsQuary.SELECT_DAY);
		stmt.setString(1, stats.getDay());
		System.out.println(stmt + ": statsDao(selectDay) - 쿼리문");
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			result = true;
		}
		
		stmt.close();
		rs.close();
		
		return result;
	}
	
	@Override	// 오늘 날짜가 없으면 오늘 날짜를 추가(selectDay - false)
	public void insertStats(Connection conn, Stats stats) throws Exception{
		statsQuary = new StatsQuary();
		
		PreparedStatement stmt = conn.prepareStatement(statsQuary.INSERT_STATS);
		stmt.setString(1, stats.getDay());
		System.out.println(stmt + ": statsDao(insertStats) - 쿼리문");
		
		stmt.executeLargeUpdate();
		
		stmt.close();
	}
	
	@Override	// 오늘 날짜가 있으면 오늘 날짜의 cnt 업데이트(selectDay - true)
	public void updateStats(Connection conn, Stats stats) throws Exception{
		statsQuary = new StatsQuary();
		
		PreparedStatement stmt = conn.prepareStatement(statsQuary.UPDATE_STATS);
		stmt.setString(1, stats.getDay());
		System.out.println(stmt + ": statsDao(updateStats) - 쿼리문");
		
		stmt.executeLargeUpdate();
		
		stmt.close();
	}
	
	@Override	// 오늘 날짜의 카운터 수
	public Stats selectCnt(Connection conn, Stats stats) throws Exception {
		Stats returnStats = null;
		statsQuary = new StatsQuary();
		
		PreparedStatement stmt = conn.prepareStatement(statsQuary.SELECT_CNT);
		stmt.setString(1, stats.getDay());
		System.out.println(stmt + ": statsDao(selectCnt) - 쿼리문");
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			returnStats = new Stats();
			returnStats.setCnt(rs.getInt("cnt"));
		}
		
		return returnStats;
	}
	
	@Override	// 전체 날짜의 카운터 수
	public int selectSumCnt(Connection conn) throws Exception{
		int result = 1;
		
		statsQuary = new StatsQuary();
		
		PreparedStatement stmt = conn.prepareStatement(statsQuary.SELECT_SUM_CNT);
		System.out.println(stmt + ": statsDao(selectSumCnt) - 쿼리문");
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			result = rs.getInt("SUM(cnt)");
		}
		
		return result;
	}
}