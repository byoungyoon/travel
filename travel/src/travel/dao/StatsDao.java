package travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import travel.quary.StatsQuary;
import travel.vo.Stats;

public class StatsDao implements IStatsDao{
	private StatsQuary statsQuary;
	
	@Override	// ���� ��¥�� �ִ��� ������ üũ
	public boolean selectDay(Connection conn, Stats stats) throws Exception{
		boolean result = false;
		
		statsQuary = new StatsQuary();
		PreparedStatement stmt = conn.prepareStatement(statsQuary.SELECT_DAY);
		stmt.setString(1, stats.getDay());
		System.out.println(stmt + ": statsDao(selectDay) - ������");
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			result = true;
		}
		
		stmt.close();
		rs.close();
		
		return result;
	}
	
	@Override	// ���� ��¥�� ������ ���� ��¥�� �߰�(selectDay - false)
	public void insertStats(Connection conn, Stats stats) throws Exception{
		statsQuary = new StatsQuary();
		
		PreparedStatement stmt = conn.prepareStatement(statsQuary.INSERT_STATS);
		stmt.setString(1, stats.getDay());
		System.out.println(stmt + ": statsDao(insertStats) - ������");
		
		stmt.executeLargeUpdate();
		
		stmt.close();
	}
	
	@Override	// ���� ��¥�� ������ ���� ��¥�� cnt ������Ʈ(selectDay - true)
	public void updateStats(Connection conn, Stats stats) throws Exception{
		statsQuary = new StatsQuary();
		
		PreparedStatement stmt = conn.prepareStatement(statsQuary.UPDATE_STATS);
		stmt.setString(1, stats.getDay());
		System.out.println(stmt + ": statsDao(updateStats) - ������");
		
		stmt.executeLargeUpdate();
		
		stmt.close();
	}
	
	@Override	// ���� ��¥�� ī���� ��
	public Stats selectCnt(Connection conn, Stats stats) throws Exception {
		Stats returnStats = null;
		statsQuary = new StatsQuary();
		
		PreparedStatement stmt = conn.prepareStatement(statsQuary.SELECT_CNT);
		stmt.setString(1, stats.getDay());
		System.out.println(stmt + ": statsDao(selectCnt) - ������");
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			returnStats = new Stats();
			returnStats.setCnt(rs.getInt("cnt"));
		}
		
		return returnStats;
	}
	
	@Override	// ��ü ��¥�� ī���� ��
	public int selectSumCnt(Connection conn) throws Exception{
		int result = 1;
		
		statsQuary = new StatsQuary();
		
		PreparedStatement stmt = conn.prepareStatement(statsQuary.SELECT_SUM_CNT);
		System.out.println(stmt + ": statsDao(selectSumCnt) - ������");
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			result = rs.getInt("SUM(cnt)");
		}
		
		return result;
	}
}