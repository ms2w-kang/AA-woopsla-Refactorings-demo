package srp09.extractclass;

/**
 * <h3>SMELL: Poor Cohesion</h3>
 * <ul>
 *   <li> When one class does the work of two, awkwardness results.
 * </ul>
 * <h3>TREATMENT: Extract Class</h3>
 * <ul>
 *   <li> Create a new class and place the fields and methods responsible
 *      for the relevant functionality in it.
 * </ul>
 */

public class Person {
    private String name;
    // Telephone
    private String officeAreaCode;
    private String officeNumber;

    public String getName() {
        return name;
    }

    public String getTelephoneNumber() {
        return ("(" + officeAreaCode + ") " + officeNumber);
    }

    public String getOfficeAreaCode() {
        return officeAreaCode;
    }

    public void setOfficeAreaCode(String arg) {
        officeAreaCode = arg;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String arg) {
        officeNumber = arg;
    }
}
