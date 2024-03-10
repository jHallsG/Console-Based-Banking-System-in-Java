package com.JavaATM.main;

public class DepositDisplay implements ConsoleDisplays{

	@Override
	public void show() {
		System.out.print(""
				+ "+--------------------------------------------+"
				+ "|				Deposit						|"
				+ "+--------------------------------------------+"
				+ "| Account Number: 	********1234			|"
				+ "| Current Balance:	PHP1234.00 				|"
				+ "+--------------------------------------------+"
				+ ""
				+ "Please enter deposit amount: "
				+ ">> ");
	}
	
	public void processDeposit() {
		
	}

}
