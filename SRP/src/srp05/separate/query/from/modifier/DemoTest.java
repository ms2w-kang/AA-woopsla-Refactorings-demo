package srp05.separate.query.from.modifier;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoTest {
    // SUT
    private Demo demo = new Demo();

    @Test
    void checkResult() {
        // Arrange (Given)
        List<Long> expected = List.of(0L, 1L, 3L, 6L, 10L, 15L, 21L, 28L, 36L, 45L);
        List<Long> sums = new ArrayList<>();

        // Act (When)
        for (int i = 0; i < 10; i++) {
            sums.add(demo.addAndGetSum(i));
        }

        // Assert (Then)
        assertEquals(expected, sums);
    }

}
