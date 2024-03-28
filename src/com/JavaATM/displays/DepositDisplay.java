package com.JavaATM.displays;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.JavaATM.api.JDBCImplementation;
import com.JavaATM.dao.JavaATMDAO;
import com.JavaATM.main.ClearConsoleScreen;
import com.JavaATM.main.ParentClass;

@Component
public class DepositDisplay extends ParentClass{
	
	private int depositAmt;
	
	@Lazy
	@Autowired
	LoginDisplay loginDisplay;
	
	@Autowired
	JDBCImplementation jdbcImpl;
	
	@Autowired
	ManageDisplay manageDisplay;

	@Override
	public void show() {
		String acct = null;
		double balance = 0;
		
		for (JavaATMDAO item : getAcctDetails()) {
			acct = item.getAccount_number();
			balance = item.getBalance();
		}
		
		String padding1 = " ".repeat(24-acct.length());
		String padding2 = " ".repeat(21-Double.toString(balance).length());
		
			
		
		
		System.out.printf(""
				+ "+--------------------------------------------+\n"
				+ "|                    Deposit                 |\n"
				+ "+--------------------------------------------+\n"
				+ "| Account Number: 	%s%s|\n"
				+ "| Current Balance:	PHP%f%s|\n"
				+ "+--------------------------------------------+\n"
				+ "\n"
				+ "Please enter deposit amount: \n"
				+ ">> ",acct,padding1,balance,padding2);
		
		depositAmt = scan.nextInt();
		
		processDeposit(depositAmt);
		ClearConsoleScreen.pauseThenClearScreen();
		manageDisplay.popDisplay();
		
	}
	
	private void processDeposit(int amount) {
		if (jdbcImpl.updateBalance(loginDisplay.getAcctId(), amount) > 0) {
			System.out.printf("\nYou have successfully deposited %s into your account",depositAmt);
		} else {
			System.out.println("\nDeposit failed. Please try again later.");
		}
	}
	
	private List<JavaATMDAO> getAcctDetails(){
		return jdbcImpl.getAcctDetails(loginDisplay.getAcctId());
	}
}
