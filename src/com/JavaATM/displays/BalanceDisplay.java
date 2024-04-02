package com.JavaATM.displays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.JavaATM.api.JDBCImplementation;
import com.JavaATM.main.ClearConsoleScreen;
import com.JavaATM.main.ParentClass;
import com.JavaATM.main.TransactionProcessor;

@Component
public class BalanceDisplay extends ParentClass{
	
	public BalanceDisplay(ManageDisplay manageDisplay, JDBCImplementation jdbcImpl, TransactionProcessor transactionProcessor) {
		super(manageDisplay, jdbcImpl,transactionProcessor);
	}
	
	public void show() {
		int balance = jdbcImpl.getBalance(transactionProcessor.returnAcctId());
		String formatted = String.format("%,d", balance);
		String padding = " ".repeat((9 - formatted.length())/2);
		
		System.out.printf(""
				+ "+--------------------------------+\n"
				+ "|             BALANCE            |\n"
				+ "+--------------------------------+\n"
				+ "|         PHP: %s%s%s          |\n"
				+ "+--------------------------------+\n",padding,formatted,padding);
		
		ClearConsoleScreen.pauseThenClearScreen();
		manageDisplay.popDisplay();
	}
}
