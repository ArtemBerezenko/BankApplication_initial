package com.luxoft.bankapp.model;

import com.luxoft.bankapp.exceptions.NotEnoughFundsException;

import java.util.Map;

public class SavingAccount extends AbstractAccount {

	public SavingAccount(float initialBalance) throws IllegalArgumentException {
		if (initialBalance >= 0) {
			balance = initialBalance;
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void withdraw(float x) throws NotEnoughFundsException {
		if (balance >= x)
			balance -= x;
		else
			throw new NotEnoughFundsException(x);
	}

//	public String getAccountName() {
//		return "Saving Account";
//	}

	public String getAccountName() {
		return "s";
	}


	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}


    public void parseFeed(Map<String,String> feed){
        super.balance = Float.parseFloat(feed.get("balance"));
    }



}
