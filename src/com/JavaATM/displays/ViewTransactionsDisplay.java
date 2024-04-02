package com.JavaATM.displays;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.JavaATM.api.JDBCImplementation;
import com.JavaATM.dao.JavaATMDAO;
import com.JavaATM.main.ClearConsoleScreen;
import com.JavaATM.main.ParentClass;
import com.JavaATM.main.TransactionProcessor;

@Component
public class ViewTransactionsDisplay extends ParentClass{
	
	public ViewTransactionsDisplay(ManageDisplay manageDisplay, JDBCImplementation jdbcImpl, TransactionProcessor transactionProcessor) {
		super(manageDisplay, jdbcImpl, transactionProcessor);
	}
	
	@Override
	public void show() {
		String transaction_type,amount,transaction_date,padding1,padding2,padding3;
		System.out.println(""
				+ "+---------------------+---------------+-------------------------+\n"
				+ "|   Transaction Type  |    Amount     |     Transaction Date    |\n"
				+ "+---------------------+---------------+-------------------------+");
//		          "| %s%s                | %s            | %s                      |\n"
		
		for (JavaATMDAO item : jdbcImpl.viewTransactions(transactionProcessor.returnAcctId())) {
			transaction_type = item.getTransaction_type();
			padding1 = " ".repeat(20-transaction_type.length());
			Integer amountValue = item.getAmount();
	        amount = (amountValue != null) ? amountValue.toString() : "N/A"; // Handle null case
	        padding2 = " ".repeat(14-amount.length());
			transaction_date = dateFormatter(item.getTransaction_date());
			padding3 = " ".repeat(24-transaction_date.length());
			System.out.printf("| %s%s| %s%s| %s%s|\n",transaction_type,padding1,amount,padding2,transaction_date,padding3);
		}
		System.out.println("+---------------------+---------------+-------------------------+");
		
		System.out.print("\n\nPress any key to exit: ");
		scan.next();
		
		ClearConsoleScreen.clearScreen();
		manageDisplay.popDisplay();
	}
	
	private String dateFormatter(LocalDateTime date) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
		return date.format(format);
	}

}
