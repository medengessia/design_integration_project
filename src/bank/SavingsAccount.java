package bank;

import java.util.*;

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
	
}
