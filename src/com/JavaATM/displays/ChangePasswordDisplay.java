package com.JavaATM.displays;

import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.JavaATM.api.JDBCImplementation;
import com.JavaATM.main.ClearConsoleScreen;
import com.JavaATM.main.ParentClass;

@Component
public class ChangePasswordDisplay extends ParentClass{
	@Autowired
	private ManageDisplay manageDisplay;
	
	@Autowired
	JDBCImplementation jdbcImpl;
	
	@Autowired
	private LoginDisplay loginDisplay;
	
	public void show() {
		int acct = loginDisplay.getAcctId();
		
		while (true) {
			System.out.print(""
					+ "+-----------------------------+\n"
					+ "| Enter password:             |\n"
					+ "+-----------------------------+\n"
					+ ">> ");
			String userPass = scan.nextLine();
			
			loginDisplay.getAcctId();
			
			if (BCrypt.checkpw(userPass, jdbcImpl.getHashedPasswordByAcctId(acct))) break;
			else {
				System.out.println("\nPassword is incorrect. Please try again.\n");
				continue;
			}
		}
			
		while (true) {
			System.out.print("\n"
					+ "+-----------------------------+\n"
					+ "| Enter new password:         |\n"
					+ "+-----------------------------+\n"
					+ ">> ");
			String newUserPass = scan.nextLine();
			
			System.out.print("\n"
					+ "+-----------------------------+\n"
					+ "| Confirm new password:       |\n"
					+ "+-----------------------------+\n"
					+ ">> ");
			String confirmUserpass = scan.nextLine();
			
			if (newUserPass.equals(confirmUserpass)) {
				if (jdbcImpl.updatePassword(confirmUserpass, acct) > 0) {
					System.out.println("\nPassword successfully changed");
					break;
				} else {
					System.out.println("\nPassword change failed. Please try again");
					break;
				}
			} else {
				System.out.println("\nPassword mismatch. Please try again.");
				continue;
			}
		}
		
		ClearConsoleScreen.pauseThenClearScreen();
		manageDisplay.popDisplay();
	}
	
public boolean validateSuccessfulChangePassword(String uPass, String confirmPass) {
		
		if(uPass.equals(confirmPass)) {
			System.out.println("\nPassword successfully updated!");
				
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			return true;
		} else {
			System.out.println("\nPassword mismatch. Please try again!");
		}
		
		return false;
	}
}
