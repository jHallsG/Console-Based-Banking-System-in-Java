package com.JavaATM.dao;

import java.time.LocalDateTime;

public class JavaATMDAO {
	
	private static JavaATMDAO instance = null;
	
//	private JavaATMDAO() {
//		// private to prevent instantiation of this class
//	}
//	
//	public static JavaATMDAO getInstance() {
//		if (instance == null) instance = new JavaATMDAO();
//		return instance;
//	}

	private int account_id;
	private String account_number;
	private int balance;
	private String name;
	private String address;
	private String contact_number;
	private String username;
	private String password;
	private int transaction_id;
	private String transaction_type;
	private Integer amount;
	private LocalDateTime transaction_date;

//	@Override
//	public String toString() {
//		String display =  ""
//				+ "Account ID: " + account_id +"\n"
//				+ "Name: " + name + "\n"
//				+ "Address: " + address + "\n"
//				+ "Contact Number: " + contact_number;
//		return display;
//	}
	
	
	public int getAccount_id() {
		return account_id;
	}

	public String getAccount_number() {
		return account_number;
	}

	public int getBalance() {
		return balance;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getContact_number() {
		return contact_number;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public Integer getAmount() {
		return amount;
	}

	public LocalDateTime getTransaction_date() {
		return transaction_date;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public void setTransaction_date(LocalDateTime transaction_date) {
		this.transaction_date = transaction_date;
	}

}
