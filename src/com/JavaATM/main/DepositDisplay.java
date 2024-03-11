package com.JavaATM.main;

import org.springframework.stereotype.Component;

@Component
public class DepositDisplay extends ParentClass{

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
		
		int deposit = scan.nextInt();
		
		pause();
		updatedDeposit();
		pause();
	}
	
	public void processDeposit() {
		
	}
	
	public void updatedDeposit() {
		int accountNum = 123456789;
		int balance = 123456;
		System.out.print(""
				+ "+--------------------------------------------+\n"
				+ "|				Deposit						|\n"
				+ "+--------------------------------------------+\n");
		System.out.printf("| Account Number: 	%s			|\n",accountNum);
		System.out.printf("| Current Balance:	PHP%s 				|\n",balance);
		System.out.print("+--------------------------------------------+\n");
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
