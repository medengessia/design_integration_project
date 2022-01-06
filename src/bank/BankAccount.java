package bank;

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
	
	/**
	 * A constructor for BankAccount instances.
	 */
	public BankAccount () {
		this.credit = 0;
		this.debit = 0;
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
	 * Adds a certain amount to an account.
	 * @param amount the amount to credit an account with.
	 */
	public void credit(double amount) {
		if (amount > 0) {
			this.credit += amount;
		}
	}

	/**
	 * Removes a certain amount to an account.
	 * @param amount the amount to debit an account with.
	 */
	public void debit(double amount) {
		if (amount > 0) {
			this.debit -= amount;
		}
	}

	public double[] getCredits() {
		// TODO Auto-generated method stub
		return null;
	}

	public double[] getDebits() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addCredit(double amount1) {
		// TODO Auto-generated method stub
		
	}

	public void addDebit(double amount2) {
		// TODO Auto-generated method stub
		
	}

	public int getCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}

}
