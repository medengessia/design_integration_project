package bank;

import org.junit.*;
import static org.junit.Assert.*;
import bank.util.*;
import bank.account.SavingsAccount;

/**
 * 
 * @author Medeng Matthieu
 * 
 * This is a class meant to test a savings account's behaviour.
 *
 */

public class SavingsAccountTest {
	
	@Test
	public void savingsAccountWellCreated () {
		SavingsAccount sAccount = new SavingsAccount();
		assertEquals(0, sAccount.getCredits().size());
		assertEquals(0, sAccount.getDebits().size());
	}
	
	@Test
	public void creditWellAppliedOnAccount () {
		SavingsAccount sAccount = new SavingsAccount();
		int before = sAccount.getCredits().size();
		double amount = 100;
		try {
			sAccount.addCredit(amount);
		} catch (ZeroCreditOrDebitException e) {
			fail();
		}
		assertEquals(before + 1, sAccount.getCredits().size());
		assertTrue(amount == sAccount.getCredits().get(before));
	}
	
	@Test
	public void balanceCorrectlyComputed () {
		SavingsAccount sAccount = new SavingsAccount();
		assertTrue(0 == sAccount.getBalance());
		double amount1 = 100;
		double amount2 = 200;
		try {
			sAccount.addCredit(amount1);
			sAccount.addCredit(amount2);
		} catch (ZeroCreditOrDebitException e) {
			fail();
		}
		assertTrue(amount1 + amount2 == sAccount.getBalance());
	}
	
	/**
	 * @Test
	 * public void debitGreaterThanBalanceNotApplied () {
	 *     SavingsAccount sAccount = new SavingsAccount();
	 *     assertEquals(0, sAccount.getBalance());
	 *     double amount1 = 100;
	 *     double amount2 = 200;
	 *     sAccount.credit(amount1);
	 *     assertEquals(amount1, sAccount.getBalance());
	 *     sAccount.debit(amount2);
	 *     assertEquals(amount1, sAccount.getBalance());	
	 * }
	 */
	
	@Test(expected = DebitGreaterThanBalanceException.class)
	public void debitGreaterThanBalanceForbidden () throws DebitGreaterThanBalanceException {
		SavingsAccount sAccount = new SavingsAccount();
		assertTrue(0 == sAccount.getBalance());
		double amount = 100;
		try {
			sAccount.addDebitForSavings(amount);
		} catch (ZeroCreditOrDebitException e) {
			fail();
		}
	}
	
	@Test
	public void interestCorrectlyComputed () {
		SavingsAccount sAccount = new SavingsAccount();
		assertTrue(0 == sAccount.getInterest());
		double rate = 1.75;
		double amount = 10000;
		try {
			sAccount.addCredit(amount);
		} catch (ZeroCreditOrDebitException e) {
			fail();
		}
		sAccount.computeInterest(rate);
		assertTrue((amount*rate)/100 == sAccount.getInterest());
	}
	
	@Test
	public void interestAreProperlyCredited () {
		SavingsAccount sAccount = new SavingsAccount();
		double rate = 1.75;
		double amount = 10000;
		try {
			sAccount.addCredit(amount);
		} catch (ZeroCreditOrDebitException e) {
			fail();
		}
		assertTrue(amount == sAccount.getBalance());
		sAccount.echeance(rate);
		assertTrue(amount + (amount*rate)/100 == sAccount.getFinalBalance());
	}
	
	public static junit.framework.Test suite() {
	      return new junit.framework.JUnit4TestAdapter(SavingsAccountTest.class);
	  }

}
