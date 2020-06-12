package srp15.move.embellishment.to.decorator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringWriterTest {

    private WriterPolicy policy;
    private Writer writer;

    @Before
    public void setup() throws Exception {
        policy = new WriterPolicy();
    }

    @Test
    public void should_not_capitalize_if_that_policy_not_set() throws Exception {
        policy.setCapitalized(false);
        writer = new StringWriter(policy.isCapitalized());
        writer.write("not capitalized");

        assertEquals("not capitalized", writer.toString());
    }

    @Test
    public void should_capitalize_if_that_policy_was_set() throws Exception {
        policy.setCapitalized(true);
        writer = new StringWriter(policy.isCapitalized());
        writer.write("CAPITALIZED");

        assertEquals("CAPITALIZED", writer.toString());
    }
}