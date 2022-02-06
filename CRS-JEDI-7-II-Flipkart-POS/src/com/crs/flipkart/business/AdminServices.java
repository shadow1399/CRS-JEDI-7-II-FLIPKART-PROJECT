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
 * @author SATYANSH
 *
 */
public class AdminServices implements AdminInterface {
	
	
	AdminDaoInterface adminDaoOperation=new AdminDaoOperations();
	@Override
	public boolean approveStudent(String rollNo) {
		// TODO Auto-generated method stub
		try {
			
			adminDaoOperation.approveStudent(rollNo);
			return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
		
	}

	@Override
	public boolean addProfessor(Professor professor) {
		// TODO Auto-generated method stub
		try {
//			AdminDaoInterface adminDaoOperation=new AdminDaoOperations();
			adminDaoOperation.addProfessor(professor);
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean addCourse(Course course) {
		// TODO Auto-generated method stub
		try {
//			AdminDaoInterface adminDaoOperation=new AdminDaoOperations();
			adminDaoOperation.addCourse(course);
			return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
		
	}

	@Override
	public boolean dropCourse(String courseId) {
		// TODO Auto-generated method stub
		try {
//			AdminDaoInterface adminDaoOperation=new AdminDaoOperations();
			adminDaoOperation.dropCourse(courseId);
			return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		List<Course> courses=new ArrayList<Course>();
		try {
//			AdminDaoInterface adminDaoOperation=new AdminDaoOperations();
			courses=adminDaoOperation.getCourses();
		}catch(Exception e) {
			System.out.println(e);
		}
		return courses;

	}

	@Override
	public boolean generateReportCard() {
		// TODO Auto-generated method stub
		try {
			adminDaoOperation.generateReportCard();
			return true;
		}catch(Exception e){
			System.out.println(e);
		}
		
		return false;
	}

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		List<Student> students=new ArrayList<Student>();
		try {
//			AdminDaoInterface adminDaoOperation=new AdminDaoOperations();
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
//			AdminDaoInterface adminDaoOperation=new AdminDaoOperations();
			professors=adminDaoOperation.getProfessors();
		}catch(Exception e) {
			System.out.println(e);
		}
		return professors;
	}

}
