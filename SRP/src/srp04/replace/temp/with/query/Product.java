package srp04.replace.temp.with.query;

/**
 * <h3>SMELL: Duplicate Code, Shotgun Surgery</h3>
 * <ul>
 *   <li> You have a temporary variable to hold the result of expression.
 *   <li> Especially, the temporary variable is also defined in other
 *      methods --> "Shotgun Surgery"
 * </ul>
 * <h3>TREATMENT: Replace Temp with Query</h3>
 * <ul>
 *   <li> Extract the expression into a method so that it can be used
 *      in other methods
 *   <li> Lay foundation for later "Extract Method" refactoring.
 * </ul>
 */

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

    public double getPriceForVIP() {
        double basePrice = quantity * itemPrice; // <-------------
        return basePrice * 0.7;
    }
}
