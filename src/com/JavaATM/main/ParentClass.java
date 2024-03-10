package com.JavaATM.main;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

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
	
	@Autowired
	public ParentClass(ManageDisplay manageDisplay, LoginDisplay loginDisplay, RegisterDisplay registerDisplay) {
		this.manageDisplay = manageDisplay;
		this.loginDisplay = loginDisplay;
		this.registerDisplay = registerDisplay;
	}
	
	@Autowired
	public ParentClass(ManageDisplay manageDisplay, UserDisplay userDisplay) {
		this.manageDisplay = manageDisplay;
		this.userDisplay = userDisplay;
	}
	
	@Autowired
	public ParentClass(ManageDisplay manageDisplay, WelcomeDisplay welcomeDisplay) {
		this.manageDisplay = manageDisplay;
		this.welcomeDisplay = welcomeDisplay;
	}
	
	@Autowired
	public ParentClass(ManageDisplay manageDisplay, EditDisplay editDisplay) {
		this.manageDisplay = manageDisplay;
		this.editDisplay = editDisplay;
	}

	@Override
    public abstract void show();
}
