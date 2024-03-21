package com.JavaATM.displays;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.JavaATM.api.JDBCImplementation;
import com.JavaATM.main.ClearConsoleScreen;
import com.JavaATM.main.ParentClass;

@Component
public class LoginDisplay extends ParentClass{
	
	public LoginDisplay(ManageDisplay manageDisplay, UserDisplay userDisplay, JDBCImplementation jdbcImpl) {
		super(manageDisplay, userDisplay, jdbcImpl);
	}
	
	private String username, pass;

	@Override
	public void show() {
		
		while(true) {
			System.out.print(""
					+ "+----------------------------------+\n"
					+ "| Please enter your email address: |\n"
					+ "+----------------------------------+\n"
					+ "\n>> ");
			username = scan.nextLine();
			
			if (jdbcImpl.emailCheck(username) > 0) break;
			else {
				System.out.println("\nEmail is not yet enrolled. Please enroll your account and try again.\n");
			}
			
			manageDisplay.popDisplay();
		}
		
		while (true) {
			System.out.print(""
					+ "+----------------------------------+\n"
					+ "| Please enter your password:      |\n"
					+ "+----------------------------------+\n"
					+ "\n>> ");
			pass = scan.nextLine();
			
			if (jdbcImpl.authenticatePassword(username, pass) > 0) break;
			else {
				System.out.println("\nEmail and password does not match. Please try again.\n");
				continue;
			}
		}
		
		new ClearConsoleScreen();
		manageDisplay.pushDisplay(userDisplay);
	}
}
