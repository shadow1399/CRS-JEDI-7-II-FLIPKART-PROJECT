/**
 * 
 */
package com.crs.flipkart.business;

/**
 * @author Keertana
 *
 */
import com.crs.flipkart.dao.*;
/**
 * @author Keertana
 *
 */
import java.util.*;
import com.crs.flipkart.bean.*;
public class ProfessorService {
	/**
	 * Method that displays all students registered in a course taught by the professor
	 * @param courseid
	 * @param userid
	 * @return List of roll numbers of students who are there in the course taught by professor
	 */
	public List<String> getStudents(String courseid,String userid)
	{
		try {
			ProfessorDaoInterface professorDaoOperation=new ProfessorDaoOperation();
			List<String> result=professorDaoOperation.getStudents(courseid,userid);
			return result;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	/**
	 * Method that displays all courses
	 * @return List of all courses that are taught
	 */
	public List<Course> getCourses()
	{
		try {
			ProfessorDaoInterface professorDaoOperation=new ProfessorDaoOperation();
			List<Course> result=professorDaoOperation.getCourses();
			return result;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	/**
	 *  Method that displays all courses registered by the professor
	 * @param profid
	 * @return List of all courses that professor registered
	 */
	public List<Course> getRegisteredCourses(String profid)
	{
		try {
			ProfessorDaoInterface professorDaoOperation=new ProfessorDaoOperation();
			List<Course> result=professorDaoOperation.getRegisteredCourses(profid);
			return result;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	/**
	 * Method that enables professor to add grades to students
	 * @param courseid
	 * @param userid
	 * @return whether all grades are added successfully or not
	 */
	public boolean addGrades(String courseid,String userid)
	{
		try {
			ProfessorDaoInterface professorDaoOperation=new ProfessorDaoOperation();
			return professorDaoOperation.addGrades(courseid,userid);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return false;
		
	}
	/**
	 * Method through which professor registers for a course
	 * @param courseId
	 * @param profId
	 * @return whether professor successfully registered in the course or not
	 */
	public boolean registerCourse(String courseId,String profId)
	{
		try {
			ProfessorDaoInterface professorDaoOperation=new ProfessorDaoOperation();
			return professorDaoOperation.registerCourse(courseId,profId);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return false;
	}
}
