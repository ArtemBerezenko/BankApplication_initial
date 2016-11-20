package com.luxoft.bankapp.model;

import com.luxoft.bankapp.exceptions.NotEnoughFundsException;

import java.util.Map;

public interface Account extends Report {
	public String getAccountName();

	public float getBalance();

	public void deposit(float x) throws IllegalArgumentException;

	public void withdraw(float x) throws NotEnoughFundsException;

	public void parseFeed(Map<String,String> feed);
	
}
