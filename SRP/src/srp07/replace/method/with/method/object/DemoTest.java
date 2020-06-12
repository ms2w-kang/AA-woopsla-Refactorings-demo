package srp07.replace.method.with.method.object;

import static org.junit.Assert.*;

import org.junit.Test;

public class DemoTest
{
	@Test
	public void testFoo() throws Exception
	{
		Demo demo = new Demo();
		
		assertEquals(198, demo.foo(10, 20));
		assertEquals(185, demo.foo(11, 17));
	}
}
