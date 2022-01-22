package bank;

import org.junit.*;
import static org.junit.Assert.*;
import bank.util.*;
import bank.account.BankAccount;

/**
 * 
 * @author Medeng Matthieu
 * 
 * This is a class meant to test a bank account's behaviour.
 *
 */

public class BankAccountTest {
	
	@Test
	public void accountWellCreated () {
		BankAccount account = new BankAccount();
		assertTrue(0 == account.getCredit());
		assertTrue(0 == account.getDebit());
		assertEquals(0, account.getCredits().size());
		assertEquals(0, account.getDebits().size());
	}
	
	@Test
	public void creditWellAppliedOnAccount () {
		BankAccount account = new BankAccount();
		double before = account.getCredit();
		double amount = 100;
		try {
			account.credit(amount);
		} catch (ZeroCreditOrDebitException e) {
			fail();
		}
		assertTrue(amount == account.getCredit() - before);
	}
	
	@Test
	public void debitWellAppliedOnAccount () {
		BankAccount account = new BankAccount();
		double before = account.getDebit();
		double amount = 100;
		try {
			account.debit(amount);
		} catch (ZeroCreditOrDebitException e) {
			fail();
		}
		assertTrue(amount == before - account.getDebit());
	}
	
	@Test
	public void negativeAmountNotApplied () {
		BankAccount account = new BankAccount();
		double amount = -100;
		try {
			account.credit(amount);
			account.debit(amount);
			account.addCredit(amount);
			account.addDebit(amount);
		} catch (ZeroCreditOrDebitException e) {
			fail();
		}
		assertTrue(0 == account.getCredit());
		assertTrue(0 == account.getDebit());
		assertEquals(0, account.getCredits().size());
		assertEquals(0, account.getDebits().size());
	}
	
	@Test
	public void balanceCorrectlyComputed () {
		BankAccount account = new BankAccount();
		assertTrue(0 == account.getBalance());
		double amount1 = 100;
		double amount2 = 50;
		for (int i=0; i<5; i++) {
			try {
				account.credit(amount1);
				account.debit(amount2);
			} catch (ZeroCreditOrDebitException e) {
				fail();
			}
		}
		assertTrue(account.getBalance() == account.getCredit() + account.getDebit());
	}
	
	@Test(expected = ZeroCreditOrDebitException.class)
	public void zeroCreditOrDebitIsForbidden () throws ZeroCreditOrDebitException {
		BankAccount account = new BankAccount();
		account.credit(0);
		account.debit(0);
		account.addCredit(0);
		account.addDebit(0);
	}
	
	@Test
	public void creditOrDebitNotExceeding () {
		BankAccount account = new BankAccount();
		double amount = 100001;
		try {
			account.credit(amount);
			account.debit(amount*2);
			account.addCredit(amount*3);
			account.addDebit(amount*4);
		} catch (ZeroCreditOrDebitException e) {
			fail();
		}
		assertTrue(0 == account.getCredit());
		assertTrue(0 == account.getDebit());
		assertEquals(0, account.getCredits().size());
		assertEquals(0, account.getDebits().size());
	}
	
	public static junit.framework.Test suite() {
	      return new junit.framework.JUnit4TestAdapter(BankAccountTest.class);
	  }
	
}
