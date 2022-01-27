/**
 * 
 */
package com.crs.flipkart.dao;

import java.util.List;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;

/**
 * @author YASH
 *
 */
public interface AdminDaoInterface {
	public void addCourse(Course course);
	
	public void dropCourse(String courseId);
	
	public List<Course> getCourses();
	
	public List<Student> getStudents();
	
	public List<Professor> getProfessors();
	
	public void approveStudent(String rollNo);
	
	public void generateReportCard(int semester);
	
}
