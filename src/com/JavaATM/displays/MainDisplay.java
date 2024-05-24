package com.JavaATM.displays;

import org.springframework.stereotype.Component;

import com.JavaATM.api.JDBCImplementation;
import com.JavaATM.main.ClearConsoleScreen;
import com.JavaATM.main.ParentClass;
import com.JavaATM.main.TransactionProcessor;

@Component
public class MainDisplay extends ParentClass{
	
	public MainDisplay(ManageDisplay manageDisplay, 
			EditDisplay editDisplay, 
			BalanceDisplay balanceDisplay, 
			DepositDisplay depositDisplay,
			JDBCImplementation jdbcImpl,
			TransactionProcessor transactionProcessor,
			MoneyTransferDisplay moneyTransferDisplay,
			ViewTransactionsDisplay viewTransactionsDisplay) {
		
		super(manageDisplay, 
				editDisplay,
				balanceDisplay, 
				depositDisplay,
				jdbcImpl,
				transactionProcessor,
				moneyTransferDisplay,
				viewTransactionsDisplay);
	}

	@Override
	public void show() {
//		String name = jdbcImpl.getName(loginDisplay.getAcctId());
		String name = jdbcImpl.getName(transactionProcessor.returnAcctId());
		String embolden = "\033[1m" + name + "\033[0m";
		String padding = " ".repeat((20 - name.length())/2);
		int retry = 0;
		
		System.out.printf(""
				+ "+----------------------------------------------------------------+\n"
				+ "| Hello %s%s%s, what would you like to do today?   |\n"
				+ "+---------+------------------------------------------------------+\n"
				+ "|    1    |   User Details                                       |\n"
				+ "|    2    |   Check Balance                                      |\n"
				+ "|    3    |   Deposit                                            |\n"
				+ "|    4    |   Money Transfer                                     |\n"
				+ "|    5    |   View Transactions                                  |\n"
				+ "|    6    |   Logout                                             |\n"
				+ "+---------+------------------------------------------------------+\n"
				+ ">> ",padding,embolden,padding);
		
		while(true) {
			char options = scan.next().charAt(0);
			switch (options) {
			case '1':
				ClearConsoleScreen.clearScreen();
				manageDisplay.pushDisplay(editDisplay);
				return;
			case '2':
				ClearConsoleScreen.clearScreen();
				manageDisplay.pushDisplay(balanceDisplay);
				return;
			case '3':
				ClearConsoleScreen.clearScreen();
				manageDisplay.pushDisplay(depositDisplay);
				return;
			case '4':
				ClearConsoleScreen.clearScreen();
				manageDisplay.pushDisplay(moneyTransferDisplay);
				return;
			case '5':
				ClearConsoleScreen.clearScreen();
				manageDisplay.pushDisplay(viewTransactionsDisplay);
				return;
			case '6':
				ClearConsoleScreen.clearScreen();
				manageDisplay.popDisplay();
				return;
			default:
				retry++;
				if (retry == 3) {
					System.out.println("\nMultiple invalid inputs detected. Exiting application...");
					return;
				} else {
					System.out.println("\nInvalid input. Please try again: \n");
				}
			}
		}
	}
	
}
