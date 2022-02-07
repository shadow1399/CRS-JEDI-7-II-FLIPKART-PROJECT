/**
 * 
 */
package com.crs.flipkart.application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.EnrolledStudent;
import com.crs.flipkart.business.ProfessorInterface;
import com.crs.flipkart.business.ProfessorOperation;
import com.crs.flipkart.exception.GradeNotAddedException;
import com.crs.flipkart.exception.StudentNotFoundForVerificationException;
import com.crs.flipkart.exception.StudentNotRegisteredException;
import com.crs.flipkart.validator.ProfessorValidator;

/**
 * Class that display Professor Client Menu
 *
 */
public class ProfessorMenuCRS {

	ProfessorInterface professorInterface=ProfessorOperation.getInstance();

	/**
	 * Method to create Professor menu
	 * @param professorId: professor id obtained after logging into the system
	 * returns displays all the options for the professor, and provides navigation
	 */
	public void professorMenu(String professorId)
	{
		Scanner sc=new Scanner(System.in);
		
		int in=1;
		while(in!=4)
		{
			System.out.println("\n\n----------------------------------------------------------------------------------------");
			System.out.println("----------------------------------------PROFESSOR MENU---------------------------------------");
			System.out.println("---------------------------------------------------------------------------------------------\n");

			System.out.println("1. View Courses");
			System.out.println("2. View Enrolled Students");
			System.out.println("3. Add grade");
			System.out.println("4. Logout");

			System.out.println("------------------------------------------");
			System.out.print("ENTER YOUR CHOICE--->:\t");
			System.out.println();

			in=sc.nextInt();
			//input user
			
			switch(in)
			{
				case 1:
					//view all the courses taught by the professor
					getCourses(professorId);
					break;
				case 2:
					//view all the enrolled students for the course
					viewStudents(professorId);
					break;
					
				case 3:
					//add grade for a student
					addGrade(professorId);
					break;
				case 4:
					//logout from the system
					return;
				default:
					System.out.println("Select right option.");
			}
			
		}
		sc.close();
		
		
	}

	private void addGrade(String professorId){
		Scanner sc=new Scanner(System.in);
		
		String studentId;
		String courseId;
		String grade;
		int semester;
		try
		{
			System.out.println("\n\n----------------------------------------------------------------------------------------");
			System.out.println("----------------------------------------CURRENT ENROLLED STUDENTS------------------------------");
			System.out.println("---------------------------------------------------------------------------------------------\n");

			List<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
			enrolledStudents=professorInterface.viewStudents(professorId);
			for(EnrolledStudent obj: enrolledStudents)
			{
				System.out.println(String.format("%20s %20s %20s %20s",obj.getCourseId(), obj.getCourseName(),obj.getStudentId(),obj.getSemester()));
			}
			List<Course> coursesEnrolled=new ArrayList<Course>();
			coursesEnrolled	=professorInterface.getCourses(professorId);
			System.out.println("---------------------------------------------ADD GRADE----------------------------------------\n");
			System.out.println("Enter student Id");
			studentId=sc.nextLine();
			System.out.println("Enter course Id");
			courseId=sc.nextLine();
			System.out.println("Enter grade");
			grade=sc.nextLine();
			System.out.println("Enter semester");
			semester=sc.nextInt();
			sc.nextLine();
			if(ProfessorValidator.isValidEntry(enrolledStudents, studentId,courseId,semester))
			{
				try {
					professorInterface.addGrade(studentId, courseId, semester,grade);
				System.out.println("Grade added successfully for "+studentId);
				}
				catch(Exception e)
				{
					System.out.println("Something went wrong "+e.getMessage());
				}
			}
			else
			{
				System.out.println("Invalid data entered, try again!");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			
		}

		System.out.println("---------------------------------------------------------------------------------------------\n");

	}

	private void viewStudents(String professorId) {

		System.out.println("\n\n----------------------------------------------------------------------------------------");
		System.out.println("----------------------------------------CURRENT ENROLLED STUDENTS------------------------------");
		System.out.println("---------------------------------------------------------------------------------------------\n");

		System.out.println(String.format("%20s %20s %20s %20s","COURSE ID","COURSE NAME","STUDENTS ID","SEMESTER" ));
		System.out.println("---------------------------------------------------------------------------------------------\n");

		try
		{
			List<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
			enrolledStudents=professorInterface.viewStudents(professorId);
			for(EnrolledStudent obj: enrolledStudents)
			{
				System.out.println(String.format("%20s %20s %20s %20s",obj.getCourseId(), obj.getCourseName(),obj.getStudentId(),obj.getSemester()));
			}
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage()+"Something went wrong, please try again later!");
		}

		System.out.println("---------------------------------------------------------------------------------------------\n");

	}

	private void getCourses(String professorId) {

		try
		{
			System.out.println("\n\n----------------------------------------------------------------------------------------");
			System.out.println("----------------------------------------CURRENT COURSES------------------------------");
			System.out.println("---------------------------------------------------------------------------------------------\n");

			List<Course> coursesEnrolled=professorInterface.getCourses(professorId);
			System.out.println(String.format("%20s %20s %20s","COURSE ID","COURSE NAME","STUDENTS REGISTERED" ));
			for(Course obj: coursesEnrolled)
			{
				System.out.println(String.format("%20s %20s %20s",obj.getCourseId(), obj.getCourseName(),10- obj.getSeats()));
			}		
		}
		catch(Exception ex)
		{
			System.out.println("Something went wrong!"+ex.getMessage());
		}
		System.out.println("---------------------------------------------------------------------------------------------\n");

	}
}
