/**
 * 
 */
package com.crs.flipkart.business;

import java.sql.SQLException;
import java.util.HashMap;
import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.ReportCard;
import com.crs.flipkart.dao.AdminDaoInterface;
import com.crs.flipkart.dao.AdminDaoOperation;
import com.crs.flipkart.exception.AddCourseException;
import com.crs.flipkart.exception.CourseNotDeletedException;
import com.crs.flipkart.exception.CourseNotFoundException;
import com.crs.flipkart.exception.ProfessorNotAddedException;
import com.crs.flipkart.exception.ProfessorNotDeletedException;
import com.crs.flipkart.exception.StudentNotFoundForVerificationException;
import com.crs.flipkart.exception.StudentNotRegisteredException;
import com.crs.flipkart.exception.UserAlreadyExistException;
import com.crs.flipkart.exception.UserNotFoundException;

/**
 *
 * Implementations of Admin Operations
 *
 */

public class AdminOperation implements AdminInterface {

	private static Logger logger = Logger.getLogger(AdminOperation.class);
	private static volatile AdminOperation instance = null;

	private AdminOperation()
	{

	}

	/**
	 * Method to make AdminOperation Singleton
	 */
	public static AdminOperation getInstance()
	{
		if(instance == null)
		{
			synchronized(AdminOperation.class){
				instance = new AdminOperation();
			}
		}
		return instance;
	}


	AdminDaoInterface adminDaoOperation =AdminDaoOperation.getInstance();


	/**
	 * Method to Delete Course from Course Catalog
	 * 
	 * @param courseId
	 * @throws CourseNotFoundException
	 * @throws CourseNotDeletedException
	 */
	@Override
	public void removeCourse(String courseId) throws CourseNotFoundException, CourseNotDeletedException {
		try {
			adminDaoOperation.deleteCourse(courseId);
		} catch (CourseNotFoundException e) {
			logger.error(e.getMessage());
		} catch (CourseNotDeletedException e) {
			logger.info(e.getMessage());
		}
	}


	/**
	 * Method to add Course to Course Catalog
	 * 
	 * @param course : Course object storing details of a course
	 * @throws AddCourseException
	 */
	@Override
	public void addCourse(Course course) throws AddCourseException {
		try {
			adminDaoOperation.addCourse(course);
		} catch (AddCourseException e) {
			logger.error(e.getMessage());
		}
	}


	/**
	 * Method to approve a Student
	 * 
	 * @param studentId id of student to be approved
	 * @throws StudentNotFoundForVerificationException
	 * @return Approval Status
	 */
	@Override
	public boolean approveStudent(String studentId) throws StudentNotFoundForVerificationException {
		try {
			adminDaoOperation.approveStudent(studentId);
			
			return true;
		} catch (StudentNotFoundForVerificationException e) {
			logger.error(e.getMessage());
		}
		return false;
	}


	/**
	 * Method to add Professor to DB
	 * 
	 * @param professor : Professor Object storing details of a professor
	 * @throws ProfessorNotAddedException
	 * @throws UserAlreadyExistException
	 */
	@Override
	public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserAlreadyExistException {
		try {
			adminDaoOperation.addProfessor(professor);
		} catch (ProfessorNotAddedException e) {
			logger.error(e.getMessage());
		} catch (UserAlreadyExistException e) {
			logger.error(e.getMessage());
		}
	}





	/**
	 * Method to generate report
	 *
	 * @param StudentId id of student
	 * @param semester semester of student
	 * @throws StudentNotRegisteredException
	 */
	float counter=0.0f,sum=0.0f;
	@Override
	public void generateReport(String StudentId, int semester) throws StudentNotRegisteredException  {

		try {
			HashMap<String, String> gradecrd = adminDaoOperation.fetchGrades(StudentId, semester);
			if(gradecrd == null) {
				throw new StudentNotRegisteredException(StudentId);
			}
			gradecrd.forEach((k, v) -> {
				counter = counter + 1;
				if (v.toString().equals("A".toString()))
					sum += 4;
				else if (v.toString().equals("B".toString()))
					sum += 3;
				else if (v.toString().equals("C".toString()))
					sum += 2;
				else
					sum += 1;
			});
			
			float CPI = (float)sum/counter;
			
			adminDaoOperation.generateReport(semester, StudentId, CPI);
		} catch (StudentNotRegisteredException  e) {
			logger.error(e.getMessage());
		}
	}


	/**
	 * Method to delete Professor from DB
	 * 
	 * @param professorId id of professor
	 * @throws ProfessorNotAddedException
	 * @throws ProfessorNotDeletedException
	 */
	@Override
	public void removeProfessor(String professorId) throws ProfessorNotAddedException, ProfessorNotDeletedException {
		try {
			adminDaoOperation.removeProfessor(professorId);
		} catch (ProfessorNotDeletedException|UserNotFoundException e) {
			logger.error(e.getMessage());
		}
	}

}
