package bank;

/**
 * 
 * @author Medeng Matthieu
 * 
 * An exception class that forbids a debit greater than the balance of a savings account.
 *
 */

public class DebitGreaterThanBalanceException extends Exception {
	public DebitGreaterThanBalanceException (String msg) {
		super(msg);
	}
}
