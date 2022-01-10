package bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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

}
