/*
 * SMELL: Control Couple
 *   -- A method is split into parts, each of which is run
 *      depending on the value of a parameter.
 *
 * TREATMENT: Replace Parameter with Explicit Method
 *   -- Extract the individual parts of the method into their
 *      own methods and call them instead of the original method.
 */

package coupling04.replace.parameter.with.explicit.method;

import java.util.ArrayList;
import java.util.List;

class Item {
}

class Order {
    // ...
    public static final int FIXED_DISCOUNT = 0;
    public static final int PERCENT_DISCOUNT = 1;

    private double price;
    public List<Item> items = new ArrayList<>();

    public void applyDiscount(int type, double discount) {
        switch (type) {
        case FIXED_DISCOUNT:
            price -= discount;
            break;
        case PERCENT_DISCOUNT:
            price -= price * discount;
            break;
        default:
            throw new IllegalArgumentException("Invalid discount type");
        }
    }
}

public class Driver {

    private static boolean weekend;

    public static void main(String[] args) {
        // Somewhere in client code
        Order order = new Order();
        if (weekend) {
            order.applyDiscount(Order.FIXED_DISCOUNT, 10);
        }
        if (order.items.size() > 5) {
            order.applyDiscount(Order.PERCENT_DISCOUNT, 0.2);
        }
    }
}



/*
 * Other possibility? (kim) -- Strategy?
 */
