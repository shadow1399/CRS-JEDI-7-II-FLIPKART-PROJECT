package com.crs.flipkart.business;

import java.sql.SQLException;

import com.crs.flipkart.bean.ReportCard;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.dao.RegistrationDaoInterface;
import com.crs.flipkart.dao.RegistrationDaoOperations;
import com.crs.flipkart.dao.StudentDaoInterface;
import com.crs.flipkart.dao.StudentDaoOperation;
import com.crs.flipkart.exceptions.UserAlreadyExistException;
import org.apache.log4j.Logger;

public class StudentOperation implements StudentInterface {
	
	private static volatile StudentOperation instance=null;
	private static Logger logger = Logger.getLogger(StudentOperation.class);
	StudentDaoInterface studentDaoInterface=StudentDaoOperation.getInstance();
	RegistrationDaoInterface registrationDaoInterface = RegistrationDaoOperations.getInstance();

	public StudentOperation()
	{
		
	}
	/**
	 * Method to make StudentOperation Singleton
	 * @return
	 */
	public static StudentOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(StudentOperation.class){
				instance=new StudentOperation();
			}
		}
		return instance;
	}



	@Override
	public int checkIsVerified(String studentId) throws SQLException {
		
		// TODO Auto-generated method stub
		
		return studentDaoInterface.isApproved(studentId);
	}
	
	
	@Override
	public String getStudentId(String userId) {
		return studentDaoInterface.getStudentId(userId);
	
	}

	@Override
	public ReportCard viewReportCard(String studentId, int semester) throws SQLException{
		// TODO Auto-generated method stub
		
		
		
		try {
			return registrationDaoInterface.viewReportCard(studentId, semester);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		} 
		return null;
	}
	

	@Override
	public String registerStudent(String userName, String phoneNumber, String address, String userId,
			String password, String role, String rollNumber, String branch, Boolean isVerified)
			throws UserAlreadyExistException {
		// TODO Auto-generated method stub
		String studentId;
		try {

			studentId = studentDaoInterface.addStudent(userName,phoneNumber,address,userId,password,role,rollNumber,branch,isVerified);
			
		}
		catch(UserAlreadyExistException ex){
			throw ex;
		}
		return studentId;
	}

}
