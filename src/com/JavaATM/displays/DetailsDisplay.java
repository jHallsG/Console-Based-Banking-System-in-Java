package com.JavaATM.displays;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import com.JavaATM.dao.JavaATMDAO;
import com.JavaATM.main.ClearConsoleScreen;
import com.JavaATM.main.ParentClass;

public class DetailsDisplay extends ParentClass{

	@Lazy
	@Autowired
	LoginDisplay loginDisplay;
	
	
	@Override
	public void show() {
		String name = null;
		String address = null;
		String contactNum = null;
		
		List<JavaATMDAO> dao = jdbcImpl.getUserDetails(loginDisplay.getAcctId());
		for (JavaATMDAO items : dao) {
			name = items.getName();
			address = items.getAddress();
			contactNum = items.getContact_number();
		}
		
		System.out.printf(""
				+ "+------------------------------------+\n"
				+ "|            USER DETAILS            |\n"
				+ "+------------------------------------+\n"
				+ "|  Name: %s                          |\n"
				+ "|  Address: %s                       |\n"
				+ "|  Contact Number: %s                |\n"
				+ "+------------------------------------+\n",name,address,contactNum);
		
		ClearConsoleScreen.pauseThenClearScreen();
		manageDisplay.popDisplay();
	}
}
