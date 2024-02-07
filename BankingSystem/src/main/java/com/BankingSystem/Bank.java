package com.BankingSystem;

import java.util.LinkedHashMap;

public class Bank implements BankInterface{
	private LinkedHashMap<Long, Account> accounts; // object reference

	public Bank() {
		// complete the function
		this.accounts = new LinkedHashMap<>();
	}

	public Account getAccount(Long accountNumber) {
		// complete the function
		return this.accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		// complete the function
		CommercialAccount newAc = new CommercialAccount(company, null, pin, startingDeposit);
		accounts.put(newAc.getAccountNumber(), newAc);
		return newAc.getAccountNumber();
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		// complete the function
		CustomerAccount newAc = new CustomerAccount(person, null, pin, startingDeposit);
		accounts.put(newAc.getAccountNumber(), newAc);
		return newAc.getAccountNumber();
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
		return accounts.get(accountNumber).getPin() == pin;
	}

	public double getBalance(Long accountNumber) {
		// complete the function
		return accounts.get(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
		return false;
	}
}