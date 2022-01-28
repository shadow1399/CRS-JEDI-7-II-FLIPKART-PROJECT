/**
 * 
 */
package com.crs.flipkart.dao;

import java.util.List;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;

/**
 * @author YASH
 *
 */
public interface AdminDaoInterface {
	
	/**
	 * Add course to the course table in DB
	 * @param course
	 */
	public void addCourse(Course course);
	
	/**
	 * Drop course from the course table in DB
	 * @param courseId
	 */
	public void dropCourse(String courseId);
	
	/**
	 * Fetch all the courses available in the course table in DB
	 * @return list of course object
	 */
	public List<Course> getCourses();
	
	/**
	 * Fetch all the Students available in the student table in DB
	 * @return list of student object
	 */
	public List<Student> getStudents();
	
	/**
	 * Fetch all the Professors available int the professor table in DB
	 * @return list of professor object
	 */
	public List<Professor> getProfessors();
	
	/**
	 * Approve the students in student table in DB
	 * @param rollNo
	 */
	public void approveStudent(String rollNo);
	 /**
	  * Generate Report Card of all the students of given semester
	  * @param semester
	  */
	public void generateReportCard(int semester);
	
}
