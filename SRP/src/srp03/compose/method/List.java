package srp03.compose.method;

/**
 * <h3>SMELL: Long Method</h3>
 * <ul>
 *   <li> You can’t rapidly understand a method’s logic.
 *   <li> It consists of a number of concrete logics.
 * </ul>
 * <h3>TREATMENT: Compose Method</h3>
 * <ul>
 *   <li> Transform the logic into a small number of
 *      intention-revealing steps at the same level of detail.
 * </ul>
 */

public class List<T> {
    private boolean readOnly = false;
    private int size;
    T[] elements;

    @SuppressWarnings("unchecked")
    public List() {
        elements = (T[]) new Object[0];
        size = elements.length;
    }

    public void add(T element) {
        if (!readOnly) {
            int newSize = size + 1; // update size

            if (newSize > elements.length) { // grow array if capacity exceeds
                @SuppressWarnings("unchecked")
                T[] newElements = (T[]) new Object[elements.length + 10];
                if (size >= 0) System.arraycopy(elements, 0, newElements, 0, size);
                elements = newElements;
            }

            elements[size++] = element; // add element
        }
    }

    /* for testing purpose */
    int size() {
        return size;
    }

    int getCapacity() {
        return elements.length;
    }
}
