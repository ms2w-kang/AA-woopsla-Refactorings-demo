package scp04.remove.assignments.to.parameters;

/**
 * <h3>SMELL: Non Const Parameters</h3>
 * <ul>
 * 	<li> Some value is assigned to a parameter inside method's body.
 * 	<li> Same problem as DD-anomaly.
 * </ul>
 * <h3>TREATMENT: Remove Assignment To Parameters</h3>
 * <ul>
 * 	<li> Use a local variable(s) instead of a parameter.
 *  <li> You can enforce this convention with the final/const keyword
 * </ul>
 */
public class Demo {
	int getDiscount(int inputVal, int quantity, int yearToDate) {
		if (inputVal > 50) {
		    inputVal -= 2;
		}
		if (quantity > 100) {
		    inputVal -= 1;
		}
		if (yearToDate > 10000) {
		    inputVal -= 4;
		}
		return inputVal;
	}
}
