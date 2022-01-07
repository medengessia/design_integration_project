package bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
		assertEquals(0, account.getCredit());
		assertEquals(0, account.getDebit());
		for (int i=0; i<account.getCapacity(); i++) {
			assertEquals(0, account.getCredits()[i]);
			assertEquals(0, account.getDebits()[i]);
		}
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
		assertEquals(amount, account.getCredit() - before);
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
		assertEquals(amount, before - account.getDebit());
	}
	
	@Test
	public void negativeAmountNotApplied () {
		BankAccount account = new BankAccount();
		double amount = -100;
		try {
			account.credit(amount);
			account.debit(amount);
		} catch (ZeroCreditOrDebitException e) {
			fail();
		}
		assertEquals(0, account.getCredit());
		assertEquals(0, account.getDebit());
	}
	
	@Test
	public void balanceCorrectlyComputed () {
		BankAccount account = new BankAccount();
		assertEquals(0, account.getBalance());
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
		assertEquals(account.getBalance(), account.getCredit() + account.getDebit());
	}
	
	@Test
	public void creditDebitAccumulation () {
		BankAccount account = new BankAccount();
		
		// Firstly, check the tables of credits and debits have the expected length.
		assertEquals(account.getCapacity(), account.getCredits().length);
		assertEquals(account.getCapacity(), account.getDebits().length);
		
		// Secondly, check there are no credits nor debits within the account.
		for (int i=0; i<account.getCapacity(); i++) {
			assertEquals(0, account.getCredits()[i]);
			assertEquals(0, account.getDebits()[i]);
		}
		
		// Thirdly, credit and debit the account till the capacity is exceeded
		double amount1 = 100;
		double amount2 = 50;
		for (int i=0; i<account.getCapacity()+1; i++) {
			try {
				account.addCredit(amount1);
				account.addDebit(amount2);
			} catch (ZeroCreditOrDebitException e) {
				fail();
			}
		}
		
		// Fourthly, check the first elements in the tables of credits and debits are the sum of the former ones. 
		assertEquals(amount1*account.getCapacity(), account.getCredits()[0]);
		assertEquals(amount2*account.getCapacity(), account.getDebits()[0]);
		
		// Fifthly, check the second elements in the tables are the new amounts credited or debited.
		assertEquals(amount1, account.getCredits()[1]);
		assertEquals(amount2, account.getDebits()[1]);
		
		// Finally, check the rest of the elements of both tables have returned to zero.
		for (int i=2; i<account.getCapacity(); i++) {
			assertEquals(0, account.getCredits()[i]);
			assertEquals(0, account.getDebits()[i]);
		}
	}
	
	@Test
	public void zeroCreditOrDebitIsForbidden () {
		BankAccount account = new BankAccount();
		assertThrows(ZeroCreditOrDebitException.class, () -> {account.credit(0);});
		assertThrows(ZeroCreditOrDebitException.class, () -> {account.debit(0);});
		assertThrows(ZeroCreditOrDebitException.class, () -> {account.addCredit(0);});
		assertThrows(ZeroCreditOrDebitException.class, () -> {account.addDebit(0);});
	}
	
	@Test
	public void creditOrDebitNotExceeding () {
		BankAccount account = new BankAccount();
		double amount = 100000;
		try {
			account.credit(amount);
			account.debit(amount*2);
			account.addCredit(amount*3);
			account.addDebit(amount*4);
		} catch (ZeroCreditOrDebitException e) {
			fail();
		}
		assertEquals(0, account.getCredit());
		assertEquals(0, account.getDebit());
		for (int i=0; i<account.getCapacity(); i++) {
			assertEquals(0, account.getCredits()[i]);
			assertEquals(0, account.getDebits()[i]);
		}
	}
	
}
