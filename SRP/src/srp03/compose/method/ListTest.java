package srp03.compose.method;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListTest {
    private List<Integer> ints;

    @Before
    public void setup() throws Exception {
        ints = new List<>();
    }

    @Test
    public void add_first_element_increment_capacity_to_10() throws Exception {
        addElements(1);

        assertEquals(1, ints.size());
        assertEquals(10, ints.getCapacity());
    }

    @Test
    public void add_first_10_elements_returns_capacity_of_10() throws Exception {
        addElements(10);

        assertEquals(10, ints.size());
        assertEquals(10, ints.getCapacity());
    }


    @Test
    public void add_first_11_elements_returns_capacity_of_20() throws Exception {
        addElements(11);

        assertEquals(11, ints.size());
        assertEquals(20, ints.getCapacity());
    }

    private void addElements(int n) {
        for (int i = 0; i < n; i++)
            ints.add(new Integer(i));
    }
}
