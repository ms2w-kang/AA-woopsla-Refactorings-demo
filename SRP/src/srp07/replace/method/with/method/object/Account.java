package srp07.replace.method.with.method.object;

/**
 * <h3>SMELL: Long Method</h3>
 * <ul>
 *   <li> You have a long method in which the local variables
 *      are so intertwined that you cannot apply "Extract Method".
 * </ul>
 * <h3>TREATMENT: Replace Method with Method Object</h3>
 * <ul>
 *   <li> Turn the method into its own object so that all the local
 *      variables become fields on that object.
 * </ul>
 */

public class Account {
    // ... Select function body in {} to convert to method object
    int gamma(int inputVal, int quantity, int yearToDate) {
        int importantValue1 = (inputVal * quantity) + delta();
        int importantValue2 = (inputVal * yearToDate) + 100;
        if ((yearToDate - importantValue1) > 100) { // Important thing
            importantValue2 -= 20;
        }
        int importantValue3 = importantValue2 * 7;
        // and so on…
        return importantValue3 - 2 * importantValue1;
    }
    // ...

    int delta() {
        return 7;
    }
}
