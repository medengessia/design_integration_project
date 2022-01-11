package bank;

import java.util.*;

/**
 * 
 * @author Medeng Matthieu
 * 
 * This is a class modelling a bank.
 *
 */

public class Bank {
	
	// The list of bank accounts in the bank.
	private List<BankAccount> bankAccounts;
	
	// The list of savings accounts in the bank.
	private List<SavingsAccount> savingsAccounts;
	
	/**
	 * A constructor for Bank instances.
	 */
	public Bank () {
		this.bankAccounts = new ArrayList<>();
		this.savingsAccounts = new ArrayList<>();
	}

	/**
	 * Returns the list of bank accounts in the bank.
	 * @return the list of bank accounts in the bank.
	 */
	public List<BankAccount> getBankAccounts() {
		return this.bankAccounts;
	}

	/**
	 * Returns the list of savings accounts in the bank.
	 * @return the list of savings accounts in the bank.
	 */
	public List<SavingsAccount> getSavingsAccounts() {
		return this.savingsAccounts;
	}
	
	

}
