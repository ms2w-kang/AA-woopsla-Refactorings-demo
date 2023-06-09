package coupling05.hide.delegate;

/**
 * <h3>SMELL: Method Chain</h3>
 * <ul>
 *   <li> The client gets object B from a field or method of object А.
 *      Then the client calls a method of object B.
 * </ul>
 * <h3>TREATMENT: Hide Delegate (Tell/Don't Ask, Law of Demeter, Law of Least knowledge)</h3>
 *  <ul>
 *   <li> Create a new method in class A that delegates the call to object B.
 *      Now the client does not know about, or depend on, class B.
 * </ul>
 */

class Person {
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department arg) {
        department = arg;
    }
    // …
}

class Department {
    private String chargeCode;
    private Person manager;

    public Department(Person manager) {
        this.manager = manager;
    }

    public Person getManager() {
        return manager;
    }
}

public class Demo {
    public static void main(String[] args) {
        // Somewhere in client code
        Person john = new Person();
        Department department = new Department(john);

        Person manager = john.getDepartment().getManager();

    }
}