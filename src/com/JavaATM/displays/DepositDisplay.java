package com.JavaATM.displays;

import org.springframework.stereotype.Component;

import com.JavaATM.main.ClearConsoleScreen;
import com.JavaATM.main.ParentClass;

@Component
public class DepositDisplay extends ParentClass{
	
	private int depositAmt;

	@Override
	public void show() {
		
		System.out.print(""
				+ "+--------------------------------------------+\n"
				+ "|				Deposit						|\n"
				+ "+--------------------------------------------+\n"
				+ "| Account Number: 	%d			|\n"
				+ "| Current Balance:	PHP%d 				|\n"
				+ "+--------------------------------------------+\n"
				+ "\n"
				+ "Please enter deposit amount: \n"
				+ ">> ");
		
		depositAmt = scan.nextInt();
		
		processDeposit(depositAmt);
		ClearConsoleScreen.pauseThenClearScreen();
		manageDisplay.popDisplay();
		
	}
	
	public void processDeposit(int amount) {
		if (jdbcImpl.updateBalance(loginDisplay.getAcctId(), amount) > 0) {
			System.out.printf("\nYou have successfully deposited %s into your account",depositAmt);
		} else {
			System.out.println("\nDeposit failed. Please try again later.");
		}
	}
}
