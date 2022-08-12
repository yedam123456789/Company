package Board;

import java.sql.Date;

public class Board {
	private String BoardId;
	private String BoardNumber;
	private String BoardDate;
	private String BoardTitle;
	private String Contents;
	public String getBoardId() {
		return BoardId;
	}
	public void setBoardId(String boardId) {
		BoardId = boardId;
	}
	public String getBoardNumber() {
		return BoardNumber;
	}
	public void setBoardNumber(String boardNumber) {
		BoardNumber = boardNumber;
	}
	public String getBoardDate() {
		return BoardDate;
	}
	public void setBoardDate(String boardDate) {
		BoardDate = boardDate;
	}
	public String getBoardTitle() {
		return BoardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		BoardTitle = boardTitle;
	}
	public String getContents() {
		return Contents;
	}
	public void setContents(String contents) {
		Contents = contents;
	}
	

	
	
	
}
