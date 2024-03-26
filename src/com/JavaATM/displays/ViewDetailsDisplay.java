package com.JavaATM.displays;

import com.JavaATM.main.ClearConsoleScreen;
import com.JavaATM.main.ParentClass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.JavaATM.api.JDBCImplementation;
import com.JavaATM.dao.JavaATMDAO;

@Component
public class ViewDetailsDisplay extends ParentClass{

	@Lazy
	@Autowired
	LoginDisplay loginDisplay;
	
	@Autowired
	JDBCImplementation jdbcImpl;
	
	@Autowired
	ManageDisplay manageDisplay;
	
	@Override
	public void show() {
		String name = null, address = null, contactNum = null;
		
		for (JavaATMDAO item: getDetails()) {
			name = item.getName();
			address = item.getAddress();
			contactNum = item.getContact_number();
		}
		
		String padding1 = " ".repeat(29-name.length());
		String padding2 = " ".repeat(26-address.length());
		String padding3 = " ".repeat(24-contactNum.length());
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
//		return jdbcImpl.getUserDetails(loginDisplay.getAcctId());
		return jdbcImpl.getUserDetails(1);
	}
}
