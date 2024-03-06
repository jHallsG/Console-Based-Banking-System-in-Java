package com.JavaATM.main;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ChangeUsernameDisplay implements ConsoleDisplays{
	
	private Scanner scan = new Scanner(System.in);
	
	@Autowired
	ManageDisplay manageDisplay;
	
	@Override
	public void show() {
		
		while (true) {
			System.out.print("\nEnter desired username: ");
			String userName = scan.nextLine();
			
			System.out.print("\nConfirm username: ");
			String confirmUsername = scan.nextLine();
			
			if (validateSuccessfulChangeName(userName, confirmUsername)) {
				new ClearConsoleScreen();
				manageDisplay.popDisplay();
			} else {
				continue;
			}
		}
	}
	
	
	public boolean validateSuccessfulChangeName(String uName, String confirmUName) {
		
		if(uName.equals(confirmUName)) {
			System.out.println("\nUsername successfully updated!");
				
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			return true;
		} else {
			System.out.println("\nUsername mismatch. Please try again!");
		}
		
		return false;
	}
}
