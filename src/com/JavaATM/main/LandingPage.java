package com.JavaATM.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LandingPage {
	
	private Scanner scan = new Scanner(System.in);
	
	public void startLandingPage() {
		boolean landingPageLoop = true;
		int retry = 0;
		int loginCredsRetry = 0;
		
		System.out.print("\n\nWelcome to XYZ Banking.\n"
				+ "What do you want to do today?\n"
				+ "1.		Login\r\n"
				+ "2. 		Register\r\n"
				+ "3. 		Exit\r\n"
				+ ">> ");
		
		while (landingPageLoop) {
			try {
				int options = scan.nextInt();
				switch (options) {
				case 1:
					if (login() == true) {
						System.out.println("\nContinue to user page");
					} else {
						loginCredsRetry++;
						if (loginCredsRetry == 3) {
							System.out.println("Multiple invalid credentials input.Exiting application...");
						}
						System.out.println("\nIncorrect email/password. Please try again.\n>> ");
					}
					
					landingPageLoop = false;
					break;
				case 2:
					System.out.println("to be continued to register");
				case 3:
					System.out.println("Exiting application...");
					System.exit(0);
				default:
					retry++;
					if (retry == 3) {
						System.out.println("\nMultiple invalid inputs detected. Exiting application...");
		                System.exit(0);
					}
					System.out.print("\nInvalid input. Please try again: \n>> ");
				}
			} catch (InputMismatchException e) {
				retry++;
				if (retry == 3) {
					System.out.println("\nMultiple invalid inputs detected. Exiting application...");
	                System.exit(0);
				}
				System.out.print("\nInvalid input. Please try again. \n>> ");	
				scan.next(); //need to clear the input or the program will run in an infinite loop.
			}
		}
	}
	
	public boolean login() {
		System.out.print("\nPlease enter your email address: \n>> ");
		scan.nextLine();	//dont't delete. somehow scanner detects the newline \n as an input
		
		String username = scan.nextLine();
		
		System.out.print("\nPlease enter your password: \n>> ");
		String pass = scan.nextLine();
		
		// check credentials on the database. it should return a true or false
		if (username.equals("wrong")) {
			return false;
		} else {
			return true;
		}
	}
}
