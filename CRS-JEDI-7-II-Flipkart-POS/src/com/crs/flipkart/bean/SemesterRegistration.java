package com.crs.flipkart.bean;

import java.util.List;

public class SemesterRegistration {
	private String rollNo;
	private int semester;
	private List<Course> courseRegistered;
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public List<Course> getCourseRegistered() {
		return courseRegistered;
	}
	public void setCourseRegistered(List<Course> courseRegistered) {
		this.courseRegistered = courseRegistered;
	}
	
}
