package srp14.move.embellishment.to.decorator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringWriterTest {

    private WriterPolicy policy;
    private Writer writer;

    @BeforeEach
    public void setup() {
        policy = new WriterPolicy();
    }

    @Test
    public void should_not_capitalize_if_that_policy_not_set() {
        policy.setCapitalized(false);
        writer = new StringWriter(policy.isCapitalized());
        writer.write("not capitalized");

        assertEquals("not capitalized", writer.toString());
    }

    @Test
    public void should_capitalize_if_that_policy_was_set() {
        policy.setCapitalized(true);
        writer = new StringWriter(policy.isCapitalized());
        writer.write("CAPITALIZED");

        assertEquals("CAPITALIZED", writer.toString());
    }
}