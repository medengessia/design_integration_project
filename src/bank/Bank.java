package bank;

import java.util.*;
import bank.account.*;
import bank.util.*;

/**
 * 
 * @author Medeng Matthieu
 * 
 * This is a class modelling a bank.
 *
 */

public class Bank {
	
	// The list of accounts in the bank.
	private List<Account> accounts;
	
	/**
	 * A constructor for Bank instances.
	 */
	public Bank () {
		this.accounts = new ArrayList<>();
	}

	/**
	 * Returns the list of accounts in the bank.
	 * @return the list of accounts in the bank.
	 */
	public List<Account> getAccounts() {
		return this.accounts;
	}

	/**
	 * Creates a new account in the list of accounts. 
	 * @param account an account to be added.
	 */
	public void addAccount(Account account) {
		this.accounts.add(account);
	}

	/**
	 * Credits an account in the list according to its index.
	 * @param i the index of the account.
	 * @param amount the amount to credit the account with.
	 * @throws NotExistingAccountException when the index does not exist in the list.
	 * @throws ZeroCreditOrDebitException when the amount is zero.
	 */
	public void creditAccount(int i, double amount) throws NotExistingAccountException, ZeroCreditOrDebitException {
		if (this.getAccounts().size() > i) {
			this.getAccounts().get(i).addCredit(amount);
		} else {
			throw new NotExistingAccountException("This account does not exist!");
		}
	}

	/**
	 * Debits an account in the list according to its index.
	 * @param i the index of the account.
	 * @param amount the amount to credit the account with.
	 * @throws NotExistingAccountException when the index does not exist in the list.
	 * @throws ZeroCreditOrDebitException when the amount is zero.
	 */
	public void debitAccount(int i, double amount) throws NotExistingAccountException, ZeroCreditOrDebitException {
		if (this.getAccounts().size() > i) {
			this.getAccounts().get(i).addDebit(amount);
		} else {
			throw new NotExistingAccountException("This account does not exist!");
		}
	}
	
}
