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
	private float credit;
	
	// The debit available on an account.
	private float debit;
	
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
	public float getCredit() {
		return this.credit;
	}

	/**
	 * Returns the debit available on an account.
	 * @return the debit available on an account.
	 */
	public float getDebit() {
		return this.debit;
	}

	/**
	 * Adds a certain amount to an account.
	 * @param amount the amount to credit an account with.
	 */
	public void credit(float amount) {
		this.credit += amount;
	}

	/**
	 * Removes a certain amount to an account.
	 * @param amount the amount to debit an account with.
	 */
	public void debit(float amount) {
		this.debit -= amount;
	}

}
