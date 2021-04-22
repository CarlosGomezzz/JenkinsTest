package Carlos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitIntroTest {

	@Test // <-- this annotation runs a test
	public void learningTestAnnotation() {
		System.out.println("TEST 1");
	}

	@Test
	public void learningTestAnnotation2() {
		System.out.println("TEST 2");
	}

	@Test
	public void learningTestAnnotation3() {
		System.out.println("TEST 3");
	}

	@Before
	public void beforeAnnotation() {
		System.out.println("Create connection!!");
	}

	@After
	public void afterAnnotation() {
		System.out.println("Close Connection!!");
	}

	@BeforeClass
	public static void testBeforeClass() {
		System.out.println("----------------------------");
		System.out.println("Before Classs");
		System.out.println("----------------------------");
	}

	@AfterClass
	public static void testAfterClass() {
		System.out.println("----------------------------");
		System.out.println("After Classs");
		System.out.println("----------------------------");

	}

}
