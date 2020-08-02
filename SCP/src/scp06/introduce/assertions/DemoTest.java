package scp06.introduce.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DemoTest {

	@Test
	public void SetRefreshRate_InvalidRate_ThrowsException() {
		Demo demo = new Demo();

		assertThrows(IllegalArgumentException.class, () ->
				demo.setRefreshRate(-1)
		);
	}
}
