package scp08.replace.errorcode.with.exception;

/**
 * <h3>SMELL: Error Code</h3>
 * <ul>
 *   <li> A method returns a special value that indicates an error.
 *      (Unix tradition)
 * </ul>
 * <h3>TREATMENT: Replace Error Code with Exception</h3>
 * <ul>
 *   <li> Throw an exception instead.
 *   <li> Exceptions clearly separate normal processing from error processing
 *      which makes programs easier to understand.
 * </ul>
 */
public class Demo {
	private int balance;

	int withdraw(int amount) {
		if (amount > balance) {
			return -1;
		}
		else {
			balance -= amount;
			return 0;
		}
	}
}



