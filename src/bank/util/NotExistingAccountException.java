package bank.util;

/**
 * 
 * @author Medeng Matthieu
 * 
 * An exception class that is raised when an operation is tried on an account that does not exist.
 *
 */

public class NotExistingAccountException extends Exception {
	public NotExistingAccountException (String msg) {
		super(msg);
	}
}
