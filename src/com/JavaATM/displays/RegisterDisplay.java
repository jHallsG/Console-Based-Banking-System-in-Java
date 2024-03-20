package com.JavaATM.displays;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.JavaATM.api.JDBCImplementation;
import com.JavaATM.main.ClearConsoleScreen;

@Component
public class RegisterDisplay implements ConsoleDisplays{
	
	private Scanner scan = new Scanner(System.in);
	private String account, pass, confirmPass, email;
	private static final String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final Pattern pattern = Pattern.compile(emailPattern);
	
	
	@Autowired
	private ManageDisplay manageDisplay;
	@Autowired
	private JDBCImplementation jdbcImpl;
	
	
	
	@Override
	public void show() {
		while(true) {
			System.out.print(""
					+ "+-------------------------------------------+\n"
					+ "| Please enter your 12-digit account number |\n"
					+ "+-------------------------------------------+\n"
					+ ">> ");
			account = scan.nextLine();
			
			// CHECK ACCOUNT IF CORRECT
			if(account.length() != 12 || !account.matches("\\d+")) {
				System.out.println("\n\"" + account + "\"" + " is not a valid account number. Please check your account number and try again.\n");
				continue;
			}
			
			// CHECK FOR ACCOUNT DUPLICATES
			if(jdbcImpl.accountCheck(account) > 0) {
				System.out.println("\n\"" + account + "\"" + " is already enrolled. Please try again.\n");
				continue;
			}
			
			break;
		}
		
		while(true) {
			System.out.print(""
					+ "+-----------------------------------+\n"
					+ "| Please enter your email.          |\n"
					+ "| This will serve as your username. |\n"
					+ "+-----------------------------------+\n"
					+ ">> ");
			email = scan.nextLine();
			
			// CHECK IF VALID EMAIL PATTERN
			if(!emailPatternValidation(email)) {
				System.out.println("\n\"" + email + "\"" + " is not an email address. Please try again.\n");
				continue;
			}
			
			//CHECK IF EMAIL ALREADY EXISTS
			if(jdbcImpl.emailCheck(email) > 0) {
				System.out.println("\n\"" + email + "\"" + " is already used. Please try again.\n");
				continue;
			}
			
			break;
		}
		
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
			
			// Register and generate account id. If no ID is generated, it means failed and prompt to try again.
			if (pass.equals(confirmPass)) {
				int accountId = jdbcImpl.saveAndGenerateAcctId(account);
					if (accountId <= 0) {
						System.out.println("Enrollment failed. Please try again.");
						break;
					}
				
				// Register if account id is generated
				jdbcImpl.registration(accountId, email, confirmPass, name, address, contactNum);
				System.out.println("\nCongratulations! You are now successfully registered. Please relogin to activate your credentials.");
				break;
			} else {
				System.out.println("\nPassword does not match. Please try again.\n");
			}
		}
		
		pause();
		manageDisplay.popDisplay();
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
}
