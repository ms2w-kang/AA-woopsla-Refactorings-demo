package scp06.introduce.assertions.after;

import static org.junit.Assert.*;

import org.junit.Test;

public class DemoTest
{
	@Test(expected=IllegalArgumentException.class)
	public void SetRefreshRate_InvalidRate_ThrowsException() throws Exception
	{
		Demo demo = new Demo();
		demo.setRefreshRate(-1);
	}
}
