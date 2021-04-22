package Carlos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JunitAssertionTest {

	@Test
	public void twoPlusTwoEqual4() {
		assertEquals(4, 2 + 2);
	}

	@Test
	public void twoPlusTwoEqualFour() {
		assertEquals("2 + 2 = 4", 4, 2 + 2);
	}

	boolean result = true;

	@Test
	public void testingAssrtTrue() {
		assertTrue(result);
	}

	@Test
	public void testingAssrtTrueWithDescription() {
		assertTrue("Result is true ", result);
	}
}
