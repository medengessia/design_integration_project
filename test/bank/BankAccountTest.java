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
}
