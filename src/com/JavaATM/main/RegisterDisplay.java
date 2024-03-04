package com.JavaATM.main;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterDisplay implements ConsoleDisplays{
	
	private Scanner scan = new Scanner(System.in);
	
	@Autowired
	private ManageDisplay manageDisplay;
	
	@Override
	public void show() {
		System.out.print("\nPlease enter your email address: \n>> ");
			
		String username = scan.nextLine();
			
		System.out.print("\nPlease enter your password: \n>> ");
		String pass = scan.nextLine();
		
		System.out.print("\nPlease confirm your password: \n>> ");
		String confirmPass = scan.nextLine();
		
		authenticateSuccessfulRegistration();
	}
	
	public void authenticateSuccessfulRegistration() {
		// insert code to process registration here =========>>
		
		System.out.println("\nCongratulations! You are now successfully registered. Please relogin to activate your credentials.");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new ClearConsoleScreen();
		manageDisplay.popDisplay();
		
	}
}
