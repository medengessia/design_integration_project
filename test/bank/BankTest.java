package bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import bank.account.*;
import bank.util.*;

/**
 * 
 * @author Medeng Matthieu
 * 
 * This is a class meant to test a bank's behaviour.
 *
 */

public class BankTest {
	
	@Test
	public void bankCorrectlyCreated () {
		Bank bank = new Bank();
		assertEquals(0, bank.getAccounts().size());
	}
	
	@Test
	public void accountsWellCreated () {
		Bank bank = new Bank();
		Account account = new BankAccount();
		Account sAccount = new SavingsAccount();
		bank.addAccount(account);
		bank.addAccount(sAccount);
		assertEquals(2, bank.getAccounts().size());
	}
	
	@Test
	public void accountsWellCredited () {
		Bank bank = new Bank();
		double amount = 100;
		Account account = new BankAccount();
		bank.addAccount(account);
		assertEquals(0, account.getCredits().size());
		try {
			try {
				bank.creditAccount(0, amount);
			} catch (ZeroCreditOrDebitException e) {
				fail();
			}
		} catch (NotExistingAccountException e) {
			fail();
		}
		assertEquals(1, account.getCredits().size());
		assertEquals(amount, account.getCredits().get(0));
	}
	
	@Test
	public void accountsWellDebited () {
		Bank bank = new Bank();
		Account sAccount = new SavingsAccount();
		double amount1 = 100;
		double amount2 = 50;
		bank.addAccount(sAccount);
		assertEquals(0, sAccount.getDebits().size());
		try {
			try {
				bank.creditAccount(0, amount1);
				bank.debitAccount(0, amount2);
			} catch (ZeroCreditOrDebitException e) {
				fail();
			}
		} catch (NotExistingAccountException e) {
			fail();
		}
		assertEquals(1, sAccount.getDebits().size());
		assertEquals(amount2, sAccount.getDebits().get(0));
	}
	
	@Test
	public void notExistingAccountRejected () {
		Bank bank = new Bank();
		double amount = 100;
		assertThrows(NotExistingAccountException.class, () -> {bank.creditAccount(0, amount);});
		assertThrows(NotExistingAccountException.class, () -> {bank.debitAccount(0, amount);});
	}
	
}
