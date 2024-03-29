package com.JavaATM.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.JavaATM.api.JDBCImplementation;
import com.JavaATM.displays.LoginDisplay;

@Component
public class TransactionProcessor {
	
	@Autowired
	JDBCImplementation jdbcImpl;
	
	@Lazy
	@Autowired
	LoginDisplay loginDisplay;
	
	//add money to account then save transaction
	public int deposit(int acctId, int depositAmt) {
		if (jdbcImpl.updateBalance(acctId, depositAmt) > 0) {
			saveTransaction(acctId, "deposit", depositAmt);
			return 1;
		} else return 0;
	}
	
	// deduct money from account then save transaction
	public void moneyTransfer(int acctId, int targetId, int transferAmt) {
		deductFromAcct(transferAmt);
		deposit(targetId, transferAmt);
	}
	
	private int deductFromAcct(int transferAmt) {
		if (jdbcImpl.moneyTransfer(returnAcctId(), transferAmt) > 0) {
			saveTransaction(returnAcctId(), "withdrawal", transferAmt);
			return 1;
		} else return 0;
	}
	// store transaction type and date
	private void saveTransaction(int acctId, String transactionType, int amt) {
		jdbcImpl.updateTransaction(acctId, transactionType, amt);
	}

	public int returnAcctId() {
		return loginDisplay.getAcctId(); // can't set acctId as global var. results in "this.LoginDisplay" is null error.
	}
}
