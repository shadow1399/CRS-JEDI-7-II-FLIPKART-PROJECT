/**
 * 
 */
package com.crs.flipkart.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.constants.SQLQueryConstants;
import com.crs.flipkart.utils.DBUtils;

/**
 * @author YASH
 *
 */
public class AdminDaoOperations implements AdminDaoInterface {
	
	private PreparedStatement statement=null;
	
	Connection connection=DBUtils.getConnection();
	@Override
	public void dropCourse(String courseId) {
		// TODO Auto-generated method stub
		try {
//			System.out.println(courseId);
//			 String sql="delete from course where courseId=?";
			 
			 statement=connection.prepareStatement(SQLQueryConstants.DROP_COUSRE_QUERY);
			 statement.setString(1, courseId);
			 
			 
			 
			 statement.executeUpdate();
			 System.out.println("Course Dropped Successfully");
			 
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		List<Course> courses=new ArrayList<Course>();
		
		try {
//			 String sql="select * from course";
			 
			 statement=connection.prepareStatement(SQLQueryConstants.GET_COURSE_QUERY);
			 
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
			System.out.println(e);
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
			 
			 statement=connection.prepareStatement(SQLQueryConstants.GET_STUDENT_QUERY);
			 
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
			System.out.println(e);
		}
		
		return students;
	}

	@Override
	public List<Professor> getProfessors() {
		// TODO Auto-generated method stub
		List<Professor> professors=new ArrayList<Professor>();
		
		try {
//			 String sql="select * from professor";
			
			 
			 statement=connection.prepareStatement(SQLQueryConstants.GET_PROFESSOR_QUERY);
			 
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
			System.out.println(e);
		}
		
		return professors;
	}

	@Override
	public void approveStudent(String rollNo) {
		// TODO Auto-generated method stub
		try {
			
//			 String sql="update student set isVerified=1 where rollNo=?";
			 
			 statement=connection.prepareStatement(SQLQueryConstants.APPROVE_STUDENT_QUERY);
			 statement.setString(1, rollNo);
			 
			 
			 
			 statement.executeUpdate();
			 System.out.println("Student having "+rollNo+" Approved Successfully!!");
			 
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}

	@Override
	public void generateReportCard(int semester) {
		// TODO Auto-generated method stub
//		System.out.println("Generated Report Card for Semester "+semester);
		
		
	}

	
	
	public void addCourse(Course course) {
		try {
//			 String sql="insert into course values(?,?,?,?)";
				
			 
			 statement=connection.prepareStatement(SQLQueryConstants.ADD_COURSE_QUERY);
			 statement.setString(1, course.getCourseId());
			 statement.setString(2, course.getCourseName());
			 statement.setString(3, course.getProfessorId());
			 statement.setInt(4, course.getNumberOfStudents());
			 
			 statement.executeUpdate();
			 System.out.println("Course Added Successfully");
			 
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	
}
