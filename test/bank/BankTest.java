package bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
		assertEquals(0, bank.getBankAccounts().size());
		assertEquals(0, bank.getSavingsAccounts().size());
	}
	
	@Test
	public void accountsWellCreated () {
		Bank bank = new Bank();
		BankAccount account = new BankAccount();
		SavingsAccount sAccount = new SavingsAccount();
		bank.addAccount(account);
		bank.addAccount(sAccount);
		assertEquals(1, bank.getBankAccounts().size());
		assertEquals(1, bank.getSavingsAccounts().size());
	}
	
}
