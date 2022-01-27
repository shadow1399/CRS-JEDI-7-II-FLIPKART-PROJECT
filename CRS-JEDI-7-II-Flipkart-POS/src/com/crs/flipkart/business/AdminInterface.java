package com.crs.flipkart.business;

import java.util.List;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;

public interface AdminInterface {
	public void approveStudent(String rollNo);
	public void addCourse(Course course);
	public void dropCourse(String courseId);
	public List<Course> getCourses();
	public void generateReportCard(int semester);
	public List<Student>getStudents();
	public List<Professor> getProfessors();
}
