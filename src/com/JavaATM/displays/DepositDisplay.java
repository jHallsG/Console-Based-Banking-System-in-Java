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
				+ "| Account Number: 	********1234			|\n"
				+ "| Current Balance:	PHP1234.00 				|\n"
				+ "+--------------------------------------------+\n"
				+ "\n"
				+ "Please enter deposit amount: \n"
				+ ">> ");
		
		depositAmt = scan.nextInt();
		
		processDeposit();
		pause();
		
	}
	
	public void processDeposit() {
		// process deposit//
		System.out.printf("\nYou have successfully deposited %s into your account",depositAmt);
	}
	
	public void pause() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new ClearConsoleScreen();
	}

}
