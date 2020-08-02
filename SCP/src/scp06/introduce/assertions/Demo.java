package scp06.introduce.assertions;

/**
 * <h3>SMELL: Implicit Assertion, Complex Conditional Expression</h3>
 * <ul>
 *   <li>For a portion of code to work correctly,
 *      certain conditions or values must be true.
 *   <li>A section of code assumes something about the state of
 *      the program. Sometimes the assumptions are stated with a comment
 * </ul>
 * <h3>TREATMENT: Introduce Assertion</h3>
 * <ul>
 *   <li>Make the assumption explicit with an assertion.
 * </ul>
 */
class Project {
    public double getMemberExpenseLimit() {
        return 9999.0;
    }
}

public class Demo {
    private static final double NULL_EXPENSE = 0.0;
    private double expenseLimit;
    private final Project primaryProject = new Project();

    public double getExpenseLimit() {

        // should have either expense limit or a primary project
        return (expenseLimit != NULL_EXPENSE) ?
                expenseLimit : primaryProject.getMemberExpenseLimit();
    }

    //region Do not use assertions to check the parameters of a public method
    // -- the assert construct does not throw an exception of the specified type.
    // -- It can throw only an "AssertionError".
    public void setRefreshRate(int rate) {
        // Enforce specified precondition in public method
        assert (rate > 0 && rate <= MAX_REFRESH_RATE);

        setRefreshInterval(1000 / rate);
    }
    //endregion

    //region OK to use for private method
    private static final int MAX_REFRESH_RATE = 32;

    private void setRefreshInterval(int interval) {
        // Confirm adherence to precondition in nonpublic method
        assert interval > 0 && interval <= 1000 / MAX_REFRESH_RATE : interval;

        // ... Set the refresh interval
    }
    //endregion
}
