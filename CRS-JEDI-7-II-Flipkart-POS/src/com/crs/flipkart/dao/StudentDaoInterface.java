/**
 * 
 */
package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Student;
import com.crs.flipkart.exceptions.UserAlreadyExistException;

/**
 * @author lenovo
 *
 */
public interface StudentDaoInterface {
	
	/**
	 * Method to add student to database
	 * @param student: student object containing all the fields
	 * @return true if student is added, else false
	 * @throws StudentNotRegisteredException
	 */
	public String addStudent(String userName, String phoneNumber, String address, String userId,
			String password, String role, String rollNumber, String branch, Boolean isVerified) throws UserAlreadyExistException;
	
	
	/**
	 * Method to retrieve Student Id from User Id
	 * @param userId
	 * @return Student Id
	 */
	public String getStudentId(String userId);
	
	/**
	 * Method to check if Student is approved
	 * @param studentId
	 * @return boolean indicating if student is approved
	 */
	public int isApproved(String studentId);

}
