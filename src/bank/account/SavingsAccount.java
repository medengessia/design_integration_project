package bank.account;

import java.util.*;
import bank.util.DebitGreaterThanBalanceException;

/**
 * 
 * @author Medeng Matthieu
 * 
 * This is a class modelling a savings account.
 *
 */

public class SavingsAccount {
	
	// The list of credits.
	private List<Double> credits;
	
	// The list of debits.
	private List<Double> debits;
	
	// The interest computed as a bonus for the account.
	private double interest;
	
	// The balance of the account.
	private double finalBalance;
	
	/**
	 * A constructor for SavingsAccount instances.
	 */
	public SavingsAccount () {
		this.credits = new ArrayList<>();
		this.debits = new ArrayList<>();
		this.interest = 0;
		this.finalBalance = 0;
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
	 * Returns the interest of a savings account.
	 * @return the interest of a savings account.
	 */
	public double getInterest() {
		return this.interest;
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

	/**
	 * Computes the interest of a savings account at the end of a year according to its balance and a rate of interest.
	 * @param rate the rate of interest.
	 */
	public void computeInterest(double rate) {
		if(rate >= 0 && rate < 100) {
			this.interest = (this.getBalance()*rate)/100;
		}
	}

	/**
	 * Computes the balance of a savings account at the end of a year according to its former balance and a rate of interest.
	 * @param rate the rate of interest.
	 */
	public void echeance(double rate) {
		this.computeInterest(rate);
		this.finalBalance += this.interest;
	}

	/**
	 * Returns the balance of a savings account at the end of a year.
	 * @return the balance of a savings account at the end of a year.
	 */
	public double getFinalBalance() {
		return this.finalBalance + this.getBalance();
	}
	
}
