package com.crs.flipkart.business;

import java.sql.SQLException;
import java.util.List;

import com.crs.flipkart.bean.*;
import com.crs.flipkart.exception.AddCourseException;
import com.crs.flipkart.exception.CourseLimitReachedException;
import com.crs.flipkart.exception.CourseNotDeletedException;
import com.crs.flipkart.exception.CourseNotFoundException;
import com.crs.flipkart.exception.PaymentNotFoundException;

public interface RegistrationInterface {
	/**
	 *
	 * @param courseId
	 * @param studentId
	 * @param courseList
	 * @return true/false for successful/unsuccessful operation of adding a course.
	 * @throws AddCourseException
	 * @throws SQLException 
	 * @throws  
	 */
	public boolean addCourse(String courseId, String studentId, int semester) throws CourseNotFoundException,AddCourseException, CourseLimitReachedException, SQLException;

	/**
	 *
	 * @param courseId
	 * @param studentId
	 * @param registeredCourseList
	 * @return true/false for successful/unsuccessful operation of dropping a
	 *         course.
	 * @throws CourseNotDeletedException
	 * @throws SQLException 
	 */
	public boolean dropCourse(String courseId, String studentId, int semester)
			throws CourseNotDeletedException, SQLException,CourseNotFoundException;

	/**
	 *
	 * @return list of courses available
	 * @throws SQLException 
	 */
	public List<Course> viewCourses(String studentId, int semester) throws SQLException;

	/**
	 *
	 * @param studentId
	 * @return list of registered courses by a student.
	 * @throws SQLException 
	 */
	public List<Course> viewRegisteredCourses(String studentId, int semester) throws SQLException;

	/**
	 *
	 * @param studentId
	 * @return report card of the student as an object of class ReportCard
	 * @throws SQLException 
	 */
	public ReportCard viewReportCard(String studentId,  int semester) throws SQLException;

	/**
	 *
	 * @param studentId
	 * @return total fees paid
	 * @throws PaymentNotFoundException on unsuccessful payment
	 * @throws SQLException 
	 */
	public boolean payFee(Payment payment) throws PaymentNotFoundException, SQLException;

	/*
	 * Method to check whether the given student has paid the fee or not
	 * for given sem
	 * */
	public Payment viewFee(String studentId,int semester) throws SQLException;



}
