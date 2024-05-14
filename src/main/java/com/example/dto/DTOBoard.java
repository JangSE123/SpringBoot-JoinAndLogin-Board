package com.example.dto;
import com.example.entity.EntityBoard;

public class DTOBoard {
    public String BoardTitle;
    public String BoardContent;
    public String BoardAuthor;
    public String BoardDate;

    public DTOBoard() { BoardTitle = BoardContent = BoardAuthor = BoardDate = ""; }

    public DTOBoard(String boardTitle, String boardContent, String boardAuthor, String boardDate) {
        super();
        BoardTitle = boardTitle;
        BoardContent = boardContent;
        BoardAuthor = boardAuthor;
        BoardDate = boardDate;
    }

    public String getBoardTitle() {
        return BoardTitle;
    }
    public void setBoardTitle(String boardTitle) {
        BoardTitle = boardTitle;
    }
    public String getBoardContent() {
        return BoardContent;
    }
    public void setBoardContent(String boardContent) {
        BoardContent = boardContent;
    }
    public String getBoardAuthor() {
        return BoardAuthor;
    }
    public void setBoardAuthor(String boardAuthor) {
        BoardAuthor = boardAuthor;
    }
    public String getBoardDate() {
        return BoardDate;
    }
    public void setBoardDate(String boardDate) {
        BoardDate = boardDate;
    }
    public EntityBoard ToEntity() {
        return new EntityBoard(-1, this.BoardTitle, this.BoardContent, this.BoardAuthor, this.BoardDate);
    }

}
