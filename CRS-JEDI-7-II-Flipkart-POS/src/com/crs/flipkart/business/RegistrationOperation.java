package com.crs.flipkart.business;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Payment;
import com.crs.flipkart.bean.ReportCard;
import com.crs.flipkart.constants.SQLQueriesConstants;
import com.crs.flipkart.dao.RegistrationDaoInterface;
import com.crs.flipkart.dao.RegistrationDaoOperations;
import com.crs.flipkart.exceptions.CourseLimitReachedException;
import com.crs.flipkart.exceptions.CourseNotRegisteredException;
import com.crs.flipkart.exceptions.PaymentNotFoundException;
import com.crs.flipkart.exceptions.CourseNotFoundException;
import com.crs.flipkart.utils.DBUtils;
import com.mysql.jdbc.Connection;

public class RegistrationOperation implements RegistrationInterface {

	private static volatile RegistrationOperation instance = null;
	private static Logger logger = Logger.getLogger(RegistrationOperation.class);
	/**
	 * Default constructor
	 */
	private RegistrationOperation() {
	}

	/**
	 * Method to make Registration Operation Singleton
	 *
	 * @return
	 */
	public static RegistrationOperation getInstance() {
		if (instance == null) {
			synchronized (RegistrationOperation.class) {
				instance = new RegistrationOperation();
			}
		}
		return instance;
	}

	RegistrationDaoInterface registrationDaoInterface = RegistrationDaoOperations.getInstance();


	/**
	 * Method to add Course selected by student
	 *
	 * @param courseId id of course
	 * @param studentId id of student
	 * @param semester semester of student
	 * @return boolean indicating if the course is added successfully
	 * @throws CourseNotFoundException
	 * @throws AddCourseException
	 * @throws CourseLimitReachedException
	 * @throws SQLException
	 */
	@Override
	public boolean addCourse(String courseId, String studentId, int semester) throws CourseLimitReachedException, CourseNotFoundException, SQLException{

		try {
			if (registrationDaoInterface.numOfRegisteredCourses(studentId, semester) >= 6) {
				throw new CourseLimitReachedException(semester);
			}
			if(registrationDaoInterface.isValidCourse(courseId)) {
				throw new CourseNotFoundException(courseId);
			}
			return registrationDaoInterface.addCourse(courseId, studentId, semester);
		}
		catch (CourseLimitReachedException | CourseNotFoundException | SQLException e) {
			logger.error(e.getMessage());
		} 	
		return false;
		
	}


	/**
	 *  Method to drop Course selected by student
	 *
	 * @param courseId id of course
	 * @param studentId id of student
	 * @param semester semester of student
	 * @return boolean indicating if the course is dropped successfully
	 * @throws CourseNotRegisteredException
	 * @throws SQLException
	 */
	@Override
	public boolean dropCourse(String courseId, String studentId, int semester) throws CourseNotRegisteredException, SQLException{
		try {
			if(!registrationDaoInterface.isRegistered(courseId, studentId, semester)) {
				throw new CourseNotRegisteredException(courseId);
			}
			registrationDaoInterface.removeCourse(courseId, studentId, semester);
			return true;
		} catch (SQLException | CourseNotRegisteredException e) {
			logger.error(e.getMessage());
		} 
		return false;
	}


	/**
	 * Method to view the list of available courses
	 *
	 * @param studentId id of student
	 * @param semester semester of student
	 * @return List of courses
	 * @throws SQLException
	 */
	@Override
	public List<Course> viewCourses(String studentId, int semester) throws SQLException{
		// TODO Auto-generated method stub
		try {

			return registrationDaoInterface.viewCourses(studentId, semester);
		}
		catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return Collections.EMPTY_LIST;
	}


	/**
	 * Method to view the list of courses registered by the student
	 *
	 * @param studentId id of student
	 * @param semester semester of student
	 * @return List of registered courses
	 * @throws SQLException
	 */
	@Override
	public List<Course> viewRegisteredCourses(String studentId, int semester) throws SQLException{
		try {
			return registrationDaoInterface.viewRegisteredCourses(studentId, semester);
		}
		catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return Collections.EMPTY_LIST;
	}


	/**
	 * Method to view report card for students
	 * @param studentId id of student
	 * @param semester semester of student
	 * @return report card object
	 * @throws SQLException
	 */
	@Override
	public ReportCard viewReportCard(String studentId, int semester)throws SQLException {
			try {
				return registrationDaoInterface.viewReportCard(studentId, semester);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}


	/**
	 * Method for Fee payment for selected courses
	 * @param payment payment object with payment details
	 * @return boolean for successful/unsuccessful payment
	 * @throws PaymentNotFoundException
	 * @throws SQLException
	 */
	@Override
	public boolean payFee(Payment payment) throws SQLException{
		try {
			return registrationDaoInterface.payFee(payment);
		}
		catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return false;
		
	}


	/**
	 * Method to view the total fee
	 *
	 * @param studentId id of student
	 * @param semester semester for fee payment
	 * @return Payment object containing payment details
	 * @throws SQLException
	 */
	@Override
	public Payment viewFee(String studentId,int semester) throws PaymentNotFoundException,SQLException{
		try {
			if(registrationDaoInterface.isPaymentExist(studentId, semester)) {
				throw new PaymentNotFoundException(studentId);
			}
			return registrationDaoInterface.viewFee(studentId, semester);
		}
		catch(PaymentNotFoundException |SQLException e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	


}
