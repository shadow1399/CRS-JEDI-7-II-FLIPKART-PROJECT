/**
 * 
 */
package com.crs.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.crs.flipkart.constants.SQLQueryConstants;
import com.crs.flipkart.utils.DBUtils;

/**
 * @author YASH
 *
 */
public class UserDaoOperations implements UserDaoInterface {
	
	private PreparedStatement statement=null;
	
	Connection connection=DBUtils.getConnection();

	@Override
	public boolean verifyCredentials(String email, String password) {
		// TODO Auto-generated method stub
		try {
			statement = connection.prepareStatement(SQLQueryConstants.VERIFY_CREDENTIALS);
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			if (!resultSet.next()) {
				System.out.println("USer Not Found");
				return false;
			}
			else if (password.equals(resultSet.getString("password")))
				return true;
			else {
				System.out.println("Invalid email or Password");
				return false;
			}
				
		} catch (Exception e) {
			System.out.println(e);
		}

		return false;
	}

	@Override
	public boolean updatePassword(String email, String password) {
		// TODO Auto-generated method stub
		try {
			statement = connection.prepareStatement(SQLQueryConstants.UPDATE_PASSWORD);
			statement.setString(1, password);
			statement.setString(2, email);
			ResultSet resultSet = statement.executeQuery();
			if (!resultSet.next()) {
				System.out.println("User Not Found!!");
				return false;
			}
				
			return true;
		} catch (Exception e) {
			System.out.println(e);
		} 
		return false;
	}

	@Override
	public String getUserType(String email) {
		// TODO Auto-generated method stub
		
		try {
			statement = connection.prepareStatement(SQLQueryConstants.GET_Type);
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			if (!resultSet.next()) {
				System.out.println("User Not Found");
				return null;
			}
				
			else
				return resultSet.getString("type");
		} catch (Exception e) {
			System.out.println(e);
			
		} 
		return null;
	}

}
