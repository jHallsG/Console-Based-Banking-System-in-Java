package com.JavaATM.main;

import java.util.Scanner;

public class LoginDisplay implements ConsoleDisplays{

	Scanner scan = new Scanner(System.in);
	
	@Override
	public void show() {
		System.out.print("\nPlease enter your email address: \n>> ");
		scan.nextLine();	//dont't delete. somehow scanner detects the newline \n as an input
			
		String username = scan.nextLine();
			
		System.out.print("\nPlease enter your password: \n>> ");
		String pass = scan.nextLine();
		
		
			
	}
	
	public boolean authenticateSuccessfulLogin() {
		return true;
	}

}
