/*
 * SMELL: Long Parameter List
 *   -- You get several values from an object and then pass them 
 *      as parameters to a method.
 * 
 * TREATMENT: Preserve Whole Object
 *   -- Instead, try passing the whole object.
 *   -- Beware: Avoid stamp coupling 
 *   			(i.e., Using only part of the passed object)
 */
package coupling02.preserve.whole.object;

class Room
{
	// ...
	public boolean withinPlan(HeatingPlan plan)
	{
		int low = getLowestTemp();
		int high = getHighestTemp();
		/*
		 * Currently, we are passing only the temperature 
		 * for analysis but at any time we may need to check 
		 * another room parameter, such as humidity.
		 */
		return plan.withinRange(low, high);
	}

	public int getHighestTemp()
	{
		return 0;
	}

	public int getLowestTemp()
	{
		return 100;
	}
}

class HeatingPlan
{
	private TempRange range;

	public HeatingPlan(TempRange range)
	{
		this.range = range;
	}

	public boolean withinRange(int low, int high)
	{
		return (low >= range.getLow() && high <= range.getHigh());
	}
}

class TempRange
{
	private int low;
	private int high;

	public TempRange(int low, int high)
	{
		this.low = low;
		this.high = high;
	}

	public int getLow()
	{
		return low;
	}

	public int getHigh()
	{
		return high;
	}
}
