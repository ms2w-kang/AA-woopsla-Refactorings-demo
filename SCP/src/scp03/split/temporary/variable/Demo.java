package scp03.split.temporary.variable;

/**
 * <h3>SMELL: DD-Anomaly (by PMD)</h3>
 * <ul>
 *   <li> You have a local variable that is used to store various
 *      intermediate values inside a method.
 *      (except for loop or accumulator variables).
 * </ul>
 * <h3>TREATMENT: Split Temporary Variables</h3>
 * <ul>
 *   <li> Use different variables for different values.
 *      Each variable should be responsible for only one particular
 *      thing (cohesion).
 * </ul>
 */

public class Demo {

	public void printInfo(int width, int height) {

		double temp = 2 * (width + height);
		System.out.println(temp);

		temp = width * height;
		System.out.println(temp);
	}
}
