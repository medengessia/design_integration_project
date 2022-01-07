package bank;

import java.util.*;
import bank.ZeroCreditOrDebitException;

/**
 * 
 * @author Medeng Matthieu
 * 
 * This is a class modelling a bank account.
 *
 */

public class BankAccount {
	
	// The credit available on an account.
	private double credit;
	
	// The debit available on an account.
	private double debit;
	
	// The table of credits.
	private List<Double> credits;
	
	// The table of debits.
	private List<Double> debits;
	
	// The maximal allowed amount to credit or debit an account.
	public static final double MAX_AMOUNT = 100000;
	
	/**
	 * A constructor for BankAccount instances.
	 */
	public BankAccount () {
		this.credit = 0;
		this.debit = 0;
		this.credits = new ArrayList<>();
		this.debits = new ArrayList<>();
	}

	/**
	 * Returns the credit available on an account.
	 * @return the credit available on an account.
	 */
	public double getCredit() {
		return this.credit;
	}

	/**
	 * Returns the debit available on an account.
	 * @return the debit available on an account.
	 */
	public double getDebit() {
		return this.debit;
	}
	
	/**
	 * Returns the balance of an account.
	 * @return the balance of an account.
	 */
	public double getBalance() {
		return this.credit + this.debit;
	}
	
	/**
	 * Returns the table of credits.
	 * @return the table of credits.
	 */
	public List<Double> getCredits() {
		return this.credits;
	}

	/**
	 * Returns the table of debits.
	 * @return the table of debits.
	 */
	public List<Double> getDebits() {
		return this.debits;
	}
	
	/**
	 * Adds a certain amount to an account.
	 * @param amount the amount to credit an account with.
	 * @throws ZeroCreditOrDebitException when the amount is zero.
	 */
	public void credit(double amount) throws ZeroCreditOrDebitException {
		if (amount == 0) {
			throw new ZeroCreditOrDebitException("A credit of zero is prohibited!");
		}
		if (amount > 0 && amount <= MAX_AMOUNT) {
			this.credit += amount;
		}
	}

	/**
	 * Removes a certain amount to an account.
	 * @param amount the amount to debit an account with.
	 * @throws ZeroCreditOrDebitException when the amount is zero.
	 */
	public void debit(double amount) throws ZeroCreditOrDebitException {
		if (amount == 0) {
			throw new ZeroCreditOrDebitException("A debit of zero is prohibited!");
		}
		if (amount > 0 && amount <= MAX_AMOUNT) {
			this.debit -= amount;
		}
	}

	/**
	 * Adds a credit to an account's table of credits.
	 * @param amount the amount to credit an account with.
	 * @throws ZeroCreditOrDebitException when the amount is zero.
	 */
	public void addCredit(double amount) throws ZeroCreditOrDebitException {
		if (amount == 0) {
			throw new ZeroCreditOrDebitException("A credit of zero is prohibited!");
		}
		if (amount > 0 && amount <= MAX_AMOUNT) {
			this.credits.add(amount);
		}
	}

	/**
	 * Adds a debit to an account's table of debits.
	 * @param amount the amount to debit an account with.
	 * @throws ZeroCreditOrDebitException when the amount is zero.
	 */
	public void addDebit(double amount) throws ZeroCreditOrDebitException {
		if (amount == 0) {
			throw new ZeroCreditOrDebitException("A debit of zero is prohibited!");
		}
		if (amount > 0 && amount <= MAX_AMOUNT) {
			this.debits.add(amount);
		}
	}

}
