/*
 * SMELL: Unbalanced Branch
 *   -- You have a group of nested conditionals and it is 
 *   	hard to determine the normal flow of code execution.
 * 
 * TREATMENT: Replace Nested Conditional with Guard Clauses
 *   -- Isolate all "special checks and edge cases" into separate
 *   	clauses and place them before the main checks.
 *
 *   -- Ideally, you should have a "flat" list of conditionals,
 *   	one after the other.
 *
 *   -- Forget about "Single Exit Point"
 */
package scp07.replace.nested.conditional.with.guard.clauses.after;

class Payout {
	private boolean isDead;
	private boolean isSeparated;
	private boolean isRetired;

	double getPayAmount() {
		if (isDead) {
			return deadAmount();
		}
		if (isSeparated) {
			return separatedAmount();
		}
		if (isRetired) {
			return retiredAmount();
		}
		return normalPayAmount();
	}

	private double normalPayAmount() {
		return 0;
	}

	private double retiredAmount() {
		return 0;
	}

	private double separatedAmount() {
		return 0;
	}

	private double deadAmount() {
		return 0;
	}
}
