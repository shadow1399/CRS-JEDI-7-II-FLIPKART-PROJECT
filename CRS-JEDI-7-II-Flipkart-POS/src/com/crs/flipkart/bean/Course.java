package com.crs.flipkart.bean;

public class Course {

	private String courseName;
	private String courseId;
	private String professorId;
	private int numberOfStudents;
	
	/**
	 * @param courseName
	 * @param courseId
	 * @param professorId
	 * @param numberOfStudents
	 */
	public Course() {
		
	}
	public Course(String courseName, String courseId, String professorId, int numberOfStudents) {
		super();
		this.courseName = courseName;
		this.courseId = courseId;
		this.professorId = professorId;
		this.numberOfStudents = numberOfStudents;
	}
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	/**
	 * @return the professorId
	 */
	public String getProfessorId() {
		return professorId;
	}
	/**
	 * @param professorId the professorId to set
	 */
	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}
	/**
	 * @return the numberOfStudents
	 */
	public int getNumberOfStudents() {
		return numberOfStudents;
	}
	/**
	 * @param numberOfStudents the numberOfStudents to set
	 */
	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}
	
}
