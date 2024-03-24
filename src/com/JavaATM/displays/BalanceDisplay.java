package com.JavaATM.displays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.JavaATM.api.JDBCImplementation;
import com.JavaATM.main.ClearConsoleScreen;
import com.JavaATM.main.ParentClass;

@Component
public class BalanceDisplay extends ParentClass{
	
	@Autowired
	ManageDisplay manageDisplay;
	
	@Autowired
	JDBCImplementation jdbcImpl;
	
	@Lazy
	@Autowired
	LoginDisplay loginDisplay;
	
	public void show() {
		int balance = jdbcImpl.getBalance(loginDisplay.getAcctId());
		String formatted = String.format("%,d", balance);
		String padding = " ".repeat((9 - formatted.length())/2);
		
		System.out.printf(""
				+ "+--------------------------------+\n"
				+ "|             BALANCE            |\n"
				+ "+--------------------------------+\n"
				+ "|         PHP: %s%s%s         |\n"
				+ "+--------------------------------+\n",padding,formatted,padding);
		
		
		ClearConsoleScreen.pause();
		new ClearConsoleScreen();
		manageDisplay.popDisplay();
	}
}
