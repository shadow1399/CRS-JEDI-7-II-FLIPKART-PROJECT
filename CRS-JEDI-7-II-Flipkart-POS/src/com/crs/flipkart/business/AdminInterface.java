package com.crs.flipkart.business;

import java.util.List;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;

public interface AdminInterface {
	public boolean approveStudent(String rollNo);
	public boolean addCourse(Course course);
	public boolean dropCourse(String courseId);
	public List<Course> getCourses();
	public boolean generateReportCard();
	public List<Student>getStudents();
	public List<Professor> getProfessors();
	
	public boolean addProfessor(Professor professor);
}
