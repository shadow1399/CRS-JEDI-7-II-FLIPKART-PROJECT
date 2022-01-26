package com.crs.flipkart.bean;

import java.util.Map;

public class ReportCard {
	private int Semester;
	private int rollNo;
	private float gpa;
	private Map<String,Float> grades;
	public int getSemester() {
		return Semester;
	}
	public void setSemester(int semester) {
		Semester = semester;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public float getGpa() {
		return gpa;
	}
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	public Map<String, Float> getGrades() {
		return grades;
	}
	public void setGrades(Map<String, Float> grades) {
		this.grades = grades;
	}
	
	
}
