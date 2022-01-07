package bank;

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
	private double[] credits;
	
	// The table of debits.
	private double[] debits;
	
	// The capacity of both tables.
	private static final int CAPACITY = 20;
	
	/**
	 * A constructor for BankAccount instances.
	 */
	public BankAccount () {
		this.credit = 0;
		this.debit = 0;
		this.credits = new double[CAPACITY];
		this.debits = new double[CAPACITY];
		for (int i=0; i<CAPACITY; i++) {
			this.credits[i] = 0;
			this.debits[i] = 0;
		}
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
	 * Returns the capacity of the tables.
	 * @return the capacity of the tables.
	 */
	public int getCapacity() {
		return CAPACITY;
	}
	
	/**
	 * Returns the table of credits.
	 * @return the table of credits.
	 */
	public double[] getCredits() {
		return this.credits;
	}

	/**
	 * Returns the table of debits.
	 * @return the table of debits.
	 */
	public double[] getDebits() {
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
		if (amount > 0) {
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
		if (amount > 0) {
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
		if (amount > 0) {
			int i = 0;
			while (i<CAPACITY && this.credits[i] != 0) {
				i += 1;
			}
			if (i < CAPACITY) {
				this.credits[i] = amount;
			}
			else {
				initialiseTable(this.credits);
				this.credits[1] = amount;
			}
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
		if (amount > 0) {
			int i = 0;
			while (i<CAPACITY && this.debits[i] != 0) {
				i += 1;
			}
			if (i < CAPACITY) {
				this.debits[i] = amount;
			}
			else {
				initialiseTable(this.debits);
				this.debits[1] = amount;
			}
		}
	}
	
	/**
	 * Initialises a table so that the first element becomes the sum of all former elements, whose places return to zero.
	 * @param table the table to initialise.
	 */
	private void initialiseTable (double[] table) {
		int sum = 0;
		for (int i=0; i<CAPACITY; i++) {
			sum += table[i];
		}
		table[0] = sum;
		for (int i=1; i<CAPACITY; i++) {
			table[i] = 0;
		}
	}

}
