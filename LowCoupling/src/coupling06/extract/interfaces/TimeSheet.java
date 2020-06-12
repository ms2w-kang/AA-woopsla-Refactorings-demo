/*
 * SMELL: Fat Interface
 *   -- Several clients use the same subset of a class's interface, 
 *      or two classes have part of their interfaces in common.
 * 
 * TREATMENT: Extract Interface
 *   -- Extract the subset into an interface.
 */
package coupling06.extract.interfaces;

public class TimeSheet {
    // ...
    public double charge(Employee employee, int days) {
        double base = employee.getRate() * days;
        if (employee.hasSpecialSkill()) {
            return base * 1.05;
        } else {
            return base;
        }
    }
}

class Employee {
    private String name;
    private String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getRate() {
        // ...
        return 0;
    }

    public boolean hasSpecialSkill() {
        // ...
        return false;
    }
}
