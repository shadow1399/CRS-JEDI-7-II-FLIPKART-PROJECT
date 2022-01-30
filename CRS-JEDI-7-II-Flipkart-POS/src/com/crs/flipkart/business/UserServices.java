/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.dao.UserDaoInterface;
import com.crs.flipkart.dao.UserDaoOperations;

/**
 * @author YASH
 *
 */
public class UserServices implements UserInterface{

	@Override
	public boolean verifyCredentials(String email, String password) {
		// TODO Auto-generated method stub
		boolean verified=false;
		try {
			UserDaoInterface userDaoInterface=new UserDaoOperations();
			 verified=userDaoInterface.verifyCredentials(email, password);
		}catch(Exception e) {
			System.out.println(e);
		}
		return verified;
	}

	@Override
	public boolean updatePassword(String email, String password) {
		// TODO Auto-generated method stub
		boolean updatedPass=false;
		try {
			UserDaoInterface userDaoInterface=new UserDaoOperations();
			updatedPass=userDaoInterface.updatePassword(email, password);
		}catch(Exception e) {
			System.out.println(e);
		}
		return updatedPass;
		
	}

	@Override
	public String getUserType(String email) {
		// TODO Auto-generated method stub
		String userType=null;
		try {
			UserDaoInterface userDaoInterface=new UserDaoOperations();
			userType=userDaoInterface.getUserType(email);
		}catch(Exception e) {
			System.out.println(e);
		}
		return userType;
	}

}
