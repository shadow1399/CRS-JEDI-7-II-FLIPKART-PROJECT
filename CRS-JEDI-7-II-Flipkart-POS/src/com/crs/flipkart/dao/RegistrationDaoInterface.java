/**
 * 
 */
package com.crs.flipkart.dao;

import java.sql.SQLException;
import java.util.List;

import com.crs.flipkart.bean.*;

/**
 * @author Shubham Sharma
 *
 */
public interface RegistrationDaoInterface {
	/**
	 * Method to add course in database
	 * 
	 * @param courseCode
	 * @param studentId
	 * @return boolean indicating if the course is added successfully
	 * @throws SQLException
	 * @throws CourseNotFoundException 
	 */
	public boolean addCourse(String courseId, String studentId, int semester);
	
	/**
	 * Drop Course selected by student
	 * 
	 * @param courseCode
	 * @param studentId
	 * @return boolean indicating if the course is dropped successfully
	 */
	public boolean removeCourse(String courseId, String studentId, int semester);
	
	/**
	 * Method to get the list of courses available from course catalog
	 * 
	 * @param studentId
	 * @return list of Courses
	 */
	public List<Course> viewCourses(String studentId, int semester);
	
	/**
	 * Method to View list of Registered Courses
	 * 
	 * @param studentId
	 * @return list of Registered Courses
	 */
	public List<Course> viewRegisteredCourses(String studentId, int semester);
	
	/**
	 * Method to view grade card of the student
	 * 
	 * @param studentId
	 * @return Grade Card
	 */
	public ReportCard viewReportCard(String studentId, int semester);
	
	/**
	 * Method to retrieve fee for the selected courses from the database and
	 * calculate total fee
	 * 
	 * @param studentId
	 * @return Fee Student has to pay
	 */
	public boolean payFee(Payment payment);
	
	 /**
	 * Method to check whether the given student has paid the fee or not
	 * for given sem
	 */
	public Payment viewFee(String studentId,int semester);
}
