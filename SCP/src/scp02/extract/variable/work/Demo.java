/*
 * SMELL: Complicated (Conditional) Expression
 *   -- You have an expression that is not clear hard to understand.
 *
 * TREATMENT: Extract Variable (aka Introduce Explaining Variable)
 *   -- Put the result of the expression or part of the expression
 *      in a temporary variable with a name that explains the purpose.
 *   -- Extract method(or Replace Temp with Query) can be considered.
 */
package scp02.extract.variable.work;

import java.util.Scanner;

public class Demo
{
	// discountRate depends on the season of the year
	static float getDiscountRate(int month)
	{
		float discountRate = 0.0F;
		if (month >= 3 && month <= 5) // Spring
			discountRate = 0.2F;
		else if (month >= 6 && month <= 8) // Summer
			discountRate = 0.5F;
		else if (month >= 9 && month <= 11) // Fall
			discountRate = 0.2F;
		else // Winter
			discountRate = 0.1F;
		return discountRate;
	}

	//region Another Example
	static String platform = "macOS";
	static String browser = "IExplorer";
	static int resize = 0; // if resize > 0 then wasResized

	static boolean wasInitialized()
	{
		return true;
	}

	static void renderBanner()
	{
		if ((platform.toUpperCase().indexOf("MAC") > -1) && (browser.toUpperCase().indexOf("IE") > -1)
				&& wasInitialized() && resize > 0)
		{
			// do something
		}
	}
	//endregion

	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		System.out.println("Discount Rate: " + getDiscountRate(new Scanner(System.in).nextInt()));
	}

}
