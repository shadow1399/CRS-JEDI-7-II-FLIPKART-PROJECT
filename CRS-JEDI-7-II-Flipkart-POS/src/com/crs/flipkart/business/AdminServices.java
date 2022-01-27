/**
 * 
 */
package com.crs.flipkart.business;

import java.util.ArrayList;
import java.util.List;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.dao.AdminDaoInterface;
import com.crs.flipkart.dao.AdminDaoOperations;

/**
 * @author YASH
 *
 */
public class AdminServices implements AdminInterface {

	@Override
	public void approveStudent(String rollNo) {
		// TODO Auto-generated method stub
		try {
			AdminDaoInterface adminDaoOperation=new AdminDaoOperations();
			adminDaoOperation.approveStudent(rollNo);
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		try {
			AdminDaoInterface adminDaoOperation=new AdminDaoOperations();
			adminDaoOperation.addCourse(course);
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void dropCourse(String courseId) {
		// TODO Auto-generated method stub
		try {
			AdminDaoInterface adminDaoOperation=new AdminDaoOperations();
			adminDaoOperation.dropCourse(courseId);
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		List<Course> courses=new ArrayList<Course>();
		try {
			AdminDaoInterface adminDaoOperation=new AdminDaoOperations();
			courses=adminDaoOperation.getCourses();
		}catch(Exception e) {
			System.out.println(e);
		}
		return courses;

	}

	@Override
	public void generateReportCard(int semester) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		List<Student> students=new ArrayList<Student>();
		try {
			AdminDaoInterface adminDaoOperation=new AdminDaoOperations();
			students=adminDaoOperation.getStudents();
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
			AdminDaoInterface adminDaoOperation=new AdminDaoOperations();
			professors=adminDaoOperation.getProfessors();
		}catch(Exception e) {
			System.out.println(e);
		}
		return professors;
	}

}
