package dry02.parameterize.method;

import java.util.List;

/**
 * <h3>SMELL: Similar Codes among Methods</h3>
 * <ul>
 *   <li> Several methods do similar things but with different values
 * </ul>
 * <h3>TREATMENT: Parameterize Method</h3>
 * <ul>
 *   <li> Create one method that uses a parameter for the different values
 * </ul>
 */

class Client { }

class Employee {
	public static int MANAGER = 1;
	private int type;
	private double salary;
	public int yearsOfExperience;
	public List<Client> clients;
	
	// ...
	public void promoteToManager() {
		type = Employee.MANAGER;
		salary *= 1.5;
	}
	
	public void tenPercentRaise() {
		salary *= 1.1;
	}

	public void fivePercentRaise() {
		salary *= 1.05;
	}
}

public class Demo {
	public static void main(String[] args) {
		// Somewhere in client code
		
		Employee employee = new Employee();
		
		if (employee.yearsOfExperience > 5) {
			if (employee.clients.size() > 10) {
				employee.promoteToManager();
			} else {
				employee.fivePercentRaise();
			}
		}
	}
}
