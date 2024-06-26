package com.JavaATM.displays;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

import com.JavaATM.api.JDBCImplementation;
import com.JavaATM.main.ClearConsoleScreen;
import com.JavaATM.main.ParentClass;

@Component
public class LoginDisplay extends ParentClass{
	
	public LoginDisplay(ManageDisplay manageDisplay, MainDisplay mainDisplay, JDBCImplementation jdbcImpl) {
		super(manageDisplay, mainDisplay, jdbcImpl);
	}
	
	private String username, pass;
	

	@Override
	public void show() {
		
		while(true) {
			System.out.print(""
					+ "+----------------------------------+\n"
					+ "| Please enter your email address: |\n"
					+ "+----------------------------------+\n"
					+ ">> ");
			username = scan.nextLine();
			
			if (jdbcImpl.emailCheck(username) > 0) break;
			else {
				System.out.println("\nEmail \"" + username + "\" is not yet enrolled. Please enroll your account and try again.\n");
				manageDisplay.popDisplay();
				return;
			}
		}
		
		while (true) {
			System.out.print("\n"
					+ "+----------------------------------+\n"
					+ "| Please enter your password:      |\n"
					+ "+----------------------------------+\n"
					+ ">> ");
			pass = scan.nextLine();
			
			if (BCrypt.checkpw(pass, jdbcImpl.getHashedPassword(username))) {
				ClearConsoleScreen.clearScreen();
				manageDisplay.pushDisplay(mainDisplay);
				return;
			}
			else {
				System.out.println("\nEmail and password does not match. Please try again.");
				continue;
			}
		}
	}
	
	public int getAcctId() {
		return jdbcImpl.getAcctId(username);
	}
}
