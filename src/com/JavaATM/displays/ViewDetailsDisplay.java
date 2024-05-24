package com.JavaATM.displays;

import java.util.List;

import org.springframework.stereotype.Component;

import com.JavaATM.api.JDBCImplementation;
import com.JavaATM.dao.JavaATMDAO;
import com.JavaATM.main.ClearConsoleScreen;
import com.JavaATM.main.ParentClass;
import com.JavaATM.main.TransactionProcessor;

@Component
public class ViewDetailsDisplay extends ParentClass{

	public ViewDetailsDisplay(ManageDisplay manageDisplay, JDBCImplementation jdbcImpl, TransactionProcessor transactionProcessor) {
		super(manageDisplay,jdbcImpl,transactionProcessor);
	}
	
	@Override
	public void show() {
		String name = null, address = null, contactNum = null;
		
		for (JavaATMDAO item: getDetails()) {
			name = item.getName();
			address = item.getAddress();
			contactNum = item.getContact_number();
		}
		
		String padding1 = " ".repeat(29-name.length());
		String padding2 = " ".repeat(50-(address != null ? address.length() : 4));
		String padding3 = " ".repeat(24-(contactNum != null ? contactNum.length() : 4));
		System.out.printf(""
				+ "+------------------------------------+\n"
				+ "|            USER DETAILS            |\n"
				+ "+------------------------------------+\n"
				+ "| Name: %s%s|\n"
				+ "| Address: %s%s|\n"
				+ "| Contact #: %s%s|\n"
				+ "+------------------------------------+\n"
				+ "",name,padding1,address,padding2,contactNum,padding3);
		
		ClearConsoleScreen.pauseThenClearScreen();
		manageDisplay.popDisplay();
	}
	
	private List<JavaATMDAO> getDetails() {
		return jdbcImpl.getUserDetails(transactionProcessor.returnAcctId());
	}
}
