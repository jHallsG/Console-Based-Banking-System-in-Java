package com.JavaATM.displays;

import java.util.List;

import org.springframework.stereotype.Component;

import com.JavaATM.api.JDBCImplementation;
import com.JavaATM.dao.JavaATMDAO;
import com.JavaATM.main.ClearConsoleScreen;
import com.JavaATM.main.ParentClass;
import com.JavaATM.main.TransactionProcessor;

@Component
public class DepositDisplay extends ParentClass{
	
	public DepositDisplay(ManageDisplay manageDisplay, JDBCImplementation jdbcImpl, TransactionProcessor transactionProcessor) {
		super(manageDisplay,jdbcImpl,transactionProcessor);
	}
	
	private int depositAmt;

	@Override
	public void show() {
		String acct = null;
		double balance = 0;
		
		for (JavaATMDAO item : getAcctDetails()) {
			acct = item.getAccount_number();
			balance = item.getBalance();
		}
		
		String padding1 = " ".repeat(21-acct.length());
		String padding2 = " ".repeat(15-Double.toString(balance).length());
		
		while (true) {
			System.out.printf(""
					+ "+--------------------------------------------+\n"
					+ "|                    Deposit                 |\n"
					+ "+--------------------------------------------+\n"
					+ "| Account Number: 	%s%s|\n"
					+ "| Current Balance:	PHP %,.2f%s|\n"
					+ "+--------------------------------------------+\n"
					+ "\n"
					+ "Please enter deposit amount: \n"
					+ ">> ",acct,padding1,balance,padding2);
			
			depositAmt = scan.nextInt();
			
			if (depositAmt < 100) {
				System.out.println("\nError: Minimum deposit allowed is 100\n");
				continue;
			} else {
				break;
			}
		}
		
		if (transactionProcessor.deposit(transactionProcessor.returnAcctId(),depositAmt) == 1) {
			System.out.println("\n" + depositAmt + " successfully deposited to your account");
		} else {
			System.out.println("Operation failed. Please try again.");
		}
		ClearConsoleScreen.pauseThenClearScreen();
		manageDisplay.popDisplay();
		
	}
	
	private List<JavaATMDAO> getAcctDetails(){
		return jdbcImpl.getAcctDetails(transactionProcessor.returnAcctId());
	}
}
