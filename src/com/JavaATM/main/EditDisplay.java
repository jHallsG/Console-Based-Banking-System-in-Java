package com.JavaATM.main;

import java.util.Scanner;

import org.springframework.stereotype.Component;
@Component
public class EditDisplay implements ConsoleDisplays{
	
	private Scanner scan = new Scanner(System.in);
	
	@Override
	public void show() {
		
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
			switch (userChoice) {
			case 1:
				System.out.print("\nEnter desired username: ");
				String username = scan.nextLine();
				System.out.print("\nConfirm username: ");
				String confirmUsername = scan.nextLine();
				
				if (username.equals(confirmUsername)) {
					
					// update username on database //
					
					System.out.println("Username successfully updated!");
					editLoop = false;
					break;
				} else {
					System.out.println("Username mismatch. Please try again!");
					break;
				}
				
			case 2:
				System.out.println("Show change password");
				break;
				
			case 3:
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
