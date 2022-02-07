/**
 * 
 */
package com.crs.flipkart.business;

import java.util.List;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.EnrolledStudent;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.exception.CourseNotFoundException;
import com.crs.flipkart.exception.GradeNotAddedException;
import com.crs.flipkart.exception.StudentNotFoundForVerificationException;
import com.crs.flipkart.exception.StudentNotRegisteredException;

/**
 *
 */
public interface ProfessorInterface {

	/**
	 * Function to get all the courses
	 * 
	 * @param professorId
	 * @return list of all the courses
	 */
	public List<Course> getCourses(String professorId);

	/**
	 * Function to get list of students registered for a course
	 * 
	 * @param professorId
	 * @return list of registered students
	 * @throws CourseNotFoundException
	 */
	public List<EnrolledStudent> viewStudents(String professorId) ;

	/**
	 * Function to add grade for a student registered in a course
	 * 
	 * @param studentId
	 * @param courseId
	 * @param grade
	 * @return status if the grade is successfully registered or not
	 * @throws StudentNotFoundForVerificationException
	 * @throws StudentNotRegisteredException
	 */
	public boolean addGrade(String studentId, String courseId,int  semester, String grade)
			throws StudentNotRegisteredException, StudentNotFoundForVerificationException,GradeNotAddedException;

}
