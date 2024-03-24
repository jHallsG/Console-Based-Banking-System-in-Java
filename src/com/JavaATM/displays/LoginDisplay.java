package com.JavaATM.displays;

import java.util.List;
import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.JavaATM.api.JDBCImplementation;
import com.JavaATM.dao.JavaATMDAO;
import com.JavaATM.main.ClearConsoleScreen;
import com.JavaATM.main.ParentClass;

@Component
public class LoginDisplay extends ParentClass{
	
	public LoginDisplay(ManageDisplay manageDisplay, MainDisplay userDisplay, JDBCImplementation jdbcImpl) {
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
					+ ">> ");
			username = scan.nextLine();
			
			if (jdbcImpl.emailCheck(username) > 0) break; 
			else {
				System.out.println("\nEmail \"" + username + "\" is not yet enrolled. Please enroll your account and try again.\n");
			}
			
			manageDisplay.popDisplay();
		}
		
		while (true) {
			System.out.print("\n"
					+ "+----------------------------------+\n"
					+ "| Please enter your password:      |\n"
					+ "+----------------------------------+\n"
					+ ">> ");
			pass = scan.nextLine();
			
			if (BCrypt.checkpw(pass, jdbcImpl.getHashedPassword(username))) break;
			else {
				System.out.println("\nEmail and password does not match. Please try again.");
				continue;
			}
		}
		
		new ClearConsoleScreen();
		manageDisplay.pushDisplay(userDisplay);
	}
	
	public int getAcctId() {
		return jdbcImpl.getAcctId(username);
	}
}
