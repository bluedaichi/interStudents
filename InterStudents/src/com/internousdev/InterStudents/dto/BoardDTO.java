package com.internousdev.InterStudents.dto;

public class BoardDTO {
	private int id;
	private String contributorName;
	private String attribute;
	private String title;
	private String comment;
	private String insertDate;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContributorName() {
		return contributorName;
	}
	public void setContributorName(String contributorName) {
		this.contributorName = contributorName;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
}