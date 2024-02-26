package com.JavaATM.main;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginDisplay implements ConsoleDisplays{

	Scanner scan = new Scanner(System.in);
	@Autowired
	ManageDisplay manageDisplay;
	@Autowired
	UserDisplay userDisplay;
	
	@Override
	public void show() {
		System.out.print("\nPlease enter your email address: \n>> ");
		String username = scan.nextLine();
			
		System.out.print("\nPlease enter your password: \n>> ");
		String pass = scan.nextLine();
		
		authenticateSuccessfulLogin();
	}
	
	public void authenticateSuccessfulLogin() {
		//insert login credentials checking code here =========>>>
		
		new ClearConsoleScreen();
		manageDisplay.pushDisplay(userDisplay);
		
	}

}
