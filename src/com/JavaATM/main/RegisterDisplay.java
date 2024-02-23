package com.JavaATM.main;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class RegisterDisplay implements ConsoleDisplays{

Scanner scan = new Scanner(System.in);
	
	@Override
	public void show() {
		System.out.print("\nPlease enter your email address: \n>> ");
		scan.nextLine();	//dont't delete. somehow scanner detects the newline \n as an input
			
		String username = scan.nextLine();
			
		System.out.print("\nPlease enter your password: \n>> ");
		String pass = scan.nextLine();
		
		System.out.print("\nPlease re-enter your password: \n>> ");
		scan.nextLine();
		String pass2 = scan.nextLine();
	}
}
