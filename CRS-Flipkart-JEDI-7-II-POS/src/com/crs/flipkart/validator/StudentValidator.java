/**
 * 
 */
package com.crs.flipkart.validator;


import java.util.ArrayList;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.exception.CourseLimitReachedException;
import com.crs.flipkart.exception.CourseNotFoundException;
import com.crs.flipkart.exception.SeatNotAvailableException;
/**
 *
 */

public class StudentValidator {
	
	/**
	 * Method to validate if student is already registered for this particular course (courseCode) or not 
	 * @param courseCode
	 * @param studentId
	 * @param registeredCourseList  
	 * @return Student Registration Status
	 * @throws CourseNotFoundException
	 */
	public static boolean isRegistered(String courseCode,int studentId,ArrayList<Course>registeredCourseList) throws CourseNotFoundException
	{
		for(Course course : registeredCourseList)
		{
			if(courseCode.equalsIgnoreCase(course.getCourseId())) 
			{
				return true; 
			}
		}
		
		return false;
	}
	
	
	/**
	 * Method to validate if couseCode is valid or not
	 * @param courseId
	 * @param availableCourseList
	 * @return if couseCode is valid or not
	 */
	public static boolean isValidCourseCode(String courseId,ArrayList<Course>availableCourseList) 
	{
		for(Course course : availableCourseList)
		{
			if(courseId.equalsIgnoreCase(course.getCourseId())) 
			{
				return true; 
			}
		}
		
		return false;
	
	}

}
