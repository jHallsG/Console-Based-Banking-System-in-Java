package com.JavaATM.displays;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.JavaATM.main.ClearConsoleScreen;

@Component
public class RegisterDisplay implements ConsoleDisplays{
	
	private Scanner scan = new Scanner(System.in);
	private static final String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final Pattern pattern = Pattern.compile(emailPattern);
	
	@Autowired
	private ManageDisplay manageDisplay;
	
	private String pass, confirmPass, email;
	
	@Override
	public void show() {
		System.out.print(""
				+ "+-----------------------------------+\n"
				+ "| Please enter your email.          |\n"
				+ "| This will serve as your username. |\n"
				+ "+-----------------------------------+\n"
				+ ">> ");
		email = scan.nextLine();
		
		while(!emailPatternValidation(email)) {
			System.out.println("\nDoes not match email pattern. Please try again.\n");
			show();
		}
		
		//CHECK IF EMAIL ALREADY EXISTS //
		emailCheck();
		
		
		System.out.print(""
				+ "+------------------------------+\n"
				+ "| Please enter your name:      |\n"
				+ "+------------------------------|\n"
				+ ">> ");
		String name = scan.nextLine();

		System.out.print(""
				+ "+------------------------------+\n"
				+ "| Please enter your address:   |\n"
				+ "+------------------------------|\n"
				+ ">> ");
		String address = scan.nextLine();
		
		System.out.print(""
				+ "+--------------------------------------+\n"
				+ "| Please enter your contact number:    |\n"
				+ "+--------------------------------------+\n"
				+ ">> ");
			
		String contactNum = scan.nextLine();
		
		while(true) {
			System.out.print(""
					+ "+--------------------------------------+\n"
					+ "| Please enter your password:          |\n"
					+ "+--------------------------------------+\n"
					+ ">> ");
			pass = scan.nextLine();
			
			System.out.print(""
					+ "+--------------------------------------+\n"
					+ "| Please confirm your password:        |\n"
					+ "+--------------------------------------+\n"
					+ ">> ");
			confirmPass = scan.nextLine();
			
			if (pass.equals(confirmPass)) {
				System.out.println("\nCongratulations! You are now successfully registered. Please relogin to activate your credentials.");
				pause();
				manageDisplay.popDisplay();
			} else {
				System.out.println("\nPassword does not match. Please try again.\n");
				continue;
			}
		}
	}
	
	public void verifyCredentials() {
		// insert code to process registration here =========>>
		// insert check if 
		
		
		
	}
	
	public static boolean emailPatternValidation(String emailInput) {
		Matcher matcher = pattern.matcher(emailInput);
		return matcher.matches();
	}
		
		
	public void pause() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new ClearConsoleScreen();
	}
	
	public void emailCheck() {
		
	}
	
	public void passwordCheck() {
		
	}
}
