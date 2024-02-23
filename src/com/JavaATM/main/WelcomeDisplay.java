package com.JavaATM.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WelcomeDisplay implements ConsoleDisplays{
	
	private Scanner scan = new Scanner(System.in);
	@Autowired
	private LoginDisplay loginDisplay;
	@Autowired
	private RegisterDisplay registerDisplay;
	@Autowired
	private ManageDisplay manageDisplay;

	public void show() {
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
					manageDisplay.pushDisplay(loginDisplay);
					landingPageLoop = false;
					break;
				case 2:
					manageDisplay.pushDisplay(registerDisplay);
					landingPageLoop = false;
					break;
				case 3:
					System.out.println("\nExiting application...");
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
}
