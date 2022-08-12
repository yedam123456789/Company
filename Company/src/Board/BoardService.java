package Board;

import java.util.ArrayList;

import Lunch.Lunch;
import Lunch.LunchDAO;

public class BoardService {

	// 게시판조회 서비스
	public void getBoardList() {
		ArrayList<Board> boards = BoardDAO.getInstance().getBoards();
		System.out.println("===게시판정보===");
		System.out.println("총 " + boards.size() + "개");
		for(int i=0; i<boards.size(); i++) {
			Board board = boards.get(i);
			System.out.println(i+1 + ". " + board.getBoardTitle() + "|" + board.getContents());
		}
	}
	
	// 상품등록 서비스
	public void insertBoard(String boardTitle, String boardContent) {
		int result = BoardDAO.getInstance().insertBoard(boardTitle, boardContent);
		if (result == 1) {
			System.out.println("게시판 등록 성공");
		} 
		else {
			System.out.println("게시판 등록 실패");
		}
	}

	// 게시판삭제 서비스
	public void deleteBoard(String boardTitleName) {
		int result = BoardDAO.getInstance().deleteBoard(boardTitleName);
		if (result == 1) {
			System.out.println("게시판 삭제 성공");
		} 
		else {
			System.out.println("게시판 삭제 실패");
		}
	}

}
