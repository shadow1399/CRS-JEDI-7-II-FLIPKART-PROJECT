/**
 * 
 */
package com.flipkart.bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * CLass for User Login
 *
 */
public class LoginUser {
	
	private String loginId;

	
	private String password;
	
	/**
	 * Dafault Constructor
	 */
	public LoginUser() {
		
	}
	/**
	 * Parameterized Constructor
	 * @param loginId
	 * @param password
	 */
	@JsonCreator
	public LoginUser(@JsonProperty("loginId") String loginId,
			@JsonProperty("password") String password) {
		this.loginId = loginId;
		this.password = password;
	}
	/**
	 * Getters and Setters for Login Class
	 * @return
	 */
	public String getLoginId() {
		return loginId;
	}
	
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
