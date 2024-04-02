package com.JavaATM.displays;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

import com.JavaATM.api.JDBCImplementation;
import com.JavaATM.main.ClearConsoleScreen;
import com.JavaATM.main.ParentClass;
import com.JavaATM.main.TransactionProcessor;

@Component
public class ChangePasswordDisplay extends ParentClass{
	
	public ChangePasswordDisplay(ManageDisplay manageDisplay, JDBCImplementation jdbcImpl, TransactionProcessor transactionProcessor) {
		super(manageDisplay,jdbcImpl,transactionProcessor);
	}
	
	public void show() {
		int acct = transactionProcessor.returnAcctId();
		
		while (true) {
			System.out.print(""
					+ "+-----------------------------+\n"
					+ "| Enter password:             |\n"
					+ "+-----------------------------+\n"
					+ ">> ");
			String userPass = scan.nextLine();
			
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
}
