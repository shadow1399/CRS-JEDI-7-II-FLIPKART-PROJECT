/**
 * 
 */
package com.crs.flipkart.application;
import java.util.*;
import java.util.Scanner;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.business.AdminInterface;
import com.crs.flipkart.business.AdminServices;

/**
 * @author YASH
 *
 */
public class AdminMenu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminInterface adminServices=new AdminServices();
		Scanner sc=new Scanner(System.in);
//		Course course=new Course();
//		System.out.println("Enter Roll No: ");
//		String rollNo=sc.nextLine();
//		course.setCourseId(sc.nextLine());
		
		try {
			List<Professor> courses=new ArrayList<Professor>();
			
//			adminServices.approveStudent(rollNo);
			courses=adminServices.getProfessors();
			for(Professor course:courses) {
				System.out.println(course.getProfessorId()+" "+course.getDepartment());
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}

	

}
