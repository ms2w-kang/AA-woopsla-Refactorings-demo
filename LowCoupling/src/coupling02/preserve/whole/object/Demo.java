package coupling02.preserve.whole.object;

/**
 * <h3>SMELL: Long Parameter List</h3>
 * <ul>
 *   <li> You get several values from an object and then pass them
 *      as parameters to a method.
 * </ul>
 * <h3>TREATMENT: Preserve Whole Object</h3>
 * <ul>
 *   <li> Instead, try passing the whole object.
 *   <li> Beware: Avoid stamp coupling
 *   			(i.e., Using only part of the passed object)
 * </ul>
 */

class Room {
    // ...
    public boolean withinPlan(HeatingPlan plan) {
        int low = getLowestTemp();
        int high = getHighestTemp();
        /*
         * Currently, we are passing only the temperature
         * for analysis but at any time we may need to check
         * another room parameter, such as humidity.
         */
        return plan.withinRange(low, high);
    }

    public int getHighestTemp() {
        return 0;
    }

    public int getLowestTemp() {
        return 100;
    }
}

class HeatingPlan {
    private final TempRange range;

    public HeatingPlan(TempRange range) {
        this.range = range;
    }

    public boolean withinRange(int low, int high) {
        return (low >= range.getLow() && high <= range.getHigh());
    }
}

class TempRange {
    private final int low;
    private final int high;

    public TempRange(int low, int high) {
        this.low = low;
        this.high = high;
    }

    public int getLow() {
        return low;
    }

    public int getHigh() {
        return high;
    }
}
