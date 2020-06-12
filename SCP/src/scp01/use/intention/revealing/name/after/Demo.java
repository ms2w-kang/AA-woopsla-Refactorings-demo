/*
 * SMELL: Meaningless Name
 * 
 * TREATMENT: Use Intention-revealing Name
 */
package scp01.use.intention.revealing.name.after;

import java.util.Scanner;

public class Demo {

	// this function returns discount rate depending on the season of the year
	static float getValue(int month) { // m: month
		float discountRate = 0.0F;	// r: discountRate
		if (month>= 3 && month<= 5)
			 discountRate = 0.2F;
		else if (month>= 6 && month<= 8)
			 discountRate = 0.5F;
		else if (month>= 9 && month<= 11)
			 discountRate = 0.2F;
		else
			 discountRate = 0.1F;
		return discountRate ;
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Discount Rate: " 
			+ getValue(new Scanner(System.in).nextInt()));
	}

}
