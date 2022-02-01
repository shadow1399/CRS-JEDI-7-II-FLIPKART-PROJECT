package com.crs.flipkart.bean;

import java.util.HashMap;
import java.util.Map;

public class ReportCard {
	private int Semester;
	private int rollNo;
	private float gpa;
	private HashMap<String,Float> grades = new HashMap<String,Float>();
	
	
	/**
	 * @param semester
	 * @param rollNo
	 * @param gpa
	 * @param grades
	 */
	public ReportCard(int semester, int rollNo, float gpa, HashMap<String, Float> grades) {
		super();
		Semester = semester;
		this.rollNo = rollNo;
		this.gpa = gpa;
		this.grades = grades;
	}
	/**
	 * @return the semester
	 */
	public int getSemester() {
		return Semester;
	}
	/**
	 * @param semester the semester to set
	 */
	public void setSemester(int semester) {
		Semester = semester;
	}
	/**
	 * @return the rollNo
	 */
	public int getRollNo() {
		return rollNo;
	}
	/**
	 * @param rollNo the rollNo to set
	 */
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	/**
	 * @return the gpa
	 */
	public float getGpa() {
		return gpa;
	}
	/**
	 * @param gpa the gpa to set
	 */
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	/**
	 * @return the grades
	 */
	public HashMap<String, Float> getGrades() {
		return grades;
	}
	/**
	 * @param grades the grades to set
	 */
	public void setGrades(HashMap<String, Float> grades) {
		this.grades = grades;
	}
	
}
