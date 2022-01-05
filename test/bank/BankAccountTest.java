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
	}
	
	@Test
	public void creditWellAppliedOnAccount () {
		BankAccount account = new BankAccount();
		float before = account.getCredit();
		float amount = 100;
		account.credit(amount);
		assertEquals(amount, account.getCredit() - before);
	}
	
	@Test
	public void debitWellAppliedOnAccount () {
		BankAccount account = new BankAccount();
		float before = account.getDebit();
		float amount = 100;
		account.debit(amount);
		assertEquals(amount, before - account.getDebit());
	}
	
	@Test
	public void negativeAmountNotApplied () {
		BankAccount account = new BankAccount();
		float credit = account.getCredit();
		float debit = account.getDebit();
		float amount = -100;
		account.credit(amount);
		account.debit(amount);
		assertEquals(credit, account.getCredit());
		assertEquals(debit, account.getDebit());
	}
}
