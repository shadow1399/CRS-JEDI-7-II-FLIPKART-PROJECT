package com.crs.flipkart.business;

public interface UserInterface {
	public boolean verifyCredentials(String email,String password);
	
	public boolean updatePassword(String email,String password);
	
	public String getUserType(String email);
}
