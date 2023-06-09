package srp13.replace.type.code.with.classes;

/**
 * <h3>SMELL: Primitive Obsession</h3>
 * <ul>
 *   <li> A class has a field that contains type code.
 *      The values of this type are not used in operator conditions
 *      and do not affect the behavior of the program.
 * </ul>
 *
 * What are the shortcomings of this approach?
 * <ol>
 * <li> The field setters often do not check which value is sent,
 * which can cause big problems when someone sends unintended or wrong values
 * to these fields.
 * <li> In addition, type verification is impossible for these fields.
 * It is possible to send any number or string to them, which won't be type
 * checked by your IDE and even allow your program to run (and crash later).
 * </ol>
 * <h3>TREATMENT: Replace Type Code with Object</h3>
 * <ul>
 *   <li> Create a new class and use its objects instead of the type code values.
 * </ul>
 */

public class Person {
    /*
     * Create a new BloodGroup class encapsulating a code,
     * and make clients use its instances instead of code directly.
     */
    public static final int O = 0;
    public static final int A = 1;
    public static final int B = 2;
    public static final int AB = 3;

    private int bloodGroup;

    public Person() {
    }

    public Person(int code) {
        bloodGroup = code;
    }

    public void setBloodGroup(int code) {
        bloodGroup = code;
    }

    public int getBloodGroup() {
        return bloodGroup;
    }

    public static void main(String[] args) {
        // Somewhere in client code.
        Person parent = new Person(Person.O);
        if (parent.getBloodGroup() == Person.AB) {
            // ...
        }

        Person child = new Person();
        child.setBloodGroup(parent.getBloodGroup());
    }
}

/*
 * 1. Create a new BloodGroup Class,
 *    which will be responsible for blood types.
 * 2. Place the blood type code from the Person class,
 *    its getter and the constructor, which initialize the field value.
 * 3. Create static methods for each type code value from the original class.
 *    These methods should return instances of the BloodGroup class.
 * 4. In the original class, change the type of code field to BloodGroup.
 * 5. Change the code of the setter and constructor accordingly.
 * 6. Then change the field getter so that it calls the getter of the BloodGroup.
 * 7. Replace all type code values with calls to the corresponding static methods
 *    of the type class.
 * 8. Get rid of direct references to constants of the Person class
 *    in the remaining code. We can use calls to the methods of
 *    the BloodGroup class instead.
 * 9. In the end, it is better to avoid using any numeric codes for BloodGroup
 *    and use objects instead. Let's try to do so in the Person class.
 * 10. You can remove unused constants from the Person class.
 * 11. Finally, you should make the BloodGroup constructor private.
 */
