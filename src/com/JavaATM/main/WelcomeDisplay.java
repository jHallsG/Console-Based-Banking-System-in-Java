package com.JavaATM.main;

import java.util.InputMismatchException;
import org.springframework.stereotype.Component;

@Component
public class WelcomeDisplay extends ParentClass{
	
	public WelcomeDisplay(ManageDisplay manageDisplay, LoginDisplay loginDisplay, RegisterDisplay registerDisplay) {
		super(manageDisplay, loginDisplay, registerDisplay);
	}

	public void show() {
		boolean landingPageLoop = true;
		int retry = 0;
		
		System.out.print(""
				+ "+---------------------------------+\n"
				+ "| Welcome to XYZ Banking.         |\n"
				+ "| What do you want to do today?   |\n"
				+ "+----+----------------------------+\n"
				+ "| 1  |           Login            |\n"
				+ "| 2  |           Register         |\n"
				+ "| 3  |           Exit             |\n"
				+ "+----+----------------------------+\n"
				+ "\n>> ");
		
		while (landingPageLoop) {
			try {
				char options = scan.next().charAt(0);
				switch (options) {
				case '1':
					new ClearConsoleScreen();
					manageDisplay.pushDisplay(loginDisplay);
					landingPageLoop = false;
					break;
				case '2':
					new ClearConsoleScreen();
					manageDisplay.pushDisplay(registerDisplay);
					landingPageLoop = false;
					break;
				case '3':
					System.out.println("\nExiting application...");
					return;
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
