package scp07.replace.nested.conditional.with.guard.clauses;

/**
 * <h3>SMELL: Unbalanced Branch</h3>
 * <ul>
 *   <li> You have a group of nested conditionals and it is
 *   	hard to determine the normal flow of code execution.
 * </ul>
 * <h3>TREATMENT: Replace Nested Conditional with Guard Clauses</h3>
 * <ul>
 *   <li> Isolate all "special checks and edge cases" into separate
 *   	clauses and place them before the main checks.
 *   <li> Ideally, you should have a "flat" list of conditionals,
 *   	one after the other.
 *   <li> Forget about "Single Exit Point"
 * </ul>
 */
class Payout {
	private boolean isDead;
	private boolean isSeparated;
	private boolean isRetired;

	// ...
	double getPayAmount() {
		double result = 0;
		if (isDead) {
			result = deadAmount();
		} else {
			if (isSeparated) {
				result = separatedAmount();
			} else {
				if (isRetired) {
					result = retiredAmount();
				} else {
					result = normalPayAmount();
				}
			}
		}
		return result;
	}

	private double normalPayAmount() {
		return 1.0;
	}

	private double retiredAmount() {
		return 2.0;
	}

	private double separatedAmount() {
		return 3.0;
	}

	private double deadAmount() {
		return 4.0;
	}
}
