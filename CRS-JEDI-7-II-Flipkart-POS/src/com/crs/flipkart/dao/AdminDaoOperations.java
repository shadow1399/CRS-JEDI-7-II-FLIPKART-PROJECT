/**
 * 
 */
package com.crs.flipkart.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.constants.SQLQueriesConstants;
import com.crs.flipkart.exceptions.AddCourseException;
import com.crs.flipkart.exceptions.CourseNotFoundException;
import com.crs.flipkart.utils.DBUtils;

/**
 * @author SATYANSH
 *
 */
public class AdminDaoOperations implements AdminDaoInterface {
	
	



	private PreparedStatement statement=null;
	
	Connection connection=DBUtils.getConnection();
	private static Logger logger = Logger.getLogger(AdminDaoOperations.class);
	
	@Override
	public boolean addProfessor(Professor professor) {
		// TODO Auto-generated method stub
		
		try {

			statement=connection.prepareStatement(SQLQueriesConstants.ADD_PROFESSOR_QUERY);
			statement.setString(1, professor.getProfessorId());
			statement.setString(2, professor.getDepartment());
			
			statement.executeUpdate();
			statement=connection.prepareStatement(SQLQueriesConstants.ADD_USER_QUERY);
			statement.setString(1,professor.getProfessorId());
			statement.setString(2, professor.getName());
			statement.setString(3, professor.getPassword());
			statement.setString(4, professor.getType());
			
			statement.setString(5, professor.getPhoneNumber());
			statement.setString(6, professor.getEmail());
			statement.executeUpdate();
			
			logger.info("Professor Added Successfully!!!");
			return true;
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return false;
	}
	
	@Override
	public boolean dropCourse(String courseId) throws CourseNotFoundException{
		// TODO Auto-generated method stub
		try {
//			System.out.println(courseId);
//			 String sql="delete from course where courseId=?";
			 
			 statement=connection.prepareStatement(SQLQueriesConstants.DROP_COURSE_ADMIN_QUERY);
			 statement.setString(1, courseId);
			 
			 
			 
			 int rowAffected=statement.executeUpdate();
			 if(rowAffected==0) {
				 throw new CourseNotFoundException(courseId);
			 }
			 logger.info("Course Dropped Successfully!!!");
			 return true;
		}catch(Exception e) {
			logger.error(e.getMessage());		
		}
		return false;
	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		List<Course> courses=new ArrayList<Course>();
		
		try {
//			 String sql="select * from course";
			 
			 statement=connection.prepareStatement(SQLQueriesConstants.GET_COURSE_QUERY);
			 
			 ResultSet listCourses=statement.executeQuery();
			 
			 while(listCourses.next())
			 {
				 Course course=new Course();
				 course.setCourseId(listCourses.getString("courseId"));
				 course.setCourseName(listCourses.getString("courseName"));
				 course.setProfessorId(listCourses.getString("professorId"));
				 course.setNumberOfStudents(listCourses.getInt("numberOfStudents"));
				 courses.add(course);
				 
				
			 }
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return courses;
	}

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
//		System.out.println("HE!!");
		List<Student> students=new ArrayList<Student>();
		
		try {
//			 String sql="select * from student";
			 
			 statement=connection.prepareStatement(SQLQueriesConstants.GET_STUDENT_QUERY);
			 
			 ResultSet listStudents=statement.executeQuery();
			 
			 while(listStudents.next())
			 {
				 Student student=new Student();
				 student.setRollNo(listStudents.getString("rollNo"));
				 student.setSemester(listStudents.getInt("semester"));
				 student.setBranch(listStudents.getString("branch"));
				 student.setIsVerified(listStudents.getInt("isVerified"));
				 students.add(student);
				 
				
			 }
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return students;
	}

	@Override
	public List<Professor> getProfessors() {
		// TODO Auto-generated method stub
		List<Professor> professors=new ArrayList<Professor>();
		
		try {
//			 String sql="select * from professor";
			
			 
			 statement=connection.prepareStatement(SQLQueriesConstants.GET_PROFESSOR_QUERY);
			 
			 ResultSet listProfessors=statement.executeQuery();
			 
			 while(listProfessors.next())
			 {
				 Professor professor=new Professor();
				 professor.setProfessorId(listProfessors.getString("professorId"));
				 professor.setDepartment(listProfessors.getString("department"));
				 professor.setName(listProfessors.getString("name"));
				 
				 professors.add(professor);
				 
				
			 }
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return professors;
	}

	@Override
	public boolean approveStudent(String rollNo) {
		// TODO Auto-generated method stub
		try {
			
//			 String sql="update student set isVerified=1 where rollNo=?";
			 
			 statement=connection.prepareStatement(SQLQueriesConstants.APPROVE_STUDENT_QUERY);
			 statement.setString(1, rollNo);
			 
			 
			 
			 statement.executeUpdate();
			 logger.info("Student having rollNo "+rollNo+" Approved Successfully!!");
			 return true;
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return false;
		
	}

	@Override
	public boolean generateReportCard() {
		// TODO Auto-generated method stub
//		System.out.println("Generated Report Card for Semester "+semester);
		try {
			statement=connection.prepareStatement(SQLQueriesConstants.GENERATE_REPORT_CARD);
			statement.executeUpdate();
			logger.info("Grade Card Generated Successfully!!!");
			return true;
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	
	
	public boolean addCourse(Course course) throws AddCourseException{
		try {
//			 String sql="insert into course values(?,?,?,?)";
				
			 statement=connection.prepareStatement(SQLQueriesConstants.CHECK_COURSE_QUERY);
			 statement.setString(1, course.getCourseId());
			 ResultSet rs=statement.executeQuery();
			 if(rs.next()) {
				 throw new AddCourseException(course.getCourseId());
			 }
			 statement=connection.prepareStatement(SQLQueriesConstants.ADD_COURSE_QUERY);
			 statement.setString(1, course.getCourseId());
			 statement.setString(2, course.getCourseName());
			 statement.setString(3, course.getProfessorId());
			 statement.setInt(4, course.getNumberOfStudents());
			 
			 statement.executeUpdate();
			 logger.info("Course Added Successfully!!!");
			 return true;
			 
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}
	
	
}
