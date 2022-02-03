/**
 * 
 */
package com.crs.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.crs.flipkart.constants.SQLQueriesConstants;
import com.crs.flipkart.exceptions.UserInvalidCredentialsException;
import com.crs.flipkart.utils.DBUtils;

/**
 * @author SATYANSH
 *
 */
public class UserDaoOperations implements UserDaoInterface {
	
	private PreparedStatement statement=null;
	
	Connection connection=DBUtils.getConnection();
	private static Logger logger = Logger.getLogger(UserDaoOperations.class);

	@Override
	public boolean verifyCredentials(String email, String password) throws UserInvalidCredentialsException{
		// TODO Auto-generated method stub
		try {
			statement = connection.prepareStatement(SQLQueriesConstants.VERIFY_CREDENTIALS);
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			//logger.info("Password : " + resultSet.getString("password"));
			if (!resultSet.next()) {
				throw new UserInvalidCredentialsException(email);
				
			}
			else if (password.equals(resultSet.getString("password")))
				return true;
			else {
				throw new UserInvalidCredentialsException(email);
			}
				
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return false;
	}

	@Override
	public boolean updatePassword(String email, String password) throws UserInvalidCredentialsException{
		// TODO Auto-generated method stub
		try {
			statement = connection.prepareStatement(SQLQueriesConstants.UPDATE_PASSWORD);
			statement.setString(1, password);
			statement.setString(2, email);
			ResultSet resultSet = statement.executeQuery();
			if (!resultSet.next()) {
				throw new UserInvalidCredentialsException(email);
			}
			logger.info("Password Updated Successfully!!!");
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage());
		} 
		return false;
	}

	@Override
	public String getUserType(String email) throws UserInvalidCredentialsException {
		// TODO Auto-generated method stub
		
		try {
			statement = connection.prepareStatement(SQLQueriesConstants.GET_Type);
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			if (!resultSet.next()) {
				throw new UserInvalidCredentialsException(email);
			}
				
			else {
				
				return resultSet.getString("type");
			}
				
		} catch (Exception e) {
			logger.error(e.getMessage());
			
		} 
		return null;
	}

}
