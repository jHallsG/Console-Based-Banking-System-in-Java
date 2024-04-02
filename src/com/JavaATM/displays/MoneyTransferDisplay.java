package com.JavaATM.displays;

import org.springframework.stereotype.Component;

import com.JavaATM.api.JDBCImplementation;
import com.JavaATM.main.ClearConsoleScreen;
import com.JavaATM.main.ParentClass;
import com.JavaATM.main.TransactionProcessor;

@Component
public class MoneyTransferDisplay extends ParentClass{
	
	public MoneyTransferDisplay(ManageDisplay manageDisplay, JDBCImplementation jdbcImpl, TransactionProcessor transactionProcessor) {
		super(manageDisplay, jdbcImpl, transactionProcessor);
	}
	
	private String destinationAcct;
	private int transferAmt;

	@Override
	public void show() {
		while (true) {
			System.out.print("Enter destination account number: ");
			destinationAcct = scan.nextLine();
			
			if (validateAcct() > 0) break;
			else {
				System.out.println("\nAccount not recognized. Please try again.\n");
				continue;
			}
		}
		
		while (true) {
			System.out.print("\nEnter transfer amount: ");
			transferAmt = scan.nextInt();
			
			if (transferAmt > validateBalance()) {
				System.out.println("\nError: Insufficient balance.\n");
				break;
			} else {
				transactionProcessor.moneyTransfer(transactionProcessor.returnAcctId(),getAcctId(),transferAmt);
				System.out.printf("You have successfully transferred %d to %s", transferAmt, destinationAcct);
				break;
			}
		}
		
		ClearConsoleScreen.pauseThenClearScreen();
		manageDisplay.popDisplay();
	}
	
	private int getAcctId() {
		return jdbcImpl.getAcctIdByAcctNum(destinationAcct);
	}
	
	private int validateAcct() {
		return jdbcImpl.accountCheck(destinationAcct);
	}

	private int validateBalance() {
		return jdbcImpl.getBalance(transactionProcessor.returnAcctId());
	}
}
