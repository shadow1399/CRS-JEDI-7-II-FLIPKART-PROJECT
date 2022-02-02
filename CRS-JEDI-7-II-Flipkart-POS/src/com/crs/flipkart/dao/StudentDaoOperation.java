/**
 * 
 */
package com.crs.flipkart.dao;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.crs.flipkart.bean.Student;
import com.crs.flipkart.constants.SQLQueriesConstants;
import com.crs.flipkart.exceptions.UserAlreadyExistException;
import com.crs.flipkart.business.StudentOperation;
import com.crs.flipkart.utils.DBUtils;

/**
 * @author lenovo
 *
 */
public class StudentDaoOperation implements StudentDaoInterface {
	
	private static volatile StudentDaoOperation instance=null;
	private static Logger logger = Logger.getLogger(StudentDaoOperation.class);
	
	/**
	 * Default Constructor
	 */
	private StudentDaoOperation()
	{
		
	}
	
	/**
	 * Method to make StudentDaoOperation Singleton
	 * @return
	 */
	public static StudentDaoOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(StudentDaoOperation.class){
				instance=new StudentDaoOperation();
			}
		}
		return instance;
	}
	
	/**
	 * Method to add student to database
	 * @param student: student object containing all the fields
	 * @return true if student is added, else false
	 * @throws StudentNotRegisteredException
	 */
	@Override
	public String addStudent(String userName, String phoneNumber, String address, String userId,
			String password, String role, String rollNumber, String branch, Boolean isVerified) throws UserAlreadyExistException{
		
		Connection connection=DBUtils.getConnection();
//		System.out.println("here also");
		String studentId="";
		try{
			//open db connection
			PreparedStatement preparedStatement=connection.prepareStatement(SQLQueriesConstants.ADD_USER_QUERY);
			preparedStatement.setString(1, rollNumber);
			preparedStatement.setString(2, userName);
			preparedStatement.setString(3, password);
			preparedStatement.setString(4, role);
			preparedStatement.setString(5, phoneNumber);
			preparedStatement.setString(6, userId);
			int rowsAffected=preparedStatement.executeUpdate();
			if(rowsAffected==1)
			{
				//add the student record
				PreparedStatement preparedStatementStudent;
				preparedStatementStudent=connection.prepareStatement(SQLQueriesConstants.ADD_STUDENT,Statement.RETURN_GENERATED_KEYS);
				preparedStatementStudent.setString(1,rollNumber);
				preparedStatementStudent.setInt(2,1);
				preparedStatementStudent.setString(3,phoneNumber);
				preparedStatementStudent.setInt(4, 0);
				preparedStatementStudent.executeUpdate();
				ResultSet results=preparedStatementStudent.getGeneratedKeys();
				if(results.next())
					studentId=results.getString(0);
				System.out.println("----------------------------------SUCCESSFULLY REGISTERED-----------------------------\n");


			}
			else {
				throw new UserAlreadyExistException(userId);
			}
			
			
		}
		catch(UserAlreadyExistException|SQLException ex)
		{
			System.out.println("-----------------REGISTERATION FAILED!!-------------------------");
			logger.error("User with user id : "+ userId +" already exists.");
			
		}
		return studentId;
	}
	
	/**
	 * Method to retrieve Student Id from User Id
	 * @param userId
	 * @return Student Id
	 */
	@Override
	public String getStudentId(String userId) {
			return userId;
	}
	
	
	
	
	/**
	 * Method to check if Student is approved
	 * @param studentId
	 * @return boolean indicating if student is approved
	 */
	@Override
	public int isApproved(String studentId) {
		Connection connection=DBUtils.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.IS_APPROVED);
			statement.setString(1, studentId);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next())
			{
				return rs.getInt("isVerified");
			}
				
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
		
		return 0;
	}
}
