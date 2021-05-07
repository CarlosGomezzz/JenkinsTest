package Carlos;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;

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

	@BeforeMethod
	public void beforeAnnotation() {
		System.out.println("Create connection!!");
	}

	@AfterMethod
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
