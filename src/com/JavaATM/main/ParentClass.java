package com.JavaATM.main;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import com.JavaATM.api.JDBCImplementation;
import com.JavaATM.displays.BalanceDisplay;
import com.JavaATM.displays.ChangePasswordDisplay;
import com.JavaATM.displays.ConsoleDisplays;
import com.JavaATM.displays.DepositDisplay;
import com.JavaATM.displays.DisclaimerDisplay;
import com.JavaATM.displays.EditDisplay;
import com.JavaATM.displays.EditUserDetailsDisplay;
import com.JavaATM.displays.LoginDisplay;
import com.JavaATM.displays.ManageDisplay;
import com.JavaATM.displays.MoneyTransferDisplay;
import com.JavaATM.displays.RegisterDisplay;
import com.JavaATM.displays.MainDisplay;
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
	protected MainDisplay userDisplay;
	protected ViewTransactionsDisplay viewTransactionsDisplay;
	protected WelcomeDisplay welcomeDisplay;
	protected BalanceDisplay balanceDisplay;
	protected JDBCImplementation jdbcImpl;
	protected EditUserDetailsDisplay editUserDetailsDisplay;
	
	public ParentClass() {};
	
	// Constructor for Register Page , Edit User Details Page
	@Autowired
	public ParentClass(ManageDisplay manageDisplay, JDBCImplementation jdbcImpl) {
		this.manageDisplay = manageDisplay;
		this.jdbcImpl = jdbcImpl;
	}
	
	// Constructor for Login Page
	@Autowired
	public ParentClass(ManageDisplay manageDisplay, MainDisplay userDisplay, JDBCImplementation jdbcImpl) {
		this.manageDisplay = manageDisplay;
		this.userDisplay = userDisplay;
		this.jdbcImpl = jdbcImpl;
	}
	
	// Constructor for Main Page
	@Autowired
	public ParentClass(ManageDisplay manageDisplay, EditDisplay editDisplay, BalanceDisplay balanceDisplay, DepositDisplay depositDisplay) {
		this.manageDisplay = manageDisplay;
		this.editDisplay = editDisplay;
		this.balanceDisplay = balanceDisplay;
		this.depositDisplay = depositDisplay;
	}
	
	// Constructor for Disclaimer Page
	@Autowired
	public ParentClass(ManageDisplay manageDisplay, WelcomeDisplay welcomeDisplay) {
		this.manageDisplay = manageDisplay;
		this.welcomeDisplay = welcomeDisplay;
	}
	
	// Constructor for Welcome Page
	@Autowired
	public ParentClass(ManageDisplay manageDisplay, LoginDisplay loginDisplay, RegisterDisplay registerDisplay) {
		this.manageDisplay = manageDisplay;
		this.loginDisplay = loginDisplay;
		this.registerDisplay = registerDisplay;
	}
	
	// Constructor for Edit Display
	public ParentClass(ChangePasswordDisplay changePasswordDisplay, EditUserDetailsDisplay editUserDetailsDisplay, ManageDisplay manageDisplay) {
		this.manageDisplay = manageDisplay;
		this.changePasswordDisplay = changePasswordDisplay;
		this.editUserDetailsDisplay = editUserDetailsDisplay;
	}
	
	@Override
    public abstract void show();
}
