package scp05.replace.magicnumber.with.constant;

/**
 * <h3>SMELL: Literal (or Magic Number)</h3>
 * <ul>
 *   <li>You have a literal number with a particular meaning.
 *   <li>Magic numbers are really nasty when you need to reference
 *      the same logical number in more than one place
 *      ==> cause Shotgun Surgery smell
 * </ul>
 * <h3>TREATMENT: Replace Magic Number with Symbolic Constant</h3>
 * <ul>
 *   <li>Replace the literal with a constant with meaningful name
 * </ul>
 */
public class Demo {

	double potentialEnergy(double mass, double height) {
	  return mass * height * 9.81; // Gravitational Constant
	}
}
