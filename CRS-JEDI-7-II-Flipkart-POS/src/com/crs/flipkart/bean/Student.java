package com.crs.flipkart.bean;

public class Student extends User{
	private String rollNo;
	private int semester;
	private String branch;
	private int isVerified;
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	/**
	 * @return the isVerified
	 */
	public int getIsVerified() {
		return isVerified;
	}
	/**
	 * @param isVerified the isVerified to set
	 */
	public void setIsVerified(int isVerified) {
		this.isVerified = isVerified;
	}
	
	
}
