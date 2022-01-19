package bank.account;

import bank.util.DebitGreaterThanBalanceException;
import bank.util.ZeroCreditOrDebitException;

/**
 * 
 * @author Medeng Matthieu
 * 
 * This is a class modelling a savings account.
 *
 */

public class SavingsAccount extends Account {
	
	// The interest computed as a bonus for the account.
	private double interest;
	
	// The balance of the account.
	private double finalBalance;
	
	/**
	 * A constructor for SavingsAccount instances.
	 */
	public SavingsAccount () {
		super();
		this.interest = 0;
		this.finalBalance = 0;
	}
	
	/**
	 * Returns the interest of a savings account.
	 * @return the interest of a savings account.
	 */
	public double getInterest() {
		return this.interest;
	}

	/**
	 * Returns the balance of a savings account.
	 * @return the balance of a savings account.
	 */
	public double getBalance() {
		double balance = 0;
		for (int i=0; i<super.getCredits().size(); i++) {
			balance += super.getCredits().get(i);
		}
		for (int i=0; i<super.getDebits().size(); i++) {
			balance -= super.getDebits().get(i);
		}
		return balance;
	}

	/**
	 * Adds a debit in the list of debits of a savings account.
	 * @param amount the amount to debit the account with.
	 * @throws DebitGreaterThanBalanceException when the debit is greater than the balance.
	 * @throws ZeroCreditOrDebitException when the amount is zero.
	 */
	public void addDebitForSavings(double amount) throws DebitGreaterThanBalanceException, ZeroCreditOrDebitException {
		if (this.getBalance() >= amount) {
			super.addDebit(amount);
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
