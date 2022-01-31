package com.crs.flipkart.business;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Payment;
import com.crs.flipkart.bean.ReportCard;
import com.crs.flipkart.constants.SQLQueriesConstants;
import com.crs.flipkart.dao.RegistrationDaoInterface;
import com.crs.flipkart.dao.RegistrationDaoOperations;
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
	public boolean addCourse(String courseId, String studentId, int semester){

		try {
//			if (registrationDaoInterface.numOfRegisteredCourses(studentId, semester) >= 6) {
//				throw new CourseLimitReachedException(semester);
//			}
//			if (registrationDaoInterface.isRegistered(courseId, studentId, semester)) {
//				throw new CourseAlreadyRegisteredException(courseId);
//			}
			return registrationDaoInterface.addCourse(courseId, studentId, semester);
		}
		catch (Exception e) {
			logger.error("");
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
	 * @throws CourseNotDeletedException
	 * @throws SQLException
	 */
	@Override
	public boolean dropCourse(String courseId, String studentId, int semester){
//		try {
//			if(!registrationDaoInterface.isRegistered(courseId, studentId, semester)) {
//				throw new SQLException();
//			}
//		} catch (SQLException e) {
//			//logger.error("");
//		} 
		return registrationDaoInterface.removeCourse(courseId, studentId, semester);
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
	public List<Course> viewCourses(String studentId, int semester){
		// TODO Auto-generated method stub
		return registrationDaoInterface.viewCourses(studentId, semester);
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
	public List<Course> viewRegisteredCourses(String studentId, int semester){
		return registrationDaoInterface.viewRegisteredCourses(studentId, semester);
	}


	/**
	 * Method to view report card for students
	 * @param studentId id of student
	 * @param semester semester of student
	 * @return report card object
	 * @throws SQLException
	 */
	@Override
	public ReportCard viewReportCard(String studentId, int semester) {
			try {
				return registrationDaoInterface.viewReportCard(studentId, semester);
			} catch (Exception e) {
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
	public boolean payFee(Payment payment){
		return registrationDaoInterface.payFee(payment);
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
	public Payment viewFee(String studentId,int semester){
		return registrationDaoInterface.viewFee(studentId, semester);
	}
	


}
