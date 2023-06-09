package srp01.consolidate.condition.expression;

/**
 * <h3>SMELL: A Sequence of Condition Tests With The Same Result</h3>
 * <ul>
 *   <li> You have a sequence of conditional tests with the same result.
 * </ul>
 * <h3>TREATMENT: Consolidate Conditional Expression</h3>
 * <ul>
 *   <li> Combine them into a single conditional expression.
 *   <li> It Makes the check clearer.
 *   <li> May continue refactoring with "Extract Method".
 * </ul>
 */
class Payout {
	  // ...

	  public int seniority;
	  public int monthsDisabled;
	  public boolean isPartTime;

	  public double disabilityAmount() {
	    if (seniority < 2) {	// not eligible for disability
	      return 0;
	    }
	    if (monthsDisabled > 12) { // not eligible for disability
	      return 0;
	    }
	    if (isPartTime) { // not eligible for disability
	      return 0;
	    }
	    // compute the disability amount
	    // ...
	    return 1234.0; // dummy
	  }

	  public double vacationAmount() {
	    if (onVacation()) {
	      if (lengthOfService() > 10) {
	        return 1;
	      }
	    }
	    return 0.5;
	  }

	private int lengthOfService() {
		return 0; // dummy
	}

	private boolean onVacation() {
		return false; // dummy
	}
}
