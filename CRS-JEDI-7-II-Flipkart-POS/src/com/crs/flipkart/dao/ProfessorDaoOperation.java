/**
 * 
 */
package com.crs.flipkart.dao;

import com.mysql.jdbc.*;
import com.crs.flipkart.bean.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;
import com.crs.flipkart.constants.*;
import com.crs.flipkart.utils.*;
import org.apache.log4j.Logger;

/**
 * @author Keertana
 *
 */
public class ProfessorDaoOperation implements ProfessorDaoInterface{
	/**
	 * Method that displays all students registered in a course taught by the professor through Database Call
	 * @param courseid
	 * @param userid
	 * @return List of roll numbers of students who are there in the course taught by professor
	 */
	private static Logger logger = Logger.getLogger(UserDaoOperations.class);
	public List<String> getStudents(String courseid,String userid)
	{
		try {
			Connection con=DBUtils.getConnection();
			PreparedStatement stmt1=con.prepareStatement(SQLQueriesConstants.COURSES_TAUGHT_BYPROFESSOR);
			stmt1.setString(1,userid);
			ResultSet rs1=stmt1.executeQuery();
			int found=0;
			while(rs1.next())
			{
				if(courseid.equals(rs1.getString("courseId")))
				{
					found=1;
					break;
				}
			}
			if(found==1)
			{
				PreparedStatement stmt=con.prepareStatement(SQLQueriesConstants.STUDENTS_REGISTERED_INACOURSE);
				stmt.setString(1,courseid);
				ResultSet rs=stmt.executeQuery();
				List<String> result=new ArrayList<String>();
				while(rs.next())
				{
					result.add(rs.getString("rollNo"));
				}
				return result;
			}
			else
				System.out.println("You do not teach this course");
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
		return null;
	}
	/**
	 * Method that displays all courses through Database Call
	 * @return List of all courses that are taught
	 */
	public List<Course> getCourses()
	{
		try {
			Connection con=DBUtils.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(SQLQueriesConstants.COURSETABLE_RECORDS);
			List<Course> result=new ArrayList<Course>();
			while(rs.next())
			{
				Course c=new Course();
				c.setCourseId(rs.getString("courseId"));
				c.setCourseName(rs.getString("courseName"));
				c.setProfessorId(rs.getString("professorId"));
				c.setNumberOfStudents(rs.getInt("numberOfStudents"));
				result.add(c);
			}
			return result;
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
		return null;
		
	}
	/**
	 * Method that enables professor to add grades to students through Database Call
	 * @param courseid
	 * @param userid
	 * @return whether all grades are added successfully or not
	 */
	public boolean addGrades(String courseid,String userid)
	{
		try {
			Scanner sc=new Scanner(System.in);
			Connection con=DBUtils.getConnection();
			PreparedStatement stmt1=con.prepareStatement(SQLQueriesConstants.COURSES_TAUGHT_BYPROFESSOR);
			stmt1.setString(1,userid);
			ResultSet rs1=stmt1.executeQuery();
			int found=0;
			while(rs1.next())
			{
				if(courseid.equals(rs1.getString("courseId")))
				{
					found=1;
					break;
				}
			}
			if(found==1)
			{
				PreparedStatement stmt=con.prepareStatement(SQLQueriesConstants.STUDENTS_REGISTERED_INACOURSE);
				stmt.setString(1,courseid);
				ResultSet rs=stmt.executeQuery();
				List<String> rollNos=new ArrayList<String>();
				while(rs.next())
				{
					rollNos.add(rs.getString("rollNo"));
				}
				for(String rollNo:rollNos)
				{
					PreparedStatement stmt2=con.prepareStatement(SQLQueriesConstants.ADDING_GRADES);
					System.out.println("Enter grade for student with rollno "+rollNo+" for course "+courseid+":");
					int grade=sc.nextInt();
					stmt2.setInt(1,grade);
					stmt2.setString(2, rollNo);
					stmt2.setString(3, courseid);
					int executed=stmt2.executeUpdate();
				}
				return true;
			}
			else
			{
				System.out.println("You do not teach this course");
				return false;
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
		return false;
	}
	/**
	 *  Method that displays all courses registered by the professor through Database Call
	 * @param profid
	 * @return List of all courses that professor registered
	 */
	public List<Course> getRegisteredCourses(String profid)
	{
		try {
			Connection con=DBUtils.getConnection();
			PreparedStatement stmt=con.prepareStatement(SQLQueriesConstants.COURSES_TAUGHT_BYPROFESSOR);
			stmt.setString(1,profid);
			ResultSet rs=stmt.executeQuery();
			List<Course> result=new ArrayList<Course>();
			while(rs.next())
			{
				Course c=new Course();
				c.setCourseId(rs.getString("courseId"));
				c.setCourseName(rs.getString("courseName"));
				c.setProfessorId(rs.getString("professorId"));
				c.setNumberOfStudents(rs.getInt("numberOfStudents"));
				result.add(c);
			}
			//System.out.println("Returned Result");
			return result;
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
		return null;
	}
	/**
	 * Method through which professor registers for a course through Database Call
	 * @param courseid
	 * @param profid
	 * @return whether professor successfully registered in the course or not
	 */
	public boolean registerCourse(String courseid,String profid)
	{
		try {
			Connection con=DBUtils.getConnection();
			PreparedStatement stmt=con.prepareStatement(SQLQueriesConstants.VACANT_COURSES);
			stmt.setString(1,courseid);
			ResultSet rs=stmt.executeQuery();
			List<Course> result=new ArrayList<Course>();
			if(rs.next()==false)
			{
				System.out.println("SORRY!! Coursenot available");
				return false;
			}
			else
			{
				PreparedStatement stmt1=con.prepareStatement(SQLQueriesConstants.REGISTER_FOR_COURSE);
				stmt1.setString(1,profid);
				stmt1.setString(2, courseid);
				int executed=stmt1.executeUpdate();
				if(executed==1)
					return true;
				else
					return false;
				
			}
			
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
		return false;
		
	}


}
