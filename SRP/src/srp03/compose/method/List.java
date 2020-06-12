/*
 * SMELL: Long Method
 *   -- You can’t rapidly understand a method’s logic. 
 *   -- It consists of a number of concrete logics.
 * 
 * TREATMENT: Compose Method
 *   -- Transform the logic into a small number of 
 *      intention-revealing steps at the same level of detail.
 */
package srp03.compose.method;

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
                for (int i = 0; i < size; i++)
                    newElements[i] = elements[i];
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
