package com.crs.flipkart.bean;

public class Payment {
	
	
	private String paymentId;
	private String rollNo;
	private float pAmout;
	private boolean pStatus;
	private String pType;
	private String notificationId;
	private int semester;
	
	/**
	 *Default Constructor 
	 */
	
	public Payment() {
		
	}
	/**
	 * @param paymentId
	 * @param rollNo
	 * @param pAmout
	 * @param pStatus
	 * @param pType
	 * @param notificationId
	 * @param semester
	 */
	public Payment(String paymentId, String rollNo, float pAmout, boolean pStatus, String pType, String notificationId,
			int semester) {
		super();
		this.paymentId = paymentId;
		this.rollNo = rollNo;
		this.pAmout = pAmout;
		this.pStatus = pStatus;
		this.pType = pType;
		this.notificationId = notificationId;
		this.semester = semester;
	}
	
	/**
	 * @return the semester
	 */
	public int getSemester() {
		return semester;
	}
	/**
	 * @param semester the semester to set
	 */
	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	/**
	 * @return the notificationId
	 */
	public String getNotificationId() {
		return notificationId;
	}
	/**
	 * @param notificationId the notificationId to set
	 */
	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}
	
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public float getpAmout() {
		return pAmout;
	}
	public void setpAmout(float pAmout) {
		this.pAmout = pAmout;
	}
	public boolean ispStatus() {
		return pStatus;
	}
	public void setpStatus(boolean pStatus) {
		this.pStatus = pStatus;
	}
	public String getpType() {
		return pType;
	}
	public void setpType(String pType) {
		this.pType = pType;
	}
	
	
}
