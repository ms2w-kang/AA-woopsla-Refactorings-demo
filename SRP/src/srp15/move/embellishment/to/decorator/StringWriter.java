package srp15.move.embellishment.to.decorator;

//region Description
/*
 * 1. Replace Type-code with Subclasses to remove embellished logic
 *   1.1 Self-encapsulate field against type code
 *   1.2 create static create method to encapsulate type codes
 *       - return type must be the enclosed type
 *   {compile and test}
 *   1.3 for each type, create subclasses.
 *   1.4 override type code for getter to return true/false
 *   1.5 modify create method and remove type-code field, setter,
 *       ctror that accepts it.
 * 2. Replace Conditional with Polymorphism.
 *   2.1 copy to subclass embellished method and modify and compile.
 *   2.2 remove unnecessary getter for type code
 *   2.3 make subclasss to call super to remove minor duplication.
 * 3. Replace Inheritance with Delegation
 *   3.1 Make a delegate field in subclass and replace super with enclosure.
 *   3.2 Extract Parameter to accept a delegate from the static create method in 1.2.
 */
//endregion

public class StringWriter implements Writer {

    private StringBuilder target = new StringBuilder();
    private boolean capitalized;

    public StringWriter() {}

    public StringWriter(boolean capitalized) {
        this.capitalized = capitalized;
    }

    @Override
    public void write(String msg) {
        if (capitalized)
            target.append(msg.toUpperCase());
        else
            target.append(msg);
    }

    @Override
    public String toString() {
        return target.toString();
    }
}
