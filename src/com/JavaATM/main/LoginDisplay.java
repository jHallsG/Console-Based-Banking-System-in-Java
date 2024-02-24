package com.JavaATM.main;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class LoginDisplay implements ConsoleDisplays{

	Scanner scan = new Scanner(System.in);
	
	@Override
	public void show() {
		System.out.print("\nPlease enter your email address: \n>> ");
		String username = scan.nextLine();
			
		System.out.print("\nPlease enter your password: \n>> ");
		String pass = scan.nextLine();
	}
	
	public boolean authenticateSuccessfulLogin() {
		return true;
	}

}
