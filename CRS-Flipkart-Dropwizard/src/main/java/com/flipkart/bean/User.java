/**
 * 
 */
package com.flipkart.bean;

/**
 * @author JEDI-02
 * Scholarsihp Class
 */
public class User {

	private String userName;
	private String phoneNumber;
	private String address;
	private String userId;
	private String userPassword;
	private String type;

	/**
	 * Constructor for User class
	 * @param userName
	 * @param phoneNumber
	 * @param address
	 * @param userId
	 * @param userPassword
	 * @param type
	 */
	public User(String userName, String phoneNumber, String address, String userId, String userPassword, String type) {
		super();
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.userId = userId;
		this.userPassword = userPassword;
		this.type = type;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Getter Setter Methods for User details
	 *
	 */
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Method to Convert Student object to string
	 * @return object as string value
	 */
	@Override
	public String toString() {
		return "User [userName=" + userName + ", phoneNumber=" + phoneNumber + ", address=" + address + ", userId="
				+ userId + ", userPassword=" + userPassword + ", type=" + type + "]";
	}

}
