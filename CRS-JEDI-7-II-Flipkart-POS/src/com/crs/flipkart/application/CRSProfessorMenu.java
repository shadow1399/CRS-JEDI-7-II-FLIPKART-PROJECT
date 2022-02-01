/**
 * 
 */
package com.crs.flipkart.application;

import java.util.List;
import java.util.Scanner;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.business.ProfessorService;

/**
 * @author Keertana
 *
 */
public class CRSProfessorMenu {
	/**
	 * displays professor menu
	 * @param userid
	 */
	public static void displayProfessorMenu(String userid)
	{
		while(true)
		{
			System.out.println("--------------------PROFESSOR MENU:-------------------");
			System.out.println("1.Display courses");
			System.out.println("2.Register for a course");
			System.out.println("3.View Registered Courses");
			System.out.println("4.View Students");
			System.out.println("5.Update Grades");
			System.out.println("6.Logout");
			Scanner sc=new Scanner(System.in);
			int choice=sc.nextInt();
			int logout=0;
			switch(choice)
			{
				case 1:
					displayCourses();
					break;
				case 2:
					registerCourse(userid);
					break;
				case 3:
					getRegisteredCourses(userid);
					break;
				case 4:
					getStudents(userid);
					break;
				case 5:
					addGrades(userid);
					break;
				case 6:
					logout=1;
					break;
				default:
					System.out.println("Invalid Option.");
					break;
			}	
			if(logout==1)
				break;
			
		}
		
	}
	/**
	 * Method to display all courses
	 */
	public static void displayCourses()
	{
		System.out.println("All the courses are:");
		ProfessorService professorService=new ProfessorService();
		List<Course> courses=professorService.getCourses();
		System.out.println("CourseId\tCourseName");
		courses.forEach(c->{System.out.println(c.getCourseId()+"\t\t"+c.getCourseName());});
	}
	/**
	 * Method for professor to registers for a course
	 * @param profId
	 */
	public static void registerCourse(String profId)
	{
		Scanner sc=new Scanner(System.in);
		ProfessorService professorService=new ProfessorService();
		System.out.println("Enter courseId to register:");
		String courseId=sc.next();
		boolean result=professorService.registerCourse(courseId,profId);
		if(result==true)
			System.out.println("registration Successful.");
		else
			System.out.println("Registration unsuccessful");
		
	}
	/**
	 * Method that displays all courses registered by professor
	 * @param userid
	 */
	public static void getRegisteredCourses(String userid)
	{
		System.out.println("Registered Courses are:");
		ProfessorService professorService=new ProfessorService();
		List<Course> courses=professorService.getRegisteredCourses(userid);
		System.out.println("CourseId\tCourseName");
		courses.forEach(c->{System.out.println(c.getCourseId()+"\t\t"+c.getCourseName());});
	}
	/**
	 * Method that displays all students registered in a course taught by the professor
	 * @param userid
	 */
	public static void getStudents(String userid)
	{
		Scanner sc=new Scanner(System.in);
		ProfessorService professorService=new ProfessorService();
		System.out.println("Enter courseId to display students in that course:");
		String courseid=sc.next();
		List<String> students=professorService.getStudents(courseid,userid);
		System.out.println("Students enrolled in the course "+courseid+" taken by "+userid+" are:");
		try {
		students.forEach(System.out::println);
		}
		catch(NullPointerException e)
		{
			System.out.println("Course is not taught by teacher");
		}
	}
	/**
	 * Method for professor to add grades to students
	 * @param userid
	 */
	public static void addGrades(String userid)
	{
		Scanner sc=new Scanner(System.in);
		ProfessorService professorService=new ProfessorService();
		System.out.println("Enter courseId to add grades to students in that course:");
		String courseid=sc.next();
		boolean result=professorService.addGrades(courseid,userid);
		if(result==true)
			System.out.println("Grades added Successful.");
		else
			System.out.println("Falied to add grades.");
	}

}
