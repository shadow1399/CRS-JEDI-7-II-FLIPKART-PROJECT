package com.crs.flipkart.bean;

public class Payment {
	private String paymentId;
	private String rollNo;
	private float pAmout;
	private boolean pStatus;
	private String pType;
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
