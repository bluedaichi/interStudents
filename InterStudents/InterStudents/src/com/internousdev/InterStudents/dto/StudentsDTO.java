package com.internousdev.InterStudents.dto;

public class StudentsDTO {

	private String id;
	private String userName;
	private String generation;
	private String studyName;
	private String studyHomework;
	private String studyPeriod;
	private String updateDate;
	private String teamName;
	private int tableNumber;


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGeneration() {
		return generation;
	}
	public void setGeneration(String generation) {
		this.generation = generation;
	}
	public String getStudyName() {
		return studyName;
	}
	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}
	public String getStudyHomework() {
		return studyHomework;
	}
	public void setStudyHomework(String studyHomework) {
		this.studyHomework = studyHomework;
	}
	public String getStudyPeriod() {
		return studyPeriod;
	}
	public void setStudyPeriod(String studyPeriod) {
		this.studyPeriod = studyPeriod;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

}