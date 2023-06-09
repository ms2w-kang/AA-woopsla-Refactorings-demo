package dry01.extract.method;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>SMELL: Long Method or Code Duplicate Across Methods</h3>
 * <ul>
 *   <li> You have a code fragment that can be grouped together.
 *   <li> You have the same or similar codes.
 * </ul>
 * <h3>TREATMENT: Extract Method</h3>
 * <ul>
 *   <li> Move this code to a separate new method (or function)
 *      and replace the old code with a call to the method.
 * </ul>
 */

public class Customer {
	
	private String name;
	private List<Order> orders = new ArrayList<>();

	public void printOwing() {
		
		// Print banner
		System.out.println("****************************");
		System.out.println("****** Customer Total ******");
		System.out.println("****************************");

		// Print details
		System.out.println("name: " + name);
		System.out.println("amount: " + getOutstanding());
	}

	private double getOutstanding()
	{
		double outstanding = 0.0;
		for (Order order : orders) {
			outstanding += order.getAmount();
		}
		return outstanding;
	}
}
