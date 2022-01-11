package bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
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
		sAccount.credit(amount);
		assertEquals(before + 1, sAccount.getCredits().size());
		assertEquals(amount, sAccount.getCredits().get(before));
	}
	
	@Test
	public void balanceCorrectlyComputed () {
		SavingsAccount sAccount = new SavingsAccount();
		assertEquals(0, sAccount.getBalance());
		double amount1 = 100;
		double amount2 = 200;
		sAccount.credit(amount1);
		sAccount.credit(amount2);
		assertEquals(amount1 + amount2, sAccount.getBalance());
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
	
	@Test
	public void debitGreaterThanBalanceForbidden () {
		SavingsAccount sAccount = new SavingsAccount();
		assertEquals(0, sAccount.getBalance());
		double amount = 100;
		assertThrows(DebitGreaterThanBalanceException.class, () -> {sAccount.debit(amount);});
	}
	
	@Test
	public void interestCorrectlyComputed () {
		SavingsAccount sAccount = new SavingsAccount();
		assertEquals(0, sAccount.getInterest());
		double rate = 1.75;
		double amount = 10000;
		sAccount.credit(amount);
		sAccount.computeInterest(rate);
		assertEquals((amount*rate)/100, sAccount.getInterest());
	}
	
	@Test
	public void interestAreProperlyCredited () {
		SavingsAccount sAccount = new SavingsAccount();
		double rate = 1.75;
		double amount = 10000;
		sAccount.credit(amount);
		assertEquals(amount, sAccount.getBalance());
		sAccount.echeance(rate);
		assertEquals(amount + (amount*rate)/100, sAccount.getFinalBalance());
	}

}
