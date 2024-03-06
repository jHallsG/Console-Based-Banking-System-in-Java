package com.JavaATM.main;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class EditDisplay implements ConsoleDisplays{
	
	private Scanner scan = new Scanner(System.in);
	@Autowired
	ChangePasswordDisplay changePasswordDisplay;
	@Autowired
	ChangeUsernameDisplay changeUsernameDisplay;
	@Autowired
	private ManageDisplay manageDisplay;
	
	@Override
	public void show() {
		boolean innerLoop = true;
		boolean editLoop = true;
		int retry = 0;
		
		System.out.print("What would you like to do?\n\n"
				+ ""
				+ "1.	Change username.\n"
				+ "2. 	Change password.\n"
				+ "3.	Back/Cancel\n"
				+ ">> ");

		while(editLoop) {
			char userChoice = scan.next().charAt(0);
			scan.nextLine();
			
			switch (userChoice) {
			case '1':
				new ClearConsoleScreen();
				manageDisplay.pushDisplay(changeUsernameDisplay);
				break;
				
			case '2':
				new ClearConsoleScreen();
				manageDisplay.pushDisplay(changePasswordDisplay);
				break;
				
			case '3':
				new ClearConsoleScreen();
				manageDisplay.popDisplay();
				break;
				
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
