package com.JavaATM.displays;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.JavaATM.api.JDBCImplementation;
import com.JavaATM.main.ClearConsoleScreen;
import com.JavaATM.main.ParentClass;
import com.JavaATM.main.TransactionProcessor;
@Component
@Lazy
public class EditUserDetailsDisplay extends ParentClass{
	
	public EditUserDetailsDisplay(ManageDisplay manageDisplay, JDBCImplementation jdbcImpl, TransactionProcessor transactionProcessor) {
		super(manageDisplay, jdbcImpl, transactionProcessor);
	}
	
	@Override
	public void show() {
		System.out.print(""
			+ "+------------------------------+\n"
			+ "| Please enter your name:      |\n"
			+ "+------------------------------|\n"
			+ ">> ");
		String name = scan.nextLine();
	
		System.out.print("\n"
			+ "+------------------------------+\n"
			+ "| Please enter your address:   |\n"
			+ "+------------------------------|\n"
			+ ">> ");
		String address = scan.nextLine();
	
		System.out.print("\n"
			+ "+--------------------------------------+\n"
			+ "| Please enter your contact number:    |\n"
			+ "+--------------------------------------+\n"
			+ ">> ");
		String contactNum = scan.nextLine();
		
		if (jdbcImpl.updateUserDetails(name, address, contactNum, transactionProcessor.returnAcctId()) > 0) {
			System.out.println("\nDetails successfully saved.");
			ClearConsoleScreen.pause();
			ClearConsoleScreen.clearScreen();
			manageDisplay.popDisplay();
		} else {
			System.out.println("\nOperation failed. Please try again.");
		}
		
	}
}
