package com.JavaATM.displays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.JavaATM.api.JDBCImplementation;
import com.JavaATM.dao.JavaATMDAO;
import com.JavaATM.main.ClearConsoleScreen;
import com.JavaATM.main.ParentClass;

@Component
public class MainDisplay extends ParentClass{
	
	public MainDisplay(ManageDisplay manageDisplay, EditDisplay editDisplay, BalanceDisplay balanceDisplay, DepositDisplay depositDisplay) {
		super(manageDisplay, editDisplay,balanceDisplay, depositDisplay);
	}
	
	@Autowired
	JDBCImplementation jdbcImpl;;
	
	@Lazy		// don't delete, causes a Circular Reference error
	@Autowired
	LoginDisplay loginDisplay;

	@Override
	public void show() {
		String name = jdbcImpl.getName(loginDisplay.getAcctId());
		String embolden = "\033[1m" + name + "\033[0m";
		String padding = " ".repeat((10 - name.length())/2);
		int retry = 0;
		
		System.out.printf(""
				+ "+----------------------------------------------------------------+\n"
				+ "| Hello %s%s%s, what would you like to do today?             |\n"
				+ "+---------+------------------------------------------------------+\n"
				+ "|    1    |   View User Details                                  |\n"
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
				break;
			case '2':
				ClearConsoleScreen.clearScreen();
				manageDisplay.pushDisplay(balanceDisplay);
				manageDisplay.popDisplay();
				break;
			case '3':
				ClearConsoleScreen.clearScreen();
				manageDisplay.pushDisplay(depositDisplay);
				manageDisplay.popDisplay();
				break;
			case '4':
				System.out.println("Enter recipient number");
				break;
			case '5':
				System.out.println("\nExiting application... ");
				return;
			case '6':
				manageDisplay.popDisplay();
				break;
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
