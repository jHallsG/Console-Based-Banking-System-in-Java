package com.JavaATM.displays;

import org.springframework.stereotype.Component;

import com.JavaATM.main.ClearConsoleScreen;
import com.JavaATM.main.ParentClass;

@Component
public class WelcomeDisplay extends ParentClass{
	
	public WelcomeDisplay(ManageDisplay manageDisplay, LoginDisplay loginDisplay, RegisterDisplay registerDisplay) {
		super(manageDisplay, loginDisplay, registerDisplay);
	}

	public void show() {
		int retry = 0;
		
		System.out.print(""
				+ "+---------------------------------+\n"
				+ "| Welcome to XYZ Banking.         |\n"
				+ "| What do you want to do today?   |\n"
				+ "+----+----------------------------+\n"
				+ "| 1  |           Login            |\n"
				+ "| 2  |           Enroll Account   |\n"
				+ "| 3  |           Exit             |\n"
				+ "+----+----------------------------+\n"
				+ "\n>> ");
		
		while (true) {
			char options = scan.next().charAt(0);
			switch (options) {
				case '1':
					ClearConsoleScreen.clearScreen();
					manageDisplay.pushDisplay(loginDisplay);
					return;
				case '2':
					ClearConsoleScreen.clearScreen();
					manageDisplay.pushDisplay(registerDisplay);
					return;
				case '3':
					System.out.println("\nExiting application...\n");
					return;
				default:
					retry++;
					if (retry == 3) {
						System.out.println("\nMultiple invalid inputs detected. Exiting application...");
		                return;
					}
					System.out.print("\nInvalid input. Please try again: \n>> ");
			}
		}
	}
}
