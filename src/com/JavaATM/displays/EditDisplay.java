package com.JavaATM.displays;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.JavaATM.main.ClearConsoleScreen;
import com.JavaATM.main.ParentClass;
@Component
public class EditDisplay extends  ParentClass{
	
	public EditDisplay(ChangePasswordDisplay changePasswordDisplay, EditUserDetailsDisplay editUserDetailsDisplay, ManageDisplay manageDisplay, ViewDetailsDisplay viewDetailsDisplay) {
		super(changePasswordDisplay,editUserDetailsDisplay,manageDisplay,viewDetailsDisplay);
	}
	
	@Override
	public void show() {
		int retry = 0;
		
		System.out.print(""
				+ "+-----------------------------------------+\n"
				+ "|  What would you like to do?             |\n"
				+ "+-----+-----------------------------------+\n"
				+ "|  1  |  View details                     |\n" 
				+ "|  2  |  Edit Details                     |\n"
				+ "|  3  |  Change password                  |\n"
				+ "|  4  |  Back/Cancel                      |\n"
				+ "+-----+-----------------------------------+\n"
				+ ">> ");

		while(true) {
			char userChoice = scan.next().charAt(0);
			scan.nextLine();
			
			switch (userChoice) {
			case '1':
				ClearConsoleScreen.clearScreen();
				manageDisplay.pushDisplay(viewDetailsDisplay);
				return;
				
			case '2':
				ClearConsoleScreen.clearScreen();
				manageDisplay.pushDisplay(editUserDetailsDisplay);
				return;
				
			case '3':
				ClearConsoleScreen.clearScreen();
				manageDisplay.pushDisplay(changePasswordDisplay);
				return;
				
			case '4':
				ClearConsoleScreen.clearScreen();
				manageDisplay.popDisplay();
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
