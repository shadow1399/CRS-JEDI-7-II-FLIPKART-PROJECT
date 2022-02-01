/**
 * 
 */
package com.crs.flipkart.exceptions;

/**
 * @author JEDI-02 Exception to check if course was delted successfully.
 */
public class CourseNotRegisteredException extends Exception {

	/*
	 * Course Code which cannot be Deleted.
	 */
	private String courseCode;

	public CourseNotRegisteredException(String courseCode) {
		this.courseCode = courseCode;
	}

	/**
	 * Message thrown by exception
	 */
	@Override
	public String getMessage() {
		return "Course with courseCode: " + courseCode + " can not be deleted.";
	}
}
