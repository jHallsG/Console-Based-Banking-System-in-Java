package com.JavaATM.main;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class UserDisplay implements ConsoleDisplays{

	private Scanner scan = new Scanner(System.in);
	
	@Override
	public void show() {
		boolean userPageLoop = true;
		int retry = 0;
		int userRetry = 0;
		
		System.out.print("Hello @USER, what would you like to do today? \n"
				+ "1.	Edit User Details\n"
				+ "2.	Check Balance\n"
				+ "3. 	Deposit\n"
				+ "4.	Money Transfer\n"
				+ "5.	Logout\n"
				+ ">> ");
		
		while(userPageLoop) {
			char options = scan.next().charAt(0);
			switch (options) {
			case 1:
				System.out.println("Show user info");
				userPageLoop = false;
				break;
			case 2:
				System.out.println("Your balance is: ");
				break;
			case 3:
				System.out.println("Deposit deposit");
				break;
			case 4:
				System.out.println("Enter recipient number");
				break;
			case 5:
				System.out.println("\nExiting application... ");
				System.exit(0);
			default:
				retry++;
				if (retry == 3) {
					System.out.println("\nMultiple invalid inputs detected. Exiting application...");
	                System.exit(0);
				} else {
					System.out.println("\nInvalid input. Please try again: \n");
				}
			}
		}
	}
	
}
