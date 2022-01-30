/**
 * 
 */
package com.crs.flipkart.dao;

/**
 * @author YASH
 *
 */
public interface UserDaoInterface {
	public boolean verifyCredentials(String email,String password);
	
	public boolean updatePassword(String email,String password);
	
	public String getUserType(String email);
}
