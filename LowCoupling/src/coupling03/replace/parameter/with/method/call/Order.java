package coupling03.replace.parameter.with.method.call;

/**
 * <h3>SMELL: Long Parameter List</h3>
 * <ul>
 *   <li> Before a method call, a second method is run and its
 *      result is sent back to the first method as an argument.
 *      But the parameter value could have been obtained inside
 *      the method being called.
 * </ul>
 * <h3>TREATMENT: Replace Parameter with Method Call</h3>
 * <ul>
 *   <li> Instead of passing the value through a parameter, place
 *      the value-getting code inside the method.
 * </ul>
 */

class Order {
	private int quantity;
	private int itemPrice;

	// ...
	public double getPrice() {
		int basePrice = quantity * itemPrice;
		int discountLevel;
		if (quantity > 100) {
			discountLevel = 2;
		} else {
			discountLevel = 1;
		}
		double finalPrice = discountedPrice(basePrice, discountLevel);
		return finalPrice;
	}

	// The method for getting the discount (discountedPrice) is 
	// currently nearly impossible to use separately from the method 
	// for getting the price (getPrice), since you must get the 
	// values of all parameters prior to it.
	private double discountedPrice(int basePrice, int discountLevel) {
		if (discountLevel == 2) {
			return basePrice * 0.1;
		} else {
			return basePrice * 0.05;
		}
	}
}
