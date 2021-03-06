package com.luxoft.bankapp.model;

import java.util.*;

import com.luxoft.bankapp.exceptions.NotEnoughFundsException;

public class Client implements Report {
	private String name;
//	private List<Account> accounts = new ArrayList<Account>();
	private Account activeAccount;
	private float initialOverdraft;
	private float initialBalance;
	private Gender gender;
	Set<Account> accounts = new HashSet<>();


	public enum Gender {
		MALE("Mr"), FEMALE("Ms");

		private String prefix;

		public void setPrefix(String prefix) {
			this.prefix = prefix;
		}

		String getSalutation() {
			return prefix;
		}

		Gender(String prefix) {
			this.prefix = prefix;
		}

	}
	public String getGender() { return gender==Gender.MALE?"m":"f"; }

	public void setGender(String gender) {
		if(gender.equals("m"))
			this.gender = Gender.MALE;
		else
			this.gender = Gender.FEMALE;
	}

//	public Client(String name, float initialOverdraft, Gender gender) {
//		this.name = name;
//		this.initialOverdraft = initialOverdraft;
//		this.gender = gender;
//	}

//	public Client(String name, Gender gender) {
//		this(name, 0, gender);
//	}


	public Client(String name) {
		this.name = name;
	}


	public float getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(float initialBalance) {
		this.initialBalance = initialBalance;
	}

	public void setInitialOverdraft(float initialOverdraft) {
		this.initialOverdraft = initialOverdraft;
	}

	public void setActiveAccount(Account activeAccount) {
		this.activeAccount = activeAccount;
	}

	public Account getActiveAccount() {
		return activeAccount;
	}

	public String getName() {
		return this.name;
	}

	public float getBalance() {
		return activeAccount.getBalance();

	}

//	public List<Account> getAccounts() {
//		return accounts;
//	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void addAccount(Account account) {
		accounts.add(account);
	}

	public void deposit(float x) throws IllegalArgumentException {
		activeAccount.deposit(x);
	}

	public void withdraw(float x) throws NotEnoughFundsException {
		activeAccount.withdraw(x);
	}

	public Account createAccount(String accountType) {
		switch (accountType) {
			case "Saving": {
				return new SavingAccount(initialBalance);
			}
			case "Checking": {
				return new CheckingAccount(initialOverdraft);
			}
			default: {
				return null;
			}
		}
	}

	public void printReport() {
		System.out.println("Name : " + this.getClientSalutation() + " " + name);
		for (Account a : accounts) {
			System.out.print(a.getAccountName() + " balance: " + a.getBalance()
					+ " ");
		}
		System.out.println();

	}

	public String getClientSalutation() {
		return gender.getSalutation();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Client client = (Client) o;

		if (Float.compare(client.initialOverdraft, initialOverdraft) != 0) return false;
		if (!name.equals(client.name)) return false;
		return gender == client.gender;

	}

	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 31 * result + (initialOverdraft != +0.0f ? Float.floatToIntBits(initialOverdraft) : 0);
		result = 31 * result + gender.hashCode();
		return result;
	}

	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("Client: " + this.getClientSalutation() + " " + this.getName());
		for(Account account : accounts){
			str.append(" Account: " + account.toString());
		}
		str.append("\n");
		return str.toString();
	}


	private Account getAccount(String accountType){
		for (Account acc: accounts) {
			if (acc.getAccountName().equals(accountType)) {
				return acc;
			}
		}
		return createNewAccount(accountType);
	}

	private Account createNewAccount(String accountType) {
		Account acc;
		if ("s".equals(accountType)) {
			acc = new SavingAccount(initialBalance);
		} else if ("c".equals(accountType)) {
			acc = new CheckingAccount(initialOverdraft);
		} else {
			throw new IllegalArgumentException("Account type not found "+
					accountType);
		}
		accounts.add(acc);
		return acc;
	}

	public void parseFeed(Map<String, String> feed) {
		String accountType = feed.get("accounttype");
		Account acc;
			acc = getAccount(accountType);
			setActiveAccount(acc);
			acc.parseFeed(feed);
		}
	

}
