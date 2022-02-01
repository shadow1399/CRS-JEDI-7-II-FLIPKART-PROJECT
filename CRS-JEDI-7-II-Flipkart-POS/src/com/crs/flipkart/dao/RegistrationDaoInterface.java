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
	 */
	public boolean addCourse(String courseId, String studentId, int semester) throws SQLException;
	
	/**
	 * Drop Course selected by student
	 * 
	 * @param courseCode
	 * @param studentId
	 * @return boolean indicating if the course is dropped successfully
	 */
	public boolean removeCourse(String courseId, String studentId, int semester) throws SQLException;
	
	/**
	 * Method to get the list of courses available from course catalog
	 * 
	 * @param studentId
	 * @return list of Courses
	 */
	public List<Course> viewCourses(String studentId, int semester) throws SQLException;
	
	/**
	 * Method to View list of Registered Courses
	 * 
	 * @param studentId
	 * @return list of Registered Courses
	 */
	public List<Course> viewRegisteredCourses(String studentId, int semester) throws SQLException;
	
	/**
	 * Method to view grade card of the student
	 * 
	 * @param studentId
	 * @return Grade Card
	 */
	public ReportCard viewReportCard(String studentId, int semester) throws SQLException;
	
	/**
	 * Method to retrieve fee for the selected courses from the database and
	 * calculate total fee
	 * 
	 * @param studentId
	 * @return Fee Student has to pay
	 */
	public boolean payFee(Payment payment) throws SQLException;
	
	 /**
	  * 
	  * @param studentId
	  * @param semester
	  * @return
	  * @throws SQLException
	  */
	public Payment viewFee(String studentId,int semester) throws SQLException;
	
	/**
	 * 
	 * @param studentId
	 * @param semester
	 * @return
	 * @throws SQLException
	 */
	public int numOfRegisteredCourses(String studentId, int semester) throws SQLException;
	
	/**
	 * 
	 * @param courseCode
	 * @param studentId
	 * @param semester
	 * @return
	 * @throws SQLException
	 */
	public boolean isRegistered(String courseCode, String studentId, int semester) throws SQLException;
	
	/**
	 * 
	 * @param courseId
	 * @return
	 * @throws SQLException
	 */
	public boolean isValidCourse(String courseId) throws SQLException;
	
	/**
	 * 
	 * @param studentId
	 * @param semester
	 * @return
	 * @throws SQLException
	 */
	public boolean isPaymentExist(String studentId,int semester) throws SQLException;
}
