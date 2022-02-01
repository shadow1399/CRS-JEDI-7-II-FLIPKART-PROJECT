/**
 * 
 */
package com.crs.flipkart.business;

import java.util.List;

import com.crs.flipkart.bean.Course;

/**
 * @author Keertana
 *
 */
public interface ProfessorInterface {
	/**
	 * Function that displays all students registered in a course taught by the professor
	 * @param courseid
	 * @param userid
	 * @return  List of roll numbers of students who are there in the course taught by professor
	 */
	public List<String> getStudents(String courseid,String userid);
	/**
	 * Function that displays all courses
	 * @return List of all courses that are taught
	 */
	public List<Course> getCourses();
	/**
	 * Function that enables professor to add grades to students
	 * @param courseid
	 * @param userid
	 * @return whether all grades are added successfully or not
	 */
	public boolean addGrades(String courseid,String userid);
	/**
	 * Function that displays all courses registered by the professor
	 * @param profid
	 * @return List of all courses that professor registered
	 */
	public List<Course> getRegisteredCourses(String profid);
	/**
	 * Function through which professor registers for a course
	 * @param courseId
	 * @param profId
	 * @return whether professor successfully registered in the course or not
	 */
	public boolean registerCourse(String courseId,String profId);

}
