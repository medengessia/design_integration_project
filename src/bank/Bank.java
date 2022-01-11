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

	/**
	 * Creates a new account either in the list of bank accounts or in the list of savings accounts. 
	 * @param account an object which must be an instance of BankAccount or SavingsAccount.
	 */
	public void addAccount(Object account) {
		if (account instanceof BankAccount) {
			BankAccount a1 = (BankAccount) account;
			this.bankAccounts.add(a1);
		}
		if (account instanceof SavingsAccount) {
			SavingsAccount a2 = (SavingsAccount) account;
			this.savingsAccounts.add(a2);
		}
	}

	/**
	 * Credits an account in the lists according to its index.
	 * @param account the account whose type is to be identified.
	 * @param i the index of the account.
	 * @param amount the amount to credit the account with.
	 */
	public void creditAccount(Object account, int i, double amount) {
		if (account instanceof BankAccount) {
			try {
				this.getBankAccounts().get(i).addCredit(amount);
			} catch (ZeroCreditOrDebitException e) {
				System.out.println("A credit of zero is prohibited!");
			}
		}
		if (account instanceof SavingsAccount) {
			this.getSavingsAccounts().get(i).credit(amount);
		}
	}

	public void debitAccount(Object account, int i, double amount2) {
		// TODO Auto-generated method stub
		
	}
	
	

}
