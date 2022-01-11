package bank;

import java.util.*;
import bank.DebitGreaterThanBalanceException;

/**
 * 
 * @author Medeng Matthieu
 * 
 * This is a class modelling a savings account.
 *
 */

public class SavingsAccount {
	
	// The list of credits 
	private List<Double> credits;
	
	// The list of debits
	private List<Double> debits;
	
	/**
	 * A constructor for SavingsAccount instances.
	 */
	public SavingsAccount () {
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
	 * Adds a credit in the list of credits of a savings account.
	 * @param amount the amount to credit the account with.
	 */
	public void credit(double amount) {
		this.credits.add(amount);
	}

	/**
	 * Returns the balance of a savings account.
	 * @return the balance of a savings account.
	 */
	public double getBalance() {
		double balance = 0;
		for (int i=0; i<this.credits.size(); i++) {
			balance += this.credits.get(i);
		}
		for (int i=0; i<this.debits.size(); i++) {
			balance -= this.debits.get(i);
		}
		return balance;
	}

	/**
	 * Adds a debit in the list of debits of a savings account.
	 * @param amount the amount to debit the account with.
	 * @throws DebitGreaterThanBalanceException when the debit is greater than the balance.
	 */
	public void debit(double amount) throws DebitGreaterThanBalanceException {
		if (this.getBalance() >= amount) {
			this.debits.add(amount);
		}
		else {
			throw new DebitGreaterThanBalanceException("The debit should not be greater than the balance!");
		}
	}

	public Double getInterest() {
		// TODO Auto-generated method stub
		return null;
	}

	public void computeInterest(double rate) {
		// TODO Auto-generated method stub
		
	}
	
}
