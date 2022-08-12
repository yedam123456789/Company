package Board;

import java.sql.Date;
import java.util.ArrayList;

import Co.common.DAO;

public class BoardDAO extends DAO {
	private static BoardDAO bd = new BoardDAO();
	static BoardDAO getInstance() {
		return bd;
	}


	public ArrayList<Board> getBoards() {
		ArrayList<Board> boards = new ArrayList<>();
		try {
			conn();
			String sql = "select * from board";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				String boardTitle 	 = rs.getString("BOARD_TITLE");
				String boardContents = rs.getString("BOARD_CONTENTS");
				String boardDate 	 = rs.getString("BOARD_DATE");
				
				
				Board board = new Board();
				board.setBoardDate(boardDate);
				board.setBoardTitle(boardTitle);
				board.setContents(boardContents);
				
				boards.add(board);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return boards;
	}
	

	public int insertBoard(String boardTitle, String boardContent) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO board (BOARD_TITLE, BOARD_CONTENTS, BOARD_DATE) VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardTitle);
			pstmt.setString(2, boardContent);
			pstmt.setDate(3, new Date(System.currentTimeMillis()));

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
	
	public int deleteBoard(String boardTitleName) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM board WHERE board_title = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardTitleName);

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
