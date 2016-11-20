package com.luxoft.bankapp.model;

import com.luxoft.bankapp.exceptions.OverDraftLimitExceededException;

import java.util.Map;

public class CheckingAccount extends AbstractAccount {
	private float overdraft;

	public CheckingAccount(float overdraft) throws IllegalArgumentException {
		if (overdraft >= 0) {
			this.overdraft = overdraft;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void setOverdraft(float x) throws IllegalArgumentException {
		if (x >= 0) {
			overdraft = x;
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void withdraw(float x) throws OverDraftLimitExceededException {
		if (balance + overdraft > x) {
			balance -= x;
		} else {
			throw new OverDraftLimitExceededException(getAccountName(), balance
					+ overdraft);
		}
	}

//	public String getAccountName() {
//		return "Checking Account";
//	}

	public String getAccountName() {
		return "c";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CheckingAccount)) return false;
		if (!super.equals(o)) return false;

		CheckingAccount that = (CheckingAccount) o;

		return Float.compare(that.overdraft, overdraft) == 0;

	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (overdraft != +0.0f ? Float.floatToIntBits(overdraft) : 0);
		return result;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(this.getAccountName() +
				" balance=" + balance + " overdraft=" + overdraft);
		return str.toString();
	}

	public void parseFeed(Map<String,String> feed){
		this.overdraft = Float.parseFloat(feed.get("overdraft"));
		super.balance = Float.parseFloat(feed.get("balance"));
	}
}
