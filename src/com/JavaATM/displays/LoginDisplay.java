package com.JavaATM.displays;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.JavaATM.main.ClearConsoleScreen;
import com.JavaATM.main.ParentClass;

@Component
public class LoginDisplay extends ParentClass{
	
	public LoginDisplay(ManageDisplay manageDisplay, UserDisplay userDisplay) {
		super(manageDisplay, userDisplay);
	}

	@Override
	public void show() {
		System.out.print(""
				+ "+----------------------------------+\n"
				+ "| Please enter your email address: |\n"
				+ "+----------------------------------+\n"
				+ "\n>> ");
		String username = scan.nextLine();
			
		System.out.print("\n"
				+ "+----------------------------------+\n"
				+ "| Please enter your password:      |\n"
				+ "+----------------------------------+\n"
				+ "\n>> ");
		String pass = scan.nextLine();
		
		authenticateSuccessfulLogin();
	}
	
	public void authenticateSuccessfulLogin() {
		//insert login credentials checking code here =========>>>
		
		new ClearConsoleScreen();
		manageDisplay.pushDisplay(userDisplay);
		
	}

}
