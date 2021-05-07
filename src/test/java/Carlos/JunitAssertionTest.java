package Carlos;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;

public class JunitAssertionTest {

	@Test
	public void twoPlusTwoEqual4() {
		AssertJUnit.assertEquals(4, 2 + 2);
	}

	@Test
	public void twoPlusTwoEqualFour() {
		AssertJUnit.assertEquals("2 + 2 = 4", 4, 2 + 2);
	}

	boolean result = true;

	@Test
	public void testingAssrtTrue() {
		AssertJUnit.assertTrue(result);
	}

	@Test
	public void testingAssrtTrueWithDescription() {
		AssertJUnit.assertTrue("Result is true ", result);
	}
}
