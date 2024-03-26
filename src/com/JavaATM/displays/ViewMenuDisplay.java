package com.JavaATM.displays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.JavaATM.main.ClearConsoleScreen;
import com.JavaATM.main.ParentClass;

@Component
public class ViewMenuDisplay extends ParentClass{
	
	@Autowired
	ManageDisplay manageDisplay;
	
	@Autowired
	EditUserDetailsDisplay editUserDetailsDisplay;
	
	@Lazy
	@Autowired
	LoginDisplay loginDisplay;
	
	@Autowired
	ViewDetailsDisplay viewDetailsDisplay;

	@Override
	public void show() {
		int retry = 0;
		
		
		System.out.print(""
				+ "+----------------------------------------+\n"
				+ "| What would you like to do?             |\n"
				+ "+---------+------------------------------+\n"
				+ "|    1    |   Edit User Details          |\n"
				+ "|    2    |   View Details               |\n"
				+ "|    3    |   Back/ Cancel               |\n"
				+ "+---------+------------------------------+\n"
				+ ">> ");
		
		while(true) {
			char options = scan.next().charAt(0);
			switch (options) {
			case '1':
				ClearConsoleScreen.clearScreen();
				manageDisplay.pushDisplay(editUserDetailsDisplay);
				break;
			case '2':
				ClearConsoleScreen.clearScreen();
				manageDisplay.pushDisplay(viewDetailsDisplay);
				manageDisplay.popDisplay();
				break;
			case '3':
				manageDisplay.popDisplay();
				break;
			default:
				retry++;
				if (retry == 3) {
					System.out.println("\nMultiple invalid inputs detected. Exiting application...");
					return;
				} else {
					System.out.println("\nInvalid input. Please try again: \n");
				}
			}
		}
		
	}
	
	

}
