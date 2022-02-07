/**
 * 
 */
package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.ReportCard;
import com.crs.flipkart.bean.User;
import com.crs.flipkart.exception.AddCourseException;
import com.crs.flipkart.exception.CourseNotDeletedException;
import com.crs.flipkart.exception.CourseNotFoundException;
import com.crs.flipkart.exception.ProfessorNotAddedException;
import com.crs.flipkart.exception.ProfessorNotDeletedException;
import com.crs.flipkart.exception.StudentNotFoundForVerificationException;
import com.crs.flipkart.exception.StudentNotRegisteredException;
import com.crs.flipkart.exception.UserAlreadyExistException;
import com.crs.flipkart.exception.UserNotApprovedExecption;
import com.crs.flipkart.exception.UserNotFoundException;

import java.util.HashMap;

/**
 */
public interface AdminDaoInterface {

	/**
	 * Delete Course using SQL commands
	 * @param courseCode
	 * @throws CourseNotFoundException
	 * @throws CourseNotDeletedException 
	 */
	public void deleteCourse(String courseId) throws CourseNotFoundException, CourseNotDeletedException;

	/**
	 * Add Course using SQL commands
	 * @param course
	 * @throws AddCourseException
	 */
	public void addCourse(Course course) throws AddCourseException;
	
	/**
	 * Approve Student using SQL commands
	 * @param studentId
	 * @throws StudentNotFoundForVerificationException
	 */
	public void approveStudent(String studentId) throws StudentNotFoundForVerificationException;
	
	/**
	 * Add professor using SQL commands
	 * @param professor
	 * @throws ProfessorNotAddedException
	 * @throws UserAlreadyExistException 
	 */
	public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserAlreadyExistException;
	
	/**
	 * Method to add user using SQL commands
	 * @param user
	 * @throws UserNotApprovedExecption
	 * @throws UserAlreadyExistException 
	 */
	public void addUser(Professor user) throws UserNotApprovedExecption, UserAlreadyExistException;
	
	/**
	 * Method to delete Professor from DB
	 * 
	 * @param professorId
	 * @throws ProfessorNotAddedException
	 * @throws UserNotFoundException
	 */
	public void removeProfessor(String prefessorId) throws ProfessorNotAddedException,ProfessorNotDeletedException, UserNotFoundException;

	/**
	 * Function to generate report
	 * 
	 * @param reportCard
	 * @throws StudentNotRegisteredException
	 */
	public void generateReport(int semester,String StudentId,float CPI) throws StudentNotRegisteredException;

	/**
	 * Method to fetch grades of a student by semester Id
	 * @param StudentId id of the student
	 * @param semester semester to fetch grades for
	 * @return hashmap of courseId with corresponding grades of the student
	 */
	public HashMap<String, String> fetchGrades(String StudentId, int semester);

}
