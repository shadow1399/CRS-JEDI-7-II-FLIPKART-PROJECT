/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 * SemesterRegistration Class
 */
public class SemesterRegistration {
	private String coursesAdded[];
	private int semester;
	private String studentId;

	/**
	 * Getter Setter Methods for Registration details
	 *
	 */
	public String[] getCoursesAdded() {
		return coursesAdded;
	}

	public void setCoursesAdded(String[] coursesAdded) {
		this.coursesAdded = coursesAdded;
	}

	public int getSem() {
		return semester;
	}

	public void setSem(int sem) {
		this.semester = sem;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

}
