package com.JavaATM.main;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDisplay extends ParentClass{
	
	public UserDisplay(ManageDisplay manageDisplay, EditDisplay editDisplay, BalanceDisplay balanceDisplay, DepositDisplay depositDisplay) {
		super(manageDisplay, editDisplay,balanceDisplay, depositDisplay);
	}

	@Override
	public void show() {
		boolean userPageLoop = true;
		int retry = 0;
		int userRetry = 0;
		
		System.out.print(""
				+ "+-----------------------------------------------+\n"
				+ "| Hello @USER, what would you like to do today? |\n"
				+ "+-----------------------------------------------+\n"
				+ "|  1  |   Edit User Details                     |\n"
				+ "|  2  |   Check Balance                         |\n"
				+ "|  3  |   Deposit                               |\n"
				+ "|  4  |   Money Transfer                        |\n"
				+ "|  5  |   View Transactions                     |\n"
				+ "|  6  |   Logout                                |\n"
				+ "+-----------------------------------------------+\n"
				+ ">> ");
		
		while(userPageLoop) {
			char options = scan.next().charAt(0);
			switch (options) {
			case '1':
				new ClearConsoleScreen();
				manageDisplay.pushDisplay(editDisplay);
				userPageLoop = false;
				break;
			case '2':
				new ClearConsoleScreen();
				manageDisplay.pushDisplay(balanceDisplay);
				manageDisplay.popDisplay();
				userPageLoop = false;
				break;
			case '3':
				new ClearConsoleScreen();
				manageDisplay.pushDisplay(depositDisplay);
				manageDisplay.popDisplay();
				userPageLoop = false;
				break;
			case '4':
				System.out.println("Enter recipient number");
				break;
			case '5':
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
