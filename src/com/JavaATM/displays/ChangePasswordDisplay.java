package com.JavaATM.displays;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.JavaATM.main.ClearConsoleScreen;

@Component
public class ChangePasswordDisplay implements ConsoleDisplays{

	private Scanner scan = new Scanner(System.in);
	@Autowired
	private ManageDisplay manageDisplay;
	
	public void show() {
		
		while (true) {
			System.out.print("\nEnter desired password: ");
			String userPass = scan.nextLine();
			
			System.out.print("\nConfirm username: ");
			String confirmUserpass = scan.nextLine();
			
			if (validateSuccessfulChangePassword(userPass, confirmUserpass)) {
				new ClearConsoleScreen();
				manageDisplay.popDisplay();
			} else {
				continue;
			}
		}
	}
	
public boolean validateSuccessfulChangePassword(String uPass, String confirmPass) {
		
		if(uPass.equals(confirmPass)) {
			System.out.println("\nPassword successfully updated!");
				
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			return true;
		} else {
			System.out.println("\nPassword mismatch. Please try again!");
		}
		
		return false;
	}
}
