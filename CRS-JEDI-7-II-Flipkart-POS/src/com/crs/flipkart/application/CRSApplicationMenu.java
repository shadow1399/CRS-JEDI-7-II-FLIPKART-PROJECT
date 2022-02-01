	/**
 * 
 */
package com.crs.flipkart.application;

import java.util.*;

import com.crs.flipkart.business.UserInterface;
import com.crs.flipkart.business.UserServices;

/**
 * @author YASH
 *
 */
public class CRSApplicationMenu {

	/**
	 * @param args
	 */
	
	static boolean isLoggedIn=false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("================================================================================");
		System.out.println("********************WELCOME to Course Registration System!!!********************");
		System.out.println("================================================================================");

		printMenu();
		int Input=sc.nextInt();
		
		while(Input!=3)
		{
			switch(Input)
			{	
				case 1:
					registerUser();
					break;
				case 2:
					loginUser();
					break;
				case 3:
					break;
				default:
					System.out.println("Enter a valid input");
			}
			printMenu();
			Input = sc.nextInt();
		}
		System.out.println("*******************************Thank you for using our Application.*********************************");
		sc.close();
	}
	public static void printMenu() {
		System.out.println("\n\n----------------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------MAIN MENU-----------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------\n");

		System.out.println("1. Signup");
		System.out.println("2. Login ");
		System.out.println("3. Exit");
		System.out.println("------------------------------------------");
		System.out.print("ENTER YOUR CHOICE----->:\t");

	}
	
	
	/*
	 *Student signup function 
	 * 
	 * */
	private static void registerUser() {
		Scanner sc = new Scanner(System.in);

		String userId, name, password,branch, mobileNumber, rollNumber;

		try {
			// input all the student details
			System.out.println("\n\n----------------------------------------------------------------------------------------");
			System.out.println("----------------------------------------------STUDENT SIGN UP------------------------------");
			System.out.println("-----------------------------------------------------------------------------------------\n");

			System.out.println("Name:");
			name = sc.nextLine();
			System.out.println("Roll Number:");
			rollNumber = sc.nextLine();
			System.out.println("Email:");
			userId = sc.nextLine();
			System.out.println("Password:");
			password = sc.nextLine();
			System.out.println("Mobile Number:");
			mobileNumber = sc.nextLine();
			System.out.println("Branch:");
			branch = sc.nextLine();
			

//			StudentOperation studentOperation = new StudentOperation();
//			studentOperation.registerStudent(name, mobileNumber, address, userId, password, String.valueOf(STUDENT),
//					rollNumber, branch, false);
			System.out.println("-----------------------------------------------------------------------------------------\n");

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	/*
	 *Student Login after signup 
	 * 
	 * */
	private static void loginUser() {
		Scanner sc = new Scanner(System.in);

		String email, password;
		try {
			System.out.println("\n\n----------------------------------------------------------------------------------------");
			System.out.println("---------------------------------------------LOGIN----------------------------------------");
			System.out.println("-----------------------------------------------------------------------------------------\n");

			System.out.println("Email:");
			email = sc.next();
			System.out.println("Password:");
			password = sc.next();
			UserInterface userInterface = new UserServices();
			boolean isLoggedIn = userInterface.verifyCredentials(email, password);
			// 2 cases
			// true->role->student->approved
			if (isLoggedIn) {
				String type = userInterface.getUserType(email);
				String userType=type.toUpperCase();
//				RoleConstants userRole = RoleConstants.stringToName(role);
				switch (userType) {
					case "ADMIN":
						System.out.println(" Login Successful!");
						CRSAdminMenu adminMenu = new CRSAdminMenu();
						adminMenu.createMenu();
						break;
	//				case "PROFESSOR":
	//					System.out.println(" Login Successful!");
	//					ProfessorMenuCRS professorMenu = new ProfessorMenuCRS();
	//					professorMenu.professorMenu(userId);
	//
	//					break;
	//				case "STUDENT":
	//					StudentInterface studentInterface = new StudentOperation();
	//					int isApproved = studentInterface.checkIsVerified(userId);
	//					if (isApproved == 1) {
	//						System.out.println( " Login Successful!");
	//						StudentMenuCRS studentMenu = new StudentMenuCRS();
	//						studentMenu.create_menu(userId);
	//
	//					} else {
	//						System.out.println("You have not been approved by the admin!");
	//						loggedin = false;
	//					}
	//					break;
				}

			} else {
				System.out.println("Invalid Credentials!");
			}
			System.out.println("-----------------------------------------------------------------------------------------\n");

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
