package srp10.extract.subclass;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JobItemTests {
    @Test
    public void should_calculate_total_price_according_to_job_types() throws Exception {
        Employee kent = new Employee(50);
        JobItem j1 = new JobItem(5, 0, true, kent);
        JobItem j2 = new JobItem(15, 10, false, null);
        int total = j1.getTotalPrice() + j2.getTotalPrice();

        assertEquals(400, total);
    }
}
