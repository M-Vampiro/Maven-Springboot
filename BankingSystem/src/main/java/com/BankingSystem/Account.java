package com.BankingSystem;

import java.math.BigDecimal;

public abstract class Account implements AccountInterface {
	private AccountHolder accountHolder;
	private Long accountNumber;
	private int pin;
	private double balance;

	protected Account(AccountHolder accountHolder, Long accountNumber, int pin, double startingDeposit) {
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.balance = startingDeposit;
	}

	public AccountHolder getAccountHolder() {
		// complete the function
		return this.accountHolder;
	}

	public boolean validatePin(int attemptedPin) {
		// complete the function
		return attemptedPin == this.pin;
	}

	public double getBalance() {
		// complete the function
		return this.balance;
	}

	public double getPin() {
		// complete the function
		return this.pin;
	}

	public Long getAccountNumber() {
		// complete the function
		return this.accountNumber;
	}

	public void creditAccount(double amount) {
		// complete the function
		// BigDecimal
		this.balance = BigDecimal.valueOf(this.balance).add(BigDecimal.valueOf(amount)).doubleValue();
	}

	public boolean debitAccount(double amount) {
		// complete the function
		return amount <= this.balance;
	}
}