/*
 * SMELL: Duplicate Code, Shotgun Surgery
 *   -- You have a temporary variable to hold the result of expression.
 *   -- Especially, the temporary variable is also defined in other
 *      methods --> "Shotgun Surgery"
 *
 * TREATMENT: Replace Temp with Query
 *   -- Extract the expression into a method so that it can be used
 *      in other methods
 *   -- Lay foundation for later "Extract Method" refactoring.
 */
package srp04.replace.temp.with.query;

public class Product {
    int quantity;
    double itemPrice;

    public double getPrice() {
        double basePrice = quantity * itemPrice; // <------------
        double discountFactor;
        if (basePrice > 1000) {
            discountFactor = 0.95;
        } else {
            discountFactor = 0.98;
        }
        return basePrice * discountFactor;
    }

    public double getPriceforVIP() {
        double basePrice = quantity * itemPrice; // <-------------
        return basePrice * 0.7;
    }
}
