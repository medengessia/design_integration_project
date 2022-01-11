package bank.util;

/**
 * 
 * @author Medeng Matthieu
 * 
 * An exception class that forbids the credit or the debit of zero.
 *
 */

public class ZeroCreditOrDebitException extends Exception {
	public ZeroCreditOrDebitException (String msg) {
		super(msg);
	}
}
