/**
 * 
 */
package com.flipkart.bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author lenovo
 *
 */
public class LoginUser {
	
	private String loginId;

	
	private String password;
	
	public LoginUser() {
		
	}
	
	@JsonCreator
	public LoginUser(@JsonProperty("loginId") String loginId,
			@JsonProperty("password") String password) {
		this.loginId = loginId;
		this.password = password;
	}
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
