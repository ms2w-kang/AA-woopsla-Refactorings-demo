package srp10.extract.subclass;

/**
 * <h3>SMELL: Poor Cohesion</h3>
 * <ul>
 *   <li> A class has features that are used only in certain cases.
 * </ul>
 * <h3>TREATMENT: Extract Subclass</h3>
 * <ul>
 *   <li> Create a subclass for that subset of features.
 * </ul>
 */

/*
 * We start with the JobItem class, which tracks the time and
 * materials used to fix a client's car in a local garage.
 * This class is also responsible for calculating the price
 * client should pay.
 */
class JobItem {
    private int quantity;
    private int unitPrice;
    private Employee employee;
    private boolean isLabor;

    public JobItem(int quantity, int unitPrice, boolean isLabor, Employee employee) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.isLabor = isLabor;
        this.employee = employee;
    }

    public int getTotalPrice() {
        return quantity * getUnitPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    /*
     * The price usually consists of several items.
     * First, it's the fixed cost of certain parts.
     * Second, it's the cost of a mechanic's time, multiplied by his rate
     * (that can be taken directly from the Employee class).
     *
     * So, the price is calculated in several ways, all of which sit in a
     *  single class. And that starts to smell as a Large Class.
     *
     * As a solution, we could extract the LaborItem subclass and
     * move all code, which are associated with manual work, to
     * that subclass. Then we could leave only fixed amounts in
     * the original class.
     */
    public int getUnitPrice() {
        return (isLabor) ? employee.getRate() : unitPrice;
    }

    public Employee getEmployee() {
        return employee;
    }
}