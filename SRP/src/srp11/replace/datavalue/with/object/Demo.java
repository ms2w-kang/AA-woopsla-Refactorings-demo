package srp11.replace.datavalue.with.object;

import java.util.List;

/**
 * <h3>SMELL: Primitive Obsession</h3>
 * <ul>
 *   <li> A class (or group of classes) contains a data field.
 *      The field has its own behavior and associated data.
 * </ul>
 * <h3>TREATMENT: Replace Data Value with Object</h3>
 * <ul>
 *   <li> Create a new class, place the old field and its behavior
 *      in the class, and store the object of the class in the
 *      original class.
 * </ul>
 */

class Order {
	// ...
	private String customer;

	public Order(String customer) {
		this.customer = customer;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}
}

public class Demo {
	// Client code, which uses Order class.
	private static int numberOfOrdersFor(List<Order> orders, String customer) {
		int result = 0;

		for (Order each : orders) {
			if (each.getCustomer().equals(customer)) {
				result++;
			}
		}
		return result;
	}
}