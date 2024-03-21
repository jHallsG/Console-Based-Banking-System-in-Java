package com.JavaATM.main;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.JavaATM.api.JDBCImplementation;
import com.JavaATM.displays.BalanceDisplay;
import com.JavaATM.displays.ChangePasswordDisplay;
import com.JavaATM.displays.ConsoleDisplays;
import com.JavaATM.displays.DepositDisplay;
import com.JavaATM.displays.DisclaimerDisplay;
import com.JavaATM.displays.EditDisplay;
import com.JavaATM.displays.LoginDisplay;
import com.JavaATM.displays.ManageDisplay;
import com.JavaATM.displays.MoneyTransferDisplay;
import com.JavaATM.displays.RegisterDisplay;
import com.JavaATM.displays.UserDisplay;
import com.JavaATM.displays.ViewTransactionsDisplay;
import com.JavaATM.displays.WelcomeDisplay;

public abstract class ParentClass implements ConsoleDisplays{
	
	protected Scanner scan = new Scanner(System.in);
	protected ManageDisplay manageDisplay;
	protected ChangePasswordDisplay changePasswordDisplay;
	protected DepositDisplay depositDisplay;
	protected DisclaimerDisplay disclaimerDisplay;
	protected EditDisplay editDisplay;
	protected LoginDisplay loginDisplay;
	protected MoneyTransferDisplay moneyTransferDisplay;
	protected RegisterDisplay registerDisplay;
	protected UserDisplay userDisplay;
	protected ViewTransactionsDisplay viewTransactionsDisplay;
	protected WelcomeDisplay welcomeDisplay;
	protected BalanceDisplay balanceDisplay;
	protected JDBCImplementation jdbcImpl;
	
	public ParentClass() {};
	
	// Constructor for Register Page
	@Autowired
	public ParentClass(ManageDisplay manageDisplay, JDBCImplementation jdbcImpl) {
		this.manageDisplay = manageDisplay;
		this.jdbcImpl = jdbcImpl;
	}
	
	// Constructor for Login Page
	@Autowired
	public ParentClass(ManageDisplay manageDisplay, UserDisplay userDisplay, JDBCImplementation jdbcImpl) {
		this.manageDisplay = manageDisplay;
		this.userDisplay = userDisplay;
		this.jdbcImpl = jdbcImpl;
	}
	
	@Autowired
	public ParentClass(ManageDisplay manageDisplay, LoginDisplay loginDisplay, RegisterDisplay registerDisplay) {
		this.manageDisplay = manageDisplay;
		this.loginDisplay = loginDisplay;
		this.registerDisplay = registerDisplay;
	}
	
	
	
	@Autowired
	public ParentClass(ManageDisplay manageDisplay, WelcomeDisplay welcomeDisplay) {
		this.manageDisplay = manageDisplay;
		this.welcomeDisplay = welcomeDisplay;
	}

	public ParentClass(ManageDisplay manageDisplay, EditDisplay editDisplay, BalanceDisplay balanceDisplay, DepositDisplay depositDisplay) {
		this.manageDisplay = manageDisplay;
		this.balanceDisplay = balanceDisplay;
		this.editDisplay = editDisplay;
		this.depositDisplay = depositDisplay;
	}

	@Override
    public abstract void show();
}
