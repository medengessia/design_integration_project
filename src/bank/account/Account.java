package bank.account;

import java.util.ArrayList;
import java.util.List;

import bank.util.ZeroCreditOrDebitException;

/**
 * 
 * @author Medeng Matthieu
 * 
 * This is a class modelling a general type of account.
 *
 */

public abstract class Account {
	
	// The list of credits.
	private List<Double> credits;
		
	// The list of debits.
	private List<Double> debits;
	
	/**
	 * A constructor for Account instances.
	 */
	public Account () {
		this.credits = new ArrayList<>();
		this.debits = new ArrayList<>();
	}
	
	/**
	 * Returns the list of credits.
	 * @return the list of credits.
	 */
	public List<Double> getCredits() {
		return this.credits;
	}

	/**
	 * Returns the list of debits.
	 * @return the list of debits.
	 */
	public List<Double> getDebits() {
		return this.debits;
	}
	
	/**
	 * Adds a credit in the list of credits of an account.
	 * @param amount the amount to credit the account with.
	 * @throws ZeroCreditOrDebitException when the amount is zero.
	 */
	public void addCredit(double amount) throws ZeroCreditOrDebitException {
		if (amount == 0) {
			throw new ZeroCreditOrDebitException("A credit of zero is prohibited!");
		} 
		if (amount > 0) {
			this.credits.add(amount);
		}	
	}
	
	/**
	 * Adds a debit in the list of debits of an account.
	 * @param amount the amount to debit the account with.
	 * @throws ZeroCreditOrDebitException when the amount is zero.
	 */
	public void addDebit(double amount) throws ZeroCreditOrDebitException {
		if (amount == 0) {
			throw new ZeroCreditOrDebitException("A debit of zero is prohibited!");
		} 
		if (amount > 0) {
			this.debits.add(amount);
		}
	}
	
	/**
	 * Returns the balance of an account.
	 * @return the balance of an account.
	 */
	public abstract double getBalance();

}
