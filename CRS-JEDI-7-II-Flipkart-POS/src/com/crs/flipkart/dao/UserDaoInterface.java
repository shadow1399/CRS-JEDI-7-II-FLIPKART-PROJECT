/**
 * 
 */
package com.crs.flipkart.dao;

import com.crs.flipkart.exceptions.UserInvalidCredentialsException;

/**
 * @author SATYANSH
 *
 */
public interface UserDaoInterface {
	
	/**
	 * Verify the credentials given from the DB
	 * @param email
	 * @param password
	 * @return
	 * @throws UserInvalidCredentialsException 
	 */
	public boolean verifyCredentials(String email,String password) throws UserInvalidCredentialsException;
	
	/**
	 * Update the Password in DB
	 * @param email
	 * @param password
	 * @return
	 * @throws UserInvalidCredentialsException 
	 */
	public boolean updatePassword(String email,String password) throws UserInvalidCredentialsException;
	
	/**
	 * Get the userType from the DB (eg.admin,professor)
	 * @param email
	 * @return
	 * @throws UserInvalidCredentialsException 
	 */
	public String getUserType(String email) throws UserInvalidCredentialsException;
}
