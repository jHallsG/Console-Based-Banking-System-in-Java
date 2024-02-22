package com.JavaATM.main;

import java.util.Scanner;

public class LandingPage {
	
	Scanner scan = new Scanner(System.in);
	
	
	public void startLandingPage() {
		System.out.println("\n\nWelcome to XYZ Banking. What do you want to do today?\n\n"
				+ "1.		Login\r\n"
				+ "2. 		Register\r\n"
				+ "3. 		Exit\r\n"
				+ "\n"
				+ ">> ");
	}
	
	public void landingPageOptions() {
		int retry = 0;
		char options = scan.next().charAt(0);
		
		while (true) {
			switch (options) {
			case 1:
				login();
				break;
			case 2:
				System.out.println("to be continued to register");
			case 3:
				System.out.println("Exiting application...");
				System.exit(0);
			default:
				retry++;
				if (retry == 3) {
	                System.out.println("Multiple invalid inputs detected. Exiting application...");
	                System.exit(0);
	            }
				System.out.println("Invalid input. Please try again");	
			}
		}
	}
	
	public void login() {
		System.out.println("Please enter your email address: ");
		String username = scan.nextLine();
		
		System.out.println("Please enter your password: ");
		String pass = scan.nextLine();
		scan.close();
	}
}
