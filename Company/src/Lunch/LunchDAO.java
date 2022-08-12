package Lunch;

import java.util.ArrayList;

import Co.common.DAO;
import Member.Member;

public class LunchDAO extends DAO {
	private static LunchDAO ld = new LunchDAO();
	static LunchDAO getInstance() {
		return ld;
	}
	

	public ArrayList<Lunch> getLunchs() {
		ArrayList<Lunch> lunchs = new ArrayList<>();
		try {
			
			conn();
			String sql = "select * from lunch";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String fruitName 		= rs.getString("FRUIT_NAME");
				String fruitPrice 		= rs.getString("FRUIT_PRICE");
				int lunchBoxCount 		= rs.getInt("LUNCH_BOX_COUNT");
				
				Lunch lunch = new Lunch();
				lunch.setFruitName(fruitName);
				lunch.setFruitPrice(fruitPrice);
				lunch.setLunchBoxCount(lunchBoxCount);
				
				lunchs.add(lunch);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return lunchs;
	}
	
	public Lunch getLunch(String name) {

		Lunch lunch = null;
		try {
			
			conn();
			String sql = "SELECT * FROM lunch WHERE fruit_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String fruitName 		= rs.getString("FRUIT_NAME");
				String fruitPrice 		= rs.getString("FRUIT_PRICE");
				int lunchBoxCount 		= rs.getInt("LUNCH_BOX_COUNT");
				
				lunch = new Lunch();
				lunch.setFruitName(fruitName);
				lunch.setFruitPrice(fruitPrice);
				lunch.setLunchBoxCount(lunchBoxCount);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return lunch;
	}

	
	public int insertLunch(String fruitName, String fruitPrice) {
		int result = 0;
		try {
			conn();
			String sql = "insert into Lunch (FRUIT_NAME, FRUIT_PRICE)"
					+ " values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fruitName);
			pstmt.setString(2, fruitPrice);

			result = pstmt.executeUpdate();

		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			disconnect();
		}
		return result;

	}

	public int updateLunch(String fruitName, int oldCount) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE Lunch SET LUNCH_BOX_COUNT = ? WHERE FRUIT_NAME = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, oldCount + 1);
			pstmt.setString(2, fruitName);

			result = pstmt.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			disconnect();
		}
		return result;

	}

	
public int deletelunch(String lunchName) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM lunch WHERE fruit_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lunchName);

			result = pstmt.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			disconnect();
		}
		return result;
	}

}
