package com.JavaATM.displays;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.JavaATM.main.ClearConsoleScreen;
import com.JavaATM.main.ParentClass;
@Component
public class EditDisplay extends  ParentClass{
	
	@Autowired
	ChangePasswordDisplay changePasswordDisplay;
	@Autowired
	EditUserDetailsDisplay editUserDetailsDisplay;
	@Autowired
	private ManageDisplay manageDisplay;
	
	@Override
	public void show() {
		int retry = 0;
		
		System.out.print(""
				+ "+-----------------------------------------+\n"
				+ "|  What would you like to do?             |\n"
				+ "+-----+-----------------------------------+\n"
				+ "|  1  |  Edit details                     |\n"
				+ "|  2  |  Change password                  |\n"
				+ "|  3  |  Back/Cancel                      |\n"
				+ "+-----+-----------------------------------+\n"
				+ ">> ");

		while(true) {
			char userChoice = scan.next().charAt(0);
			scan.nextLine();
			
			switch (userChoice) {
			case '1':
				new ClearConsoleScreen();
				manageDisplay.pushDisplay(editUserDetailsDisplay);
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
