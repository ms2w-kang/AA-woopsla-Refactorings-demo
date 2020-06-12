/*
 * SMELL: Meaningless Name
 * 
 * TREATMENT: Use Intention-revealing Name
 */
package scp01.use.intention.revealing.name.work;

import java.util.Scanner;

public class Demo {

	// this function returns discount rate depending on the season of the year
	static float getValue(int m) { // m: month
		float r = 0.0F;	// r: discountRate
		if (m>= 3 && m<= 5)
			 r = 0.2F;
		else if (m>= 6 && m<= 8)
			 r = 0.5F;
		else if (m>= 9 && m<= 11)
			 r = 0.2F;
		else
			 r = 0.1F;
		return r ;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Discount Rate: " 
			+ getValue(new Scanner(System.in).nextInt()));
	}

}
