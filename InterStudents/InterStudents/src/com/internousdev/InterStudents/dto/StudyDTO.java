package com.internousdev.InterStudents.dto;

public class StudyDTO {
	private int id;
	private String studyName;
	private String studyHomework;
	private String studyPeriod;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
}