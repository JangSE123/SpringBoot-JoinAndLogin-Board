package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EntityBoard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int boardId;
	
	@Column
	String title;
	
	@Column
	String content;
	
	@Column
	String author;
	
	@Column
	String currentDate;
	
	public EntityBoard() {
		this.boardId = -1;
		this.title = this.content = this.author = this.currentDate = "";
	}

	@Override
	public String toString() {
		return "EntityBoard [boardId=" + boardId
				+ ", title=" + title
				+ ", content=" + content
				+ ", author=" + author
				+ ", currentDate=" + currentDate
				+ "]";
	}
	
	public EntityBoard(int boardId, String title, String content, String author, String currentDate) {
		super();
		this.boardId = -1;
		this.title = title;
		this.content = content;
		this.author = author;
		this.currentDate = currentDate;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	

	
}
