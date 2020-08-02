package srp05.separate.query.from.modifier;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>SMELL: Poor Cohesion</h3>
 * <ul>
 *   <li> You have a method that returns a value but also changes
 *      the state of the object.
 * </ul>
 * <h3>TREATMENT: Separate Query from Modifier</h3>
 * <ul>
 *   <li> Create two methods, one for the query and one for the modification.
 *   <li> The query method can be reused independently.
 * </ul>
 */

public class Demo {
	private List<Integer> scores = new ArrayList<>();

	public long addAndGetSum(int score) {
		scores.add(score);
		long sum = 0;
		for (int i = 0; i < scores.size(); i++)
			sum += scores.get(i);
		return sum;
	}

	public static void main(String[] args) {
		// Client code
		Demo demo = new Demo();

		for (int i = 0; i < 10; i++) {
			long sum = demo.addAndGetSum(i);
			System.out.println("sum = " + sum);
		}
	}
}
