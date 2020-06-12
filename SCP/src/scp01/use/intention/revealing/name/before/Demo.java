/*
 * SMELL: Meaningless Name
 * 
 * TREATMENT: Use Intention-revealing Name
 */
package scp01.use.intention.revealing.name.before;

import java.util.Scanner;

public class Demo {

	// this function returns discount rate depending on the season of the year
	static float getDiscountRate(int month) { // month: month
		float discountRate = 0.0F;	// discountRate: discountRate
		if (isSpring(month))
			 discountRate = 0.2F;
		else if (isSummer(month))
			 discountRate = 0.5F;
		else if (isFall(month))
			 discountRate = 0.2F;
		else
			 discountRate = 0.1F;
		return discountRate ;
	}

    private static boolean isFall(int month) {
        return month>= 9 && month<= 11;
    }

    private static boolean isSummer(int month) {
        return month>= 6 && month<= 8;
    }

    private static boolean isSpring(int month) {
        return month>= 3 && month<= 5;
    }

    @SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Discount Rate: "
			+ getDiscountRate(new Scanner(System.in).nextInt()));
	}

}
