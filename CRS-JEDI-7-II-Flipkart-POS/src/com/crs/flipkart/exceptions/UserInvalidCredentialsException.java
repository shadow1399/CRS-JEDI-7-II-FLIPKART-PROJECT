/**
 * 
 */
package com.crs.flipkart.exceptions;

/**
 * @author SATYANSH
 *
 */
public class UserInvalidCredentialsException extends Exception{
	private String email;
	
	
	public UserInvalidCredentialsException(String email) {
		super();
		this.email=email;
	}


	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Invalid Credentials for email: "+email;
	}
	
	
}
