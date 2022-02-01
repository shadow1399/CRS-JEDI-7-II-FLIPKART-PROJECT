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
public class CRSAdminMenu {

	/**
	 * @param args
	 */
	Scanner scanner = new Scanner(System.in);
	AdminInterface adminInterface=new AdminServices();
	public void createMenu(){		
		
		int choice=0;
		while(choice!=8) {
			System.out.println("\n\n----------------------------------------------------------------------------------------");
			System.out.println("---------------------------------------------ADMIN MENU---------------------------------------");
			System.out.println("---------------------------------------------------------------------------------------------\n");

			System.out.println("1. Add Course to catalog");
			System.out.println("2. Drop Course from catalog");
			System.out.println("3. Approve Students");
			System.out.println("4. View All Students");
			System.out.println("5. Generate Report Card");
			System.out.println("6. View All Professors");
			System.out.println("7. View All Courses");
			System.out.println("8. Exit Admin Menu");

			System.out.println("------------------------------------------");
			System.out.print("ENTER YOUR CHOICE--->:\t");


			choice=scanner.nextInt();
			scanner.nextLine();
			switch(choice) {
				case 1:
					addCourse();
					break;
						
				case 2:
					dropCourse();
					break;
						
				case 3:
					approveStudent();
					break;
						
				case 4:
					viewAllStudents();
					break;
				
				case 5:
					generateReport();
					break;
					
				case 6:
					viewAllProfessors();
					break;
				case 7:
					viewAllCourses();
					break;
					
				case 8:
					return;
					
				default:
					System.out.println("Invalid Choice");
			}
		}
	}
	
	/**
	 * Method to add course to DB
	 */
	private void addCourse()
	{
		System.out.println("\n\n----------------------------------------------------------------------------------------");
		System.out.println("---------------------------------------ADD COURSE TO CATALOG--------------------------------");
		System.out.println("---------------------------------------------------------------------------------------------\n");

		System.out.println("Enter Course Code:");
		String courseCode = scanner.nextLine();
		
		System.out.println("Enter Course Name:");
		String courseName = scanner.nextLine();
		
//		System.out.println("Enter InstructorId:");
//		String professorId = scanner.nextLine();
//				
		Course course = new Course();
		course.setCourseId(courseCode);
		course.setCourseName(courseName);
		
		try {
			
			adminInterface.addCourse(course);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("---------------------------------------------------------------------------------------------\n");

	}
	/**
	 * Method to delete course from DB
	 */
	private void dropCourse()
	{
		System.out.println("\n\n----------------------------------------------------------------------------------------");
		System.out.println("-----------------------------------DELETE COURSE FROM CATALOG--------------------------------");
		System.out.println("---------------------------------------------------------------------------------------------\n");

		System.out.println("Enter Course Code:");
		String courseCode = scanner.next();
		
		try {
			adminInterface.dropCourse(courseCode);
		} catch (Exception e) {
//			logger.error(e.getMessage());
			System.out.println(e);
		}
		System.out.println("---------------------------------------------------------------------------------------------\n");

	}
	
	/**
	 * Method to approve studentId
	 */
	private boolean approveStudent()
	{
		System.out.println("\n\n----------------------------------------------------------------------------------------");
		System.out.println("---------------------------------------APPROVE STUDENT--------------------------------------");
		System.out.println("---------------------------------------------------------------------------------------------\n");

		System.out.println("Enter Student's RollNo:");
		String studentUserIdApproval = scanner.nextLine();
		
		try {
			adminInterface.approveStudent(studentUserIdApproval);
			return true;
	
		} catch (Exception e) {
//			logger.error(e.getMessage());
			System.out.println(e);
		}
		System.out.println("---------------------------------------------------------------------------------------------\n");

		return false;
	}
	private void generateReport() {
		System.out.println("Report Generated");
	}
	
	private void viewAllStudents() {
		try {
			System.out.println("\n\n----------------------------------------------------------------------------------------");
			System.out.println("----------------------------------------CURRENT STUDENTS------------------------------");
			System.out.println("---------------------------------------------------------------------------------------------\n");
			
			
			List<Student> students=adminInterface.getStudents();
			System.out.println(String.format("%20s %20s %20s","ROLL NO","SEMESTER","BRANCH" ));
			for(Student obj: students)
			{
				System.out.println(String.format("%20s %20s %20s",obj.getRollNo(), obj.getSemester(),obj.getBranch()));
			}
			
	
		} catch (Exception e) {
//			logger.error(e.getMessage());
			System.out.println(e);
		}
	}
	
	private void viewAllProfessors() {
		try {
			System.out.println("\n\n----------------------------------------------------------------------------------------");
			System.out.println("----------------------------------------CURRENT PROFESSORS------------------------------");
			System.out.println("---------------------------------------------------------------------------------------------\n");
			
			
			List<Professor> professors=adminInterface.getProfessors();
			System.out.println(String.format("%20s %20s %20s","PROFESSOR ID","PROFESSOR NAME","DEPARTMENT" ));
			for(Professor obj: professors)
			{
				System.out.println(String.format("%20s %20s %20s",obj.getProfessorId(),obj.getName(),obj.getDepartment()));
			}
			
	
		} catch (Exception e) {
//			logger.error(e.getMessage());
			System.out.println(e);
		}
	}
	
	private void viewAllCourses() {
		
		try {
			System.out.println("\n\n----------------------------------------------------------------------------------------");
			System.out.println("----------------------------------------CURRENT AVAILABLE COURSES------------------------------");
			System.out.println("---------------------------------------------------------------------------------------------\n");
			
			
			List<Course> availableCourses=adminInterface.getCourses();
			System.out.println(String.format("%20s %20s %20s","COURSE ID","COURSE NAME","STUDENTS REGISTERED" ));
			for(Course obj: availableCourses)
			{
				System.out.println(String.format("%20s %20s %20s",obj.getCourseId(), obj.getCourseName(),obj.getNumberOfStudents()));
			}
			
	
		} catch (Exception e) {
//			logger.error(e.getMessage());
			System.out.println(e);
		}
		
	}
}
