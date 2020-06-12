/*
 * SMELL: Poor Cohesion
 *   -- When one class does the work of two, awkwardness results.
 *
 * TREATMENT: Extract Class
 *   -- Create a new class and place the fields and methods responsible
 *      for the relevant functionality in it.
 *
 */
package srp09.extractclass;

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
